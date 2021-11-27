package com.example.semana_14;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Task extends AppCompatActivity {

    private FirebaseDatabase db;

    private Button AgregarBtn;
    private EditText NombreTxt;
    private EditText DesTxt;
    private ListView itemsList;
    private String ID;

    private ArrayList<Nota> dataNotas;
    private ArrayAdapter<Nota> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);


        AgregarBtn = findViewById(R.id.AgregarBtn);
        NombreTxt = findViewById(R.id.NombreTxt);
        DesTxt = findViewById(R.id.DesTxt);
        itemsList = findViewById(R.id.itemsList);

        db = FirebaseDatabase.getInstance();

        ID = getIntent().getExtras().getString("ID");

        AgregarBtn.setOnClickListener((view)->{
            registrar();
        });

        dataNotas = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,dataNotas);
        itemsList.setAdapter(adapter);

    }

    public void registrar(){

        DatabaseReference newNota = db.getReference().child("Usuarios/" + ID + "/Notas").push();

        Nota nota = new Nota(
                NombreTxt.getText().toString(),
                DesTxt.getText().toString()
        );

        newNota.setValue(nota);


       /* newNota.addValueEventListener(//ON
                new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot data) {
                        dataNotas.clear();
                        for (DataSnapshot child : data.getChildren()) {
                            Nota noticas = child.getValue(Nota.class);
                            dataNotas.add(noticas);
                        }
                        adapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onCancelled(DatabaseError error) {

                    }
                }
        );

        */
    }

}