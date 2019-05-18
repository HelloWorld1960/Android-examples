package Panzer01.a11primeraappinterfaz;

import android.app.Activity;
import android.os.Bundle;


/*Activity es la clase padre de y para generalizar ponemos esta.*/
public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

}
