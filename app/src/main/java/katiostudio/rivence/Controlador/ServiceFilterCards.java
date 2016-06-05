package katiostudio.rivence.Controlador;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import katiostudio.rivence.R;

/**
 * Created by cquinz on 2/6/16.
 */
public class ServiceFilterCards {

    private final List<Servicio> originalList;
    private final List<Servicio> filteredList;

    /*Inicialización de lista general y auxiliar*/
    public ServiceFilterCards(List<Servicio> originalList){
        this.originalList = new LinkedList<>(originalList);
        this.filteredList = new ArrayList<>();
    }


    /*Inicialización de lista general y auxiliar*/
    public List<Servicio> performFilteringHotels () {
        filteredList.clear();
        for ( Servicio servicio : originalList){
            if (servicio.categoryId == R.drawable.hotels_ic) filteredList.add(servicio);
        }
        return filteredList;
    }

    public List<Servicio> performFilteringRenting () {
        filteredList.clear();
        for ( Servicio servicio : originalList){
            if (servicio.categoryId == R.drawable.renting_ic) filteredList.add(servicio);
        }
        return filteredList;
    }

    public List<Servicio> performFilteringFood () {
        filteredList.clear();
        for ( Servicio servicio : originalList){
            if (servicio.categoryId == R.drawable.drinksfood_ic) filteredList.add(servicio);
        }
        return filteredList;
    }

    public List<Servicio> performFilteringNight () {
        filteredList.clear();
        for ( Servicio servicio : originalList){
            if (servicio.categoryId == R.drawable.night_ic) filteredList.add(servicio);
        }
        return filteredList;
    }

    public List<Servicio> performFilteringLeisure () {
        filteredList.clear();
        for ( Servicio servicio : originalList){
            if (servicio.categoryId == R.drawable.leisure_ic) filteredList.add(servicio);
        }
        return filteredList;
    }

    public List<Servicio> performFilteringAll () {
        filteredList.clear();
        filteredList.addAll(originalList);
        return filteredList;
    }




}
