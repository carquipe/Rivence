package katiostudio.rivence.Controlador;

import java.util.ArrayList;
import java.util.List;

import katiostudio.rivence.R;

/**
 * Created by cquinz on 27/4/16.
 */
public class Evento {
    int photoId;
    String title, date,description;
    public List <Evento> eventos;

    public Evento( String titulo, String fecha, int fotoId, String descripcion ){

        title = titulo;
        date = fecha;
        photoId = fotoId;
        description = descripcion;

    }

    public Evento (){

    }

    public void initializeData(){
        eventos = new ArrayList<>();
        eventos.add(new Evento("Mascletá en pza. Ayuntamiento Valencia","Mañana a las 14:00", R.drawable.nearyousixt,"Protagonizada por la gran priotecnia Caballer bububububu"));
        eventos.add(new Evento("Opera en Ciudad de las Artes y las Ciencias","En 3 días", R.drawable.opera,"A diferencia del oratorio, la ópera es una obra destinada a ser representada. Algunos géneros de teatro musical están estrechamente relacionados con la ópera, como son la zarzuela española, el singspiel alemán, la opereta vienesa, la opéra-comique francesa y el musical inglés y estadounidense."));
        eventos.add(new Evento("Conferencia sobre Marketing en UPV Valencia","En 6 días", R.drawable.charla,"Si tiene la sensación de que su negocio está estancado o no dispone de personal especializado en estas materias, en su empresa, es hora de abrirse a otros planteamientos de gestión; Podemos ser su departamento de marketing externo y aportar nuevas ideas a su negocio o proyecto."));
    }
}
