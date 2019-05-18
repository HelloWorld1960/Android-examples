package panzer01.a28usorecursos;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

/*
* Esta aplicacion contiene dos activity_main, uno se ejecuta cuando el idioma esta en Ingles y el otro cuando esta en español.
*
* */
/*Activity es la clase padre de y para generalizar ponemos esta.*/
public class MainActivity extends Activity {

    /*
     * Metodo que se llama al iniciarse la aplicacion.*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        /*Acceder a recursos del sistema por medio de codigo Java.
        * */
        //Almacenamos dentro de la variable img la vista img_edicion
        ImageView img1 = (ImageView) findViewById(R.id.img_edicion);
        //Decirle a la variable donde buscar la imagen para mostrar.
        img1.setImageResource(android.R.drawable.ic_menu_edit);

        //Almacenamos dentro de la variable text1 la vista txtCancelar
        TextView text1 = (TextView)findViewById(R.id.txtCancelar);
        //Decirle a la variable donde buscar el texto para mostrar
        text1.setText(android.R.string.cancel);

    }
}
