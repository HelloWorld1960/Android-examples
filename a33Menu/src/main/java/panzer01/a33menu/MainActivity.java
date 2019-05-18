package panzer01.a33menu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
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
 * Creamos un menu para la aplicacion.
 *
 * Creamos una toolbar:
 * Para que se muestre correctamente nuestra toolbar tenemos que deshabilitar la que ya teniamos cambiando el codigo de styles.xml, en especifico
 * la linea parent="Theme.AppCompat.Light.NoActionBar" o agregando laslineas
 *<item name="windowActionBar">false</item> <item name="windowNoTitle">true</item>
 *
 * */
/*Activity es la clase padre de y para generalizar ponemos esta.*/
public class MainActivity extends AppCompatActivity {
    //Atributos
    ImageView img;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*Indicamos que muestre el toolBar*/
        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        //Activar la toolBar
        setSupportActionBar(toolbar);

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

    /**
     * Activar el menu.*/
    @Override
    public boolean onCreateOptionsMenu(Menu miMenu){
        getMenuInflater().inflate(R.menu.activity_menu, miMenu);
        return (true);
    }

    /**
     * Funcionalidad para el menu.
     * Retorna una opcion de menu.*/
    @Override
    public boolean onOptionsItemSelected(MenuItem opcionMenu){
        //Obtenemos el numero identificativo del item en el menu.
        int id = opcionMenu.getItemId();
        //Pulso config
        if (id == R.id.config){
            return (true);
        }
        //Pulso info
        if (id == R.id.info){
            //Este metodo necesita que le pase una vista, pero de momento no tengo una vista para enviar, asi que le mando un null.
            ejecutarInformacion(null);
        return (true);
        }
        //Finalmente retornamos el item seleccionado.
        return super.onOptionsItemSelected(opcionMenu);
    }
}
