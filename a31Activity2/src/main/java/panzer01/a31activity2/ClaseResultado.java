package panzer01.a31activity2;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/*Activity es la clase padre de y para generalizar ponemos esta.*/
public class ClaseResultado extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resultado);

        //Creamos una actividad de tipo Bundl.
        //Rescatando los datos utilizando getIntent().getExtras()
        Bundle datos = this.getIntent().getExtras();
        //Almacenamos el numero entero que viaja en el Bundl, de acuerdo a su clave.
        int num1 = datos.getInt("numero1");
        int num2 = datos.getInt("numero2");
        //Realizar operacion
        int resultado = num1 + num2;

        //Mostrar el resultado en la activity.
        TextView valorResultado = (TextView) findViewById(R.id.txtResultado); //Identifico la vista del texto en el layout resultado.xml

        valorResultado.setText("El resultado es: "+resultado); //Establecemos el resultado como el valor del texto.
    }


}
