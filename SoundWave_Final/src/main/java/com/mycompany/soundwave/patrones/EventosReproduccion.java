package com.mycompany.soundwave.patrones;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/** Subject observable; los listeners se pueden añadir sin modificar el emisor. */
public final class EventosReproduccion {
 private final List<EscuchaReproduccion> escuchas=new CopyOnWriteArrayList<>();
 public void agregar(EscuchaReproduccion escucha){escuchas.add(escucha);}
 public void notificar(String titulo,String artista){for(EscuchaReproduccion e:escuchas)e.alReproducir(titulo,artista);}
}
