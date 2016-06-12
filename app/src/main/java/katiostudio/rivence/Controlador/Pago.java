package katiostudio.rivence.Controlador;

import java.util.ArrayList;
import java.util.List;

import katiostudio.rivence.R;


/**
 * Created by cquinz on 27/4/16.
 */
public class Pago {

    /* Definicion de variables globales */
    String cantidad;
    String titulo;
    public List<Pago> pagos;
    Servicio test1; //Eliminar cuando ya funcione por BD
    Boolean pagado;


    /* Constructores */

    /**
     * Constructor de un Pago en funcion de un servicio existente
     *
     * @param servicio1 Objeto servicio sobre el cual se realiza el pago.
     * @param cantidad1 Fecha en la que se realiza el evento.
     * @param pagado1 Control del estado del pago.
     */
    public Pago(Servicio servicio1, int cantidad1, boolean pagado1) {

        titulo = servicio1.title;
        cantidad = cantidad1 + " EUR";
        pagado = pagado1;

    }

    /**
     * Constructor de un Pago totalmente personalizado
     *
     * @param titulo1 Nombre representativo del pago.
     * @param cantidad1 Fecha en la que se realiza el evento.
     * @param pagado1 Control del estado del pago.
     */
    public Pago(String titulo1, int cantidad1, boolean pagado1) {
        titulo = titulo1;
        cantidad = cantidad1 + " EUR";
        pagado = pagado1;
    }

    /**
     * Constructor vacio de un Pago
     */
    public Pago() {
        //Constructor Vacio
    }

    /* Inicialización de objetos */

    /**
     * Inicia varios pagos con toda la información recogida.
     *
     */
    public void initializeData() {
        test1 = new Servicio(R.drawable.arena_service, "Hotel las Arenas *****", "Playa Malvarosa", "30Km", "", R.drawable.hotels_ic);
        pagos = new ArrayList<>();
        pagos.add(new Pago(test1, 3456, true));
        pagos.add(new Pago("Burdel", 450, false));
        pagos.add(new Pago("Alquiler Barco", 100, true));
        pagos.add(new Pago("Restaurante Duna", 200, true));
        pagos.add(new Pago("Burdel dia 2", 450, false));
        pagos.add(new Pago("Burdel dia 3", 450, false));

    }
}
