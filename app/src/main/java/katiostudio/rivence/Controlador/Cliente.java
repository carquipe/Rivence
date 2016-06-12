package katiostudio.rivence.Controlador;

import java.util.List;

/**
 * Created by cquinz on 27/4/16.
 */
public class Cliente {

    /*  Declaración de variables Globales   */

    List<Servicio> servContratados;
    String ciudad, fechaFin, clave;
    private static Cliente cliente;
    private static Agente agente;


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
     * Obtener contrasenya del usuario
     *
     * @return Contrasenya de la aplicacion
     */
    public String getClave() {
        return clave;
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

}
