package katiostudio.rivence.Controlador;

import java.util.ArrayList;
import java.util.List;

import katiostudio.rivence.R;


/**
 * Created by cquinz on 27/4/16.
 */
public class Pago {

    String cantidad;
    String titulo;
    public List<Pago> pagos;
    Servicio test1;
    Boolean pagado;


    public Pago(Servicio servicio1, int cantidad1, boolean pagado1){

        titulo = servicio1.title;
        cantidad = cantidad1+" EUR";
        pagado = pagado1;

    }

    public Pago(String titulo1, int cantidad1, boolean pagado1){
        titulo = titulo1;
        cantidad = cantidad1+" EUR";
        pagado = pagado1;
    }

    public Pago(){

    }

    public void initializeData(){
        test1 = new Servicio (R.drawable.arena, "Hotel las Arenas *****", "Playa Malvarosa", "30Km", "", R.drawable.hotels_ic);
        pagos = new ArrayList<>();
        pagos.add(new Pago(test1, 3456,true));
        pagos.add(new Pago("Burdel", 450,false));
        pagos.add(new Pago("Alquiler Barco", 100, true));
        pagos.add(new Pago("Restaurante Duna", 200, true));
        pagos.add(new Pago("Burdel dia 2", 450, false));
        pagos.add(new Pago("Burdel dia 3", 450, false));

    }
}
