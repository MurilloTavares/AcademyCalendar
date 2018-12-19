package br.edu.ifpb.academycalendar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.my_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_turmas:
                Intent intent = new Intent(".TurmasActivity");
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
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
