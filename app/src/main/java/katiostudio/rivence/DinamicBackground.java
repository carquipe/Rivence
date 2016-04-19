package katiostudio.rivence;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Kevin on 26/01/2016.
 */
public class DinamicBackground {

    private static Date date;
    private static Date dateCompareOne;
    private static Date dateCompareTwo;

    static int id;
    public static final String inputFormat = "HH:mm";
    private static String compareStringMorning = "08:00";  //Hora de cambio background noche a dia
    private static String compareStringNight = "20:00";    //Hora de cambio backgorund dia a noche
    static SimpleDateFormat inputParser = new SimpleDateFormat(inputFormat, Locale.US); //Formato de fecha recibida

    public static int getBackOnTime( String activity) {


        //Obtener hora y minutos actuales
        Calendar now = Calendar.getInstance();
        int hour = now.get(Calendar.HOUR_OF_DAY);
        int minute = now.get(Calendar.MINUTE);

        //Rellenado de variables de tipo Date
        date = parseDate(hour + ":" + minute);
        dateCompareOne = parseDate(compareStringMorning);
        dateCompareTwo = parseDate(compareStringNight);



        if (dateCompareOne.before(date) && dateCompareTwo.after(date)) {   //Es de dia
            // Seleccion de background utilizado segun la actividad usandose
            if (activity == "main") { // En el menu y sus hijos
                id = (R.drawable.mainbackgroundday);

            }else{                    // En la pantalla de carga y login
                id = (R.drawable.splashbackgroundday);
            }

        } else {                                                          //Es de noche
            // Seleccion de background utilizado segun la actividad usandose
            if (activity == "main"){ // En el menu y sus hijos
                id = (R.drawable.mainbackgroundnight);

            }else{                   // En la pantalla de carga y login
                id= (R.drawable.splashbackgroundnight);}
        }

        return id;
    }


    private static Date parseDate(String date) {

        try {
            return inputParser.parse(date);
        } catch (java.text.ParseException e) {
            return new Date(0);
        }
    }
}

