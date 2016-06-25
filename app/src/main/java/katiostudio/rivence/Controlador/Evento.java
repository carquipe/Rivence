package katiostudio.rivence.Controlador;


/**
 * Created by cquinz on 27/4/16.
 */
public class Evento {

    /* Definición de variables globales */

    private String photoURL;
    private String title, date, description;


    /* Constructores */

    /**
     * Constructor de un evento con consulta JSON
     *
     * @param titulo Titulo del evento.
     * @param fecha Fecha en la que se realiza el evento.
     * @param fotoURL Extensión URL de acceso al recurso.
     * @param descripcion Texto adicional que se muestra cuando se pulsa el boton de mas informacion.
     *
     */
    public Evento(String titulo, String fecha, String fotoURL, String descripcion) {
        title = titulo;
        date = fecha;
        photoURL = fotoURL;
        description = descripcion;
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
     * Gett url relativa de la imagen
     *
     * @return URL relativa de la imagen
     */
    public String getPhotoURL() {
        return photoURL;
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
     * Gett Descripcion del evento
     *
     * @return descripcion del evento
     */
    public String getDescription() {
        return description;
    }

}
