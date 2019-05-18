package panzer01.a03primeraapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
/* MainActivity:
 * Este archivo contiene la logica de programacion(clases).
 *
 * content_main.xml:
 * Hace referencia a el aspecto visual de la aplicacion(imágenes, layouts, cadenas de texto, etc).
 *
 * drawable:
 * Contiene todas las imagenes del proyecto.
 *
 * menu:
 * Contiene todos los menu que pueda tener nuestra aplicacion.
 *
 * mimap:
 * Esta carpeta contiene los iconos de lanzamiento de la aplicacion.
 *
 * manifest:
 * Contiene informacion sobre la aplicacion(id, pantallas, servicios).
 *
 * Gradle Scrips:
 * Contiene informacion sobre como se debe compilar la aplicacion.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
