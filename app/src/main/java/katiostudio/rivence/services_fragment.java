package katiostudio.rivence;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.view.ViewGroup;
import android.support.v7.widget.RecyclerView;
import android.content.Context;

import katiostudio.rivence.Controlador.Cliente;
import katiostudio.rivence.Controlador.ServiceAdapter;
import katiostudio.rivence.Controlador.ServiceFilterCards;
import katiostudio.rivence.Controlador.Servicio;

import java.util.List;


public class services_fragment extends Fragment {

    private static final String TAG = "RecyclerViewFragment";


    protected RecyclerView mRecyclerView;
    protected ServiceAdapter mAdapter;
    protected RecyclerView.LayoutManager mLayoutManager;
    protected List<Servicio> mDataset;
    protected ServiceFilterCards filterCards;

    public static int Servicescontainer = R.id.services_fragment_layout;

    public services_fragment() {
        // Empty constructor required for fragment subclasses
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Iniciacion de los datos en Objeto Servicio con la Lista
       // Servicio serv = new Servicio();
        //serv.initializeData();



        mDataset = Cliente.getInstance().getServicios();

        //filtro
        filterCards = new ServiceFilterCards(mDataset);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Context thiscontext;


        //inicializacion RecyclerView
        View rootView = inflater.inflate(R.layout.services_fragment, container, false);
        rootView.setTag(TAG);

        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.services_fragment_layout);
        mRecyclerView.setHasFixedSize(true);

        //Utilizamos LinearLayout para darle forma de lista vertical.
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);

        //Creamos el adaptador
        mAdapter = new ServiceAdapter(mDataset);

        // Asignacion de adaptador al del Recycler View
        mRecyclerView.setAdapter(mAdapter);


        return rootView;
    }


    //UPDATE FILTROS CATEGORIAS

    public void updateCat0() {
        mAdapter.setList(filterCards.performFilteringAll());
        mAdapter.notifyDataSetChanged();
    }

    public void updateCat1() {
        mAdapter.setList(filterCards.performFilteringRenting());
        mAdapter.notifyDataSetChanged();
    }

    public void updateCat2() {
        mAdapter.setList(filterCards.performFilteringHotels());
        mAdapter.notifyDataSetChanged();
    }

    public void updateCat3() {
        mAdapter.setList(filterCards.performFilteringFood());
        mAdapter.notifyDataSetChanged();
    }

    public void updateCat4() {
        mAdapter.setList(filterCards.performFilteringNight());
        mAdapter.notifyDataSetChanged();
    }

    public void updateCat5() {
        mAdapter.setList(filterCards.performFilteringLeisure());
        mAdapter.notifyDataSetChanged();
    }


}

