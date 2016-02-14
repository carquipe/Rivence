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
    private static String compareStringOne = "08:00";
    private static String compareStringTwo = "20:00";
    static SimpleDateFormat inputParser = new SimpleDateFormat(inputFormat, Locale.US);

    public static int getBackOnTime( String activity) {

        Calendar now = Calendar.getInstance();
        if (activity == "main"){
         id = (R.drawable.mainbackgroundn);
        }else{
        id= (R.drawable.nightbackground);}

        int hour = now.get(Calendar.HOUR_OF_DAY);
        int minute = now.get(Calendar.MINUTE);

        date = parseDate(hour + ":" + minute);
        dateCompareOne = parseDate(compareStringOne);
        dateCompareTwo = parseDate(compareStringTwo);

        if (dateCompareOne.before(date) && dateCompareTwo.after(date)) {

            if (activity == "main") {
                id = (R.drawable.mainbackground2);
            }else{
                id = (R.drawable.daybackground);
            }

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

