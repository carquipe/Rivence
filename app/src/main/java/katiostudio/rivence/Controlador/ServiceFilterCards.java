package katiostudio.rivence.Controlador;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import katiostudio.rivence.R;

/**
 * Created by cquinz on 2/6/16.
 */
public class ServiceFilterCards {

    /* Definicion de variables globales */
    private final List<Servicio> originalList; //Lista general
    private final List<Servicio> filteredList; //Lista auxiliar

    /* Constructores */

    /**
     * Constructor de un filtrado
     *
     * @param originalList Lista que contiene la totalidad de los servicios.
     */
    public ServiceFilterCards(List<Servicio> originalList) {
        this.originalList = new LinkedList<>(originalList);
        this.filteredList = new ArrayList<>();
    }


    /*Metodos de filtrado segun categoria*/

    /**
     * Filtrar la lista original de Servicios en otra lista que contenga solamente una lista con
     * servicios de Hosteleria
     *
     * @return Lista con solamente los servicios que pertenecen a Hosteleria.
     */
    public List<Servicio> performFilteringHotels() {
        filteredList.clear();
        for (Servicio servicio : originalList) {
            if (servicio.categoryId.equals("1")) filteredList.add(servicio);
        }
        return filteredList;
    }

    /**
     * Filtrar la lista original de Servicios en otra lista que contenga solamente una lista con
     * servicios de Alquiler
     *
     * @return Lista con solamente los servicios que pertenecen a Alquiler.
     */
    public List<Servicio> performFilteringRenting() {
        filteredList.clear();
        for (Servicio servicio : originalList) {
            if (servicio.categoryId.equals("2")) filteredList.add(servicio);
        }
        return filteredList;
    }

    /**
     * Filtrar la lista original de Servicios en otra lista que contenga solamente una lista con
     * servicios de Comida
     *
     * @return Lista con solamente los servicios que pertenecen a Comida.
     */
    public List<Servicio> performFilteringFood() {
        filteredList.clear();
        for (Servicio servicio : originalList) {
            if (servicio.categoryId.equals("3")) filteredList.add(servicio);
        }
        return filteredList;
    }

    /**
     * Filtrar la lista original de Servicios en otra lista que contenga solamente una lista con
     * servicios de Ocio nocturno
     *
     * @return Lista con solamente los servicios que pertenecen a Ocio nocturno.
     */
    public List<Servicio> performFilteringNight() {
        filteredList.clear();
        for (Servicio servicio : originalList) {
            if (servicio.categoryId.equals("4")) filteredList.add(servicio);
        }
        return filteredList;
    }

    /**
     * Filtrar la lista original de Servicios en otra lista que contenga solamente una lista con
     * servicios de Ocio
     *
     * @return Lista con solamente los servicios que pertenecen a Ocio.
     */
    public List<Servicio> performFilteringLeisure() {
        filteredList.clear();
        for (Servicio servicio : originalList) {
            if (servicio.categoryId.equals("5")) filteredList.add(servicio);
        }
        return filteredList;
    }

    /**
     * Devuelve la lista original que contiene todos los elementos
     *
     * @return La lista con todos los elementos.
     */
    public List<Servicio> performFilteringAll() {
        return originalList;
    }


}
