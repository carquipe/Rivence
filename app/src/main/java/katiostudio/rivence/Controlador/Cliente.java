package katiostudio.rivence.Controlador;

import java.util.List;
/**
 * Created by cquinz on 27/4/16.
 */
public class Cliente {

    List <Servicio> servContratados;
    String ciudad, fechaFin, clave;
    private static Cliente cliente;
    private static Agente agente;


    /* Patrón Singleton para crear solamente 1 cliente */


    //Constructor privado para evitar la llamada de otra clase
    private Cliente (){
        //Empty Constructor
    }
    private Cliente (String city, String endDate, String key) {
        ciudad = city;
        fechaFin = endDate;
        clave = key;
        agente = agente.getInstance();

    }
    //Método instancia estática
    public static Cliente getInstance(){
        if(cliente == null) cliente = new Cliente("Valencia","30/09/2016","123456-123456-123456");
        return cliente;
    }


    /*Getters*/
    public String getClave(){
        return clave;
    }

    public String getCiudad(){
        return ciudad;
    }

    public String getFechaFin(){
        return fechaFin;
    }

    public Agente getAgente() { return agente; }

    /*Creación temporal*/
    public void newClient (){
        new Cliente("Valencia","30/09/2016","123456-123456-123456");
    }
}
