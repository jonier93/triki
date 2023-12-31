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
    private int cont;


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
                validar_filas_columnas();
            }
        });

        casilla2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String imprimir = validar_casilla(array[0][1]);
                array[0][1] = imprimir;
                casilla2.setText(imprimir);
                validar_filas_columnas();
            }
        });

        casilla3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String imprimir = validar_casilla(array[0][2]);
                array[0][2] = imprimir;
                casilla3.setText(imprimir);
                validar_filas_columnas();
            }
        });

        casilla4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String imprimir = validar_casilla(array[1][0]);
                array[1][0] = imprimir;
                casilla4.setText(imprimir);
                validar_filas_columnas();
            }
        });

        casilla5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String imprimir = validar_casilla(array[1][1]);
                array[1][1] = imprimir;
                casilla5.setText(imprimir);
                validar_filas_columnas();
            }
        });

        casilla6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String imprimir = validar_casilla(array[1][2]);
                array[1][2] = imprimir;
                casilla6.setText(imprimir);
                validar_filas_columnas();
            }
        });

        casilla7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String imprimir = validar_casilla(array[2][0]);
                array[2][0] = imprimir;
                casilla7.setText(imprimir);
                validar_filas_columnas();
            }
        });

        casilla8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String imprimir = validar_casilla(array[2][1]);
                array[2][1] = imprimir;
                casilla8.setText(imprimir);
                validar_filas_columnas();
            }
        });

        casilla9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String imprimir = validar_casilla(array[2][2]);
                array[2][2] = imprimir;
                casilla9.setText(imprimir);
                validar_filas_columnas();
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
        cont = 0;
        txtJugador.setText("Turno jugador 1");
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
            String imprimir = turnoJugador();
            cont += 1;
            if(cont == 9) {
                limpiar_botones();
                inicializar_array();
                Toast.makeText(MainActivity.this, String.valueOf(cont), Toast.LENGTH_LONG).show();
                imprimir="";
            }
            return imprimir;
        }
        else {
            Toast.makeText(MainActivity.this, "No es posible realizar esta jugada intente de nuevo", Toast.LENGTH_SHORT).show();
            return celda;
        }
    }

    private void validar_filas_columnas() {
        boolean validation = true;
        for (int n=0; n<2; n++) {
            if (validation) {
                for (int i = 0; i < array.length; i++) {
                    int suma = 0;
                    for (int j = 0; j < array[0].length; j++) {
                        int fila;
                        int colum;
                        if (n == 0) {
                            fila = i;
                            colum = j;
                        } else {
                            fila = j;
                            colum = i;
                        }
                        if (array[fila][colum] == "X") {
                            suma = suma + 1;
                        } else if (array[fila][colum] == "O") {
                            suma = suma - 1;
                        }
                    }
                    if (suma == 3) {
                        ganador("Ganó el jugador 1");
                        limpiar_botones();
                        validation = false;
                        break;
                    } else if (suma == -3) {
                        ganador("Ganó el jugador 2");
                        limpiar_botones();
                        validation = false;
                        break;
                    }
                }
            }
        }
    }

    private void limpiar_botones() {
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

    private void ganador(String ganador) {
        Toast.makeText(MainActivity.this, ganador, Toast.LENGTH_LONG).show();
        inicializar();
        inicializar_array();
    }
}