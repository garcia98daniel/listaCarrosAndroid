package com.unimag.quiz1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Carro> carros= new ArrayList<Carro>();
    Button agregar;
    EditText placa, marca, modelo;
    ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        placa = findViewById(R.id.placa);
        marca = findViewById(R.id.marca);
        modelo = findViewById(R.id.modelo);
        agregar = findViewById(R.id.btnagregar);
        lista = findViewById(R.id.lstcarros);
        final AdaptadorCarro adaptadorCarros = new AdaptadorCarro(this,carros);

        agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Carro auto = new Carro(placa.getText().toString(), marca.getText().toString(), modelo.getText().toString());
                carros.add(auto);
                Toast.makeText(getApplicationContext(),"Carro agregado", Toast.LENGTH_LONG).show();
                lista.setAdapter(adaptadorCarros);
            }
        });

    }
}
