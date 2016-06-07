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
 * Created by cquinz on 24/4/16.
 */

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.ServicioViewHolder>{

    private List<Servicio> servicios;

    public RVAdapter(List<Servicio> serviciosL){
        servicios = serviciosL;
    }

    // Override de métodos superclase

    @Override
    public int getItemCount() {
        return servicios.size();
    }
/********FILTRO**/
    public List<Servicio> getList(){
        return servicios;
    }

    public void setList(List<Servicio> serviciosNuevo){
        servicios = serviciosNuevo;
    }
/*********/

    @Override
    public ServicioViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.service_item, viewGroup, false);
        return new ServicioViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ServicioViewHolder servicioViewHolder, int i) {

        servicioViewHolder.serviceTitle.setText(servicios.get(i).title);
        servicioViewHolder.subtitle.setText(servicios.get(i).subtitle);
        servicioViewHolder.distance.setText(servicios.get(i).distance);
        servicioViewHolder.servicePhoto.setBackgroundResource(servicios.get(i).photoId);
        servicioViewHolder.category.setImageResource(servicios.get(i).categoryId);
        servicioViewHolder.description.setText(servicios.get(i).description);
    }


    /********
    * Clase View Holder
     **********/


    public static class ServicioViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        ImageView servicePhoto;
        TextView serviceTitle;
        TextView subtitle;
        TextView distance;
        ImageView category;
        Button more;
        TextView description;
        Button readless;



        ServicioViewHolder (View itemView) {
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.card_view);
            serviceTitle = (TextView)itemView.findViewById(R.id.service_title);
            subtitle = (TextView)itemView.findViewById(R.id.subtitle);
            distance = (TextView)itemView.findViewById(R.id.distance);
            category = (ImageView) itemView.findViewById(R.id.serviceCategory);
            more = (Button) itemView.findViewById(R.id.read_more_pay);
            servicePhoto = (ImageView)itemView.findViewById(R.id.servicePhoto);
            description = (TextView) itemView.findViewById(R.id.description);
            readless= (Button) itemView.findViewById(R.id.read_less_pay);

            more.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v){

                    readless.setVisibility(View.VISIBLE);
                    more.setVisibility(View.INVISIBLE);
                    description.setVisibility(View.VISIBLE);


                }
            });


            readless.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v){

                    readless.setVisibility(View.GONE);
                    more.setVisibility(View.VISIBLE);
                    description.setVisibility(View.GONE);


                }
            });
        }

    }


}