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


    private final List<Pago> originalList;
    private final List<Pago> filteredList;


    /*Inicialización de lista general y auxiliar*/
    public PaylogFilterCards(List<Pago> originalList) {
        this.originalList = new LinkedList<>(originalList);
        this.filteredList = new ArrayList<>();
    }


    /*  FORMATEO DE LISTA DE CADA TIPO   */
    public List<Pago> performFilteringPaid() {
        filteredList.clear();
        for (Pago pago : originalList) {
            if (pago.pagado == true) filteredList.add(pago);
        }
        return filteredList;
    }

    public List<Pago> performFilteringPending() {
        filteredList.clear();
        for (Pago pago : originalList) {
            if (pago.pagado == false) filteredList.add(pago);
        }
        return filteredList;
    }

    public List<Pago> performFilteringAll() {
        filteredList.clear();
        filteredList.addAll(originalList);
        return filteredList;
    }

}

