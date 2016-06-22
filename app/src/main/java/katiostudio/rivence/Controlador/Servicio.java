package katiostudio.rivence.Controlador;

/**
 * Created by cquinz on 24/4/16.
 */


import java.util.List;
import java.util.ArrayList;

import katiostudio.rivence.R;

public class Servicio {

    /* Inicialización de variables globales */
    int photoId, categoryId;
    String title;
    String subtitle;
    String distance;
    String description;
    String imagen;
    public List<Servicio> servicios;

    /**
     * Constructor de un objeto Servicio
     *
     * @param fotoId Identificador de la imagen que se muestra relacionada al servicio.
     * @param titulo Titulo del Servicio
     * @param subtitulo Localizacion del Servicio
     * @param distancia Distancia a la que se encuentra, respecto al cliente
     * @param categoriaId Identificador de la categoria a la que pertenece
     */
    public Servicio(int fotoId, String titulo, String subtitulo, String distancia, String descripcion, int categoriaId) {
        title = titulo;
        distance = distancia;
        subtitle = subtitulo;
        description = descripcion;
        photoId = fotoId;
        categoryId = categoriaId;
    }

//VOLLEY

    public Servicio(String titulo, String subtitulo, String distancia, String descripcion, int categoriaId) {
        title = titulo;
        distance = distancia;
        subtitle = subtitulo;
        description = descripcion;
        categoryId = categoriaId;
    }





    /**
     * Constructor vacio
     */
    public Servicio() {
        //Constructor vacio
    }

    /**
     * Inicia varios objetos con toda la información recogida.
     */
    public void initializeData() {
        servicios = new ArrayList<>();
        servicios.add(new Servicio(R.drawable.arena_service, "Hotel las Arenas *****", "Playa Malvarosa", "30Km", "Exclusivo hotel situado en la zona de la costa. Contiene SPA, jardines y ble ble ble", R.drawable.hotels_ic));
        servicios.add(new Servicio(R.drawable.duna_service, "Restaurante la Duna", "El perelló", "60Km", "Destacado restaurante con  alto renombre e nivel nacionas, su especialidad son los arroces y el marisco.", R.drawable.drinksfood_ic));
        servicios.add(new Servicio(R.drawable.marina_service, "Marina Beach", "Playa Malvarosa", "32Km", "Marina Beach es un centro de ocio al lado de la Marina Real Juan Carlos I, el paraje y el entorno es inmejorable.", R.drawable.night_ic));
        servicios.add(new Servicio(R.drawable.coche_service, "Alquiler coches SIXT", "A domicilio", "0Km", "Coches de alta gama, servidos en tiempo récord", R.drawable.renting_ic));

    }

    public String getImagen() {
        return imagen;
    }



}
