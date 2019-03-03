package br.edu.ifpb.academycalendar;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
<<<<<<< HEAD
import android.util.Patterns;
=======
import android.util.Log;
>>>>>>> a6eb858cb5128c5e18033a8608a1e40e0c6c94ad
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

<<<<<<< HEAD
import br.edu.ifpb.academycalendar.entity.Usuario;
import br.edu.ifpb.academycalendar.sqlite.UsuarioController;

public class CadastrarActivity extends AppCompatActivity {

    private Button btnCadastrar;
    private EditText etEmail;
    private EditText etSenha;
    private EditText etSenhaConf;
    private EditText etNome;
=======
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class CadastrarActivity extends AppCompatActivity {

    private String TAG = "CadastrarActivity";
    private FirebaseAuth mAuth;

    private EditText etEmail;
    private EditText etSenha;

    private Button btnCadastrar;
>>>>>>> a6eb858cb5128c5e18033a8608a1e40e0c6c94ad

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar);
        init();
    }

<<<<<<< HEAD
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


=======
    @Override
    protected void onStart() {
        super.onStart();

        FirebaseUser currentUser = mAuth.getCurrentUser();
        updateUI(currentUser);
    }

    private void cadastrar() {
        String email = etEmail.getText().toString().trim();
        String senha = etSenha.getText().toString().trim();
        createAccount(email, senha);
    }

    private void createAccount (String email, String password) {
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Log.d(TAG, "createUserWithEmail: success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            updateUI(user);
                        } else {
                            Log.w(TAG, "createUserWithEmail: failure", task.getException());
                            Toast.makeText(CadastrarActivity.this,
                                    "Authentication falied",
                                    Toast.LENGTH_LONG).show();
                            updateUI(null);
                        }
                    }
                });
    }

    private void updateUI(FirebaseUser user){
        if(user != null){
            Log.d(TAG, user.getDisplayName());
        } else {
            Log.d(TAG, "updateUI: NULL");
        }

    }

    private void init() {

        FirebaseApp.initializeApp(this);
        mAuth = FirebaseAuth.getInstance();
        etEmail = (EditText) findViewById(R.id.cadastro_et_email);
        etSenha = (EditText) findViewById(R.id.cadastro_et_senha);
        btnCadastrar = (Button) findViewById(R.id.cadastro_btn_cadastrar);
        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cadastrar();
            }
        });
    }
>>>>>>> a6eb858cb5128c5e18033a8608a1e40e0c6c94ad

}
