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

    private String photoURL;
    private String title, date, description;
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
     * Constructor de un evento con consulta JSON
     *
     * @param titulo Titulo del evento.
     * @param fecha Fecha en la que se realiza el evento.
     * @param fotoURL Extensión URL de acceso al recurso.
     * @param descripcion Texto adicional que se muestra cuando se pulsa el boton de mas informacion.
     */
    public Evento(String titulo, String fecha, String fotoURL, String descripcion) {

        title = titulo;
        date = fecha;
        photoURL = fotoURL;
        description = descripcion;

    }


    /**
     * Constructor vacio.
     */
    public Evento() {
        //Constructor vacio
    }


    /* Getters and Setters */

    /**
     * Gett titulo del evento
     *
     * @return String con el titulo del evento
     */
    public String getTitle() {
        return title;
    }

    /**
     * Modificar el titulo del evento
     *
     * @param title Nuevo titulo
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gett url relativa de la imagen
     *
     * @return URL relativa de la imagen
     */
    public String getPhotoURL() {
        return photoURL;
    }

    /**
     * Modificar la URL relativa del recurso imagen
     *
     * @param photoURL Nueva URL relativa del recurso
     */
    public void setPhotoURL(String photoURL) {
        this.photoURL = photoURL;
    }

    /**
     * Gett Fecha de realización del evento
     *
     * @return Fecha del evento
     */
    public String getDate() {
        return date;
    }

    /**
     * Modificar la fecha del evento
     *
     * @param date Nueva fecha
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * Gett Descripcion del evento
     *
     * @return descripcion del evento
     */
    public String getDescription() {
        return description;
    }

    /**
     * Modificar la descripción del evento
     *
     * @param description Nueva descripción del evento
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /* Inicialización de objetos */

    /**
     * Inicia varios objetos con toda la información recogida.
     * BORRAR CUANDO ESTÉN LAS CONSULTAS
     */
    public void initializeData() {
        eventos = new ArrayList<>();
        eventos.add(new Evento("Mascletá en pza. Ayuntamiento Valencia", "Mañana a las 14:00", R.drawable.mascleta_event, "Protagonizada por la gran priotecnia Caballer bububububu"));
        eventos.add(new Evento("Opera en Ciudad de las Artes y las Ciencias", "En 3 días", R.drawable.opera_event, "A diferencia del oratorio, la ópera es una obra destinada a ser representada. Algunos géneros de teatro musical están estrechamente relacionados con la ópera, como son la zarzuela española, el singspiel alemán, la opereta vienesa, la opéra-comique francesa y el musical inglés y estadounidense."));
        eventos.add(new Evento("Conferencia sobre Marketing en UPV Valencia", "En 6 días", R.drawable.charla_event, "Si tiene la sensación de que su negocio está estancado o no dispone de personal especializado en estas materias, en su empresa, es hora de abrirse a otros planteamientos de gestión; Podemos ser su departamento de marketing externo y aportar nuevas ideas a su negocio o proyecto."));
    }
}
