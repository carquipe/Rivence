package katiostudio.rivence;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Locale;

import katiostudio.rivence.Controlador.Cliente;
import katiostudio.rivence.Interfaces.CategoryListener;
import katiostudio.rivence.Persistencia.MySocialMediaRequests;


/**
 * Created by Kevin on 22/01/2016.
 */
public class main extends Activity implements CategoryListener {

    boolean closed = true;  //Variable que captura el estado del chat (abierto o cerrado)
    //DELETE public static int Fragcontainer = R.id.content; //Contenedor principal que se rellena según el menu
    public static FragmentManager fragmentManager;
    MySocialMediaRequests mySocialMediaRequests;

    private RelativeLayout drawer; //Variable que almacena el Layout del chat
    static DrawerLayout drawerLayout; //Layout general
    private TextView titleText;  //Titulo "Rivence" superior
    static ImageView chaticon;
    static ImageView backicon;


    EventCenter eventCenter;

    protected void onCreate(Bundle savedInstanceState) {

        /* Generar objetos de APP */
        //Inicialización de variables
        mySocialMediaRequests = MySocialMediaRequests.getInstance(getApplicationContext());
        mySocialMediaRequests.initializePagos();
        mySocialMediaRequests.initializeServicios();
        mySocialMediaRequests.initializeEventos();


        /* Generar estructura interfaz básica de la aplicación procedente del Layout: main.xml */
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);


        /* Almacenar en variables los elementos del xml main */
        chaticon = (ImageView) findViewById(R.id.chaticon);
        backicon = (ImageView) findViewById(R.id.backBttn);
        titleText = (TextView) findViewById(R.id.titletext);
        drawerLayout = (DrawerLayout) findViewById(R.id.Background);
        drawer = (RelativeLayout) findViewById(R.id.drawerPane);


        /* Seleccion de imagen de fondo segun la hora ( Llamada metodo getBackOnTime ) */
        drawerLayout.setBackgroundResource(DinamicBackground.getBackOnTime("main"));


        /* Insercion de la fuente del titulo */
        String fontPath = "fonts/Ailerons-Typeface.otf";
        Typeface tf = Typeface.createFromAsset(getAssets(), fontPath);
        titleText.setTypeface(tf);


        /* Gestion de los fragmentos a visualizar inicialmente ( Chat y menu ) */
        fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Fragment menuFrag = new menu_fragment();
        Fragment chatFrag = new chat_fragment();

        fragmentTransaction.add(R.id.content, menuFrag);
        fragmentTransaction.add(R.id.drawerPane, chatFrag);
        fragmentTransaction.commit();


        /******** Listeners **********/
        drawerLayout.setDrawerListener(myDrawerListener);
        chaticon.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                drawerLayout.openDrawer(drawer);
            }
        });

        backicon.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                onBackPressed();


            }
        });

    }


    /* Apertura y cerrado del panel del Chat */
    @Override
    public void onBackPressed() {
        if (this.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            this.drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
            backicon.setVisibility(View.GONE);
        }
    }

    DrawerLayout.DrawerListener myDrawerListener = new DrawerLayout.DrawerListener() {

        @Override
        public void onDrawerClosed(View drawerView) {

        }

        @Override
        public void onDrawerOpened(View drawerView) {

        }

        @Override
        public void onDrawerSlide(View drawerView, float slideOffset) {

        }


        /*   Captura de cambio de estado en el chat */
        @Override
        public void onDrawerStateChanged(int newState) {

            if (newState == DrawerLayout.STATE_SETTLING) {
                //  Si esta cerrado, se muestra el icono del chat y se actualiza la variable closed a false
                if (closed) {
                    chaticon.setVisibility(View.INVISIBLE);
                    closed = false;

                } else {
                    //  Si esta abierto, se oculta el icono del chat y se actualiza la variable closed a true
                    chaticon.setVisibility(View.VISIBLE);
                    closed = true;
                }
            }


        }
    };

    public void categoryClicked(int position) {

        services_fragment servicesFRA = (services_fragment)
                fragmentManager.findFragmentByTag("servicesTAG");

        if (servicesFRA != null) {
            switch (position) {
                case 0:
                    servicesFRA.updateCat0();
                    break;
                case 1:
                    servicesFRA.updateCat1();
                    break;
                case 2:
                    servicesFRA.updateCat2();
                    break;
                case 3:
                    servicesFRA.updateCat3();
                    break;
                case 4:
                    servicesFRA.updateCat4();
                    break;
                case 5:
                    servicesFRA.updateCat5();
                    break;
            }
        }

    }

    public static Context getContext(){

        return getContext();

    }
}

