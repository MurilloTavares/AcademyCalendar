package br.edu.ifpb.academycalendar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import br.edu.ifpb.academycalendar.entity.Usuario;
import br.edu.ifpb.academycalendar.sqlite.UsuarioController;

public class CadastrarActivity extends AppCompatActivity {

    private Button btnCadastrar;
    private EditText etEmail;
    private EditText etSenha;
    private EditText etSenhaConf;
    private EditText etNome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar);
        init();
    }

    private void cadastrarOnClick(){
        if(!validate()){
            return;
        }
        String email = etEmail.getText().toString();
        String senha = etSenha.getText().toString();
        String nome = etNome.getText().toString();

        UsuarioController crud = new UsuarioController(getBaseContext());
        Usuario usuario = new Usuario();
        usuario.setEmail(email);
        usuario.setSenha(senha);
        usuario.setNome(nome);

        boolean result = crud.inserirUsuario(usuario);
        if(result) {
            Toast.makeText(getApplicationContext(), "Sucesso.", Toast.LENGTH_SHORT).show();
            finish();
        } else {
            Toast.makeText(getApplicationContext(), "Falha no cadastro.", Toast.LENGTH_SHORT).show();
        }
    }

    private void init() {
        etNome = (EditText) findViewById(R.id.cadastro_txt_nome);
        etEmail = (EditText) findViewById(R.id.cadastro_txt_email);
        etSenha = (EditText) findViewById(R.id.cadastro_txt_senha);
        etSenhaConf = (EditText) findViewById(R.id.cadastro_txt_senhaConf);

        btnCadastrar = (Button) findViewById(R.id.cadastro_btn_cadastrar);
        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cadastrarOnClick();
            }
        });
    }

    private boolean validate() {
        String nome = etNome.getText().toString().trim();
        if(nome.isEmpty() || nome == null){
            etNome.setError("Nome obrigatório.");
            return false;
        }
        String email = etEmail.getText().toString().trim();
        if(email.isEmpty() || email == null || !Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            etEmail.setError("Email inválido.");
            return false;
        }
        String senha = etSenha.getText().toString();
        String senhaConf = etSenhaConf.getText().toString();
        if(senha.isEmpty() || senha == null){
            etSenha.setError("Informe uma senha.");
            return false;
        } else if (!senha.equals(senhaConf)){
            etSenhaConf.setError("As senhas são diferentes");
            return false;
        }
        return true;
    }



}
