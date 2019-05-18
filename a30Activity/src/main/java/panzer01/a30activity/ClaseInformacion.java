package panzer01.a30activity;

import android.app.Activity;
import android.os.Bundle;

/**
* Esta clase pertenece al layout informacion.*/

/*Activity es la clase padre de y para generalizar ponemos esta.*/
public class ClaseInformacion extends Activity {

    /*
     * Metodo que se llama al iniciarse la aplicacion.*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.informacion);
    }
}
