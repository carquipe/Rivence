package katiostudio.rivence.Controlador;

/**
 * Created by cquinz on 14/5/16.
 */
public class Agente {
    String nombre;
    private static Agente agente;

    private Agente(){
        //Empty constructor
    }

    private Agente(String name){
        nombre = name;
    }

    //Método obtener instancia
    public static Agente getInstance(){
        if(agente == null) agente = new Agente("Manuel Castillo");
        return agente;
    }

    public String getName(){ return nombre; }
}
