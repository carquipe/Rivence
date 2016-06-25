package katiostudio.rivence.Controlador;

/**
 * Created by cquinz on 14/5/16.
 */
public class Agente {



    /*  Declaración de variables Globales   */
    String fotoURL;
    String nombre;
    private static Agente agente;

    //Constructores

    /**
     * Constructor privado para evitar llamadas de clases externas
     * Sin atributos de entrada
     *
     * @deprecated
     */
    private Agente() {
        //Empty constructor
    }

    /**
     * Constructor privado para evitar llamadas de clases externas
     * Con atributos de entrada
     *
     * @param name Nombre del agente.
     */
    private Agente(String name, String fotoURL1) {
        nombre = name;
        fotoURL = fotoURL1;
    }


    /**
     * Metodo de instancia estatica (Singleton)
     *
     * @return Si no existe un agente crea uno nuevo, sino devuelve el actual.
     */
    public static Agente getInstance() {
        return agente;
    }

    public static Agente getInstance(String name, String fotoURL){
        if (agente == null) agente = new Agente(name,fotoURL);

        return agente;
    }
    /* Getters */

    public String getFotoURL() {
        return fotoURL;
    }
    /**
     * Obtener el nombre del agente
     *
     * @return Nombre del agente
     */
    public String getName() {
        return nombre;
    }
}
