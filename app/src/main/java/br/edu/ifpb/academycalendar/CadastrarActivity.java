package br.edu.ifpb.academycalendar;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar);
        init();
    }

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

}
