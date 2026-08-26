# SoundWave

SoundWave es una aplicación de música desarrollada en Java. Su funcionamiento consiste en mostrar al usuario información sobre diferentes elementos de una plataforma musical y permitirle seleccionar una canción de un catálogo.

## ¿Cómo funciona?

Cuando el usuario inicia SoundWave, la aplicación muestra en la consola la información disponible en la plataforma. Primero puede ver los usuarios registrados, los artistas, los álbumes y las playlists.

Después, la aplicación muestra un catálogo de *30 canciones*, cada una identificada con un número, su título y el artista correspondiente.

El usuario puede elegir una canción escribiendo su número. Al confirmar la selección, la aplicación muestra la información de la canción elegida y los datos relacionados con su reproducción.

En general, el usuario interactúa con la aplicación de esta forma:

*Iniciar → Consultar información → Ver canciones → Seleccionar una canción → Ver información de reproducción*

## ¿Qué puede hacer el usuario?

### Consultar usuarios

El usuario puede visualizar los perfiles registrados en SoundWave y conocer la información mostrada de cada uno.

### Consultar artistas

El usuario puede conocer los artistas incluidos en la aplicación y la información disponible sobre ellos, como su nombre y género musical.

### Consultar álbumes

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
