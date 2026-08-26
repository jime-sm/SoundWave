# SoundWave

SoundWave es una aplicación de música desarrollada en Java. Su funcionamiento consiste en mostrar al usuario información sobre diferentes elementos de una plataforma musical y permitirle seleccionar una canción de un catálogo.

## ¿Cómo funciona?

Cuando el usuario inicia SoundWave, la aplicación muestra en la consola la información disponible en la plataforma. Primero puede ver los usuarios registrados, los artistas, los álbumes y las playlists.

Después, la aplicación muestra un catálogo de *30 canciones*, cada una identificada con un número, su título y el artista correspondiente.

El usuario puede elegir una canción escribiendo su número. Al confirmar la selección, la aplicación muestra la información de la canción elegida y los datos relacionados con su reproducción.

En general, el usuario interactúa con la aplicación de esta forma:

*Iniciar → Consultar información → Ver canciones → Seleccionar una canción → Ver información de reproducción*

## ¿Qué puede hacer el usuario?

Consultar usuarios
El usuario puede visualizar los perfiles registrados en SoundWave y conocer la información mostrada de cada uno.

Consultar artistas
El usuario puede conocer los artistas incluidos en la aplicación y la información disponible sobre ellos, como su nombre y género musical.

 Consultar álbumes
El usuario puede visualizar los álbumes disponibles y consultar los datos que muestra la aplicación, como el nombre, el año de lanzamiento y la cantidad de canciones.

### Ver playlists
El usuario puede revisar las playlists que se encuentran registradas en SoundWave.

### Seleccionar una canción

El usuario puede elegir una canción del catálogo de 30 opciones. Para hacerlo, debe ingresar el número correspondiente a la canción que desea seleccionar.

### Ver el estado de reproducción
Después de seleccionar una canción, el usuario puede ver la información que muestra el reproductor, como:

* Canción seleccionada.
* Estado de reproducción.
* Volumen.

### Explorar canciones
El usuario puede consultar las 30 canciones disponibles en el catálogo. Cada canción está relacionada con un artista y aparece numerada para facilitar su selección.

## Manual de usuario
El uso de la aplicación es sencillo y se realiza directamente desde la consola.

### 1. Inicio
Al ejecutar SoundWave, la aplicación muestra la información general disponible:
* Usuarios.
* Artistas.
* Álbumes.
* Playlists.

### 2. Catálogo musical
Después se muestra el listado de las 30 canciones disponibles. Cada canción tiene un número para poder seleccionarla.

Por ejemplo:
text
1. Blinding Lights - The Weeknd
2. Save Your Tears - The Weeknd
3. Tití Me Preguntó - Bad Bunny
4. As It Was - Harry Styles
...


### 3. Seleccionar una canción
La aplicación solicita:
text
Escribe el número de la canción:
El usuario debe escribir el número de la canción que quiere seleccionar y presionar *Enter*.

### 4. Resultado

Después de seleccionar la canción, SoundWave muestra los datos de la canción elegida y la información correspondiente al reproductor.

Por ejemplo:

text
Canción: Blinding Lights
Artista: The Weeknd
Estado: Reproduciendo
Volumen: 70%

Así, el usuario puede identificar qué canción seleccionó y conocer el estado actual del reproductor.

## Funcionamiento general

SoundWave está pensado para que el usuario pueda recorrer la información musical disponible y seleccionar una canción desde el catálogo. La interacción principal se realiza desde la consola: primero se muestra la información de la plataforma, luego el listado de canciones y finalmente el usuario selecciona una de ellas para consultar sus datos de reproducción.


# Funcionamiento de SoundWave

## Descripción general

**SoundWave** es una aplicación desarrollada en **Java** que simula algunas de las funciones principales de una plataforma de reproducción musical. El proyecto fue construido aplicando conceptos de **Programación Orientada a Objetos (POO)**, mediante diferentes clases encargadas de representar usuarios, artistas, álbumes, canciones, playlists y un reproductor.

La aplicación funciona desde la consola y permite realizar acciones como registrarse, iniciar sesión, consultar información musical, seleccionar una canción para reproducirla y visualizar información relacionada con artistas, álbumes y playlists.

El programa está compuesto por las siguientes clases:

* `SoundWave`
* `Usuario`
* `Canciones`
* `Artista`
* `Album`
* `Reproductor`
* `Playlist`

---

## Flujo general de la aplicación

La ejecución comienza desde la clase `SoundWave`, que contiene el método `main`.

Cuando el programa inicia, se muestra el menú principal:

```text
========================================
        BIENVENIDO A SOUNDWAVE
========================================
1. Registrarse
2. Iniciar sesion
Seleccione una opcion:
```

