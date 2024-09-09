package com.example.appconceptosbase;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
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
    Button regresar, llamada, contacto;
    StringBuilder contenido;
    String nombre, apellido, documento, edad, telefono, ciudad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_panelprincipal);

        informacion = findViewById(R.id.txvInformacion);
        llamada = findViewById(R.id.btnLlamada);
        contacto = findViewById(R.id.btnContacto);
        regresar = findViewById(R.id.btnRegresar);

        contenido = new StringBuilder();

        Intent recibirDatos = getIntent();
        nombre = recibirDatos.getStringExtra("nom_user");
        apellido = recibirDatos.getStringExtra("ape_user");
        documento = recibirDatos.getStringExtra("doc_user");
        edad = recibirDatos.getStringExtra("age_user");
        telefono = recibirDatos.getStringExtra("tel_user");
        ciudad = recibirDatos.getStringExtra("ciu_user");

        contenido.append("¡Gracias por registrarte ").append(nombre).append(" ").append(apellido).append(" CC ").append(documento).append("! ").append("\n\n").append("Es un gusto saber que tienes ").append(edad).append(" años, y que vives en la ciudad de ").append(ciudad).append(", nos pondremos en contacto al numero: ").append(telefono);

        informacion.setText(contenido.toString());

        llamada.setText("Verifica tu número ¡Llamandote!");
        contacto.setText("¡Agrega nuestro número!");

    }

    @Override
    protected void onStart() {
        super.onStart();

        llamada.setOnClickListener(View -> {
            Intent llamar = new Intent(Intent.ACTION_DIAL);
            llamar.setData(Uri.parse("tel:" + telefono));
            startActivity(llamar);
        });

        contacto.setOnClickListener(view -> {
            Intent agregarContacto = new Intent(Intent.ACTION_INSERT);
            agregarContacto.setType(ContactsContract.Contacts.CONTENT_TYPE);
            agregarContacto.putExtra(ContactsContract.Intents.Insert.NAME, "Contacto de prueba");
            agregarContacto.putExtra(ContactsContract.Intents.Insert.PHONE, "3004892600");
            startActivity(agregarContacto);
        });

        regresar.setOnClickListener(View -> {
            Intent volver = new Intent(Panelprincipal.this, MainActivity.class);
            startActivity(volver);
        });
    }
}