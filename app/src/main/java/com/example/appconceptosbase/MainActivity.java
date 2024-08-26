package com.example.appconceptosbase;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.inputmethod.InputMethodManager;
import android.content.Context;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText nombreUsuario, apellidoUsuario, documentoUsuario, edadUsuario, telefonoUsuario, ciudadUsuario;
    TextView banner, informacion;
    Button salir, enviar;
    StringBuilder contenido;

    String TAG = "Test";

    // Cuando la aplicacion se abre por primera vez
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG,"Estoy en el onCreate");

        nombreUsuario = (EditText) findViewById(R.id.nombreUsuario);
        apellidoUsuario = (EditText) findViewById(R.id.apellidoUsuario);
        documentoUsuario = (EditText) findViewById(R.id.documentoUsuario);
        edadUsuario = (EditText) findViewById(R.id.edadUsuario);
        telefonoUsuario = (EditText) findViewById(R.id.telefonoUsuario);
        ciudadUsuario = (EditText) findViewById(R.id.ciudadUsuario);

        informacion = (TextView) findViewById(R.id.txvInformacion);

        salir = findViewById(R.id.btnSalir);
        enviar = findViewById(R.id.btnEnviar);

        contenido = new StringBuilder();

        salir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nom_user = nombreUsuario.getText().toString();
                String ape_user = apellidoUsuario.getText().toString();
                String doc_user = documentoUsuario.getText().toString();
                String age_user = edadUsuario.getText().toString();
                String tel_user = telefonoUsuario.getText().toString();
                String ciu_user = ciudadUsuario.getText().toString();

                contenido.append("¡Gracias por registrarte ").append(nom_user).append(" ").append(ape_user).append(" CC ").append(doc_user).append("! ").append("\n").append("Es un gusto saber que tienes ").append(age_user).append(" años, y que vives en la cidudad de ").append(ciu_user).append(", nos pondremos en contacto al numero: ").append(tel_user);

                informacion.setText(contenido.toString());
            }
        });

    }

    // Cuando se inicia la pestaña actual
    @Override
    protected void onStart() {
        super.onStart();
    }

    // Trata  de abrir en la ultima pagina en la que quedo
    @Override
    protected void onResume() {
        super.onResume();

        Log.d(TAG,"Estoy en el onResume");
        //poner mensaje en pantalla
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG,"Estoy en el onPause");
    }

    // La aplicación queda en segundo plano
    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG,"Estoy en el onStop");
    }


    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG,"Estoy en el onRestart");
    }

    // Cuando se cierra la app en segundo plano
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG,"Estoy en el onDestroy");
    }
}