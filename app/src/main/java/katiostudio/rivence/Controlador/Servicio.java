package katiostudio.rivence.Controlador;

/**
 * Created by cquinz on 24/4/16.
 */

public class Servicio {

    /* Inicialización de variables globales */

    String photoURL;
    String categoryId;
    String title;
    String subtitle;
    String distance;
    String description;

    /**
     * Constructor de un objeto Servicio
     *
     * @param fotoURL Direccion relativa del recurso en el servidor.
     * @param titulo Titulo del Servicio
     * @param subtitulo Localizacion del Servicio
     * @param distancia Distancia a la que se encuentra, respecto al cliente
     * @param categoriaId Identificador de la categoria a la que pertenece
     */
    public Servicio(String titulo, String subtitulo, String distancia, String descripcion, String categoriaId, String fotoURL) {
        title = titulo;
        distance = distancia;
        subtitle = subtitulo;
        description = descripcion;
        categoryId = categoriaId;
        photoURL = fotoURL;
    }

    /**
     * Devuelve la ruta relativa de la imagen del Servicio
     *
     * @return Direccion relativa del recurso en el servidor
     */
    public String getPhotoURL() {
        return photoURL;
    }



}
