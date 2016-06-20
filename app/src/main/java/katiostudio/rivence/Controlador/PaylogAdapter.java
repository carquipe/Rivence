package katiostudio.rivence.Controlador;


import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.CardView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ImageView;
import android.view.View;

import java.util.List;

import android.view.ViewGroup;
import android.view.LayoutInflater;

import katiostudio.rivence.R;


/**
 * Created by cquinz on 27/4/16.
 */
public class PaylogAdapter extends RecyclerView.Adapter<PaylogAdapter.PagoViewHolder> {

    /* Definicion de variables globales */
    private List<Pago> pagos;


    /* Constructores */

    /**
     * Genera un adaptador de pagos.
     *
     * @param pagosL Conjunto de pagos existentes
     */
    public PaylogAdapter(List<Pago> pagosL) {
        pagos = pagosL;
    }

    /* Getters y setters */

    /**
     * Getter de la variable pagos.
     *
     * @return Lista de pagos
     */
    public List<Pago> getList() {
        return pagos;
    }

    /**
     * Setter de la variable pagos, para el filtrado.
     *
     * @param pagosNuevo Nueva lista actualizada de pagos
     */
    public void setList(List<Pago> pagosNuevo) {
        pagos = pagosNuevo;
    }


    /* Override métodos superclase */

    /**
     * Obtiene el tamaño de la lista pagos.
     *
     * @return numero de objetos Pago que contiene la lista pagos
     */
    @Override
    public int getItemCount() {
        return pagos.size();
    }

    /**
     * Creador del layout de un item PAgo
     *
     * @param viewGroup Grupo de vistas de items del cardview.
     * @param i numero de posición del evento en la Lista pagos
     */
    @Override
    public PagoViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.paylog_item, viewGroup, false);
        return new PagoViewHolder(v);
    }

    /**
     * Rellenado del layout con la informacion de un Pago concreto
     *
     * @param pagoViewHolder Layout del item.
     * @param i  posicion del objeto Pago concreto en la lista
     */
    @Override
    public void onBindViewHolder(PagoViewHolder pagoViewHolder, int i) {

        pagoViewHolder.paylogTitle.setText(pagos.get(i).getTitulo());
        pagoViewHolder.quant.setText(pagos.get(i).setDivisa(Cliente.getInstance().getDivisa()));


        //Color según el estado del pago
        if (pagos.get(i).getPagado() == true) { // Si está pagado
            pagoViewHolder.status.setBackgroundResource(R.color.green);
        } else { //Si no esta pagado
            pagoViewHolder.status.setBackgroundResource(R.color.red);
        }


    }


    /********
     * Clase View Holder
     **********/


    public static class PagoViewHolder extends RecyclerView.ViewHolder {

        /* Inicializacion de variables globales */
        CardView cv;
        TextView paylogTitle;
        TextView quant;
        Button more;
        ImageView status;


        /* Constructores */

        /**
         * Construir un objeto PagoViewHolder que contiene las referencias a cada elemento
         * de la interfaz que se desea posteriormente modificar
         *
         * @param itemView Vista de la interfaz de un item.
         */
        PagoViewHolder(View itemView) {
            super(itemView);
            cv = (CardView) itemView.findViewById(R.id.card_view_paylog);
            paylogTitle = (TextView) itemView.findViewById(R.id.paylog_title);
            quant = (TextView) itemView.findViewById(R.id.paylog_quant);
            more = (Button) itemView.findViewById(R.id.read_more_pay);
            status = (ImageView) itemView.findViewById(R.id.status);

        }

    }
}
