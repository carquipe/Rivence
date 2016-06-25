package katiostudio.rivence.Persistencia;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.LruCache;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;



public final class MySocialMediaSingleton {

    /*  Atributos  */
    private static MySocialMediaSingleton singleton;
    private RequestQueue requestQueue;
    private ImageLoader imageLoader;
    private static Context context;

    /*  Constructor  */

    /**
     * Constructor privado de clase Volley para evitar llamadas de clases externas
     * Con atributos de entrada
     *
     * @param context  Contexto de la aplicación
     */
    private MySocialMediaSingleton(Context context) {
        MySocialMediaSingleton.context = context;
        requestQueue = getRequestQueue();

        imageLoader = new ImageLoader(requestQueue,

                new ImageLoader.ImageCache() {
                    private final LruCache<String, Bitmap>
                    cache = new LruCache<String,Bitmap>(20);

                    @Override
                    public Bitmap getBitmap(String url) {
                        return cache.get(url);
                    }

                    @Override
                    public void putBitmap(String url, Bitmap bitmap) {
                        cache.put(url, bitmap);
                    }

                });

    }

    /* Get instance patrón Singleton */

    /**
     * Metodo de instancia estatica (Singleton)
     *
     * @return Si no existe un controlador de peticiones crea uno nuevo, sino devuelve el actual.
     */
    public static synchronized MySocialMediaSingleton getInstance(Context context) {
        if (singleton == null) {
            singleton = new MySocialMediaSingleton(context);
        }
        return singleton;
    }

    /* Getters y Setters */

    /**
     * Gett Cola de peticiones
     *
     * @return la cola de peticiones existentes
     */
    public RequestQueue getRequestQueue() {
        if (requestQueue == null) {
            requestQueue = Volley.newRequestQueue(context.getApplicationContext());
        }
        return requestQueue;
    }

    /* Añadir a la cola de peticiones */

    /**
     * Añade una peticion en la cola de peticiones
     *
     * @param req  Petición a añadir en la cola
     */
    public  void addToRequestQueue(Request req) {
        getRequestQueue().add(req);
    }

    /**
     * Recibir el ImageLoader usado para las peticiones
     *
     * @return Objeto que se encarga de recibir las imagenes
     */
    public ImageLoader getImageLoader() {
        return imageLoader;
    }

}