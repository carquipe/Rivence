package katiostudio.rivence.Persistencia;

import android.content.Context;
import android.util.Log;

import katiostudio.rivence.Config;
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

        JsonArrayRequest jsArrayRequest = new JsonArrayRequest(
                Request.Method.POST,
                Config.LOGIN_URL,
                null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Log.d(TAG, "Respuesta Volley:" + response.toString());
                        Cliente.getInstance().setServicios(parseJsonServicios(response));
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

        JsonArrayRequest jsArrayRequest = new JsonArrayRequest(
                Request.Method.POST,
                Config.LOGIN_URL,
                null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Log.d(TAG, "Respuesta Volley:" + response.toString());
                        Cliente.getInstance().setPagos(parseJsonPagos(response));
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

        JsonArrayRequest jsArrayRequest = new JsonArrayRequest(
                Request.Method.POST,
                Config.LOGIN_URL,
                null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Log.d(TAG, "Respuesta Volley:" + response.toString());
                        Cliente.getInstance().setEventos(parseJsonEventos(response));
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


    public List<Pago> parseJsonPagos(JSONArray entrada) {
        // Variables locales
        List<Pago> pagosL = new ArrayList();
        JSONArray jsonArray = null;

        // Obtener el array del objeto
        jsonArray = entrada;

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

    public List<Servicio> parseJsonServicios(JSONArray entrada) {

        // Variables locales
        List<Servicio> serviciosL = new ArrayList();
        JSONArray jsonArray = null;

        jsonArray = entrada;

        for (int x = 0; x < jsonArray.length(); x++) {

            try {

                JSONObject objeto = jsonArray.getJSONObject(x);
                Servicio servicio = new Servicio(
                        objeto.getString("titulo"),
                        objeto.getString("subtitulo"),
                        objeto.getString("distancia"),
                        objeto.getString("descripcion"),
                        objeto.getInt("categoriaId"));


                serviciosL.add(servicio);

            } catch (JSONException e) {
                Log.e(TAG, "Error de parsing: " + e.getMessage());
            }
        }


        return serviciosL;
    }

    public List<Evento> parseJsonEventos(JSONArray entrada){

        // Variables locales
        List<Evento> eventosL = new ArrayList();
        JSONArray jsonArray = null;

        jsonArray = entrada;

        for (int x = 0; x < jsonArray.length(); x++) {

            try {

                JSONObject objeto = jsonArray.getJSONObject(x);
                Evento evento = new Evento(
                        objeto.getString("titulo"),
                        objeto.getString("fecha"),
                        objeto.getInt("photoId"),
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
