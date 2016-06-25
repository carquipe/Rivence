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
 * Created by cquinz on 24/4/16.
 */

public class ServiceAdapter extends RecyclerView.Adapter<ServiceAdapter.ServicioViewHolder> {

    /*  Inicializacion de variables globales  */
    private List<Servicio> servicios;
    Context context;

    /*  Constructores  */

    /**
     * Constructor de un Adaptador de Servicios
     *
     * @param serviciosL Lista que contiene todos los objetos Servicio que se desean mostrar
     */
    public ServiceAdapter(List<Servicio> serviciosL, Context context1) {
        servicios = serviciosL;
        context = context1;
    }

    /*  Override de métodos superclase  */

    /**
     * Obtiene el tamaño de la lista servicios.
     *
     * @return numero de objetos Servicio que contiene la lista servicio
     */
    @Override
    public int getItemCount() {
        return servicios.size();
    }

    /**
     * Getter de la variable servicios.
     *
     * @return La lista que contiene todos los objeto servicio
     */
    public List<Servicio> getList() {
        return servicios;
    }

    /**
     * Setter de la lista servicios.
     *
     * @param serviciosNuevo  La lista que contiene todos los objeto servicio nuevos
     */
    public void setList(List<Servicio> serviciosNuevo) {
        servicios = serviciosNuevo;
    }


    /**
     * Creador del layout de un item Servicio
     *
     * @param viewGroup Grupo de vistas de items del cardview.
     * @param i numero de posición del evento en la Lista servicios
     */
    @Override
    public ServicioViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.service_item, viewGroup, false);
        return new ServicioViewHolder(v);
    }

    /**
     * Rellenado del layout con la informacion de un Servicio concreto
     *
     * @param servicioViewHolder Layout del item.
     * @param i  posicion del objeto Pago concreto en la lista
     */
    @Override
    public void onBindViewHolder(ServicioViewHolder servicioViewHolder, int i) {

        servicioViewHolder.serviceTitle.setText(servicios.get(i).title);
        servicioViewHolder.subtitle.setText(servicios.get(i).subtitle);
        servicioViewHolder.distance.setText(servicios.get(i).distance);

        // Obtener el image loader
        ImageLoader imageLoader= MySocialMediaSingleton.getInstance(context.getApplicationContext()).getImageLoader();
        // Petición de la imagen
        imageLoader.get(Config.IMAGE_URL + servicios.get(i).getPhotoURL(), ImageLoader.getImageListener(servicioViewHolder.servicePhoto,
                R.drawable.loading, R.drawable.error));

        //Set de icono categoria en funcion de datos de la BD
        switch(servicios.get(i).categoryId){
            case "1":
                servicioViewHolder.category.setImageResource(R.drawable.renting_ic);
                break;
            case "2":
                servicioViewHolder.category.setImageResource(R.drawable.hotels_ic);
                break;
            case "3":
                servicioViewHolder.category.setImageResource(R.drawable.drinksfood_ic);
                break;
            case "4":
                servicioViewHolder.category.setImageResource(R.drawable.night_ic);
                break;
            case "5":
                servicioViewHolder.category.setImageResource(R.drawable.leisure_ic);
                break;

        }

        servicioViewHolder.description.setText(servicios.get(i).description);
    }


    /********
     * Clase View Holder
     **********/


    public static class ServicioViewHolder extends RecyclerView.ViewHolder {

        /* Definicon de variables gloables */
        CardView cv;
        ImageView servicePhoto;
        TextView serviceTitle;
        TextView subtitle;
        TextView distance;
        ImageView category;
        Button more;
        TextView description;
        Button readless;

        /* Constructores */

        /**
         * Construir un objeto ServicioViewHolder que contiene las referencias a cada elemento
         * de la interfaz que se desea posteriormente modificar
         *
         * @param itemView Vista de la interfaz de un item.
         */
        ServicioViewHolder(View itemView) {
            super(itemView);
            cv = (CardView) itemView.findViewById(R.id.card_view);
            serviceTitle = (TextView) itemView.findViewById(R.id.service_title);
            subtitle = (TextView) itemView.findViewById(R.id.subtitle);
            distance = (TextView) itemView.findViewById(R.id.distance);
            category = (ImageView) itemView.findViewById(R.id.serviceCategory);
            more = (Button) itemView.findViewById(R.id.read_more_pay);
            servicePhoto = (ImageView) itemView.findViewById(R.id.servicePhoto);
            description = (TextView) itemView.findViewById(R.id.description);
            readless = (Button) itemView.findViewById(R.id.read_less_pay);

            /* Apartado de control de clickado descripcion */
            //Cuanto esta cerrado
            more.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {

                    readless.setVisibility(View.VISIBLE); //Hacemos visible el botón de -
                    more.setVisibility(View.INVISIBLE); //Hacemos invisible el boton de +
                    description.setVisibility(View.VISIBLE); //Mostramos descripcion


                }
            });

            //Cuando esta desplegado
            readless.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {

                    readless.setVisibility(View.GONE); //Hacemos invisible el boton -
                    more.setVisibility(View.VISIBLE); //Hacemos visible el boton de +
                    description.setVisibility(View.GONE); //Ocultamos descripcion


                }
            });
        }

    }


}