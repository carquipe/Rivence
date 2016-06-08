package katiostudio.rivence;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

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
        agentText.setText(cliente.getAgente().getName());

        return rootView;
    }

}




