package katiostudio.rivence.Persistencia;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import katiostudio.rivence.Config;
import katiostudio.rivence.Controlador.Agente;
import katiostudio.rivence.Controlador.Evento;
import katiostudio.rivence.Controlador.Cliente;
import katiostudio.rivence.Controlador.Pago;
import katiostudio.rivence.Controlador.Servicio;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by cquinz on 20/6/16.
 */
public class MySocialMediaRequests {

    private static MySocialMediaRequests requests;
      Context context;
    JsonObjectRequest jsArrayRequest;
    private static final String TAG = "PostAdapter";
    /**
     * Constructor privado de clase que contiene los requests para evitar llamadas de clases externas
     * Con atributos de entrada
     *
     * @param context  Contexto de la aplicación
     */
    private MySocialMediaRequests(Context context) {
        this.context = context;
    }


     /* Get instance patrón Singleton */

    /**
     * Metodo de instancia estatica (Singleton)
     *
     * @return Si no existe una clase de peticiones crea uno nuevo, sino devuelve el actual.
     */
    public static synchronized MySocialMediaRequests getInstance(Context context) {
        if (requests == null) {
            requests = new MySocialMediaRequests(context);
        }
        return requests;
    }


    public void initializeServicios() {

        StringRequest jsArrayRequest = new StringRequest(
                Request.Method.POST,
                Config.LOGIN_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d(TAG, "Respuesta Volley:" + response.toString());
                        try {
                            Cliente.getInstance().setServicios(parseJsonServicios(response));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }


                },

                new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d(TAG, "Error:" + error.getMessage());

                    }
                }) {

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                //Adding parameters to request
                params.put(Config.KEY_TAG, "servicios");
                params.put("ciudad",Cliente.getInstance().getCiudad().toLowerCase());


                //returning parameter
                return params;
            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<String, String>();
                headers.put("Content-Type", "application/x-www-form-urlencoded; charset=utf-8");
                headers.put("User-agent", "My useragent");
                return headers;
            }

        };

        // Añadir petición a la cola
        MySocialMediaSingleton.getInstance(getContext()).addToRequestQueue(jsArrayRequest);


    }

    public void initializePagos() {

        StringRequest jsArrayRequest = new StringRequest(
                Request.Method.POST,
                Config.LOGIN_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d(TAG, "Respuesta Volley:" + response.toString());
                        try {
                            Cliente.getInstance().setPagos(parseJsonPagos(response));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }


                },

                new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d(TAG, "Error:" + error.getMessage());

                    }
                }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                //Adding parameters to request
                params.put(Config.KEY_TAG, "pagos");
                params.put("cliente",Cliente.getInstance().getId());


                //returning parameter
                return params;
            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<String, String>();
                headers.put("Content-Type", "application/x-www-form-urlencoded; charset=utf-8");
                headers.put("User-agent", "My useragent");
                return headers;
            }

        };

        // Añadir petición a la cola
        MySocialMediaSingleton.getInstance(getContext()).addToRequestQueue(jsArrayRequest);


    }

    public void initializeEventos() {

        StringRequest jsArrayRequest = new StringRequest(
                Request.Method.POST,
                Config.LOGIN_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d(TAG, "Respuesta Volley:" + response.toString());
                        try {
                            Cliente.getInstance().setEventos(parseJsonEventos(response));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }


                },

                new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d(TAG, "Error:" + error.getMessage());

                    }
                }) {

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                //Adding parameters to request
                params.put(Config.KEY_TAG, "eventos");
                params.put("ciudad",Cliente.getInstance().getCiudad().toLowerCase());


                //returning parameter
                return params;
            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<String, String>();
                headers.put("Content-Type", "application/x-www-form-urlencoded; charset=utf-8");
                headers.put("User-agent", "My useragent");
                return headers;
            }

        };

        // Añadir petición a la cola
        MySocialMediaSingleton.getInstance(getContext()).addToRequestQueue(jsArrayRequest);

    }


    public List<Pago> parseJsonPagos(String entrada) throws JSONException {
        // Variables locales
        List<Pago> pagosL = new ArrayList();
        JSONArray jsonArray = null;



        // Obtener el array del objeto
        jsonArray = new JSONArray(entrada);

        for (int x = 0; x < jsonArray.length(); x++) {

            try {
                JSONObject objeto = jsonArray.getJSONObject(x);
                boolean pagado = false;
                String titulo = objeto.getString("titulo");
                int cantidad = objeto.getInt("cantidad");
                int pagadoInt = objeto.getInt("pagado");
                if (pagadoInt == 1) pagado = true;
                else pagado = false;

                Pago pago = new Pago(titulo, cantidad, pagado);


                pagosL.add(pago);
            } catch (JSONException e) {
                Log.e(TAG, "Error de parsing: " + e.getMessage());
            }
        }


        return pagosL;
    }

    public List<Servicio> parseJsonServicios(String entrada) throws JSONException {

        // Variables locales
        List<Servicio> serviciosL = new ArrayList();
        JSONArray jsonArray = null;

        jsonArray = new JSONArray(entrada);


        for (int x = 0; x < jsonArray.length(); x++) {

            try {

                JSONObject objeto = jsonArray.getJSONObject(x);
                String titulo = objeto.getString("titulo");
                String subtitulo = objeto.getString("subtitulo");
                String distancia = objeto.getString("distancia");
                String descripcion = objeto.getString("descripcion");
                String categoriaId = objeto.getString("idCategoria");
                Servicio servicio = new Servicio(titulo,subtitulo,distancia,descripcion,categoriaId);


                serviciosL.add(servicio);

            } catch (JSONException e) {
                Log.e(TAG, "Error de parsing: " + e.getMessage());
            }
        }


        return serviciosL;
    }

    public List<Evento> parseJsonEventos(String entrada) throws JSONException {

        // Variables locales
        List<Evento> eventosL = new ArrayList();
        JSONArray jsonArray = null;

        jsonArray = new JSONArray(entrada);

        for (int x = 0; x < jsonArray.length(); x++) {

            try {

                JSONObject objeto = jsonArray.getJSONObject(x);
                Evento evento = new Evento(
                        objeto.getString("titulo"),
                        objeto.getString("fecha"),
                        objeto.getString("foto_url"),
                        objeto.getString("descripcion"));


                eventosL.add(evento);

            } catch (JSONException e) {
                Log.e(TAG, "Error de parsing: " + e.getMessage());
            }
        }


        return eventosL;

    }


    public Context getContext() {
        return context;
    }
}
