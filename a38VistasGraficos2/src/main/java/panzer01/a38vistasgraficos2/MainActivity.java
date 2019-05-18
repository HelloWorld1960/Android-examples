package panzer01.a38vistasgraficos2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Establecer que comience por vista propia.
        setContentView(new MiPropiaVista(this));

    }

    /**
     * Creando vista propia.
     */
    public class MiPropiaVista extends View {
        //Constructor
        public MiPropiaVista(Context context) {
            super(context);
        }

        @Override
        protected void onDraw(Canvas canvas){
            //Crear un trazo
            Path miTrazo = new Path();
            miTrazo.addCircle(150, 200, 100, Path.Direction.CCW);
            //Creamos pincel
            Paint miPincel = new Paint();
            miPincel.setColor(Color.RED);
            miPincel.setStrokeWidth(8);
            miPincel.setStyle(Paint.Style.STROKE);
            //
            canvas.drawPath(miTrazo, miPincel);

            //Grosor de pincel
            miPincel.setStrokeWidth(1);
            //otro pincel
            miPincel.setStyle(Paint.Style.FILL);

            miPincel.setTextSize(40);

            miPincel.setTypeface(Typeface.SANS_SERIF);

            canvas.drawTextOnPath("Hola", miTrazo, 40, 60, miPincel);
        }
    }

}
