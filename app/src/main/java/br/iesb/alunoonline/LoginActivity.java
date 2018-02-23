package br.iesb.alunoonline;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button bt = findViewById(R.id.btnLogin);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent t = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(t);
            }
        });

        TextView txCad = findViewById(R.id.textViewCadastro);
        txCad.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent t1 = new Intent(LoginActivity.this, CadastroActivity.class);
                startActivity(t1);
            }
        });

        TextView txRecupera = findViewById(R.id.textViewRecuperaSenha);
        txRecupera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent t2 = new Intent(LoginActivity.this, RecuperaSenhaActivity.class);
                startActivity(t2);
            }
        });

    }
}
