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
public class PaylogAdapter extends RecyclerView.Adapter<PaylogAdapter.PagoViewHolder>{

    private List<Pago> pagos;

    public PaylogAdapter(List<Pago> pagosL){ pagos = pagosL; }


    //Override métodos superclase
    @Override
    public int getItemCount() { return pagos.size(); }

    @Override
    public PagoViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_paylog, viewGroup, false);
        return new PagoViewHolder(v);
    }

    @Override
    public void onBindViewHolder(PagoViewHolder pagoViewHolder, int i) {

        pagoViewHolder.paylogTitle.setText(pagos.get(i).titulo);
        pagoViewHolder.quant.setText(pagos.get(i).cantidad);

    }




    /********
     * Clase View Holder
     **********/


    public static class PagoViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView paylogTitle;
        TextView quant;
        Button more;



        PagoViewHolder (View itemView) {
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.card_view_paylog);
            paylogTitle = (TextView)itemView.findViewById(R.id.paylog_title);
            quant = (TextView)itemView.findViewById(R.id.paylog_quant);
            more = (Button) itemView.findViewById(R.id.read_more_pay);
        }

    }
}
