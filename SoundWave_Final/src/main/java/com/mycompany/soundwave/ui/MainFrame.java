package com.mycompany.soundwave.ui;

import com.mycompany.soundwave.CancionDAO;
import com.mycompany.soundwave.CancionDAOjdbc;
import com.mycompany.soundwave.Canciones;
import com.mycompany.soundwave.patrones.EventosReproduccion;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.sql.SQLException;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JSlider;
import javax.swing.Timer;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

/** Ventana principal de SoundWave. La tabla se alimenta desde SQLite mediante CancionDAO. */
public class MainFrame extends JFrame {

    private static final Color VERDE_OSCURO = new Color(18, 43, 31);
    private static final Color VERDE = new Color(34, 139, 78);
    private static final Color FONDO = new Color(245, 248, 245);
    private static final Color TEXTO = new Color(35, 48, 40);

    private final CancionDAO dao = new CancionDAOjdbc();
    private final EventosReproduccion eventos = new EventosReproduccion();
    private final JLabel ultimaReproduccion = new JLabel("Aún no has reproducido canciones.");
    private JTextField txtBuscar;
    private JTable tblCanciones;
    private DefaultTableModel modelo;
    private JButton btnBuscar;
    private JButton btnMostrarTodas;
    private JButton btnReproducir;
    private JButton btnAnterior, btnSiguiente;
    private JLabel ahoraSuena, reloj;
    private JSlider progreso;
    private Timer temporizador;
    private boolean reproduciendo = false;
    private boolean actualizandoProgreso = false;
    private int segundosActuales = 0;
    private int duracionActual = 0;
    private String tituloActual = "";
    private String artistaActual = "";

    public MainFrame() {
        configurarVentana();
        crearInterfaz();
        eventos.agregar((titulo,artista) -> ultimaReproduccion.setText("♫ Última reproducción: " + titulo + " — " + artista));
        cargarCanciones("");
        temporizador = new Timer(1000, e -> avanzarTiempo());
    }

