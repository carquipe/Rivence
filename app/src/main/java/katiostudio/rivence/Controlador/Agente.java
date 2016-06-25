package katiostudio.rivence.Controlador;

/**
 * Created by cquinz on 14/5/16.
 */
public class Agente {

    /*  Declaración de variables Globales   */

    String fotoURL;
    String nombre;
    private static Agente agente;

    /*  Constructores  */

    /**
     * Constructor privado para evitar llamadas de clases externas
     * Con atributos de entrada
     *
     * @param name Nombre del agente.
     * @param fotoURL1 Dirección relativa de la imagen en el servidor
     */
    private Agente(String name, String fotoURL1) {
        nombre = name;
        fotoURL = fotoURL1;
    }

    /**
     * Crea un Agente dentro del patron SINGLETON
     *
     * @param name Nombre del agente.
     * @param fotoURL Dirección relativa de la imagen en el servidor
     *
     * @return El unico agente existente
     */
    public static Agente getInstance(String name, String fotoURL){
        if (agente == null) agente = new Agente(name,fotoURL);
        return agente;
    }

    /**
     * Metodo de instancia estatica (Singleton)
     *
     * @return El unico agente existente
     */
    public static Agente getInstance() {
        return agente;
    }


    /*  Getters  */
    /**
     * Obtener la direccion relativa de la imagen en el servidor
     *
     * @return Direccion relativa de la imagen
     */
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
