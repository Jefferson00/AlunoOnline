package br.iesb.alunoonline;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.UUID;

public class MainActivity extends AppCompatActivity {
Button btnInserir;
EditText txNome;
EditText txCurso;
EditText txDtNasc;
EditText txCampus;
EditText txMatricula;
EditText txInteresse;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnInserir = findViewById(R.id.btnInserir);
        txInteresse = findViewById(R.id.txInteresses);

        txInteresse.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                Toast.makeText(MainActivity.this, "Separe com virgula",Toast.LENGTH_LONG).show();
            }
        });

        btnInserir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inserir();
            }
        });
    }

    public void inserir(){
        txNome = findViewById(R.id.txNome);
        txCampus = findViewById(R.id.txCampus);
        txCurso = findViewById(R.id.txCurso);
        txMatricula = findViewById(R.id.txMatricula);
        txDtNasc = findViewById(R.id.txDtNasc);
        txInteresse = findViewById(R.id.txInteresses);
        String interesses = txInteresse.getText().toString();

        Aluno aluno = new Aluno();
        aluno.nome = txNome.getText().toString();
        int mat = Integer.parseInt(txMatricula.getText().toString());
        aluno.matricula = mat;
        int dtNasc = Integer.parseInt(txDtNasc.getText().toString());
        aluno.dt_nasc = dtNasc;
        aluno.curso = txCurso.getText().toString();
        aluno.campus = txCampus.getText().toString();



        for(String s : interesses.split(",")){
            Interesses it = new Interesses();
            it.id = UUID.randomUUID().toString();
            it.tag = s ;
            aluno.interesses.add(it);
        }


        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference Aluno = database.getReference("iesb/alunos/" + UUID.randomUUID().toString());
        Aluno.setValue(aluno);
        Toast.makeText(MainActivity.this, "Inserido Perfil com sucesso!",Toast.LENGTH_LONG).show();
//        Aluno.child("campus").setValue(txCampus.getText().toString());
//        Aluno.child("curso").setValue(txCurso.getText().toString());
//        Aluno.child("dt_nasc").setValue(21021998);
//        Aluno.child("interesse").child("it0").setValue("Comutação");
//        Aluno.child("interesse").child("it1").setValue("teste");
//        Aluno.child("matricula").setValue(12345);
//        Aluno.child("nome").setValue(txNome.getText().toString());


    }
}
