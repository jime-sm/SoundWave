# 🎵 SoundWave — Proyecto final de Programación I

**Aplicación de escritorio para explorar música, administrar usuarios y simular la reproducción de canciones.**

**Universidad Libre · Facultad de Ingeniería · 2026**  
**Asignatura:** Programación I · **Grupo:** SC  
**Docente:** Andrés Felipe Castaño Rubiano

## 👥 Integrantes

- Karen Daniela Pabón Osorio
- Juan Felipe Ramírez
- Sebastián Moreno
- María Jimena Serrano Murillo

## 📌 Descripción

SoundWave es una aplicación académica desarrollada en **Java 21**, con interfaz gráfica **Java Swing**, gestión de dependencias **Maven** y persistencia local mediante **SQLite/JDBC**. Evoluciona el prototipo del segundo corte, basado principalmente en menús de consola y colecciones en memoria, hacia una aplicación de escritorio con biblioteca musical, buscador, cuentas de usuario y mini reproductor visual.

El objetivo del proyecto es demostrar los fundamentos de programación orientada a objetos (POO), los cinco principios **SOLID** y tres categorías de patrones de diseño, mediante funcionalidades que pueden observarse durante la ejecución.

> **Alcance del reproductor:** simula reproducción mediante un temporizador y una barra de progreso; **no emite audio real**. Los registros musicales contienen metadatos, no archivos MP3.

## ✨ Funcionalidades

| Módulo | Funcionalidad | Resultado visible |
|---|---|---|
| Biblioteca | Consultar canciones y buscar por título o artista | Tabla filtrable de canciones |
| Reproductor | Reproducir (simulado), pausar, continuar, anterior y siguiente | Barra inferior con canción activa, botones y tiempo |
| Historial/contador | Registrar cada inicio de reproducción | Contador persistente y etiqueta «Última reproducción» |
| Usuarios | Registrar cuentas gratuitas y Premium | Formulario con validaciones |
| Autenticación | Iniciar y cerrar sesión | Cambio de estado de sesión |
| Perfiles | Consultar plan y beneficios | Información diferenciada según el tipo de cuenta |
| Administración | Consultar usuarios registrados | Listado de cuentas |
| Errores | Detectar datos inválidos y accesos incorrectos | Mensajes claros sin cerrar la aplicación |

Los beneficios de los planes son una **representación académica**: no hay anuncios reales ni un sistema comercial de suscripciones.

## 🛠️ Tecnologías y requisitos

- **JDK 21** (Java Development Kit).
- **Apache NetBeans** con soporte para proyectos Maven.
- **Maven**, administrado por NetBeans o instalado localmente.
- **SQLite JDBC 3.46.1.3**, descargado automáticamente por Maven cuando esté disponible la conexión a Internet.
- **Swing**, incluido en Java, para la interfaz de escritorio.

## 🚀 Instalación y ejecución en NetBeans

1. Clonar el repositorio o descargar su contenido y descomprimirlo.
2. Abrir **Apache NetBeans → Archivo → Abrir proyecto**.
3. Seleccionar la carpeta **`SoundWave_NetBeans_Interfaz_Completa`**, donde está `pom.xml` (o la raíz si el contenido del proyecto se subió directamente al repositorio).
4. Esperar a que Maven resuelva las dependencias. La primera ejecución puede requerir Internet.
5. Ejecutar el proyecto, o ejecutar la clase **`com.mycompany.soundwave.SoundWave`**.
6. En el arranque, `InicializadorDB` prepara las tablas de SQLite y carga canciones iniciales desde `data.csv` cuando corresponda.

**Alternativa con Maven (desde la carpeta que contiene `pom.xml`):**

```bash
mvn clean compile
mvn exec:java -Dexec.mainClass=com.mycompany.soundwave.SoundWave
```

> La ubicación de `soundwave.db` depende del directorio de trabajo desde el que se ejecuta la aplicación. Para probar la persistencia, iniciar siempre desde la misma carpeta y no borrar el archivo de base de datos entre ejecuciones.

## 📂 Estructura del proyecto

