package com.example.semana_14;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.UUID;


public class MainActivity extends AppCompatActivity {

    private FirebaseDatabase db;

    private Button IngresarBtn;
    private EditText UserTxt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = FirebaseDatabase.getInstance();

        IngresarBtn = findViewById(R.id.IngresarBtn);
        UserTxt = findViewById(R.id.UserTxt);


        IngresarBtn.setOnClickListener((view)->{
            registrar();
        });

    }

    public void registrar(){

        DatabaseReference newUser = db.getReference().child("Usuarios").push();

      Usuario usuario = new Usuario(

                UserTxt.getText().toString(),
                newUser.getKey()
        );

       newUser.setValue(usuario);


        //pasar a la pantalla Task

        Intent task = new Intent(this, Task.class);
        task.putExtra("ID", usuario.getID());
        startActivity(task);

    }

}