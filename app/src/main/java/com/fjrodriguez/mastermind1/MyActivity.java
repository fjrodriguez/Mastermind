package com.fjrodriguez.mastermind1;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

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

    public void partidaNueva(View view) {
        mastermind.generarSolucion();
        Log.v("paco", mastermind.toString());
    }

    public void jugar (View view) {
        Intent i = new Intent(this, Acercade.class);
        startActivity(i);
    }

    public void pulsado_boton_colores (View view) {

        // Buscar el boton que ha generado el evento.
        Button boton = (Button) findViewById(view.getId());
        // Recuperar el color background de dicho objeto.
        ColorDrawable buttonColor = (ColorDrawable) boton.getBackground();
        int colorId = buttonColor.getColor();
        // TODO: Poner colores al resto de botones de jugada.
        Button boton_jugada = (Button) findViewById(R.id.boton_jugar_1);
        boton_jugada.setBackgroundColor(colorId);
    }

    public void pulsado_boton_jugada (View view) {

        Button boton = (Button) findViewById(view.getId());
        boton.setBackgroundColor(Color.BLACK);
    }
}

class Mastermind {

    private String[] solucion = new String[4];
    private int indiceJugada = 0;
    private String[] jugada = new String[4];
    private String[] colores = {"#0000FF", "#008000", "#FF0000", "#FFA500", "#FF00FF",
            "#000000", "#FFFF00", "#C0C0C0"};
    private static Random r = new Random();

    public Mastermind () {

    }

    private void cambiarPosicion(String[] array, int i, int j) {
        String tmpString;

        tmpString = array[i];
        array[i] = array[j];
        array[j] = tmpString;
    }

    public void generarSolucion () {
        int indiceColores;

        for (int i = 0, j = 8; i < 4; i++, j--) {
            // Selecciona aleatoriamente una posicion del array colores.
            // Guardo el color seleccionado en el array solución.
            indiceColores = r.nextInt(j);
            solucion[i] = colores[indiceColores];
            cambiarPosicion(colores, indiceColores, j - 1);
        }
    }

    public void addColorJugada (String color) {
        jugada[indiceJugada++] = color;
    }

    @Override
    public String toString() {
        return "Mastermind{" +
                "colores=" + Arrays.toString(colores) +
                '}';
    }
}
