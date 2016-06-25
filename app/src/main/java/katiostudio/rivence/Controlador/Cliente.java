package katiostudio.rivence.Controlador;

import android.content.Context;
import android.content.res.Configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by cquinz on 27/4/16.
 */
public class Cliente {

    /*  Declaración de variables Globales   */

    private static String ciudad, fechaFin, clave;
    private static Cliente cliente;
    private static Agente agente;
    private static String divisa = "EUR";
    private static String nombre;
    private static String id;

    private static List<Pago> pagos;
    private static List<Servicio> servicios;
    private static List<Evento> eventos;


    /*  Constructores  */

    /**
     * Constructor privado para evitar llamadas de clases externas
     * Con atributos de entrada
     *
     * @param city    Ciudad en la que se realiza el servicio.
     * @param endDate Fecha de finalizacion del servicio
     * @param key     Clave de acceso a la aplicacion
     * @param idPerson Numero de identificacion del usuario en base de datos
     * @param name     Nombre del cliente
     */
    private Cliente(String idPerson, String city, String endDate, String key, String name) {
        id = idPerson;
        ciudad = city;
        fechaFin = endDate;
        clave = key;
        agente = agente.getInstance();
        nombre = name;
        pagos = new ArrayList<>();
        servicios = new ArrayList<>();
    }

    /**
     * Metodo de instancia estatica (Singleton)
     *
     * @return El unico cliente existente.
     */
    public static Cliente getInstance() {
        return cliente;
    }

    /**
     * Metodo de instancia estatica (Singleton)
     *
     * @param idPerson Numero de persona del usuario en BD
     * @param nombre_user Nombre del usuario
     * @param ciudad_user Ciudad donde esta contratado el servicio
     * @param fecha_fin Fecha de finalizacion del servicio
     * @param key_user Clave del usuario
     *
     * @return El cliente único existente.
     */
    public static Cliente getInstance(String idPerson, String nombre_user, String ciudad_user, String fecha_fin, String key_user) {
            cliente = new Cliente(idPerson, ciudad_user, fecha_fin, key_user, nombre_user);
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
     * Gett Eventos disponibles
     *
     * @return Lista con los eventos
     */
    public List<Evento> getEventos() {
        return eventos;
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
     * Gett Identificador Persona del usuario en BD
     *
     * @return Numero identificador de persona
     */
    public static String getId() {
        return id;
    }

    /**
     * Gett La totalidad de los servicios
     *
     * @return Lista con todos los servicios
     */
    public static List<Servicio> getServicios() {
        return servicios;
    }



    /*  Setters  */

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
     * Modificar la lista de los eventos
     *
     * @param eventosL Nueva Lista de eventos
     */
    public static void setEventos(List<Evento> eventosL) {
        eventos = eventosL;
    }

    /**
     * Tratamiento del lenguaje del cliente
     *
     * @param languageL Nuevo lenguaje
     * @param appContext Contexto sobre el que se aplica
     *
     */
    public static void setLanguage(String languageL, Context appContext) {

        switch(languageL){
            case "es":
                Locale locale = new Locale("es");
                Locale.setDefault(locale);
                Configuration config = new Configuration();
                config.locale = locale;
                appContext.getResources().updateConfiguration(config, appContext.getResources().getDisplayMetrics());
                break;

            case "en":
                Locale locale2 = new Locale("en");
                Locale.setDefault(locale2);
                Configuration config2 = new Configuration();
                config2.locale = locale2;
                appContext.getResources().updateConfiguration(config2, appContext.getResources().getDisplayMetrics());
                break;

            case "fr":
                Locale locale3 = new Locale("fr");
                Locale.setDefault(locale3);
                Configuration config3 = new Configuration();
                config3.locale = locale3;
                appContext.getResources().updateConfiguration(config3, appContext.getResources().getDisplayMetrics());
                break;

        }
    }





}