```text
SoundWave_NetBeans_Interfaz_Completa/
├── pom.xml
├── README.md
├── soundwave.db                    # Base SQLite local incluida en esta versión
├── src/main/
│   ├── java/com/mycompany/soundwave/
│   │   ├── SoundWave.java          # Punto de entrada
│   │   ├── Usuario.java            # Clase abstracta de usuario
│   │   ├── UsuarioGratuito.java
│   │   ├── UsuarioPremium.java
│   │   ├── PlanMusical.java        # Interfaz de beneficios
│   │   ├── Canciones.java
│   │   ├── CancionDAO.java
│   │   ├── CancionDAOjdbc.java
│   │   ├── Artista.java
│   │   ├── Album.java
│   │   ├── Playlist.java
│   │   ├── Reproductor.java
│   │   ├── ui/
│   │   │   ├── MainFrame.java       # Biblioteca y mini reproductor
│   │   │   └── UsuariosDialog.java  # Registro, acceso y perfiles
│   │   ├── db/
│   │   │   ├── ConexionDB.java
│   │   │   └── InicializadorDB.java
│   │   ├── servicio/
│   │   │   ├── UsuarioServicio.java
│   │   │   ├── UsuarioRepositorio.java
│   │   │   ├── SqliteUsuarioRepositorio.java
│   │   │   └── RegistroException.java
│   │   └── patrones/
│   │       ├── UsuarioFactory.java
│   │       ├── PlanDecorador.java
│   │       ├── EventosReproduccion.java
│   │       └── EscuchaReproduccion.java
│   └── resources/
│       ├── schema.sql              # Script de creación de tablas
│       └── data.csv                # Datos musicales iniciales
└── documentación del proyecto     # Añadir el DOCX/PDF al repositorio
```

## 🏗️ Arquitectura y flujo

La aplicación separa la **presentación** (`ui`), las **reglas de negocio** (`servicio`), los **contratos de acceso a datos** (interfaces DAO/repositorio), la **persistencia** (`db`, implementaciones JDBC) y los **patrones** (`patrones`).

**Inicio:** `SoundWave.main()` → `InicializadorDB.iniciar()` → `MainFrame`.

**Registro de usuario:** `UsuariosDialog` → `UsuarioServicio` (valida) → `UsuarioFactory` (crea el subtipo) → `UsuarioRepositorio` / `SqliteUsuarioRepositorio` (guarda en SQLite).

**Inicio de canción:** `MainFrame` → `CancionDAOjdbc` (actualiza reproducciones) → `EventosReproduccion` (notifica a los observadores) → actualización visual de «Última reproducción».

## 🗃️ Persistencia y base de datos

La aplicación usa una base de datos **SQLite** almacenada en un archivo local. El esquema se encuentra en `src/main/resources/schema.sql` y la carga inicial de canciones en `src/main/resources/data.csv`.

- **Canciones:** consulta y filtrado; actualización del número de reproducciones mediante `CancionDAOjdbc`.
- **Usuarios:** registro, búsqueda para autenticación y listado mediante `SqliteUsuarioRepositorio`.
- **Inicialización:** `InicializadorDB` crea/prepara las tablas y carga datos musicales iniciales cuando hace falta.

**Comprobación de persistencia:** registrar una cuenta, cerrar SoundWave, abrir nuevamente y comprobar que la cuenta sigue disponible; reproducir una canción, reiniciar y comprobar que su contador conserva el cambio.

> **Seguridad:** esta versión académica conserva contraseñas sin hash criptográfico. No registrar contraseñas reales. Un sistema de producción necesitaría hashing con sal (p. ej., Argon2id o bcrypt), controles de acceso y pruebas de seguridad.

## 🎧 Funcionamiento del mini reproductor

1. Buscar o seleccionar una canción en la tabla.
2. Presionar **Reproducir**: comienza la simulación, se muestra el título y artista y se registra una reproducción.
3. Presionar **Pausar**: el temporizador deja de avanzar.
4. Presionar **Continuar**: el progreso continúa sin aumentar nuevamente el contador.
5. Presionar **Anterior** o **Siguiente**: se cambia la canción según el orden de la tabla.
6. Al alcanzar el tiempo de duración, el sistema avanza a la siguiente canción visible.