    private void configurarVentana() {
        setTitle("SoundWave | Biblioteca musical");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1050, 720);
        setMinimumSize(new Dimension(820, 600));
        setLocationRelativeTo(null);
        getContentPane().setBackground(FONDO);
        setLayout(new BorderLayout(0, 0));
    }

    private void crearInterfaz() {
        add(crearEncabezado(), BorderLayout.NORTH);
        add(crearContenido(), BorderLayout.CENTER);
        add(crearPie(), BorderLayout.SOUTH);
    }

    private JPanel crearEncabezado() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(VERDE_OSCURO);
        panel.setBorder(BorderFactory.createEmptyBorder(22, 30, 22, 30));

        JLabel titulo = new JLabel("♫  SoundWave");
        titulo.setForeground(Color.WHITE);
        titulo.setFont(new Font("SansSerif", Font.BOLD, 30));

        JLabel subtitulo = new JLabel("TU BIBLIOTECA MUSICAL");
        subtitulo.setForeground(new Color(190, 220, 199));
        subtitulo.setFont(new Font("SansSerif", Font.PLAIN, 12));

        JPanel textos = new JPanel(new BorderLayout(0, 5));
        textos.setOpaque(false);
        textos.add(titulo, BorderLayout.CENTER);
        textos.add(subtitulo, BorderLayout.SOUTH);
        panel.add(textos, BorderLayout.WEST);
        JButton usuarios = crearBoton("👤  Usuarios", new Color(226, 242, 230), VERDE_OSCURO);
        usuarios.addActionListener(e -> new UsuariosDialog(this).setVisible(true));
        panel.add(usuarios, BorderLayout.EAST);
        return panel;
    }

    private JPanel crearContenido() {
        JPanel contenido = new JPanel(new BorderLayout(0, 18));
        contenido.setBackground(FONDO);
        contenido.setBorder(BorderFactory.createEmptyBorder(24, 30, 18, 30));
        contenido.add(crearPanelBusqueda(), BorderLayout.NORTH);
        contenido.add(crearTabla(), BorderLayout.CENTER);
        return contenido;
    }

    private JPanel crearPanelBusqueda() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(FONDO);
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(4, 5, 4, 5);
        c.gridy = 0;
        c.anchor = GridBagConstraints.WEST;

        JLabel etiqueta = new JLabel("Buscar canciones o artistas");
        etiqueta.setFont(new Font("SansSerif", Font.BOLD, 15));
        etiqueta.setForeground(TEXTO);
        c.gridx = 0;
        c.gridwidth = 4;
        panel.add(etiqueta, c);

        txtBuscar = new JTextField();
        txtBuscar.setFont(new Font("SansSerif", Font.PLAIN, 15));
        txtBuscar.setToolTipText("Escribe el título de una canción o el nombre de un artista");
        txtBuscar.setPreferredSize(new Dimension(360, 40));
        c.gridy = 1;
        c.gridx = 0;
        c.gridwidth = 1;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;
        panel.add(txtBuscar, c);

        btnBuscar = crearBoton("Buscar", VERDE, Color.WHITE);
        c.gridx = 1;
        c.weightx = 0;
        c.fill = GridBagConstraints.NONE;
        panel.add(btnBuscar, c);

        btnMostrarTodas = crearBoton("Mostrar todas", new Color(224, 235, 226), VERDE_OSCURO);
        c.gridx = 2;
        panel.add(btnMostrarTodas, c);

        btnBuscar.addActionListener(e -> cargarCanciones(txtBuscar.getText().trim()));
        txtBuscar.addActionListener(e -> cargarCanciones(txtBuscar.getText().trim()));
        btnMostrarTodas.addActionListener(e -> {
            txtBuscar.setText("");
            cargarCanciones("");
        });
        return panel;
    }

    private JScrollPane crearTabla() {
        String[] columnas = {"Título", "Artista", "Duración", "Reproducciones"};
        modelo = new DefaultTableModel(columnas, 0) {
            @Override
            public boolean isCellEditable(int fila, int columna) {
                return false;
            }
        };
        tblCanciones = new JTable(modelo);
        tblCanciones.setFont(new Font("SansSerif", Font.PLAIN, 13));
        tblCanciones.setForeground(TEXTO);
        tblCanciones.setRowHeight(30);
        tblCanciones.setSelectionBackground(new Color(208, 235, 216));
        tblCanciones.setSelectionForeground(TEXTO);
        tblCanciones.setGridColor(new Color(225, 232, 226));
        tblCanciones.setShowVerticalLines(false);
        tblCanciones.setAutoCreateRowSorter(true);
        tblCanciones.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 13));
        tblCanciones.getTableHeader().setBackground(new Color(229, 239, 231));
        tblCanciones.getTableHeader().setForeground(VERDE_OSCURO);
        tblCanciones.getTableHeader().setReorderingAllowed(false);

        JScrollPane scroll = new JScrollPane(tblCanciones);
        scroll.setBorder(BorderFactory.createLineBorder(new Color(215, 226, 217)));
        scroll.getViewport().setBackground(Color.WHITE);
        return scroll;
    }

    /** Mini reproductor persistente, inspirado en la disposición habitual de reproductores musicales. */
    private JPanel crearPie() {
        JPanel exterior = new JPanel(new BorderLayout(0, 8));
        exterior.setBackground(VERDE_OSCURO);
        exterior.setBorder(BorderFactory.createEmptyBorder(14, 28, 15, 28));
        ahoraSuena = new JLabel("♫  Elige una canción de la biblioteca");
        ahoraSuena.setForeground(Color.WHITE);
        ahoraSuena.setFont(new Font("SansSerif", Font.BOLD, 14));
        exterior.add(ahoraSuena, BorderLayout.NORTH);

        JPanel controles = new JPanel(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 12, 0));
        controles.setOpaque(false);
        btnAnterior = crearBoton("⏮  Anterior", new Color(44, 76, 57), Color.WHITE);
        btnReproducir = crearBoton("▶  Reproducir", VERDE, Color.WHITE);
        btnSiguiente = crearBoton("Siguiente  ⏭", new Color(44, 76, 57), Color.WHITE);
        btnAnterior.addActionListener(e -> cambiarCancion(-1));
        btnReproducir.addActionListener(e -> alternarReproduccion());
        btnSiguiente.addActionListener(e -> cambiarCancion(1));
        controles.add(btnAnterior);
        controles.add(btnReproducir);
        controles.add(btnSiguiente);
        exterior.add(controles, BorderLayout.CENTER);

        JPanel linea = new JPanel(new BorderLayout(12, 0));
        linea.setOpaque(false);
        reloj = new JLabel("0:00 / 0:00");
        reloj.setForeground(new Color(202, 226, 207));
        progreso = new JSlider(0, 100, 0);
        progreso.setOpaque(false);
        progreso.setEnabled(false);
        progreso.addChangeListener(e -> {
            if (!actualizandoProgreso && !progreso.getValueIsAdjusting() && duracionActual > 0) {
                segundosActuales = progreso.getValue();
                actualizarTiempo();
            }
        });
        linea.add(progreso, BorderLayout.CENTER);
        linea.add(reloj, BorderLayout.EAST);
        exterior.add(linea, BorderLayout.SOUTH);
        return exterior;
    }

    private void alternarReproduccion() {
        if (tituloActual.isEmpty()) {
            iniciarSeleccionada();
        } else if (reproduciendo) {
            reproduciendo = false;
            temporizador.stop();
            btnReproducir.setText("▶  Continuar");
            ahoraSuena.setText("⏸  En pausa: " + tituloActual + " — " + artistaActual);
        } else {
            // Si se seleccionó otra canción, reproducirla en vez de continuar la anterior.
            if (seleccionEsDiferente()) {
                iniciarSeleccionada();
                return;
            }
            reproduciendo = true;
            temporizador.start();
            btnReproducir.setText("⏸  Pausar");
            ahoraSuena.setText("♫  Reproduciendo: " + tituloActual + " — " + artistaActual);
        }
    }

    private boolean seleccionEsDiferente() {
        int vista = tblCanciones.getSelectedRow();
        if (vista < 0) return false;
        int fila = tblCanciones.convertRowIndexToModel(vista);
        return !tituloActual.equals(modelo.getValueAt(fila, 0).toString())
            || !artistaActual.equals(modelo.getValueAt(fila, 1).toString());
    }

    private void iniciarSeleccionada() {
        int vista = tblCanciones.getSelectedRow();
        if (vista < 0) {
            JOptionPane.showMessageDialog(this, "Selecciona primero una canción de la tabla.",
                    "Biblioteca SoundWave", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        int fila = tblCanciones.convertRowIndexToModel(vista);
        String titulo = modelo.getValueAt(fila, 0).toString();
        String artista = modelo.getValueAt(fila, 1).toString();
        String duracion = modelo.getValueAt(fila, 2).toString();
        String[] partes = duracion.split(":");
        int segundos = Integer.parseInt(partes[0]) * 60 + Integer.parseInt(partes[1]);
        try {
            dao.registrarReproduccion(titulo, artista);
            tituloActual = titulo;
            artistaActual = artista;
            duracionActual = Math.max(1, segundos);
            segundosActuales = 0;
            progreso.setMaximum(duracionActual);
            progreso.setEnabled(true);
            reproduciendo = true;
            eventos.notificar(titulo, artista);
            btnReproducir.setText("⏸  Pausar");
            ahoraSuena.setText("♫  Reproduciendo: " + titulo + " — " + artista);
            actualizarTiempo();
            temporizador.restart();
            // Refrescar el contador sin interrumpir el reproductor.
            cargarCanciones(txtBuscar.getText().trim());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "No se pudo registrar la reproducción.\n" + ex.getMessage(),
                    "Error de base de datos", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void cambiarCancion(int direccion) {
        int filas = tblCanciones.getRowCount();
        if (filas == 0) {
            JOptionPane.showMessageDialog(this, "No hay canciones en la lista actual.");
            return;
        }
        int vista = tblCanciones.getSelectedRow();
        int nueva = vista < 0 ? 0 : (vista + direccion + filas) % filas;
        tblCanciones.setRowSelectionInterval(nueva, nueva);
        tblCanciones.scrollRectToVisible(tblCanciones.getCellRect(nueva, 0, true));
        iniciarSeleccionada();
    }

    private void avanzarTiempo() {
        if (!reproduciendo) return;
        segundosActuales++;
        if (segundosActuales >= duracionActual) {
            cambiarCancion(1);
        } else {
            actualizarTiempo();
        }
    }

    private void actualizarTiempo() {
        actualizandoProgreso = true;
        progreso.setValue(segundosActuales);
        actualizandoProgreso = false;
        reloj.setText(formatearSegundos(segundosActuales) + " / " + formatearSegundos(duracionActual));
    }

    private String formatearSegundos(int segundos) {
        return String.format("%d:%02d", segundos / 60, segundos % 60);
    }

    private JButton crearBoton(String texto, Color fondo, Color letra) {
        JButton boton = new JButton(texto);
        boton.setFont(new Font("SansSerif", Font.BOLD, 13));
        boton.setBackground(fondo);
        boton.setForeground(letra);
        boton.setFocusPainted(false);
        boton.setBorder(BorderFactory.createEmptyBorder(11, 17, 11, 17));
        boton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        return boton;
    }

    /** Consulta el DAO y vuelve a llenar la tabla con el resultado de SQLite. */
    private void cargarCanciones(String texto) {
        try {
            modelo.setRowCount(0);
            List<Canciones> canciones = dao.buscar(texto);
            for (Canciones cancion : canciones) {
                modelo.addRow(new Object[]{
                    cancion.getNombre(),
                    cancion.getArtista(),
                    formatearDuracion(cancion.getDuracion()),
                    cancion.getReproducciones()
                });
            }
            // Mantener seleccionada la canción activa tras actualizar reproducciones.
            for (int i = 0; i < modelo.getRowCount(); i++) {
                if (tituloActual.equals(modelo.getValueAt(i, 0).toString())
                        && artistaActual.equals(modelo.getValueAt(i, 1).toString())) {
                    int vista = tblCanciones.convertRowIndexToView(i);
                    if (vista >= 0) tblCanciones.setRowSelectionInterval(vista, vista);
                    break;
                }
            }
            setTitle("SoundWave | " + canciones.size() + " canciones");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this,
                    "No se pudieron consultar las canciones.\n" + ex.getMessage(),
                    "Error de base de datos", JOptionPane.ERROR_MESSAGE);
        }
    }

    /** El DAO entrega la duración en minutos decimales; aquí se muestra mm:ss. */
    private String formatearDuracion(double minutosDecimales) {
        int totalSegundos = (int) Math.round(minutosDecimales * 60.0);
        int minutos = totalSegundos / 60;
        int segundos = totalSegundos % 60;
        return String.format("%d:%02d", minutos, segundos);
    }
}
