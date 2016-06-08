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

    private List<Pago> pagos;

    public PaylogAdapter(List<Pago> pagosL) {
        pagos = pagosL;
    }


    public List<Pago> getList() {
        return pagos;
    }

    public void setList(List<Pago> pagosNuevo) {
        pagos = pagosNuevo;
    }


    //Override métodos superclase
    @Override
    public int getItemCount() {
        return pagos.size();
    }

    @Override
    public PagoViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.paylog_item, viewGroup, false);
        return new PagoViewHolder(v);
    }

    @Override
    public void onBindViewHolder(PagoViewHolder pagoViewHolder, int i) {

        pagoViewHolder.paylogTitle.setText(pagos.get(i).titulo);
        pagoViewHolder.quant.setText(pagos.get(i).cantidad);


        //Color según el estado del pago
        if (pagos.get(i).pagado == true) {
            pagoViewHolder.status.setBackgroundResource(R.color.green);
        } else {
            pagoViewHolder.status.setBackgroundResource(R.color.red);
        }


    }


    /********
     * Clase View Holder
     **********/


    public static class PagoViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView paylogTitle;
        TextView quant;
        Button more;
        ImageView status;


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
