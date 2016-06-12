package katiostudio.rivence.Controlador;

import java.util.ArrayList;
import java.util.List;

import katiostudio.rivence.R;

/**
 * Created by cquinz on 27/4/16.
 */
public class Evento {

    /* Definición de variables globales */
    int photoId;
    String title, date, description;
    public List<Evento> eventos;

    /* Constructores */

    /**
     * Constructor de un evento
     *
     * @param titulo Titulo del evento.
     * @param fecha Fecha en la que se realiza el evento.
     * @param fotoId Identificador de la foto relacionada con el evento.
     * @param descripcion Texto adicional que se muestra cuando se pulsa el boton de mas informacion.
     */
    public Evento(String titulo, String fecha, int fotoId, String descripcion) {

        title = titulo;
        date = fecha;
        photoId = fotoId;
        description = descripcion;

    }

    /**
     * Constructor vacio.
     */
    public Evento() {
        //Constructor vacio
    }

    /* Inicialización de objetos */

    /**
     * Inicia varios objetos con toda la información recogida.
     */
    public void initializeData() {
        eventos = new ArrayList<>();
        eventos.add(new Evento("Mascletá en pza. Ayuntamiento Valencia", "Mañana a las 14:00", R.drawable.mascleta_event, "Protagonizada por la gran priotecnia Caballer bububububu"));
        eventos.add(new Evento("Opera en Ciudad de las Artes y las Ciencias", "En 3 días", R.drawable.opera_event, "A diferencia del oratorio, la ópera es una obra destinada a ser representada. Algunos géneros de teatro musical están estrechamente relacionados con la ópera, como son la zarzuela española, el singspiel alemán, la opereta vienesa, la opéra-comique francesa y el musical inglés y estadounidense."));
        eventos.add(new Evento("Conferencia sobre Marketing en UPV Valencia", "En 6 días", R.drawable.charla_event, "Si tiene la sensación de que su negocio está estancado o no dispone de personal especializado en estas materias, en su empresa, es hora de abrirse a otros planteamientos de gestión; Podemos ser su departamento de marketing externo y aportar nuevas ideas a su negocio o proyecto."));
    }
}
