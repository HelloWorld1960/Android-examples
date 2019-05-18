package Panzer01.a18edittextcheckboxlogica;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

/*Activity es la clase padre de y para generalizar ponemos esta.*/
public class MainActivity extends Activity {
    //Atributos
    public int contador;

    TextView txtResultado; //Variable del tipo TextView.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Asignamos a la variable el identificador de la vista txtContador.
        txtResultado=(TextView) findViewById(R.id.txtContador);
        //Inicializamos el contador al iniciar la aplicacion
        contador = 0;

    }

    //Metodos
    public void incrementarContador(View vista) {
        contador++;

        //Mostramos el resultado.
        txtResultado.setText(""+contador);
    }

    public void resetContador(View vista) {
        //Creamos una variable del tipo EditText que almacena el valor de la vista nReset.
        EditText nReset=(EditText)findViewById(R.id.nReset);
        try {
            /*Convertimos el contenido de nReset a un tipo int, debido a que devuelve un objeto de tipo Editable.
             * Lo que hago es convertirlo a String y luego a int.*/
            contador = Integer.parseInt(nReset.getText().toString());
        } catch (Exception e){
            contador=0;
        }

        //Establcemos un espacio vacio a nReset.
        nReset.setText("");

        //Mostramos el resultado.
        txtResultado.setText(""+contador);
    }

    public void decrementarContador(View vista) {
        contador--;

        if (contador < 0){
            //Creamos una instancia la cual identifica el campo checkBox
            CheckBox negativos = (CheckBox)findViewById(R.id.negativos);
            if (!negativos.isChecked()){ //Si no esta activado.
                contador=0;
            }
        }
        //Mostramos el resultado.
        txtResultado.setText(""+contador);
    }

}