El usuario puede elegir entre registrarse como un nuevo usuario o iniciar sesión utilizando las credenciales de un usuario previamente creado.

Después de esta etapa, el programa carga y muestra la información de artistas, álbumes y canciones disponibles. Posteriormente, presenta un listado de 30 canciones y solicita seleccionar una mediante su número.

Cuando una canción es seleccionada, el sistema ejecuta su método de reproducción e incrementa automáticamente su número de reproducciones.

Finalmente, el programa demuestra el funcionamiento del reproductor y muestra información correspondiente a las playlists creadas.

---

## Clase `SoundWave`

La clase `SoundWave` es la **clase principal del programa**. Contiene el método:

```java
public static void main(String[] args)
```

Desde esta clase se crean los objetos y se coordinan las diferentes funciones de la aplicación.

También utiliza:

```java
Scanner entrada = new Scanner(System.in);
```

El objeto `Scanner` permite capturar desde la consola las opciones y datos ingresados por el usuario.

### Funciones principales realizadas desde `SoundWave`

La clase principal se encarga de:

1. Mostrar el menú inicial.
2. Permitir el registro de nuevos usuarios.
3. Permitir el inicio de sesión.
4. Crear los objetos correspondientes a artistas.
5. Crear los objetos correspondientes a álbumes.
6. Crear las canciones disponibles.
7. Mostrar un catálogo de canciones.
8. Recibir la canción seleccionada por el usuario.
9. Reproducir únicamente la canción elegida.
10. Ejecutar las funciones del reproductor.
11. Mostrar información de las playlists.

---

# Gestión de usuarios

## Clase `Usuario`

La clase `Usuario` representa a las personas que pueden utilizar SoundWave.

Sus atributos son:

```java
private String nombreUsuario;
private String correo;
private String contrasena;
private boolean cuentaPremium;
```

Cada usuario posee un nombre, un correo electrónico, una contraseña y un tipo de cuenta.

El atributo `cuentaPremium` utiliza un valor booleano:

```text
true  = cuenta Premium
false = cuenta Gratuita
```

### Registro de usuario

Cuando se selecciona la opción:

```text
1. Registrarse
```

el programa solicita:

* Nombre de usuario.
* Correo electrónico.
* Contraseña.
* Tipo de cuenta Premium o gratuita.

Posteriormente, se crea un objeto de tipo `Usuario`:

```java
Usuario nuevoUsuario =
        new Usuario(nombre, correo, contrasena, premium);
```

Después del registro se utiliza:

```java
nuevoUsuario.mostrarPerfil();
```

para mostrar la información del usuario creado.

### Inicio de sesión

El programa también posee un usuario previamente registrado:

```java
Usuario usuarioRegistrado = new Usuario(
        "Maria_Jimena",
        "maria@unilibre.edu.co",
        "12345",
        true
);
```

Cuando se selecciona:

```text
2. Iniciar sesion
```

se solicita el correo y la contraseña.

Estos datos son enviados al método:

```java
iniciarSesion()
```

de la clase `Usuario`.

El método funciona de la siguiente manera:

```java
public boolean iniciarSesion(String correoIngresado, String contrasenaIngresada) {
    return correo.equals(correoIngresado)
            && contrasena.equals(contrasenaIngresada);
}
```

Si ambos datos coinciden, el método devuelve `true` y el inicio de sesión es exitoso. En caso contrario, devuelve `false`.

### Validación del correo

El método:

```java
setCorreo()
```

comprueba que el correo ingresado contenga el símbolo `@` antes de almacenarlo.

### Mostrar perfil

El método:

```java
mostrarPerfil()
```

permite visualizar el nombre, correo y tipo de cuenta del usuario.

Mediante un operador ternario se determina si el plan es Premium o Gratuito:

```java
String tipoPlan = cuentaPremium ? "Premium" : "Gratuito";
```

---

# Gestión de artistas

## Clase `Artista`

La clase `Artista` almacena información relacionada con los artistas disponibles en SoundWave.

Sus atributos son:

```java
private String nombre;
private String generoMusical;
private int oyentesMensuales;
```

Cada objeto contiene:

* Nombre del artista.
* Género musical.
* Número de oyentes mensuales.

En la aplicación se crean diferentes objetos, por ejemplo:

```java
Artista artista1 =
        new Artista("Bad Bunny", "Urbano", 52000000);

Artista artista2 =
        new Artista("Shakira", "Pop Latino", 68000000);
```

El método:

```java
mostrarInfoArtista()
```

muestra la información almacenada de cada artista.

También se utiliza una validación en `setOyentesMensuales()` para impedir que se almacenen valores negativos.

---

# Gestión de álbumes

## Clase `Album`

