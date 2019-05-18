package Panzer01.a20apiyeventos01;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
/*En este programa integramos mas funciones al teclado.
* En el metodo resetContador agregamos metodos que ocultan el teclado una vez que se oprime el boton Resetear.
* Utilizamos la vista onEditorAction para poner a la escucha la vista nReset y asi detectar cuando se presione ok en el teclado.*/

/*Activity es la clase padre de y para generalizar ponemos esta.*/
public class MainActivity extends Activity {
    //Atributos
    public int contador;
    public TextView txtResultado; //Variable del tipo TextView.

    /*
    * Metodo que se llama al iniciarse la aplicacion.*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Asignamos a la variable el identificador de la vista txtContador.
        txtResultado=(TextView) findViewById(R.id.txtContador);
        //Inicializamos el contador al iniciar la aplicacion
        contador = 0;

        //
        /*La vista nReset necesita estar a la escucha de la pulsacion del ok para desencadenar su metodo.*/
        //Instacia que desencadena el metodo al pulsar ok en el teclado.
        EventoTeclado teclado = new EventoTeclado();
        /*Creamos un objeto del tipo EditText para almacenar la vista nReset, el cual tiene que estar a la escucha del teclado.*/
        EditText n_Reset=(EditText)findViewById(R.id.nReset);
        /*Ponemos a la escucha a EditText de la pulsacion de ok en el teclado.*/
        n_Reset.setOnEditorActionListener(teclado);
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

        //Almacenamos dentro de la instancia el dispositivo que utilizamos para introducir la informacion, es decir el teclado.
        InputMethodManager miTeclado = (InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);

        //Ocultamos el teclado automaticamente cuando terminemos de utilizar el editText(nReset).
        //hideSoftInputFromWindow revisar en la API de Android.
        miTeclado.hideSoftInputFromWindow(nReset.getWindowToken(), 0);

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

    /*Para acceder a la implementacion del metodo que nos permite obtener el estado del teclado debemos
    * crear una clase debido a que el metodo(OnEditorAction) en cuestion es una vista de otra clase.*/
    class EventoTeclado implements TextView.OnEditorActionListener{

        /*Metodo para revisar el estado ok del teclado*/
        @Override
        public boolean onEditorAction(TextView v, int actionId, KeyEvent keyEvent) {

            if(actionId==EditorInfo.IME_ACTION_DONE){
                /*Si se ha ocultado el teclado por que pulsamos ok, entonces realiza esto*/
                /*Obligatoriamente requiere un objeto de tipo view, pero solo necesito que se ejecute la funcion, en ese caso
                * le paso un null.*/
                resetContador(null);
            }
            //Si no se pulso ok, entonces regresa un false.
            return false;
        }
    }

}