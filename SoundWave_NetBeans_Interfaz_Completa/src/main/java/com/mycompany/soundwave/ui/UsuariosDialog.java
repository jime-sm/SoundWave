package com.mycompany.soundwave.ui;

import com.mycompany.soundwave.Usuario;
import com.mycompany.soundwave.UsuarioGratuito;
import com.mycompany.soundwave.UsuarioPremium;
import java.awt.*;
import java.sql.SQLException;
import com.mycompany.soundwave.servicio.*;
import com.mycompany.soundwave.patrones.PlanDecorador;
import java.util.Arrays;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/** Gestión de usuarios de Corte 2, integrada sin modificar la biblioteca musical. */
public class UsuariosDialog extends JDialog {
    private static final Color DARK = new Color(18,43,31), GREEN = new Color(34,139,78);
    private static final Color BG = new Color(245,248,245);
    private final CardLayout cards = new CardLayout();
    private final JPanel pages = new JPanel(cards);
    private final JLabel session = new JLabel("No has iniciado sesión");
    private final DefaultTableModel model = new DefaultTableModel(new String[]{"Nombre", "Correo", "Plan"},0) {
        @Override public boolean isCellEditable(int r,int c){return false;}
    };
    private Usuario activo;
    private final UsuarioServicio servicio = new UsuarioServicio(new SqliteUsuarioRepositorio());

