package com.example.pmdm_ut04_tarea04;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private ImageView flagEs; // Variable de clase para la bandera

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Configuramos el ImageView para la bandera
        flagEs = findViewById(R.id.flag_es);

        // Establecer el listener de clic para la bandera
        flagEs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Cambiar entre los idiomas cuando se hace clic
                String idiomaActual = obtenerIdiomaActual();
                switch (idiomaActual) {
                    case "es":
                        cambiarBandera("de");  // Cambiar a alemán
                        break;
                    case "de":
                        cambiarBandera("en");  // Cambiar a inglés
                        break;
                    case "en":
                        cambiarBandera("es");  // Cambiar a español
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + idiomaActual);
                }
            }
        });

        // botón de la encuesta
        findViewById(R.id.botonEncuesta).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Cuando el usuario haga clic en el botón de la encuesta, abrimos la actividad Encuesta
                Intent intent = new Intent(MainActivity.this, Encuesta.class);
                startActivity(intent);
            }
        });
    }

    private void cambiarBandera(String idioma) {
        // Cambiar la bandera y el idioma
        if (idioma.equals("de")) {
            flagEs.setImageResource(R.drawable.de);
            cambiarIdioma("de");
        } else if (idioma.equals("en")) {
            flagEs.setImageResource(R.drawable.england);
            cambiarIdioma("en");
        } else {
            flagEs.setImageResource(R.drawable.es);
            cambiarIdioma("es");
        }
    }


    // Cambiar el idioma de la aplicación
    private void cambiarIdioma(String idioma) {

        Locale locale;
        switch (idioma) {
            case "de":
                locale = new Locale("de", "DE");  // Alemán
                break;
            case "en":
                locale = new Locale("en", "US");  // Inglés
                break;
            default:
                locale = new Locale("es", "ES");  // Español
                break;
        }
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.setLocale(locale);
        Context context = createConfigurationContext(config);
        getResources().updateConfiguration(config, getResources().getDisplayMetrics());
        recreate();
    }

    // idioma actual
    private String obtenerIdiomaActual() {
        Locale currentLocale = getResources().getConfiguration().locale;
        return currentLocale.getLanguage();
    }
}