Los métodos de `MainFrame` que permiten estudiar este comportamiento son `alternarReproduccion()`, `iniciarSeleccionada()`, `cambiarCancion(int)`, `avanzarTiempo()` y `actualizarTiempo()`. El progreso es una simulación de tiempo con `javax.swing.Timer`.

## 🧭 Mapa del proyecto — Rúbrica del docente

**Este mapa indica dónde está cada concepto y cómo comprobarlo ejecutando la aplicación.** Es importante porque la evaluación exige que los elementos funcionen y no solo existan en el código.

### Requisitos obligatorios de POO

| Concepto | Clase(s) o paquete(s) | Aplicación y demostración |
|---|---|---|
| **Herencia** | `Usuario`, `UsuarioGratuito`, `UsuarioPremium` | Las dos clases concretas heredan del tipo general `Usuario`; registrar ambos planes. |
| **Polimorfismo** | `Usuario.obtenerTipoPlan()`, `Usuario.beneficios()` | El perfil y el listado obtienen comportamientos diferentes según el subtipo, usando referencias comunes. |
| **Encapsulamiento** | `Usuario`, `Canciones`, `Reproductor` | Atributos privados y métodos de acceso/validación; intentar registrar información inválida. |
| **Abstracción** | `Usuario` | Clase abstracta que representa características comunes de las cuentas y define operaciones especializadas. |
| **Interfaces propias** | `PlanMusical`, `UsuarioRepositorio`, `CancionDAO`, `EscuchaReproduccion` | Contratos usados en servicios, persistencia y eventos; `PlanMusical` es implementada por los tipos de usuario y el decorador. |
| **Manejo de errores** | `RegistroException`, `UsuarioServicio`, `UsuariosDialog` | Validar correo, contraseña, duplicados y acceso incorrecto; se informa el error sin cerrar el programa. |

### Criterios de calificación

| Criterio | Peso | Clase(s) / paquete(s) | Evidencia en ejecución |
|---|---:|---|---|
| **Persistencia** | **30 %** | `db/InicializadorDB`, `db/ConexionDB`, `CancionDAOjdbc`, `SqliteUsuarioRepositorio` | Registrar usuarios y reproducciones; reiniciar y comprobar que se conservan. |
| **Interfaz gráfica** | **30 %** | `ui/MainFrame`, `ui/UsuariosDialog` | Buscar canciones, utilizar el reproductor y administrar cuentas desde ventanas Swing. |
| **SOLID** | **10 %** | Detalle S, O, L, I, D en la tabla siguiente | Demostrar registro, perfiles, eventos y persistencia. |
| **Patrón creacional** | **10 %** | `patrones/UsuarioFactory` | Registrar una cuenta gratuita y otra Premium. |
| **Patrón estructural** | **10 %** | `patrones/PlanDecorador` | Abrir «Mi perfil» y consultar la descripción enriquecida de beneficios. |
| **Patrón de comportamiento** | **10 %** | `patrones/EventosReproduccion`, `EscuchaReproduccion` | Iniciar una canción y observar el cambio de «Última reproducción». |

### Principios SOLID, uno por uno

| Principio | Dónde está | Cómo se utiliza |
|---|---|---|
| **S — Responsabilidad única** | `UsuarioServicio`, `SqliteUsuarioRepositorio`, `UsuariosDialog` | Las reglas de cuentas, el almacenamiento y la interfaz están separados. |
| **O — Abierto/cerrado** | `PlanMusical`, `PlanDecorador` | Se añade una presentación de beneficios envolviendo el plan sin modificar las clases concretas de usuario. |
| **L — Sustitución de Liskov** | `UsuarioGratuito`, `UsuarioPremium`, `Usuario` | Ambos subtipos se pueden utilizar donde se espera un `Usuario`. |
| **I — Segregación de interfaces** | `PlanMusical`, `UsuarioRepositorio`, `EscuchaReproduccion` | Cada contrato tiene un propósito concreto y evita exigir operaciones ajenas. |
| **D — Inversión de dependencias** | `UsuarioServicio(UsuarioRepositorio)` | El servicio depende del contrato `UsuarioRepositorio`, no de la clase SQLite concreta. |

