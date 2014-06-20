package com.fjrodriguez.mastermind1;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.Arrays;
import java.util.Random;


public class MyActivity extends Activity {

    static Mastermind mastermind = new Mastermind();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        return id == R.id.action_settings || super.onOptionsItemSelected(item);
    }

    public void partidaNueva(View v) {
        mastermind.generarSolucion();
        Log.v("paco", mastermind.toString());
    }

    public void jugar (View v) {

    }
}

class Mastermind {

    private String[] solucion = new String[4];
    private String[] jugada = new String[4];
    private String[] colores = {"#0000FF", "#008000", "#FF0000", "#FFA500", "#FF00FF",
            "#000000", "#FFFF00", "#C0C0C0"};
    private Random r = new Random();

    public Mastermind () {

    }

    private String extraerColor (int i) {
        String tmpString;

        tmpString = colores[i];
        colores[i] = colores[colores.length-1];
        colores[colores.length-1] = tmpString;

        return tmpString;
    }

    public void generarSolucion () {

        for (int i = 0, j= 8; i < 4 ; i++, j--)
            // Selecciona aleatoriamente una posicion del array colores.
            // Guardo el color seleccionado en el array solución.
            solucion[i] = extraerColor(r.nextInt(j));
    }


    @Override
    public String toString() {
        return "Mastermind{" +
                "solucion=" + Arrays.toString(solucion) +
                '}';
    }
}
