package com.example.appconceptosbase;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Panelprincipal extends AppCompatActivity {

    TextView informacion;
    Button regresar;
    StringBuilder contenido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_panelprincipal);

        regresar = findViewById(R.id.btnRegresar);
        informacion = findViewById(R.id.txvInformacion);

        contenido = new StringBuilder();

        Intent recibirDatos = getIntent();
        String nombre = recibirDatos.getStringExtra("nom_user");
        String apellido = recibirDatos.getStringExtra("ape_user");
        String documento = recibirDatos.getStringExtra("doc_user");
        String edad = recibirDatos.getStringExtra("age_user");
        String telefono = recibirDatos.getStringExtra("tel_user");
        String ciudad = recibirDatos.getStringExtra("ciu_user");

        contenido.append("¡Gracias por registrarte ").append(nombre).append(" ").append(apellido).append(" CC ").append(documento).append("! ").append("\n\n").append("Es un gusto saber que tienes ").append(edad).append(" años, y que vives en la cidudad de ").append(ciudad).append(", nos pondremos en contacto al numero: ").append(telefono);

        informacion.setText(contenido.toString());

    }

    @Override
    protected void onStart() {
        super.onStart();

        regresar.setOnClickListener(View -> {
            Intent volver = new Intent(Panelprincipal.this, MainActivity.class);
            startActivity(volver);
        });
    }
}