    public UsuariosDialog(Frame owner) {
        super(owner,"SoundWave | Usuarios",true);
        setSize(800,720); setMinimumSize(new Dimension(680,620)); setLocationRelativeTo(owner);
        setLayout(new BorderLayout()); getContentPane().setBackground(BG);
        JPanel top = new JPanel(new BorderLayout()); top.setBackground(DARK);
        top.setBorder(BorderFactory.createEmptyBorder(20,26,20,26));
        JLabel title = new JLabel("♫  SoundWave  /  Mi cuenta");
        title.setFont(new Font("SansSerif",Font.BOLD,23)); title.setForeground(Color.WHITE);
        top.add(title,BorderLayout.WEST); add(top,BorderLayout.NORTH);
        JPanel nav = new JPanel(new FlowLayout(FlowLayout.CENTER,12,12)); nav.setBackground(BG);
        for(String name:new String[]{"Iniciar sesión","Registrarme","Mi perfil","Usuarios registrados"}) {
            JButton b=button(name); b.addActionListener(e->{if(name.equals("Usuarios registrados")) refresh();cards.show(pages,name);});nav.add(b);
        }
        JPanel body = new JPanel(new BorderLayout()); body.setBackground(BG);
        body.add(nav,BorderLayout.NORTH); body.add(pages,BorderLayout.CENTER);add(body,BorderLayout.CENTER);
        pages.add(login(),"Iniciar sesión");pages.add(register(),"Registrarme");pages.add(profile(),"Mi perfil");pages.add(users(),"Usuarios registrados");
        cards.show(pages,"Iniciar sesión");
    }
    private JPanel formPanel(String heading) {
        JPanel p=new JPanel(new GridBagLayout());p.setBackground(Color.WHITE);
        p.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(10,50,25,50),BorderFactory.createLineBorder(new Color(220,232,222))));
        p.putClientProperty("heading",heading);return p;
    }
    private void field(JPanel p,Component component,int row) {
        GridBagConstraints g=new GridBagConstraints();g.gridx=0;g.gridy=row;g.weightx=1;g.fill=GridBagConstraints.HORIZONTAL;
        g.insets=new Insets(7,28,7,28);p.add(component,g);
    }
    private JLabel heading(String text){JLabel l=new JLabel(text);l.setFont(new Font("SansSerif",Font.BOLD,21));l.setForeground(DARK);return l;}
    private JTextField input(){JTextField t=new JTextField(23);t.setFont(new Font("SansSerif",Font.PLAIN,15));t.setPreferredSize(new Dimension(300,36));return t;}
    private JButton button(String text){JButton b=new JButton(text);b.setBackground(GREEN);b.setForeground(Color.WHITE);b.setFont(new Font("SansSerif",Font.BOLD,12));b.setFocusPainted(false);b.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));return b;}
    private JPanel login(){
        JPanel p=formPanel("Iniciar sesión");JTextField email=input();JPasswordField pass=new JPasswordField(23);
        field(p,heading("¡Qué bueno verte de nuevo!"),0);field(p,new JLabel("Correo electrónico"),1);field(p,email,2);
        field(p,new JLabel("Contraseña"),3);field(p,pass,4);JButton enter=button("Entrar a SoundWave");field(p,enter,5);
        enter.addActionListener(e->{char[] pw=pass.getPassword();try{
            activo=servicio.ingresar(email.getText().trim(),new String(pw));
            updateProfile();pass.setText("");cards.show(pages,"Mi perfil");
        }catch(RegistroException ex){alert(ex.getMessage());}catch(SQLException ex){error(ex);}
        finally{Arrays.fill(pw,'\0');}});return p;
    }
    private JPanel register(){
        JPanel p=formPanel("Crear cuenta");JTextField name=input(),email=input();JPasswordField pass=new JPasswordField(23);
        JComboBox<String> plan=new JComboBox<>(new String[]{"Gratuito · con anuncios","Premium · sin anuncios"});
        field(p,heading("Únete a SoundWave"),0);field(p,new JLabel("Nombre de usuario"),1);field(p,name,2);
        field(p,new JLabel("Correo electrónico"),3);field(p,email,4);field(p,new JLabel("Contraseña"),5);field(p,pass,6);
        field(p,new JLabel("Elige tu plan"),7);field(p,plan,8);JButton save=button("Crear mi cuenta");field(p,save,9);
        save.addActionListener(e->{char[] pw=pass.getPassword();try{
                activo=servicio.registrar(name.getText().trim(),email.getText().trim(),new String(pw),plan.getSelectedIndex()==1);
                updateProfile();refresh();name.setText("");email.setText("");pass.setText("");
                JOptionPane.showMessageDialog(this,"¡Cuenta creada correctamente!");cards.show(pages,"Mi perfil");
            }catch(RegistroException ex){alert(ex.getMessage());}
            catch(SQLException ex){if(ex.getMessage()!=null&&ex.getMessage().contains("UNIQUE"))alert("Ese correo ya está registrado.");else error(ex);}
            finally{Arrays.fill(pw,'\0');}
        });return p;
    }
    private JLabel profileName=new JLabel("Inicia sesión para ver tu perfil");
    private JLabel profileEmail=new JLabel(""), profilePlan=new JLabel("");
    private JPanel profile(){JPanel p=formPanel("Mi perfil");field(p,heading("Tu espacio musical"),0);
        profileName.setFont(new Font("SansSerif",Font.BOLD,20));field(p,profileName,1);field(p,profileEmail,2);field(p,profilePlan,3);
        JLabel desc=new JLabel("Premium: sin anuncios  |  Gratuito: con anuncios");desc.setForeground(GREEN);field(p,desc,4);
        JButton logout=button("Cerrar sesión");field(p,logout,5);logout.addActionListener(e->{activo=null;updateProfile();cards.show(pages,"Iniciar sesión");});return p;
    }
    private void updateProfile(){if(activo==null){profileName.setText("Inicia sesión para ver tu perfil");profileEmail.setText("");profilePlan.setText("");}
        else {profileName.setText("Hola, "+activo.getNombreUsuario()+" ✨");profileEmail.setText("Correo: "+activo.getCorreo());profilePlan.setText("Plan: "+activo.obtenerTipoPlan()+"  |  "+new PlanDecorador(activo).beneficios());}}
    private JPanel users(){JPanel p=new JPanel(new BorderLayout(10,10));p.setBackground(BG);p.setBorder(BorderFactory.createEmptyBorder(12,30,25,30));
        p.add(heading("Comunidad SoundWave"),BorderLayout.NORTH);JTable table=new JTable(model);table.setRowHeight(32);
        table.setFont(new Font("SansSerif",Font.PLAIN,13));table.getTableHeader().setBackground(new Color(224,239,227));
        p.add(new JScrollPane(table),BorderLayout.CENTER);return p;}
    private void refresh(){model.setRowCount(0);try{
        for(Usuario u:servicio.listar())model.addRow(new Object[]{u.getNombreUsuario(),u.getCorreo(),u.obtenerTipoPlan()});
    }catch(SQLException ex){error(ex);}}
    private void alert(String message){JOptionPane.showMessageDialog(this,message,"SoundWave",JOptionPane.WARNING_MESSAGE);}
    private void error(SQLException ex){JOptionPane.showMessageDialog(this,"Error de base de datos: "+ex.getMessage(),"SoundWave",JOptionPane.ERROR_MESSAGE);}
}
