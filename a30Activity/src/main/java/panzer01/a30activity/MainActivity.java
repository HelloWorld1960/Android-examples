package panzer01.a30activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
/**
 * Esta aplicacion tiene dos activity_main, uno muestra una interfaz centrada verticalmente cuando esta esta en posicion vertical.
 * La otra muestra los elementos centrados horizontalmente cuando su posicion es horizontal.
 * Tambien la interfaz cambia de acuerdo a el idioma nativo del dispositivo, esto se logra trabajando con los archivos String.xml
 * de la carpeta values.
 * Por ultimo, asignamos una imagen a un ImageView por medio de codigo java.
 *
 * Añadimos vistas.
 * Al pulsar el boton informacion, nos llevara a una vista nueva.
 *
 * */

/*Activity es la clase padre de y para generalizar ponemos esta.*/
public class MainActivity extends Activity {
    //Atributos
    ImageView img;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Establecer una imagen en un ImageView
        //Identificamos la vista para la imagen.
        img = (ImageView) findViewById(R.id.ImagenRoca);
        //La variable tiene que recoger el recuro(imagen).
        img.setImageResource(R.drawable.rocas);

    }

    /*Activar la nueva activity*/
    /*Este metodo esta a la escucha de la pulsacion del botn informacion*/
    public void ejecutarInformacion(View view){
        //Intent: Es utilizado cuando queremos lanzar un activity
        Intent i = new Intent(this, ClaseInformacion.class);
        //Comenzar activity
        startActivity(i);
    }

    //Salir de la aplicacion
    /*Este metodo ciera la plicacion.*/
    public void salirAplicacion(View v){
        finish();
    }
}
