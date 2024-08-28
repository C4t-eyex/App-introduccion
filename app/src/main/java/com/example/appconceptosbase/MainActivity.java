package com.example.appconceptosbase;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.inputmethod.InputMethodManager;
import android.content.Context;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText nombreUsuario, apellidoUsuario, documentoUsuario, edadUsuario, telefonoUsuario, ciudadUsuario;
    TextView alerta;
    Button salir, enviar;

    String TAG = "Test";

    // Cuando la aplicacion se abre por primera vez
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.inicio));

        Log.d(TAG,"Estoy en el onCreate");

        nombreUsuario = (EditText) findViewById(R.id.nombreUsuario);
        apellidoUsuario = (EditText) findViewById(R.id.apellidoUsuario);
        documentoUsuario = (EditText) findViewById(R.id.documentoUsuario);
        edadUsuario = (EditText) findViewById(R.id.edadUsuario);
        telefonoUsuario = (EditText) findViewById(R.id.telefonoUsuario);
        ciudadUsuario = (EditText) findViewById(R.id.ciudadUsuario);

        alerta = (TextView) findViewById(R.id.txvAlerta);

        salir = findViewById(R.id.btnSalir);
        enviar = findViewById(R.id.btnEnviar);

    }

    // Cuando se inicia la pestaña actual
    @Override
    protected void onStart() {
        super.onStart();

        enviar = findViewById(R.id.btnEnviar);

        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nombreUsuario = (EditText) findViewById(R.id.nombreUsuario);
                apellidoUsuario = (EditText) findViewById(R.id.apellidoUsuario);
                documentoUsuario = (EditText) findViewById(R.id.documentoUsuario);
                edadUsuario = (EditText) findViewById(R.id.edadUsuario);
                telefonoUsuario = (EditText) findViewById(R.id.telefonoUsuario);
                ciudadUsuario = (EditText) findViewById(R.id.ciudadUsuario);
                alerta = (TextView) findViewById(R.id.txvInformacion);

                String nom_user = nombreUsuario.getText().toString();
                String ape_user = apellidoUsuario.getText().toString();
                String doc_user = documentoUsuario.getText().toString();
                String age_user = edadUsuario.getText().toString();
                String tel_user = telefonoUsuario.getText().toString();
                String ciu_user = ciudadUsuario.getText().toString();

                alerta = (TextView) findViewById(R.id.txvAlerta);

                if (ValidarCampos.validarCampos(nombreUsuario, apellidoUsuario, documentoUsuario, edadUsuario, telefonoUsuario, ciudadUsuario)) {

                    alerta.setTextColor(getResources().getColor(R.color.alertaGood));
                    alerta.setText("¡Información completa! Redirigiendo en 3 segundos...");

                    // Se crea un Handler para mostrar el mensaje y luego ir a la otra actividad
                    Handler carga = new Handler();
                    carga.postDelayed(new Runnable() {
                        @Override
                        public void run() {

                            // Intent para enviar los datos e ir a la otra actividad donde se va a mostrar el mensaje
                            Intent enviarDatos = new Intent(MainActivity.this, Panelprincipal.class);
                            enviarDatos.putExtra("nom_user", nom_user);
                            enviarDatos.putExtra("ape_user", ape_user);
                            enviarDatos.putExtra("doc_user", doc_user);
                            enviarDatos.putExtra("age_user", age_user);
                            enviarDatos.putExtra("tel_user", tel_user);
                            enviarDatos.putExtra("ciu_user", ciu_user);

                            startActivity(enviarDatos);
                        }
                    }, 3000); // 3000 milisegundos = 3 segundos
                } else {
                    alerta.setTextColor(getResources().getColor(R.color.alertaBad));
                    alerta.setText("¡Falta llenar campos!");
                }

            }
        });

        salir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
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