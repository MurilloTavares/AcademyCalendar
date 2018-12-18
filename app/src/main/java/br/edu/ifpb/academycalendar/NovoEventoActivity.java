package br.edu.ifpb.academycalendar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class NovoEventoActivity extends AppCompatActivity {

    Button btnCancelar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novo_evento);

        setCancelarListener();
    }

    public void setCancelarListener(){
        btnCancelar = (Button) findViewById(R.id.btn_cancelar);
        btnCancelar.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View v){
                finish();
            }
        });
    }

}
