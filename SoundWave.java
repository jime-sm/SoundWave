/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.soundwave;

/**
 *
 * @author karen
 */
import java.util.Scanner;
public class SoundWave {
public static void main(String[] args) {
        
      Usuario usuarioRegistrado = new Usuario(
        "Maria_Jimena",
        "maria@unilibre.edu.co",
        "12345",
        true
);
        System.out.println("========================================");
        System.out.println("        BIENVENIDO A SOUNDWAVE");
        System.out.println("========================================");

        System.out.println("1. Registrarse");
        System.out.println("2. Iniciar sesion");
        System.out.print("Seleccione una opcion: ");
        Scanner entrada = new Scanner(System.in);

        int opcion = entrada.nextInt();
        entrada.nextLine();
        
    if (opcion == 1){

    System.out.println("\n--- REGISTRO DE USUARIO ---");

    System.out.print("Ingrese su nombre de usuario: ");
    String nombre = entrada.nextLine();

    System.out.print("Ingrese su correo: ");
    String correo = entrada.nextLine();

    System.out.print("Ingrese una contraseña: ");
    String contrasena = entrada.nextLine();

    System.out.print("¿Desea una cuenta Premium? (si/no): ");
    String respuesta = entrada.nextLine();

    boolean premium = respuesta.equalsIgnoreCase("si");

    Usuario nuevoUsuario =
            new Usuario(nombre, correo, contrasena, premium);

    System.out.println("\n¡Usuario registrado correctamente!");
    nuevoUsuario.mostrarPerfil();
}
        else if (opcion == 2) {

    System.out.println("\n--- INICIAR SESIÓN ---");

    System.out.print("Correo: ");
    String correo = entrada.nextLine();

    System.out.print("Contraseña: ");
    String contrasena = entrada.nextLine();

    if (usuarioRegistrado.iniciarSesion(correo, contrasena)) {

        System.out.println("\n¡Inicio de sesión exitoso!");
        System.out.println("Bienvenido a SoundWave, "
                + usuarioRegistrado.getNombreUsuario());

    } else {

        System.out.println("\nCorreo o contraseña incorrectos.");
    }
}
        else {
    System.out.println("Opción no válida.");
}

        // 2. Demostración de la clase Artista
        // 2. Demostración de la clase Artista
System.out.println("--- ARTISTAS ---");

        Artista artista1 = new Artista("Bad Bunny", "Urbano", 52000000);
        Artista artista2 = new Artista("Shakira", "Pop Latino", 68000000);
        Artista artista3 = new Artista("Arctic Monkeys", "Indie Rock", 55000000);
        Artista artista4 = new Artista("Peso Pluma, Kenia OS", "Regional Mexicano / Pop", 42000000);
        Artista artista5 = new Artista("Kylie Cantrall", "Pop", 3500000);
        Artista artista6 = new Artista("Sabrina Carpenter", "Pop", 82000000);
        Artista artista7 = new Artista("Rauw Alejandro, Chencho Corleone", "Urbano / Reguetón", 48000000);
        Artista artista8 = new Artista("Queen", "Rock", 55000000);
        Artista artista9 = new Artista("Nirvana", "Grunge / Rock", 32000000);
        Artista artista10 = new Artista("Linkin Park", "Rock Alternativo", 45000000);
        Artista artista11 = new Artista("Guns N' Roses", "Hard Rock", 30000000);
        Artista artista12 = new Artista("AC/DC", "Hard Rock", 37000000);
        Artista artista13 = new Artista("Avicii", "Música Electrónica", 34000000);
        Artista artista14 = new Artista("The Weeknd", "R&B / Pop", 110000000);
        Artista artista15 = new Artista("Ed Sheeran", "Pop", 85000000);
        Artista artista16 = new Artista("Billie Eilish", "Pop Alternativo", 75000000);
        Artista artista17 = new Artista("Olivia Rodrigo", "Pop", 50000000);
        Artista artista18 = new Artista("ROSÉ, Bruno Mars", "Pop", 100000000);
        Artista artista19 = new Artista("BLACKPINK", "K-Pop", 18000000);
        Artista artista20 = new Artista("IVE", "K-Pop", 10000000);
        Artista artista21 = new Artista("Arctic Monkeys", "Indie Rock", 55000000);
        Artista artista22 = new Artista("Conan Gray", "Pop", 20000000);
        Artista artista23 = new Artista("Enanitos Verdes", "Rock en Español", 12000000);
        Artista artista24 = new Artista("Marc Anthony", "Salsa", 18000000);
        Artista artista25 = new Artista("Celia Cruz", "Salsa", 8000000);
        Artista artista26 = new Artista("Claude Debussy", "Música Clásica", 5000000);
        Artista artista27 = new Artista("Antonio Vivaldi", "Música Clásica", 7000000);
        Artista artista28 = new Artista("Eminem", "Hip-Hop / Rap", 80000000);
        Artista artista29 = new Artista("Lil Nas X, Jack Harlow", "Hip-Hop / Rap", 40000000);
        Artista artista30 = new Artista("deadmau5", "Música Electrónica", 5000000);
        
        artista1.mostrarInfoArtista();
        artista2.mostrarInfoArtista();
        artista3.mostrarInfoArtista();
        artista4.mostrarInfoArtista();
        artista5.mostrarInfoArtista();
        artista6.mostrarInfoArtista();
        artista7.mostrarInfoArtista();
        artista8.mostrarInfoArtista();
        artista9.mostrarInfoArtista();
        artista10.mostrarInfoArtista();
        artista11.mostrarInfoArtista();
        artista12.mostrarInfoArtista();
        artista13.mostrarInfoArtista();
        artista14.mostrarInfoArtista();
        artista15.mostrarInfoArtista();
        artista16.mostrarInfoArtista();
        artista17.mostrarInfoArtista();
        artista18.mostrarInfoArtista();
        artista19.mostrarInfoArtista();
        artista20.mostrarInfoArtista();
        artista21.mostrarInfoArtista();
        artista22.mostrarInfoArtista();
        artista23.mostrarInfoArtista();
        artista24.mostrarInfoArtista();
        artista25.mostrarInfoArtista();
        artista26.mostrarInfoArtista();
        artista27.mostrarInfoArtista();
        artista28.mostrarInfoArtista();
        artista29.mostrarInfoArtista();
        artista30.mostrarInfoArtista();

        System.out.println();

        // 3. Demostración de la clase Album
        // 3. Demostración de la clase Album
        System.out.println("--- ALBUMES ---");

        Album album1 = new Album("Un Verano Sin Ti", 2022, 23);
        Album album2 = new Album("Pies Descalzos", 1995, 11);
        Album album3 = new Album("AM", 2013, 12);
        Album album4 = new Album("ÉXODO", 2024, 24);
        Album album5 = new Album("Descendants: The Rise of Red", 2024, 13);
        Album album6 = new Album("Short n' Sweet", 2024, 12);
        Album album7 = new Album("Vice Versa", 2021, 14);
        Album album8 = new Album("A Night at the Opera", 1975, 12);
        Album album9 = new Album("Nevermind", 1991, 13);
        Album album10 = new Album("Meteora", 2003, 13);
        Album album11 = new Album("Appetite for Destruction", 1987, 12);
        Album album12 = new Album("Back in Black", 1980, 10);
        Album album13 = new Album("True", 2013, 10);
        Album album14 = new Album("After Hours", 2020, 14);
        Album album15 = new Album("Divide", 2017, 16);
        Album album16 = new Album("Happier Than Ever", 2021, 16);
        Album album17 = new Album("SOUR", 2021, 11);
        Album album18 = new Album("rosie", 2024, 12);
        Album album19 = new Album("The Album", 2020, 8);
        Album album20 = new Album("I've IVE", 2023, 11);
        Album album21 = new Album("Favourite Worst Nightmare", 2007, 12);
        Album album22 = new Album("Kid Krow", 2020, 12);
        Album album23 = new Album("Big Bang", 1994, 13);
        Album album24 = new Album("3.0", 2013, 10);
        Album album25 = new Album("Mi Vida Es Cantar", 1998, 11);
        Album album26 = new Album("Suite Bergamasque", 1905, 4);
        Album album27 = new Album("The Four Seasons", 1959, 12);
        Album album28 = new Album("8 Mile", 2002, 16);
        Album album29 = new Album("Montero", 2021, 15);
        Album album30 = new Album("For Lack of a Better Name", 2009, 10);
        
        album1.mostrarDetallesAlbum();
        album2.mostrarDetallesAlbum();
        album3.mostrarDetallesAlbum();
        album4.mostrarDetallesAlbum();
        album5.mostrarDetallesAlbum();
        album6.mostrarDetallesAlbum();
        album7.mostrarDetallesAlbum();
        album8.mostrarDetallesAlbum();
        album9.mostrarDetallesAlbum();
        album10.mostrarDetallesAlbum();
        album11.mostrarDetallesAlbum();
        album12.mostrarDetallesAlbum();
        album13.mostrarDetallesAlbum();
        album14.mostrarDetallesAlbum();
        album15.mostrarDetallesAlbum();
        album16.mostrarDetallesAlbum();
        album17.mostrarDetallesAlbum();
        album18.mostrarDetallesAlbum();
        album19.mostrarDetallesAlbum();
        album20.mostrarDetallesAlbum();
        album21.mostrarDetallesAlbum();
        album22.mostrarDetallesAlbum();
        album23.mostrarDetallesAlbum();
        album24.mostrarDetallesAlbum();
        album25.mostrarDetallesAlbum();
        album26.mostrarDetallesAlbum();
        album27.mostrarDetallesAlbum();
        album28.mostrarDetallesAlbum();
        album29.mostrarDetallesAlbum();
        album30.mostrarDetallesAlbum();

        System.out.println();
        // 4. Demostración de la clase Cancion (Independencia de objetos y comportamiento)
        System.out.println("---CANCIONES---");
        Canciones cancion1 = new Canciones("Titi Me Pregunto", "Bad Bunny", 4.03, 1450);
        Canciones cancion2 = new Canciones("Estoy Aqui", "Shakira", 3.52, 920);
        Canciones cancion3 = new Canciones("Do i wanna know?", "Artic Monkeys", 4.32, 15000);
        Canciones cancion4 = new Canciones("Tommy & Pamela", "Peso Pluma, Kenia Os", 3.29, 1000);
        Canciones cancion5 = new Canciones("Space Between", "Kylie Cantrall", 3.39, 810);
        Canciones cancion6 = new Canciones("Expresso", "Sabrina Carpenter", 2.25, 20000);
        Canciones cancion7 = new Canciones("El Efecto", "Rauw Alejandro, Chencho Carleone", 3.37, 16000);
        Canciones cancion8 = new Canciones("Bohemian Rhapsody", "Queen", 5.55, 18500);
        Canciones cancion9 = new Canciones("Smells Like Teen Spirit", "Nirvana", 5.01, 16000);
        Canciones cancion10 = new Canciones("Numb", "Linkin Park", 3.05, 22000);
        Canciones cancion11 = new Canciones("Sweet Child O' Mine", "Guns N' Roses", 5.56, 19000);
        Canciones cancion12 = new Canciones("Back In Black", "AC/DC", 4.15, 14000);
        Canciones cancion13 = new Canciones("Wake Me Up", "Avicii", 4.09, 17500);
        Canciones cancion14 = new Canciones("Blinding Lights", "The Weeknd", 3.20, 25000);
        Canciones cancion15 = new Canciones("Shape of You", "Ed Sheeran", 3.53, 28000);
        Canciones cancion16 = new Canciones("Happier Than Ever", "Billie Eilish", 4.58, 13000);
        Canciones cancion17 = new Canciones("Good 4 U", "Olivia Rodrigo", 2.58, 21000);
        Canciones cancion18 = new Canciones("APT.", "ROSÉ, Bruno Mars", 2.49, 23000);
        Canciones cancion19 = new Canciones("How You Like That", "BLACKPINK", 3.01, 20000);
        Canciones cancion20 = new Canciones("I AM", "IVE", 3.03, 12500);
        Canciones cancion21 = new Canciones("505", "Arctic Monkeys", 4.13, 18000);
        Canciones cancion22 = new Canciones("Heather", "Conan Gray", 3.18, 11500);
        Canciones cancion23 = new Canciones("Lamento Boliviano", "Enanitos Verdes", 3.48, 9500);
        Canciones cancion24 = new Canciones("Vivir Mi Vida", "Marc Anthony", 4.13, 15000);
        Canciones cancion25 = new Canciones("La Vida Es un Carnaval", "Celia Cruz", 4.16, 11000);
        Canciones cancion26 = new Canciones("Clair de Lune", "Claude Debussy", 5.00, 7000);
        Canciones cancion27 = new Canciones("The Four Seasons: Spring", "Antonio Vivaldi", 3.30, 6000);
        Canciones cancion28 = new Canciones("Lose Yourself", "Eminem", 5.26, 17000);
        Canciones cancion29 = new Canciones("Industry Baby", "Lil Nas X, Jack Harlow", 3.32, 15500);
        Canciones cancion30 = new Canciones("Strobe", "Deadmau5", 10.37, 8500);

        // Mostrar las opciones
        System.out.println("===== SOUNDWAVE =====");
        System.out.println("Selecciona una canción:\n");

        System.out.println("1. " + cancion1.getNombre() + " - " + cancion1.getArtista());
        System.out.println("2. " + cancion2.getNombre() + " - " + cancion2.getArtista());
        System.out.println("3. " + cancion3.getNombre() + " - " + cancion3.getArtista());
        System.out.println("4. " + cancion4.getNombre() + " - " + cancion4.getArtista());
        System.out.println("5. " + cancion5.getNombre() + " - " + cancion5.getArtista());
        System.out.println("6. " + cancion6.getNombre() + " - " + cancion6.getArtista());
        System.out.println("7. " + cancion7.getNombre() + " - " + cancion7.getArtista());
        System.out.println("8. " + cancion8.getNombre() + " - " + cancion8.getArtista());
        System.out.println("9. " + cancion9.getNombre() + " - " + cancion9.getArtista());
        System.out.println("10. " + cancion10.getNombre() + " - " + cancion10.getArtista());
        System.out.println("11. " + cancion11.getNombre() + " - " + cancion11.getArtista());
        System.out.println("12. " + cancion12.getNombre() + " - " + cancion12.getArtista());
        System.out.println("13. " + cancion13.getNombre() + " - " + cancion13.getArtista());
        System.out.println("14. " + cancion14.getNombre() + " - " + cancion14.getArtista());
        System.out.println("15. " + cancion15.getNombre() + " - " + cancion15.getArtista());
        System.out.println("16. " + cancion16.getNombre() + " - " + cancion16.getArtista());
        System.out.println("17. " + cancion17.getNombre() + " - " + cancion17.getArtista());
        System.out.println("18. " + cancion18.getNombre() + " - " + cancion18.getArtista());
        System.out.println("19. " + cancion19.getNombre() + " - " + cancion19.getArtista());
        System.out.println("20. " + cancion20.getNombre() + " - " + cancion20.getArtista());
        System.out.println("21. " + cancion21.getNombre() + " - " + cancion21.getArtista());
        System.out.println("22. " + cancion22.getNombre() + " - " + cancion22.getArtista());
        System.out.println("23. " + cancion23.getNombre() + " - " + cancion23.getArtista());
        System.out.println("24. " + cancion24.getNombre() + " - " + cancion24.getArtista());
        System.out.println("25. " + cancion25.getNombre() + " - " + cancion25.getArtista());
        System.out.println("26. " + cancion26.getNombre() + " - " + cancion26.getArtista());
        System.out.println("27. " + cancion27.getNombre() + " - " + cancion27.getArtista());
        System.out.println("28. " + cancion28.getNombre() + " - " + cancion28.getArtista());
        System.out.println("29. " + cancion29.getNombre() + " - " + cancion29.getArtista());
        System.out.println("30. " + cancion30.getNombre() + " - " + cancion30.getArtista());

      System.out.print("\nEscribe el número de la canción: ");
    int opcionCancion = entrada.nextInt();
    entrada.nextLine();

        // Solo se reproduce la canción seleccionada
        switch (opcionCancion) {

    case 1:
        cancion1.reproducirCancion();
        break;

    case 2:
        cancion2.reproducirCancion();
        break;

    case 3:
        cancion3.reproducirCancion();
        break;

    case 4:
        cancion4.reproducirCancion();
        break;

    case 5:
        cancion5.reproducirCancion();
        break;

    case 6:
        cancion6.reproducirCancion();
        break;

    case 7:
        cancion7.reproducirCancion();
        break;

    case 8:
        cancion8.reproducirCancion();
        break;

    case 9:
        cancion9.reproducirCancion();
        break;

    case 10:
        cancion10.reproducirCancion();
        break;

    case 11:
        cancion11.reproducirCancion();
        break;

    case 12:
        cancion12.reproducirCancion();
        break;

    case 13:
        cancion13.reproducirCancion();
        break;

    case 14:
        cancion14.reproducirCancion();
        break;

    case 15:
        cancion15.reproducirCancion();
        break;

    case 16:
        cancion16.reproducirCancion();
        break;

    case 17:
        cancion17.reproducirCancion();
        break;

    case 18:
        cancion18.reproducirCancion();
        break;

    case 19:
        cancion19.reproducirCancion();
        break;

    case 20:
        cancion20.reproducirCancion();
        break;

    case 21:
        cancion21.reproducirCancion();
        break;

    case 22:
        cancion22.reproducirCancion();
        break;

    case 23:
        cancion23.reproducirCancion();
        break;

    case 24:
        cancion24.reproducirCancion();
        break;

    case 25:
        cancion25.reproducirCancion();
        break;

    case 26:
        cancion26.reproducirCancion();
        break;

    case 27:
        cancion27.reproducirCancion();
        break;

    case 28:
        cancion28.reproducirCancion();
        break;

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
                entrada.close();
        

  
        
        // 5. Demostración de la clase Reproductor
        System.out.println("--- CONTROL DEL REPRODUCTOR ---");
        Reproductor reproductor = new Reproductor("En Pausa", 40);
        reproductor.cambiarEstado("Reproduciendo");
        reproductor.ajustarVolumen(75);
        System.out.println();

        // 6. Demostración de la clase Playlist
        System.out.println("--- PLAYLISTS ---");
        Playlist playlist1 = new Playlist("Favoritas Diurnas", 12, true);
        Playlist playlist2 = new Playlist("Estudio & Programacion", 25, false);
        playlist1.mostrarInfoPlaylist();
        playlist2.mostrarInfoPlaylist();
        System.out.println("==================================================");
    }
   
} 


