package com.example.coelh.myapplication;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.coelh.myapplication.R;

public class Conversa extends Fragment {

    private int currentConversa = -1;
    private String msgm;
    private String historico;

    private TextView txtConversa;
    private EditText caixaTxt;
    private Button btnEnviar;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View lview = inflater.inflate(R.layout.activity_conversa, container, false);

        txtConversa = (TextView) lview.findViewById(R.id.txtConversa);
        caixaTxt = (EditText) lview.findViewById(R.id.enviarMsg);
        btnEnviar = (Button) lview.findViewById(R.id.enviar);

        btnEnviar.setOnClickListener( new AdapterView.OnClickListener(){
            public void onClick(View view){
                msgm = caixaTxt.getText().toString();
                historico = txtConversa.getText().toString();
                txtConversa.setText(historico +"\n"+ msgm);
                caixaTxt.setText("");
            }
        });

        return lview;
    }

    @Override
    public void onStart(){
        super.onStart();

        if(currentConversa == 0)  txtConversa.setText("Olá Antônio Como vai?");
        else if(currentConversa == 1) txtConversa.setText("E aew Pedrão, suavera?");
        else if(currentConversa == 2) txtConversa.setText("Bora bar Gabriel?");
        else txtConversa.setText("Vai pra aula hoje Matheus?");
    }

    public void setConversa(int conversa) {
        currentConversa = conversa;
    }

    public Conversa(){}
}
