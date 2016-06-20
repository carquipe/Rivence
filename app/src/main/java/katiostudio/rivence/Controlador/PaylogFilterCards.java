package katiostudio.rivence.Controlador;


import android.view.LayoutInflater;
import android.widget.Filter;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by cquinz on 8/5/16.
 */
public class PaylogFilterCards {

    /* Inicializacion de variables globales */
    private final List<Pago> originalList;
    private final List<Pago> filteredList;


    /* Constructores */

    /**
     * Constructor de un filtrado
     *
     * @param originalList Lista que contiene la totalidad de los pagos.
     */
    public PaylogFilterCards(List<Pago> originalList) {
        this.originalList = new LinkedList<>(originalList); //Lista general
        this.filteredList = new ArrayList<>(); //Lista auxiliar
    }


    /* Metodos de filtrado segun estatus */

    /**
     * Filtrar la lista original de Pagos en otra lista que contenga solamente una lista con
     * los pagos pagados
     *
     * @return Lista con solamente los pagos pagados.
     */
    public List<Pago> performFilteringPaid() {
        filteredList.clear();
        for (Pago pago : originalList) {
            if (pago.getPagado() == true) filteredList.add(pago);
        }
        return filteredList;
    }

    /**
     * Filtrar la lista original de Pagos en otra lista que contenga solamente una lista con
     * los pagos pendientes
     *
     * @return Lista con solamente los pagos pendientes.
     */
    public List<Pago> performFilteringPending() {
        filteredList.clear();
        for (Pago pago : originalList) {
            if (pago.getPagado() == false) filteredList.add(pago);
        }
        return filteredList;
    }

    /**
     * Devuelve la lista original que contiene todos los elementos
     *
     * @return La lista con todos los elementos.
     */
    public List<Pago> performFilteringAll() {
        return originalList;
    }

}

