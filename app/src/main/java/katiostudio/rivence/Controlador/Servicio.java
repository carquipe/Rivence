package katiostudio.rivence.Controlador;

/**
 * Created by cquinz on 24/4/16.
 */


import java.util.List;
import java.util.ArrayList;

import katiostudio.rivence.R;

public class Servicio {
    int photoId,categoryId;
    String title, subtitle, distance, description;
    public List<Servicio> servicios;

    Servicio (int fotoId, String titulo, String subtitulo, String distancia, String descripcion, int  categoriaId){
        title = titulo;
        distance = distancia;
        subtitle = subtitulo;
        description = descripcion;
        photoId = fotoId;
        categoryId = categoriaId;
    }

    public Servicio (String titulo){

        title = titulo;

    }

    public Servicio (){

    };

    public void initializeData(){
        servicios = new ArrayList<>();
        servicios.add(new Servicio (R.drawable.arena, "Hotel las Arenas *****", "Playa Malvarosa", "30Km", "Exclusivo hotel situado en la zona de la costa. Contiene SPA, jardines y ble ble ble", R.drawable.hotels_ic));
        servicios.add(new Servicio (R.drawable.duna, "Restaurante la Duna", "El perelló", "60Km", "Destacado restaurante con  alto renombre e nivel nacionas, su especialidad son los arroces y el marisco.", R.drawable.drinksfood_ic));
        servicios.add(new Servicio (R.drawable.marina, "Marina Beach", "Playa Malvarosa", "32Km", "Marina Beach es un centro de ocio al lado de la Marina Real Juan Carlos I, el paraje y el entorno es inmejorable.", R.drawable.night_ic));
        servicios.add(new Servicio (R.drawable.coche, "Alquiler coches SIXT", "A domicilio", "0Km", "Coches de alta gama, servidos en tiempo récord", R.drawable.renting_ic));
        //servicios.add(new Servicio (R.drawable.barco, "Alquiler de barcos", "Puerto deportivo Gandia", "120Km", "Veleros, yates pequeños, ideal para una escapada de un día entero", R.drawable.renting_ic));

    }
}
