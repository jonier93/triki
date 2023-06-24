package com.example.triki;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button casilla1;
    private Button casilla2;
    private Button casilla3;
    private Button casilla4;
    private Button casilla5;
    private Button casilla6;
    private Button casilla7;
    private Button casilla8;
    private Button casilla9;

    private TextView txtJugador;
    private int jugador;
    private String [] [] array;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inicializar();
        inicializar_array();

        casilla1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String imprimir = validar_casilla(array[0][0]);
                array[0][0] = imprimir;
                casilla1.setText(imprimir);
                revisarGanador(imprimir);
            }
        });

        casilla2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String imprimir = validar_casilla(array[0][1]);
                array[0][1] = imprimir;
                casilla2.setText(imprimir);
                revisarGanador(imprimir);
            }
        });

        casilla3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String imprimir = validar_casilla(array[0][2]);
                array[0][2] = imprimir;
                casilla3.setText(imprimir);
                revisarGanador(imprimir);
            }
        });

        casilla4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String imprimir = validar_casilla(array[1][0]);
                array[1][0] = imprimir;
                casilla4.setText(imprimir);
                revisarGanador(imprimir);
            }
        });

        casilla5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String imprimir = validar_casilla(array[1][1]);
                array[1][1] = imprimir;
                casilla5.setText(imprimir);
                revisarGanador(imprimir);
            }
        });

        casilla6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String imprimir = validar_casilla(array[1][2]);
                array[1][2] = imprimir;
                casilla6.setText(imprimir);
                revisarGanador(imprimir);
            }
        });

        casilla7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String imprimir = validar_casilla(array[2][0]);
                array[2][0] = imprimir;
                casilla7.setText(imprimir);
                revisarGanador(imprimir);
            }
        });

        casilla8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String imprimir = validar_casilla(array[2][1]);
                array[2][1] = imprimir;
                casilla8.setText(imprimir);
                revisarGanador(imprimir);
            }
        });

        casilla9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String imprimir = validar_casilla(array[2][2]);
                array[2][2] = imprimir;
                casilla9.setText(imprimir);
                revisarGanador(imprimir);
            }
        });
    }

    private void inicializar(){
        casilla1 = (Button) findViewById(R.id.btn1);
        casilla2 = (Button) findViewById(R.id.btn2);
        casilla3 = (Button) findViewById(R.id.btn3);
        casilla4 = (Button) findViewById(R.id.btn4);
        casilla5 = (Button) findViewById(R.id.btn5);
        casilla6 = (Button) findViewById(R.id.btn6);
        casilla7 = (Button) findViewById(R.id.btn7);
        casilla8 = (Button) findViewById(R.id.btn8);
        casilla9 = (Button) findViewById(R.id.btn9);
        txtJugador = (TextView) findViewById(R.id.txtJugador);
        array = new String[3][3];
        jugador = 1;
    }

    private void inicializar_array (){
        for (int i=0; i<array.length; i++){
            for(int j=0; j<array[0].length; j++){
                array[i][j] = "";
            }
        }
    }

    private String turnoJugador(){
        if (jugador == 1) {
            txtJugador.setText("Turno jugador " + jugador);
            jugador = 2;
            return "X";
        }
        else {
            txtJugador.setText("Turno jugador " + jugador);
            jugador = 1;
            return "O";
        }
    }

    private String validar_casilla(String celda){
        if(celda.equals("")){
            return turnoJugador();
        }
        else {
            Toast.makeText(MainActivity.this, "No es posible realizar esta jugada intente de nuevo", Toast.LENGTH_SHORT).show();
            return celda;
        }
    }

    private void revisarGanador(String simbolo){
        if(revisarCuadrado(simbolo)){
           txtJugador.setText("El ganador es el jugador" + jugador);
           inicializar_array();
           inicializar_botones();
           jugador=1;
        }
    }

    private void inicializar_botones() {
        casilla1.setText("");
        casilla2.setText("");
        casilla3.setText("");
        casilla4.setText("");
        casilla5.setText("");
        casilla6.setText("");
        casilla7.setText("");
        casilla8.setText("");
        casilla9.setText("");
    }


    private Boolean revisarCuadrado(String simbolo){
        if(revisarFilas(simbolo)) return true;
        if(revisarColumnas(simbolo)) return true;
        return revisarDiagonales(simbolo);
    }

    private boolean revisarFilas(String simbolo) {
        for(int i=0; i< array[0].length;i++){
            if(revisarFila(i,simbolo))return true;
        }
        return false;
    }

    private boolean revisarFila(int fila, String simbolo) {
        for(int i=0;i< array.length;i++){
            if (!array[i][fila].equals(simbolo)) {
                return false;
            }
        }
        return true;
    }

    private Boolean revisarColumnas(String simbolo){
        for(int i=0; i< array.length;i++){
            if(revisarColumna(i,simbolo))return true;
        }
        return false;
    }

    private Boolean revisarDiagonales(String simbolo){
        if(revisarDiagonalPrincipal(simbolo)) return true;
        return revisarDiagonalSecundaria(simbolo);
    }

    private Boolean revisarDiagonalSecundaria(String simbolo) {
        for(int i=0;i< array.length;i++){
            if (!array[i][array.length-i-1].equals(simbolo)) {
                return false;
            }
        }
        return true;
    }

    private Boolean revisarDiagonalPrincipal(String simbolo){
        for(int i=0;i< array.length;i++){
            if (!array[i][i].equals(simbolo)) {
                return false;
            }
        }
        return true;
    }

    private Boolean revisarColumna(Integer fila, String simbolo){
        for(int i=0;i< array[fila].length;i++){
            if (!array[fila][i].equals(simbolo)) {
               return false; 
            }
        }
        return true;
    }
}