La clase `Album` representa los álbumes registrados en la plataforma.

Sus atributos son:

```java
private String titulo;
private int añoLanzamiento;
private int numeroCanciones;
```

Cada álbum contiene:

* Título.
* Año de lanzamiento.
* Número de canciones.

Por ejemplo:

```java
Album album1 =
        new Album("Un Verano Sin Ti", 2022, 23);
```

El método:

```java
mostrarDetallesAlbum()
```

permite visualizar la información del álbum.

La clase incluye dos validaciones:

```java
if (añoLanzamiento > 1900)
```

para controlar el año de lanzamiento y:

```java
if (numeroCanciones > 0)
```

para impedir álbumes con una cantidad de canciones igual o inferior a cero.

Actualmente, SoundWave contiene **30 objetos de tipo `Album`** asociados al catálogo musical utilizado en la aplicación.

---

# Gestión de canciones

## Clase `Canciones`

La clase `Canciones` representa cada canción disponible dentro de SoundWave.

Sus atributos son:

```java
private String nombre;
private String artista;
private double duracion;
private int reproducciones;
```

Cada canción almacena:

* Nombre.
* Artista.
* Duración.
* Cantidad de reproducciones.

Por ejemplo:

```java
Canciones cancion29 = new Canciones(
        "Industry Baby",
        "Lil Nas X, Jack Harlow",
        3.32,
        15500
);
```

### Reproducción de canciones

El comportamiento principal de esta clase se encuentra en:

```java
reproducirCancion()
```

Su funcionamiento es:

```java
public void reproducirCancion() {
    this.reproducciones++;

    System.out.println(
        " Reproduciendo: " + nombre
        + " - " + artista
        + " (Total reproducciones: "
        + reproducciones + ")"
    );
}
```

Cada vez que una canción es reproducida:

1. Se incrementa en uno su número de reproducciones.
2. Se muestra el nombre de la canción.
3. Se muestra el artista.
4. Se presenta el nuevo total de reproducciones.

Por ejemplo, si una canción posee inicialmente:

```text
15500 reproducciones
```

después de seleccionarla mostrará:

```text
15501 reproducciones
```

---

# Selección de canciones

SoundWave incluye actualmente **30 canciones**.

El programa utiliza los métodos:

```java
getNombre()
```

y:

```java
getArtista()
```

para construir automáticamente el listado mostrado al usuario.

Por ejemplo:

```java
System.out.println(
    "29. "
    + cancion29.getNombre()
    + " - "
    + cancion29.getArtista()
);
```

En la consola se presenta:

```text
29. Industry Baby - Lil Nas X, Jack Harlow
```

Después se solicita:

```text
Escribe el número de la canción:
```

El número seleccionado se almacena en:

```java
int opcionCancion
```

---

## Uso de `switch`

Para identificar qué canción debe reproducirse se utiliza una estructura `switch`.

Por ejemplo:

```java
switch (opcionCancion) {

    case 1:
        cancion1.reproducirCancion();
        break;

    case 2:
        cancion2.reproducirCancion();
        break;

    ...

    case 29:
        cancion29.reproducirCancion();
        break;

    case 30:
        cancion30.reproducirCancion();
        break;

    default:
        System.out.println("Número de canción no válido.");
        break;
}
```

Cada número se encuentra relacionado con un objeto `Canciones`.

Si el usuario escribe:

```text
29
```

se ejecuta:

```java
cancion29.reproducirCancion();
```

y el resultado será similar a:

```text
Reproduciendo: Industry Baby - Lil Nas X, Jack Harlow
(Total reproducciones: 15501)
```

Si se ingresa un número que no se encuentra entre 1 y 30, se ejecuta el bloque `default` y se muestra un mensaje indicando que la opción no es válida.

---

# Control del reproductor

## Clase `Reproductor`

La clase `Reproductor` simula algunos controles básicos de una plataforma musical.

Sus atributos son:

```java
private String estado;
private int volumen;
```

El reproductor se crea inicialmente mediante:

```java
Reproductor reproductor =
        new Reproductor("En Pausa", 40);
```

Por lo tanto, comienza:

```text
Estado: En Pausa
Volumen: 40 %
```

### Cambiar estado

El método:

```java
cambiarEstado()
```

permite modificar el estado del reproductor.

Por ejemplo:

```java
reproductor.cambiarEstado("Reproduciendo");
```

produce:

```text
Reproductor cambio su estado a: Reproduciendo
```

### Ajustar volumen

El método:

```java
ajustarVolumen()
```

modifica el nivel del volumen.

Por ejemplo:

```java
reproductor.ajustarVolumen(75);
```

produce:

```text
Volumen ajustado a: 75%
```

