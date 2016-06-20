package katiostudio.rivence.Controlador;

import java.util.ArrayList;
import java.util.List;

import katiostudio.rivence.R;


/**
 * Created by cquinz on 27/4/16.
 */
public class Pago {



    /* Definicion de variables globales */
    private String cantidad;
    private Cliente cliente;
    private String titulo;
    private Boolean pagado;
    long pagoaux;


    /* Constructores */

    /**
     * Constructor de un Pago en funcion de un servicio existente
     *
     * @param servicio1 Objeto servicio sobre el cual se realiza el pago.
     * @param cantidad1 Cantidad de pago.
     * @param pagado1 Control del estado del pago.
     */
    /*public Pago(Servicio servicio1, int cantidad1, boolean pagado1) {
        setCliente(cliente.getInstance());
        setTitulo(servicio1.title);
        if(cliente.getDivisa().equals("EUR")) setCantidad(cantidad1 + " EUR");
        else if (cliente.getDivisa().equals("USD")){
            pagoaux = (long)Math.floor(cantidad1*1.12 + 0.5d);
            cantidad = pagoaux + " USD";
        }
        else cantidad = cliente.getDivisa() + " USD";
        pagado = pagado1;

    }*/

    /**
     * Constructor de un Pago totalmente personalizado
     *
     * @param titulo1 Nombre representativo del pago.
     * @param cantidad1 Fecha en la que se realiza el evento.
     * @param pagado1 Control del estado del pago.
     */
    public Pago(String titulo1, int cantidad1, boolean pagado1) {
        cliente = cliente.getInstance();
        setTitulo(titulo1);
        pagoaux = (long) cantidad1;
        pagado = pagado1;
    }


    /**
     * Constructor vacio de un Pago
     */
    public Pago() {
        //Constructor Vacio
    }

    /* Getters y setters */
    public String getCantidad() {
        return cantidad;
    }

    /**
     * Modificar la cantidad asociada al pago
     *
     * @param cantidad precio del servicio contratado
     */
    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * Gett el estado del pago
     *
     * @return estado del pago
     */
    public Boolean getPagado(){
        return pagado;
    }

    /**
     * Modificar el estado del pago
     *
     * @param pagado1 nuevo estado de pago
     */
    public void setPagado(Boolean pagado1) {
        pagado = pagado1;
    }

    /**
     * Modificar el cliente que usa la app
     *
     * @param cliente cambio de cliente
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    /**
     * Gett el titulo del pago
     *
     * @return texto titulo del pago
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Modificar el titulo del pago
     *
     * @param titulo texto titulo del pago
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String setDivisa(String divisa){
        String cantidad1;
        String pagoauxStr;
        long pagoauxV;

        if(divisa.equals("EUR")) {
            pagoauxStr = Long.toString(pagoaux);
            cantidad1 = pagoauxStr + " EUR";
        }
        else if (divisa.equals("USD")){
            pagoauxV = (long)Math.floor(pagoaux*1.12 + 0.5d);
            pagoauxStr = Long.toString(pagoauxV);
            cantidad1 = pagoauxStr + " USD";
        }
        else cantidad1 = cliente.getDivisa() + " USD";

        return cantidad1;
    }


}
