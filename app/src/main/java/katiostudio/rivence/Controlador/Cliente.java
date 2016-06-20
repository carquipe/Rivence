package katiostudio.rivence.Controlador;

import com.android.volley.toolbox.JsonArrayRequest;

import java.util.ArrayList;
import java.util.List;

import katiostudio.rivence.R;

/**
 * Created by cquinz on 27/4/16.
 */
public class Cliente {

    /*  Declaración de variables Globales   */

    public static List<Pago> pagos;
    public static List<Servicio> servicios;
    private static String ciudad, fechaFin, clave;
    private static Cliente cliente;
    private static Agente agente;
    private static String divisa = "EUR";


    /* Patrón Singleton para crear solamente 1 cliente */

    //Constructores

    /**
     * Constructor privado para evitar llamadas de clases externas
     * Sin atributos de entrada
     *
     * @deprecated
     */
    private Cliente() {
        //Empty Constructor
    }

    /**
     * Constructor privado para evitar llamadas de clases externas
     * Con atributos de entrada
     *
     * @param city    Ciudad en la que se realiza el servicio.
     * @param endDate Fecha de finalizacion del servicio
     * @param key     Clave de acceso a la aplicacion
     */
    private Cliente(String city, String endDate, String key) {
        ciudad = city;
        fechaFin = endDate;
        clave = key;
        agente = agente.getInstance();
        pagos = new ArrayList<>();

    }


    /**
     * Metodo de instancia estatica (Singleton)
     *
     * @return Si no existe un cliente crea uno nuevo, sino devuelve el actual.
     */
    public static Cliente getInstance() {
        if (cliente == null)
            cliente = new Cliente("Valencia", "30/09/2016", "123456-123456-123456"); //Si no existe un cliente crea uno genérico
        return cliente;
    }


    /* Getters */

    /**
     * Gett Divisa preferente
     *
     * @return Divisa de los precios
     */
    public static String getDivisa() {
        return divisa;
    }

    /**
     * Obtener contrasenya del usuario
     *
     * @return Contrasenya de la aplicacion
     */
    public String getClave() {
        return clave;
    }


    /**
     * Gett Pagos del cliente
     *
     * @return Lista con los pagos
     */
    public List<Pago> getPagos() {
        return pagos;
    }

    /**
     * Gett Ciudad del usuario
     *
     * @return Ciudad del usuario
     */
    public String getCiudad() {
        return ciudad;
    }

    /**
     * Gett Fecha final del servicio
     *
     * @return Fecha en la que finaliza el servicio
     */
    public String getFechaFin() {
        return fechaFin;
    }

    /**
     * Gett Agente asociado al usuario
     *
     * @return Objeto agente asociado al usuario
     */
    public Agente getAgente() {
        return agente;
    }


    /* Setters */

    /**
     * Modificar moneda preferente
     *
     * @param nuevaDivisa Nueva divisa asociada
     */
    public static void setDivisa(String nuevaDivisa) { divisa = nuevaDivisa; }

    /**
     * Modificar la lista de los servicios
     *
     * @param serviciosL Nueva Lista de servicios
     */
    public static void setServicios(List<Servicio> serviciosL) {
        servicios = serviciosL;
    }

    /**
     * Modificar la lista de los pagos
     *
     * @param pagosL Nueva Lista de pagos
     */
    public static void setPagos(List<Pago> pagosL) {
        pagos = pagosL;
    }


    /**
     * Inicia varios pagos con toda la información recogida.
     *
     */
  //  public void initializeData() {
  //      pagos.add(new Pago("Hotel Las Arenas *****", 450, false));
  //      pagos.add(new Pago("Alquiler Barco", 100, true));
  //      pagos.add(new Pago("Restaurante Duna", 200, true));
  //      pagos.add(new Pago("Alquiler Ferrari F4320 2", 450, false));
  //      pagos.add(new Pago("Alquiler Yate 3 dias", 450, false));

  //  }


}