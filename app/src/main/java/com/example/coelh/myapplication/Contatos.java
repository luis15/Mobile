package com.example.coelh.myapplication;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

public class Contatos extends Fragment {

    private FragmentSwapper hostActivity;

    public Contatos(){}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View lview = inflater.inflate(R.layout.content_main, container, false);

        ListView listaView = (ListView) lview.findViewById(R.id.contatos);
        listaView.setOnItemClickListener( new AdapterView.OnItemClickListener(){
            public void onItemClick(AdapterView<?> listaView, View view, int pessoa, long id){
                Conversa conversa = new Conversa();
                conversa.setConversa(pessoa);
                hostActivity.replaceFragment(conversa);
            }
        });

        return lview;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
    }

    public void onAttach(Context context){
        super.onAttach(context);

        try{
            hostActivity = (FragmentSwapper) context;
        }catch (ClassCastException e){
            throw new ClassCastException(context.toString() + "Deve implementar uma Interface");
        }
    }
}
