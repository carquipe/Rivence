package katiostudio.rivence;

/**
 * Created by Kevin on 28/01/2016.
 */
public class Config {


    //URL a login.php
    public static final String LOGIN_URL = "http://www.metalgreentools.com/rivence/app/index.php";
    public static final String IMAGE_URL = "http://www.metalgreentools.com/rivence/app/imagenes/";

    //Contraseñas definidas para email y usuario en $_POST['key'] dentro de login.php
    public static final String KEY_PASS = "key";
    public static final String KEY_TAG = "tag";

    //If server response is equal to this that means login is successful
    public static final String LOGIN_SUCCESS = "success";

    //Keys for Sharedpreferences
    //This would be the name of our shared preferences
    public static final String SHARED_PREF_NAME = "Rivence";

    //This would be used to store the email of current logged in user
    public static final String EMAIL_SHARED_PREF = "key";

    //We will use this to store the boolean in sharedpreference to track user is loggedin or not
    public static final String LOGGEDIN_SHARED_PREF = "loggedin";
    public static final String SPLASH_SHOW = "splash";

}
