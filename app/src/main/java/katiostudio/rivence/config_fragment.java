package katiostudio.rivence;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Spinner;
import android.widget.ArrayAdapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Locale;

import katiostudio.rivence.Controlador.Agente;
import katiostudio.rivence.Controlador.Cliente;

/**
 * Created by carquipe on 12/02/2016.
 */
public class config_fragment extends Fragment {

    Cliente cliente;

    public config_fragment() {
        // Empty constructor required for fragment subclasses
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.config_fragment, container, false);

        cliente = cliente.getInstance();

        TextView keyText = (TextView) rootView.findViewById(R.id.keyText);
        keyText.setText(cliente.getClave());

        TextView cityText = (TextView) rootView.findViewById(R.id.cityText);
        cityText.setText(cliente.getCiudad());

        TextView dateText = (TextView) rootView.findViewById(R.id.dateText);
        dateText.setText(cliente.getFechaFin());

        TextView agentText = (TextView) rootView.findViewById(R.id.agentText);
        agentText.setText(Agente.getInstance().getName());

        final Spinner spinner2 = (Spinner) rootView.findViewById(R.id.spinner2);
        final Spinner spinner = (Spinner)  rootView.findViewById(R.id.spinner);

        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.divisa_array, android.R.layout.simple_spinner_item);

        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(getActivity(),
                R.array.lenguaje_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner2.setAdapter(adapter);
        spinner.setAdapter(adapter1);

        //Listener de seleccion de items
        spinner2.setSelection(getIndex(spinner2, cliente.getDivisa()));
        //spinner.setSelection(getIndex(spinner, Locale.getDefault().getDisplayLanguage().toUpperCase()));


        spinner.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {

                String text = parentView.getItemAtPosition(position).toString();
                spinner.setSelection(getIndex(spinner, text));
                cliente.setLanguage(text.toLowerCase(), getActivity().getBaseContext());
                System.out.println(text);

                //String toastS = "Cambiado idioma a "+text+" Vuelva al menú para aplicar cambios.";

                //Toast.makeText(getActivity().getApplicationContext(),toastS,Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {

            }
        });

        spinner2.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {

                String text = parentView.getItemAtPosition(position).toString();
                cliente.setDivisa(text);
                System.out.println(text);

            }
            @Override
            public void onNothingSelected(AdapterView<?> parentView) {

            }

        });

        return rootView;
    }

    private int getIndex(Spinner spinner, String myString){

        int index = 0;

        for (int i=0;i<spinner.getCount();i++){
            if (spinner.getItemAtPosition(i).equals(myString)){
                index = i;
            }
        }
        return index;
    }
}




