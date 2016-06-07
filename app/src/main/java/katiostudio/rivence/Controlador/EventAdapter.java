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
public class EventAdapter extends RecyclerView.Adapter<EventAdapter.EventoViewHolder> {

    private List<Evento> eventos;

    public EventAdapter(List<Evento> eventosL){ eventos = eventosL; }


    //Override métodos superclase
    @Override
    public int getItemCount() { return eventos.size(); }

    @Override
    public EventoViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.nearyou_item, viewGroup, false);
        return new EventoViewHolder(v);
    }

    @Override
    public void onBindViewHolder(EventoViewHolder eventoViewHolder, int i) {

        eventoViewHolder.eventTitle.setText(eventos.get(i).title);
        eventoViewHolder.date.setText(eventos.get(i).date);
        eventoViewHolder.eventPhoto.setBackgroundResource(eventos.get(i).photoId);
        eventoViewHolder.description.setText(eventos.get(i).description);

    }



    /********
     * Clase View Holder
     **********/


    public static class EventoViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        ImageView eventPhoto;
        TextView eventTitle;
        TextView date;
        Button more;
        TextView description;
        boolean opened = false;



        EventoViewHolder (final View itemView) {
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.card_view_event);
            eventTitle = (TextView)itemView.findViewById(R.id.paylog_title);
            date = (TextView)itemView.findViewById(R.id.event_date);
            more = (Button) itemView.findViewById(R.id.read_more_pay);
            eventPhoto = (ImageView)itemView.findViewById(R.id.eventPhoto);
            description = (TextView) itemView.findViewById(R.id.descriptionE);



           more.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v){
                    if(opened==false) {
                        more.setBackgroundResource(R.drawable.lessinfo_ic);
                        description.setVisibility(View.VISIBLE);
                        opened = true;
                    } else {
                        more.setBackgroundResource(R.drawable.moreinfo_ic);
                        description.setVisibility(View.GONE);
                        opened = false;
                    }


                }
            });

        }

    }
}
