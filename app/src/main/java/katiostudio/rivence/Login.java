package katiostudio.rivence;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import katiostudio.rivence.Controlador.Agente;
import katiostudio.rivence.Controlador.Cliente;


public class Login extends AppCompatActivity {


    /**
     * JSON Response node names.
     */
    private static final String TAG = "PostAdapter";
    private String key;
    private boolean loggedIn = false;
    private static String loginURL = "http://www.katiopruebas.com/Rivence/App";
    EditText LoginEdit;
    Button LoginBtn;
    boolean success = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        final RelativeLayout background = (RelativeLayout) findViewById(R.id.background);
        background.setBackgroundResource(DinamicBackground.getBackOnTime("login"));

        LoginEdit = (EditText) findViewById(R.id.loginkey);
        LoginBtn = (Button) findViewById(R.id.button);


        LoginBtn.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                /*Sin Checkeo de password*/
                //Intent intent = new Intent(Login.this, main.class);
                //startActivity(intent);
               /*Con Checkeo de password*/
                ProcessLogin();
            }

        });

  /*      LoginBtn.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                GradientDrawable myGrad = (GradientDrawable)rectangle.getBackgrou
                LoginBtn.getBackground().setColor(R.color.greeny_blue);
                return false;
            }
        }); */

    }

    @Override
    protected void onResume() {
        super.onResume();
        //In onresume fetching value from sharedpreference
        SharedPreferences sharedPreferences = getSharedPreferences(Config.SHARED_PREF_NAME, Context.MODE_PRIVATE);

        //Fetching the boolean value form sharedpreferences
        loggedIn = sharedPreferences.getBoolean(Config.LOGGEDIN_SHARED_PREF, false);

        //If we will get true
        // *if(loggedIn){
        //We will start the Profile Activity
        //  Intent intent = new Intent(Login.this, main.class);
        //  startActivity(intent);
        //}
    }


    private void ProcessLogin() {


        key = LoginEdit.getText().toString().trim();

        StringRequest stringRequest = new StringRequest(Request.Method.POST, Config.LOGIN_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        //If we are getting success from server
                        if (!response.equals("")) {
                            //Creating a shared preference
                            SharedPreferences sharedPreferences = Login.this.getSharedPreferences(Config.SHARED_PREF_NAME, Context.MODE_PRIVATE);

                            //Creating editor to store values to shared preferences
                            SharedPreferences.Editor editor = sharedPreferences.edit();

                            //Adding values to editor
                            editor.putBoolean(Config.LOGGEDIN_SHARED_PREF, true);
                            editor.putString(Config.EMAIL_SHARED_PREF, key);

                            //Saving values to editor
                            editor.commit();

                            //Creación Objetos Cliente y Agente

                            JSONObject jsonObj = null;
                            try {
                                jsonObj = new JSONObject(response);
                                Cliente.getInstance(jsonObj.getString("nombre_user"),jsonObj.getString("ciudad_user"),jsonObj.getString("fecha_fin_servicio_user"),jsonObj.getString("key_user"));
                                if(jsonObj.getString("nombre_agente")!= null){
                                Agente.getInstance(jsonObj.getString("nombre_agente"));}
                                else { Agente.getInstance();}

                                Toast.makeText(Login.this, "Bienvenido "+ jsonObj.getString("nombre_user"), Toast.LENGTH_LONG).show();
                            } catch (JSONException e) {
                                Log.e(TAG, "Error de parsing: " + e.getMessage());
                                e.printStackTrace();
                            }

                            //Starting profile activity
                            Intent intent = new Intent(Login.this, main.class);
                            startActivity(intent);

                        } else {
                            //If the server response is not success
                            //Displaying an error message on toast
                            Toast.makeText(Login.this, getString(R.string.incorrect_key), Toast.LENGTH_LONG).show();
                        }
                    }
                },

                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("abd", "Error: " + error
                                + ">>" + error.networkResponse.statusCode
                                + ">>" + error.networkResponse.data
                                + ">>" + error.getCause()
                                + ">>" + error.getMessage());
                        Toast.makeText(Login.this, getString(R.string.incorrect_key), Toast.LENGTH_LONG).show();
                        //You can handle error here if you want
                    }
                }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                //Adding parameters to request
                params.put(Config.KEY_TAG, "login");
                params.put(Config.KEY_PASS, key);

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


        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }


    private void openProfile(JSONObject response) {

        String success;

        Intent intent = new Intent(this, main.class);

        startActivity(intent);
    }


}






