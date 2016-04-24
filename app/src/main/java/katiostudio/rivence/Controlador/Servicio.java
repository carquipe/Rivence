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

    public Servicio (){

    };

    public void initializeData(){
        servicios = new ArrayList<>();
        servicios.add(new Servicio (R.drawable.arena, "Hotel las Arenas *****", "Playa Malvarosa", "30Km", "", R.drawable.hotels_ic));
        servicios.add(new Servicio (R.drawable.duna, "Restaurante la Duna", "El perelló", "60Km", "", R.drawable.drinksfood_ic));
        servicios.add(new Servicio (R.drawable.marina, "Marina Beach", "Playa Malvarosa", "32Km", "", R.drawable.night_ic));
        servicios.add(new Servicio (R.drawable.marina, "Marina Beach", "Playa Malvarosa", "32Km", "", R.drawable.night_ic));
        servicios.add(new Servicio (R.drawable.marina, "Marina Beach", "Playa Malvarosa", "32Km", "", R.drawable.night_ic));
        servicios.add(new Servicio (R.drawable.marina, "Marina Beach", "Playa Malvarosa", "32Km", "", R.drawable.night_ic));
        servicios.add(new Servicio (R.drawable.marina, "Marina Beach", "Playa Malvarosa", "32Km", "", R.drawable.night_ic));
        servicios.add(new Servicio (R.drawable.marina, "Marina Beach", "Playa Malvarosa", "32Km", "", R.drawable.night_ic));

    }
}
