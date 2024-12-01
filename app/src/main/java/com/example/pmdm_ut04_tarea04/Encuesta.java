package com.example.pmdm_ut04_tarea04;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.snackbar.Snackbar;

public class Encuesta extends AppCompatActivity {

    private EditText respuestaEditText;
    private Button enviarButton;
    private TextView mensajeTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.encuesta);  // Este es el layout de la encuesta

        // Inicializamos las vistas
        respuestaEditText = findViewById(R.id.respuestaEditText);
        enviarButton = findViewById(R.id.enviarButton);
        mensajeTextView = findViewById(R.id.mensajeTextView);  // TextView para mostrar el mensaje

        // Configuramos el botón de envío
        enviarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String respuesta = respuestaEditText.getText().toString();

                if (respuesta.isEmpty()) {
                    // Si la respuesta está vacía, mostramos un mensaje en el TextView
                    mensajeTextView.setText("Por favor, responde la pregunta.");
                } else {
                    // Si la respuesta no está vacía, mostramos el mensaje de agradecimiento
                    mensajeTextView.setText("Gracias por tu respuesta. Te recomendamos visitar Cieza.");

                    // Aquí podrías guardar la respuesta o enviarla a un servidor si lo deseas.

                    // Después de mostrar el mensaje, volver a la pantalla principal
                    Intent intent = new Intent(Encuesta.this, MainActivity.class);
                    startActivity(intent);
                    finish();  // Finalizamos la actividad de encuesta para que no quede en el stack
                }
            }
        });
    }
}

