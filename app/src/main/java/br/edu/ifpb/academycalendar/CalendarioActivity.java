package br.edu.ifpb.academycalendar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CalendarioActivity extends AppCompatActivity {

    Button btnNovoEvento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendario);

        setNovoEventoListener();
    }

    public void setNovoEventoListener(){
        btnNovoEvento = (Button) findViewById(R.id.btn_criar);
        btnNovoEvento.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(".NovoEventoActivity");
                startActivity(intent);
            }
        });
    }
}
