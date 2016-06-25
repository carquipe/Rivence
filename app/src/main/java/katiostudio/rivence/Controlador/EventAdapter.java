package katiostudio.rivence.Controlador;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.CardView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ImageView;
import android.view.View;

import java.util.List;

import android.view.ViewGroup;
import android.view.LayoutInflater;

import com.android.volley.toolbox.ImageLoader;

import katiostudio.rivence.Config;
import katiostudio.rivence.Persistencia.MySocialMediaSingleton;
import katiostudio.rivence.R;

/**
 * Created by cquinz on 27/4/16.
 */
public class EventAdapter extends RecyclerView.Adapter<EventAdapter.EventoViewHolder> {

    /*  Definición de variables globales  */

    private List<Evento> eventos;
    Context context;

    /*  Constructores  */

    /**
     * Constructor que crea el Adaptador de Eventos
     *
     * @param eventosL Lista que contiene todos los eventos que se van a mostrar.
     * @param context1 Contexto para poder trabajar con la carga de imagenes en ImageLoader
     */
    public EventAdapter(List<Evento> eventosL, Context context1) {
        eventos = eventosL;
        context = context1;
    }


    /*  Override métodos superclase  */

    /**
     * Getter Tamaño de lista
     *
     * @return Numero de eventos que tiene la Lista.
     */
    @Override
    public int getItemCount() {
        return eventos.size();
    }

    /**
     * Creador del layout de un item Evento
     *
     * @param viewGroup Grupo de vistas de items del cardview.
     * @param i numero de posición del evento en la Lista eventosL
     */
    @Override
    public EventoViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.nearyou_item, viewGroup, false);
        return new EventoViewHolder(v);
    }

    /**
     * Rellenado del layout con la informacion de un evento concreto
     *
     * @param eventoViewHolder Layout del item.
     * @param i  posicion del objeto evento concreto en la lista
     */
    @Override
    public void onBindViewHolder(EventoViewHolder eventoViewHolder, int i) {

        eventoViewHolder.eventTitle.setText(eventos.get(i).getTitle());
        eventoViewHolder.date.setText(eventos.get(i).getDate());

        // Obtener el image loader
        ImageLoader imageLoader= MySocialMediaSingleton.getInstance(context.getApplicationContext()).getImageLoader();
        // Petición
        imageLoader.get(Config.IMAGE_URL + eventos.get(i).getPhotoURL(), ImageLoader.getImageListener(eventoViewHolder.eventPhoto,
                R.drawable.loading, R.drawable.error));

        //eventoViewHolder.eventPhoto.setBackgroundResource(R.drawable.error);
        eventoViewHolder.description.setText(eventos.get(i).getDescription());

    }


    /***********
     *
     * Clase View Holder
     *
     **********/


    public static class EventoViewHolder extends RecyclerView.ViewHolder {

        /*  Definición de variables globales  */

        CardView cv;
        ImageView eventPhoto;
        TextView eventTitle;
        TextView date;
        Button more;
        TextView description;
        boolean opened = false;  //Controla si la descripcion esta desplegada o no

        /*  Constructores  */

        /**
         * Construir un objeto EventoViewHolder que contiene las referencias a cada elemento
         * de la interfaz que se desea posteriormente modificar
         *
         * @param itemView Vista de la interfaz de un item.
         */
        EventoViewHolder(final View itemView) {
            super(itemView);
            cv = (CardView) itemView.findViewById(R.id.card_view_event);
            eventTitle = (TextView) itemView.findViewById(R.id.paylog_title);
            date = (TextView) itemView.findViewById(R.id.event_date);
            more = (Button) itemView.findViewById(R.id.read_more_pay);
            eventPhoto = (ImageView) itemView.findViewById(R.id.eventPhoto);
            description = (TextView) itemView.findViewById(R.id.descriptionE);

            //Control de icono cuando se pulsa en mas informacion
            more.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    if (opened == false) {  //Si no esta desplegado, se cambia a icono - y se muestra la descripcion
                        more.setBackgroundResource(R.drawable.lessinfo_ic);
                        description.setVisibility(View.VISIBLE);
                        opened = true;
                    } else {  //Si esta desplegado, se cambia a icono + y se osuclta la descripcion
                        more.setBackgroundResource(R.drawable.moreinfo_ic);
                        description.setVisibility(View.GONE);
                        opened = false;
                    }


                }
            });

        }

    }
}