La clase valida que el volumen únicamente pueda encontrarse entre:

```text
0 y 100
```

mediante:

```java
if (volumen >= 0 && volumen <= 100)
```

---

# Gestión de playlists

## Clase `Playlist`

La clase `Playlist` representa las listas de reproducción creadas dentro de la aplicación.

Sus atributos son:

```java
private String nombrePlaylist;
private int totalCanciones;
private boolean esPublica;
```

Cada playlist contiene:

* Nombre.
* Número total de canciones.
* Visibilidad.

Actualmente se crean dos playlists:

```java
Playlist playlist1 =
        new Playlist("Favoritas Diurnas", 12, true);

Playlist playlist2 =
        new Playlist("Estudio & Programacion", 25, false);
```

El valor booleano determina su visibilidad:

```text
true  = Pública
false = Privada
```

El método:

```java
mostrarInfoPlaylist()
```

muestra estos datos en consola.

Ejemplo:

```text
Playlist: Favoritas Diurnas | Canciones: 12 | Visibilidad: Publica
Playlist: Estudio & Programacion | Canciones: 25 | Visibilidad: Privada
```

---

# Aplicación de Programación Orientada a Objetos

SoundWave utiliza diferentes fundamentos de la **Programación Orientada a Objetos**.

### Clases y objetos

Cada elemento de la plataforma se representa mediante una clase y posteriormente se crean objetos a partir de ella.

Ejemplo:

```java
Canciones cancion1 =
        new Canciones("Titi Me Pregunto", "Bad Bunny", 4.03, 1450);
```

`Canciones` corresponde a la clase y `cancion1` es el objeto creado.

### Encapsulamiento

Los atributos fueron declarados utilizando:

```java
private
```

Por ejemplo:

```java
private String nombre;
private int reproducciones;
```

Esto evita que los datos sean modificados directamente desde otras clases.

### Getters y setters

Para acceder o modificar los atributos privados se utilizan métodos *getters* y *setters*.

Ejemplo:

```java
public String getNombre() {
    return nombre;
}
```

y:

```java
public void setDuracion(double duracion) {
    if (duracion > 0) {
        this.duracion = duracion;
    }
}
```

### Constructores

Cada clase posee un constructor que permite asignar valores iniciales al momento de crear los objetos.

Ejemplo:

```java
public Canciones(
        String nombre,
        String artista,
        double duracion,
        int reproducciones
) {
    this.nombre = nombre;
    this.artista = artista;
    setDuracion(duracion);
    setReproducciones(reproducciones);
}
```

### Uso de `this`

La palabra reservada `this` permite hacer referencia al atributo del objeto actual.

Ejemplo:

```java
this.nombre = nombre;
```

### Métodos de comportamiento

Los objetos no solo almacenan información, también realizan acciones.

Algunos ejemplos son:

```java
reproducirCancion()
mostrarInfoArtista()
mostrarDetallesAlbum()
mostrarPerfil()
iniciarSesion()
cambiarEstado()
ajustarVolumen()
mostrarInfoPlaylist()
```

---

# Resumen del funcionamiento

El flujo general de **SoundWave** puede representarse de la siguiente manera:

```text
INICIO
   |
   v
Bienvenida a SoundWave
   |
   v
Registrarse / Iniciar sesión
   |
   v
Carga de artistas
   |
   v
Carga de álbumes
   |
   v
Catálogo de 30 canciones
   |
   v
Usuario selecciona una canción
   |
   v
Switch identifica la opción
   |
   v
Se ejecuta reproducirCancion()
   |
   v
Aumentan las reproducciones
   |
   v
Control del reproductor
   |
   v
Visualización de playlists
   |
   v
FIN
```

## Funcionalidades actuales

La versión actual de **SoundWave** permite:

* Registrar un nuevo usuario.
* Elegir entre una cuenta gratuita o Premium.
* Iniciar sesión con un usuario previamente registrado.
* Validar correo y contraseña para el inicio de sesión.
* Mostrar información de diferentes artistas.
* Mostrar información de diferentes álbumes.
* Gestionar un catálogo de 30 canciones.
* Seleccionar una canción mediante su número.
* Reproducir únicamente la canción seleccionada.
* Incrementar automáticamente su número de reproducciones.
* Cambiar el estado del reproductor.
* Ajustar el volumen entre 0 y 100.
* Mostrar playlists públicas y privadas.
* Aplicar encapsulamiento, constructores, objetos, getters, setters, validaciones y métodos de comportamiento.

## Tecnologías utilizadas

* **Java**
* **Programación Orientada a Objetos**
* **Maven**
* **NetBeans**
* Entrada de datos mediante `Scanner`
* Interacción mediante consola
