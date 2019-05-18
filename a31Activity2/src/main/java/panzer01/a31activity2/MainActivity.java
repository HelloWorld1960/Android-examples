package panzer01.a31activity2;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

/**
 * Este programa realiza una suma y muestra el resultado en el activity 2.
 *
 * Para pasar informacion entre activity es necesario construir un paquete de datos, es decir un Bundl.
 */


public class MainActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
    * Metodo del btnSumar.
     *Cambia a la segunda activity. */
    public void aSumar(View v){
        //Rescatamos la informacion de los editText
        EditText cuadroUno = (EditText)findViewById(R.id.numUno);
        int n1 = Integer.parseInt(cuadroUno.getText().toString());
        EditText cuadroDos = (EditText)findViewById(R.id.numDos);
        int n2 = Integer.parseInt(cuadroDos.getText().toString());

        /**Creamos una intencion.
         * Se le pasa como parámetros la actividad actual (this) y la actividad a la que queremos pasar(ClaseResultado.class)*/
        Intent i = new Intent(this, ClaseResultado.class);

        /**
         * Definimos dos variables con el valor de los EditText.*/
        i.putExtra("numero1", n1);
        i.putExtra("numero2", n2);


        /**
         * Iniciar la actividad pasando como parametro el Intent creado.*/
        startActivity(i);
    }
}
