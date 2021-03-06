package br.edu.ifpb.academycalendar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnCadastrar;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setLoginListener();
        setCadastrarListener();
    }

    public void setLoginListener(){
        btnLogin = (Button) findViewById(R.id.btn_login);
        btnLogin.setOnClickListener( new View.OnClickListener () {
            @Override
            public void onClick(View v){
                Intent intent = new Intent(".CalendarioActivity");
                startActivity(intent);
            }
        });
    }

    public void setCadastrarListener(){
        btnCadastrar = (Button) findViewById(R.id.btn_cadastrar);
        btnCadastrar.setOnClickListener( new View.OnClickListener () {
            @Override
            public void onClick(View v){
                Intent intent = new Intent(".CadastrarActivity");
                startActivity(intent);
            }
        });
    }
}
