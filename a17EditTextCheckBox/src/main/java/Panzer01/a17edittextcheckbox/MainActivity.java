package Panzer01.a17edittextcheckbox;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/*Activity es la clase padre de y para generalizar ponemos esta.*/
public class MainActivity extends Activity {
    //Atributos
    public int contador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Inicializamos el contador al iniciar la aplicacion
        contador = 0;

    }

    //Metodos
    public void incrementarContador(View vista) {
        contador++;

        mostrarResultado();
    }

    public void resetContador(View vista) {
        contador = 0;

        mostrarResultado();
    }

    public void decrementarContador(View vista) {
        contador--;

        mostrarResultado();
    }

    public void mostrarResultado() {
        //Creamos una instancia la cual identifica el campo que deceamos cambiar.
        //R.id.txtContador es la ruta del elemento
        TextView txtResultado = (TextView) findViewById(R.id.txtContador);

        //Dentro de la clase TextView se encuentra el metodo setText el cual nos permite cambiar el texto del campo deceado.
        txtResultado.setText("" + contador);
    }

}