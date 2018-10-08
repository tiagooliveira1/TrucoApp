package com.example.troli.trucoapp.trucoapp.Activity;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.troli.trucoapp.trucoapp.Classes.Dupla;
import com.example.troli.trucoapp.trucoapp.Classes.Partida;
import com.example.troli.trucoapp.trucoapp.Classes.Usuario;
import com.example.troli.trucoapp.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegistrarJogoActivity extends AppCompatActivity {

    private FirebaseDatabase mDatabase;
    private DatabaseReference mRefPartida;
    private DatabaseReference mRefUserStat;
    private FirebaseAuth mAuth;

    private ProgressBar progressBarPartida;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_jogo);
        mDatabase = FirebaseDatabase.getInstance();
        mRefPartida = mDatabase.getReference("partidas");
        mRefUserStat = mDatabase.getReference("stat_usuario");
        mAuth = FirebaseAuth.getInstance();

        progressBarPartida = (ProgressBar) findViewById(R.id.progressBarPartida);


    }

    public void salvarPartida(View v)
    {
        Usuario usuario1Dupla1 = new Usuario(mAuth.getCurrentUser().getUid());
        usuario1Dupla1.setNome(mAuth.getCurrentUser().getDisplayName());

        Usuario usuario2Dupla1 = new Usuario("1Nnabsudabsj");
        Usuario usuario1Dupla2 = new Usuario("");
        Usuario usuario2Dupla2 = new Usuario("");

        Dupla dupla1 = new Dupla(usuario1Dupla1, usuario2Dupla1);
        Dupla dupla2 = new Dupla(usuario1Dupla2, usuario2Dupla2);

        Partida partida1 = new Partida(dupla1, dupla2, dupla1);
        Partida partida2 = new Partida(dupla1, dupla2, dupla2);
        Partida partida3 = new Partida(dupla1, dupla2, dupla2);
        Partida partida4 = new Partida(dupla1, dupla2, dupla1);

        progressBarPartida.setVisibility(progressBarPartida.VISIBLE);

        mRefPartida.setValue(partida1).addOnCompleteListener(RegistrarJogoActivity.this, new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful()) {
                    Toast.makeText(RegistrarJogoActivity.this, "Dados da partida salva som sucesso.", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(RegistrarJogoActivity.this, "Erro ao salvar partida:"+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
        progressBarPartida.setVisibility(progressBarPartida.GONE);

    }

}
