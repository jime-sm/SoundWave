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
        
        cancion1.reproducirCancion();
        cancion2.reproducirCancion();
        System.out.println();

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


