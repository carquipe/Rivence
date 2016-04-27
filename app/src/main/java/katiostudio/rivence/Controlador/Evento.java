package katiostudio.rivence.Controlador;

import java.util.ArrayList;
import java.util.List;

import katiostudio.rivence.R;

/**
 * Created by cquinz on 27/4/16.
 */
public class Evento {
    int photoId;
    String title, date, description;
    public List <Evento> eventos;

    public Evento( String titulo, String fecha, int fotoId ){

        title = titulo;
        date = fecha;
        photoId = fotoId;

    }

    public Evento (){

    }

    public void initializeData(){
        eventos = new ArrayList<>();
        eventos.add(new Evento("Mascletá en pza. Ayuntamiento Valencia","Mañana a las 14:00", R.drawable.nearyousixt));
        eventos.add(new Evento("Opera en Ciudad de las Artes y las Ciencias","En 3 días", R.drawable.opera));
        eventos.add(new Evento("Conferencia sobre Marketing en UPV Valencia","En 6 días", R.drawable.charla));
    }
}
