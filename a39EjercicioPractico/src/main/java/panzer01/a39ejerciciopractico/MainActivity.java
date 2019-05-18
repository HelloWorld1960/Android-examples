package panzer01.a39ejerciciopractico;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**
         * Iniciamos el array casillas que identifica a cada casilla almacenada en el array*/
        CASILLAS = new int[9];
        CASILLAS[0]=R.id.a1;
        CASILLAS[1]=R.id.a2;
        CASILLAS[2]=R.id.a3;
        CASILLAS[3]=R.id.b1;
        CASILLAS[4]=R.id.b2;
        CASILLAS[5]=R.id.b3;
        CASILLAS[6]=R.id.c1;
        CASILLAS[7]=R.id.c2;
        CASILLAS[8]=R.id.c3;
    }

    /**
     * */
    private int jugadores;
    private int CASILLAS[];
    private Partida partida;

    /**
     * */
    public void aJugar(View v){
        ImageView imagen;
        //Reset del tablero.
        for (int cadaCasilla:CASILLAS){
            imagen = (ImageView) findViewById(cadaCasilla);
            imagen.setImageResource(R.drawable.casilla);
        }

        //Establecer numero de jugadores
        jugadores = 1;
        if (v.getId()==R.id.dosJugadores){
            jugadores = 2;
        }

        //Establecer dificultad
        RadioGroup configDificultad = (RadioGroup) findViewById(R.id.configD);
        //Detectar nivel de dificultad
        int id = configDificultad.getCheckedRadioButtonId();
        int dificultad=0;
        if(id == R.id.normal){
            dificultad=1;
        }else if(id == R.id.imposible){
            dificultad=2;
        }

        //
        partida = new Partida(dificultad);

        //Inhabilitar botones
        ((Button)findViewById(R.id.unJugador)).setEnabled(false);
        ((RadioGroup)findViewById(R.id.configD)).setAlpha(0);
        ((Button)findViewById(R.id.dosJugadores)).setEnabled(false);


        //Mensaje
        Toast.makeText(MainActivity.this,"Versión 1.0." + "\nJugadores: " + jugadores + "\nDificultad: " + dificultad, Toast.LENGTH_SHORT).show();

    }


    /**Identificar que casilla se presiono*/
    public void toque(View miVista){
        if(partida == null){
            /**Si NO se ha seleccionado un jugador y una dificultad, entonces no identifiques la casilla.*/
            return;
        } else {
            int casilla=0;
            for(int i = 0; i < 9; i++){
                if (CASILLAS[i] == miVista.getId()){
                    casilla = i;
                    break;
                }
            }

            if (partida.compruebaCasilla(casilla) == false){
                return;
            }

            marca(casilla);

            int resultado = partida.turno();

            if (resultado > 0){

                termina(resultado);
            }

            casilla = partida.ia();

            while(partida.compruebaCasilla(casilla) != true){
                casilla = partida.ia(); 
            }

            marca(casilla);

            resultado = partida.turno();

            if (resultado > 0){

                termina(resultado);
            }

            /**Mensaje*/
            /*Toast toast = Toast.makeText(this,"Pulsaste: " + casilla, Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER,0,0);
            toast.show();*/
        }
    }

    /**
     * */
    private void termina(int resultado){
        String mensaje;

        if (resultado == 1){

        }
    }

    /**Metodo encargado de asignar una cruz o circulo a la casilla dependiendo del jugador.*/
    private void marca(int casilla){
        ImageView imagen;
        imagen = (ImageView)findViewById(CASILLAS[casilla]);

        if(partida.jugador == 1){
            imagen.setImageResource(R.drawable.circulo);
        } else{
            imagen.setImageResource(R.drawable.aspa);
        }
    }

}
