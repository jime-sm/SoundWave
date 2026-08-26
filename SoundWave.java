/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.soundwave;

/**
 *
 * @author karen
 */
public class SoundWave {
public static void main(String[] args) {
        
        System.out.println("       SOUNDWAVE         ");
       
        
               System.out.println("USUARIOS");
        Usuario user1 = new Usuario("Maria_Jimena", "maria@unilibre.edu.co", true);
        Usuario user2 = new Usuario("CarlosDev", "carlos@gmail.com", false);
        user1.mostrarPerfil();
        user2.mostrarPerfil();
        System.out.println();

        // 2. Demostración de la clase Artista
        System.out.println("ARTISTAS");
        Artista artista1 = new Artista("Bad Bunny", "Urbano", 52000000);
        Artista artista2 = new Artista("Shakira", "Pop Latino", 68000000);
        artista1.mostrarInfoArtista();
        artista2.mostrarInfoArtista();
        System.out.println();

        // 3. Demostración de la clase Album
        System.out.println("ALBUMES");
        Album album1 = new Album("Un Verano Sin Ti", 2022, 23);
        Album album2 = new Album("Pies Descalzos", 1995, 11);
        album1.mostrarDetallesAlbum();
        album2.mostrarDetallesAlbum();
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
        Scanner scanner = new Scanner(System.in);
        int opcion = scanner.nextInt();

        // Solo se reproduce la canción seleccionada
        switch (opcion) {

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
                System.out.println("Opción no válida.");
                
                scanner.close();
        }

  
        
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


