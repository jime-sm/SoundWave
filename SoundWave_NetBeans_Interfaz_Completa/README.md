# SoundWave 🎵 — Proyecto final de Programación 1

Aplicación de escritorio **Java 21 + Swing + SQLite**, lista para abrir como proyecto **Maven en NetBeans**. Se conserva la biblioteca de canciones del proyecto original y se integra la gestión de usuarios del corte 2.

## Integrantes
Completar con los nombres de todos los integrantes antes de entregar.

## Cómo ejecutar
1. Instalar JDK 21 y Apache NetBeans con soporte Maven.
2. Descomprimir la carpeta del proyecto y abrir **Archivo > Abrir proyecto**.
3. Esperar la descarga de la dependencia `sqlite-jdbc` indicada en `pom.xml` (requiere internet la primera vez).
4. Ejecutar `com.mycompany.soundwave.SoundWave` desde la raíz del proyecto (directorio que contiene `pom.xml`).
5. La base `soundwave.db` se crea/actualiza al iniciar. El script de referencia está en `src/main/resources/schema.sql`.

## Recorrido demostrable
- Buscar canciones por título o artista, seleccionar una y pulsar **Registrar reproducción**: cambia el contador de SQLite y aparece **Última reproducción**.
- Abrir **Usuarios > Registrarme**, crear cuenta gratuita y otra Premium; consultar **Usuarios registrados**.
- Cerrar sesión, iniciar sesión con las credenciales creadas y observar los beneficios del plan en **Mi perfil**.
- Probar correo inválido, clave corta, correo duplicado y acceso incorrecto: se muestran mensajes sin cerrar la aplicación.

## Mapa del proyecto (rúbrica)
| Concepto | Clase / paquete | Cómo se verifica |
|---|---|---|
| Herencia | `UsuarioGratuito`, `UsuarioPremium` → `Usuario` | Al registrar ambos planes se construyen subtipos reales. |
| Polimorfismo | `Usuario.obtenerTipoPlan()`, `Usuario.beneficios()` | Perfil y listado llaman métodos sobrescritos mediante referencia `Usuario`. |
| Encapsulamiento | `Usuario`, `Canciones`, `Reproductor` | Estado privado y validaciones en constructor / setters. |
| Abstracción | `Usuario` abstracta | Modela una cuenta sin permitir instanciar el tipo general. |
| Interfaces | `PlanMusical` implementada por `UsuarioGratuito`, `UsuarioPremium`, `PlanDecorador`; `UsuarioRepositorio` | El perfil consume `PlanMusical`; el servicio recibe un repositorio por interfaz. |
| Excepciones propias | `RegistroException`, `UsuarioServicio`, `UsuariosDialog` | Formulario muestra errores recuperables de registro e ingreso. |
| Persistencia (30 %) | `db/InicializadorDB`, `CancionDAOjdbc`, `SqliteUsuarioRepositorio` | Registrar cuentas, autenticar, listar y actualizar reproducciones; reiniciar y verificar datos. |
| Interfaz gráfica (30 %) | `ui/MainFrame`, `ui/UsuariosDialog` | Biblioteca, buscador, reproducción, registro, ingreso, perfil, listado. |
| SOLID S | `UsuarioServicio` / `SqliteUsuarioRepositorio` / `UsuariosDialog` | Reglas, persistencia y presentación separadas. |
| SOLID O | `PlanMusical`, `PlanDecorador` | Se añaden beneficios mediante decoración sin modificar las clases de plan. |
| SOLID L | `UsuarioGratuito`, `UsuarioPremium` | Ambos sustituyen a `Usuario` en el servicio y las tablas. |
| SOLID I | `PlanMusical`, `EscuchaReproduccion`, `UsuarioRepositorio` | Contratos pequeños con responsabilidades definidas. |
| SOLID D | `UsuarioServicio(UsuarioRepositorio)` | La lógica depende de la abstracción, no de SQLite. |
| Patrón creacional: Factory | `patrones/UsuarioFactory` | Registro y lectura desde SQLite crean el subtipo correcto. |
| Patrón estructural: Decorator | `patrones/PlanDecorador` | En **Mi perfil** se muestra descripción enriquecida del plan. |
| Patrón comportamiento: Observer | `patrones/EventosReproduccion`, `EscuchaReproduccion` | Reproducir notifica y actualiza la etiqueta **Última reproducción**. |

## Base de datos
El esquema de tablas está en `src/main/resources/schema.sql`. `InicializadorDB` prepara el esquema y carga canciones desde `src/main/resources/data.csv` si hace falta. La base SQLite es local (`soundwave.db`).

## Entrega GitHub
Crear un repositorio con **archivos fuente**, no subir solo un ZIP. Añadir `README.md`, `pom.xml`, `src/` y documentación; hacer commits identificables de los integrantes y compartir el enlace con el docente. El PDF de lineamientos fija como fecha límite el **21 de noviembre de 2026**.

## Limitación de seguridad
El módulo de usuarios conserva el esquema de contraseñas en texto plano del corte 2 por compatibilidad académica. **No usar cuentas ni contraseñas reales.** Para producción, migrar a hashes con sal (Argon2id o bcrypt) y control de acceso.

## Alcance de reproducción
El botón **Registrar reproducción** incrementa el contador en la base de datos; **no reproduce audio real**.


## Mini reproductor (interfaz gráfica)

En `ui/MainFrame.java`, selecciona una canción y pulsa **Reproducir**. La barra inferior muestra el título y artista, permite **Pausar / Continuar**, **Anterior / Siguiente** y presenta una **barra de progreso** con tiempo transcurrido y duración. Al llegar al final avanza a la siguiente canción visible. Los botones de siguiente/anterior respetan el orden de la tabla, incluso si está ordenada. Cada inicio de canción registra una reproducción en SQLite mediante `CancionDAO`; pausar y continuar no incrementan el contador. El evento de reproducción se notifica mediante el patrón Observer (`EventosReproduccion`).

**Alcance académico:** la reproducción es una simulación visual con temporizador Swing; la base de datos contiene metadatos de canciones, no archivos de audio. No se emite sonido real.
