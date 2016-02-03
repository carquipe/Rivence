package katiostudio.rivence;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import android.support.v4.widget.DrawerLayout;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageButton;

/**
 * Created by Kevin on 22/01/2016.
 */
public class main extends Activity {


    final main main = this;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);


        final ImageButton Services = (ImageButton) findViewById(R.id.Menu1);

        Services.setOnClickListener(new View.OnClickListener()   {
            public void onClick(View v)  {

                    Intent intent = new Intent();
                    intent.setClass(main, services.class);

                    startActivity(intent);
                }

            });
        }


    }
