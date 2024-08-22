package com.example.appconceptosbase;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText ingresarUsuario;
    TextView usuario;
    Button salir, enviar;

    String TAG = "Test";

    // Cuando la aplicacion se abre por primera vez
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG,"Estoy en el onCreate");

        ingresarUsuario = (EditText) findViewById(R.id.editarUsuario);
        usuario = (TextView) findViewById(R.id.txvUsuario);
        salir = findViewById(R.id.btnSalir);
        enviar = findViewById(R.id.btnEnviar);
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