### Patrones de diseño: justificación

**Factory (creacional).** `UsuarioFactory` centraliza la creación de `UsuarioGratuito` y `UsuarioPremium`. La interfaz no necesita conocer todos los detalles de construcción de cada subtipo.

**Decorator (estructural).** `PlanDecorador` implementa `PlanMusical`, envuelve otro `PlanMusical` y amplía el texto de beneficios. Se utiliza al mostrar la información del plan en el perfil.

**Observer (comportamiento).** `EventosReproduccion` administra oyentes de tipo `EscuchaReproduccion`. Cuando inicia una canción, notifica a sus suscriptores y se actualiza el texto de última reproducción en `MainFrame`.

## 🧪 Guion de pruebas para la sustentación

| N.º | Prueba | Resultado esperado |
|---:|---|---|
| 1 | Abrir el proyecto desde NetBeans | Aparece la ventana principal sin errores. |
| 2 | Buscar por nombre o artista | La tabla muestra coincidencias. |
| 3 | Reproducir una canción | Cambia el estado, avanza el reloj y aumenta el contador. |
| 4 | Pausar y continuar | El tiempo se detiene y reanuda; continuar no suma una reproducción. |
| 5 | Cambiar a siguiente/anterior | Cambia la canción activa y se reinicia el progreso. |
| 6 | Registrar usuario gratuito | Se crea la cuenta y se muestra su plan. |
| 7 | Registrar usuario Premium | Se crea la cuenta con beneficios diferenciados. |
| 8 | Ingresar y cerrar sesión | Se muestra el perfil y luego se cierra la sesión. |
| 9 | Usar correo inválido o clave corta | Aparece un mensaje de validación sin cerrar la aplicación. |
| 10 | Registrar correo duplicado | El sistema informa que no se puede duplicar la cuenta. |
| 11 | Reiniciar el programa | Se conservan usuarios y contadores de reproducción. |
| 12 | Abrir perfil y reproducir canción | Se observa Decorator en beneficios y Observer en última reproducción. |

**Estado de pruebas:** lista de verificación para ejecutar en el equipo del grupo. No se afirma que todas las pruebas hayan sido realizadas o aprobadas sin evidencia.

## ⚠️ Limitaciones conocidas

- La reproducción es **visual y simulada**; no se reproduce audio real.
- Los planes Gratuito/Premium son demostrativos; no implementan pagos ni anuncios efectivos.
- Las contraseñas no cuentan con protección apropiada para producción.
- La aplicación requiere un entorno de escritorio con Java 21 y la dependencia JDBC disponible.
- Las clases del modelo musical heredadas del corte anterior pueden existir como representación del dominio sin estar todas conectadas a acciones de la interfaz; en la rúbrica se deben demostrar únicamente los flujos funcionales.

## 📦 Entrega en GitHub

El repositorio debe contener el **código fuente completo** (no únicamente un ZIP), `pom.xml`, `README.md`, documentación del proyecto, `schema.sql` y los recursos necesarios. Los integrantes deben trabajar con **commits** identificables y comprobar que el repositorio sea público o esté compartido con el docente. Según los lineamientos, se evalúa el último commit realizado **a más tardar el 21 de noviembre de 2026**.

**Repositorio indicado en la documentación del segundo corte:** https://github.com/jime-sm/SoundWave.git  
**Antes de entregar:** verificar que este enlace contenga la versión final y los archivos descritos aquí.

## 📚 Documentación y referencias

- *Proyecto SoundWave — documentación del segundo corte* (documento del grupo).
- *Documentación SoundWave — Proyecto Final Ampliada* (documento técnico del grupo).
- *Lineamientos proyecto final — Programación I*, Universidad Libre, docente Andrés Castaño (rúbrica y condiciones de entrega).
- Código fuente de SoundWave, versión final con mini reproductor.

---

**SoundWave** · Proyecto académico de Programación I · Universidad Libre · 2026.
