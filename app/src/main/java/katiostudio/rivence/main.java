package katiostudio.rivence;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;


/**
 * Created by Kevin on 22/01/2016.
 */
public class main extends Activity {
    boolean closed = true;  //Variable que captura el estado del chat (abierto o cerrado)
    public static int Fragcontainer = R.id.content; //Contenedor principal que se rellena según el menu
    public static FragmentManager fragmentManager;
    final main main = this;

    private RelativeLayout drawer ; //Variable que almacena el Layout del chat
    static DrawerLayout drawerLayout; //Layout general
    private TextView titleText;  //Titulo "Rivence" superior
    static ImageView chaticon;

    protected void onCreate(Bundle savedInstanceState) {

        /* Generar estructura interfaz básica de la aplicación procedente del Layout: main.xml */
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);


        /* Almacenar en variables los elementos del xml main */
        chaticon = (ImageView) findViewById(R.id.chaticon);
        titleText = (TextView) findViewById(R.id.titletext);
        drawerLayout = (DrawerLayout)findViewById(R.id.Background);
        drawer = (RelativeLayout)findViewById(R.id.drawerPane);


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

        fragmentTransaction.add(R.id.content,menuFrag);
        fragmentTransaction.add(R.id.drawerPane, chatFrag);
        fragmentTransaction.commit();


        /* Listeners */
        drawerLayout.setDrawerListener(myDrawerListener);
        chaticon.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                drawerLayout.openDrawer(drawer);

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
        }
    }
    DrawerLayout.DrawerListener myDrawerListener = new DrawerLayout.DrawerListener(){

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

                }else{
                //  Si esta abierto, se oculta el icono del chat y se actualiza la variable closed a true
                    chaticon.setVisibility(View.VISIBLE);
                    closed = true;
                }
            }


        }};

}

