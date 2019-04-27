package com.example.fiemg.cinema;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainCinema extends AppCompatActivity {

    public Button btnA1;
    public int cA1 = 0;
    public Button btnA2;
    public int cA2 = 0;
    public Button btnA3;
    public int cA3 = 0;
    public Button btnA4;
    public int cA4 = 0;
    public Button btnA5;
    public int cA5 = 0;
    public Button btnA6;
    public int cA6 = 0;
    public Button btnA7;
    public int cA7 = 0;
    public Button btnA8;
    public int cA8 = 0;
    public Button btnA9;
    public int cA9 = 0;
    public Button btnA10;
    public int cA10 = 0;
    public Button btnA11;
    public int cA11 = 0;
    public Button btnA12;
    public int cA12 = 0;

    public Button cancelar;
    public Button relatorio;
    public EditText edtCancelar;
    public EditText texto;
    public Integer cont = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_cinema);

        btnA1 = (Button)findViewById(R.id.btnA1);
        btnA2 = (Button)findViewById(R.id.btnA2);
        btnA3 = (Button)findViewById(R.id.btnA3);
        btnA4 = (Button)findViewById(R.id.btnA4);
        btnA5 = (Button)findViewById(R.id.btnA5);
        btnA6 = (Button)findViewById(R.id.btnA6);
        btnA7 = (Button)findViewById(R.id.btnA7);
        btnA8 = (Button)findViewById(R.id.btnA8);
        btnA9 = (Button)findViewById(R.id.btnA9);
        btnA10 = (Button)findViewById(R.id.btnA10);
        btnA11 = (Button)findViewById(R.id.btnA11);
        btnA12 = (Button)findViewById(R.id.btnA12);
        relatorio = (Button)findViewById(R.id.relatorio);
    }

    public void colorirVerde(View v) {

        v.setBackgroundResource(R.drawable.livre);
    }

    public void colorirVermelho(View v){

        v.setBackgroundResource(R.drawable.ocupada);
    }

    public void relatorio(View v){
        Intent it = new Intent(MainCinema.this, relatorio.class);
        it.putExtra("cont",cont);
        startActivity(it);
    }

    public void mensagem(String s){
        Toast msg = Toast.makeText(this, s, Toast.LENGTH_SHORT);
        msg.show();
    }

    public void reservar(View v){
        if(v.getId() == R.id.btnA1){
            if(cA1==0){
                colorirVermelho(btnA1);
                cont++;
                cA1=1;
            }else{
                mensagem("Esta cadeira já está reservada!");
            }
        }

        if(v.getId() == R.id.btnA2){
            if(cA2==0){
                colorirVermelho(v);
                cont++;
                cA2=1;
            }else{
                mensagem("Esta cadeira já está reservada!");
            }
        }
        if(v.getId() == R.id.btnA3){
            if(cA3==0){
                colorirVermelho(v);
                cont++;
                cA3=1;
            }else{
                mensagem("Esta cadeira já está reservada!");
            }
        }
        if(v.getId() == R.id.btnA4){
            if(cA4==0){
                colorirVermelho(v);
                cont++;
                cA4=1;
            }else{
                mensagem("Esta cadeira já está reservada!");
            }
        }
        if(v.getId() == R.id.btnA5){
            if(cA5==0){
                colorirVermelho(v);
                cont++;
                cA5=1;
            }else{
                mensagem("Esta cadeira já está reservada!");
            }
        }
        if(v.getId() == R.id.btnA6){
            if(cA6==0){
                colorirVermelho(v);
                cont++;
                cA6=1;
            }else{
                mensagem("Esta cadeira já está reservada!");
            }
        }
        if(v.getId() == R.id.btnA7){
            if(cA7==0){
                colorirVermelho(v);
                cont++;
                cA7=1;
            }else{
                mensagem("Esta cadeira já está reservada!");
            }
        }
        if(v.getId() == R.id.btnA8){
            if(cA8==0){
                colorirVermelho(v);
                cont++;
                cA8=1;
            }else{
                mensagem("Esta cadeira já está reservada!");
            }
        }
        if(v.getId() == R.id.btnA9){
            if(cA9==0){
                colorirVermelho(v);
                cont++;
                cA9=1;
            }else{
                mensagem("Esta cadeira já está reservada!");
            }
        }
        if(v.getId() == R.id.btnA10){
            if(cA10==0){
                colorirVermelho(v);
                cont++;
                cA10=1;
            }else{
                mensagem("Esta cadeira já está reservada!");
            }
        }
        if(v.getId() == R.id.btnA11){
            if(cA11==0){
                colorirVermelho(v);
                cont++;
                cA11=1;
            }else{
                mensagem("Esta cadeira já está reservada!");
            }
        }
        if(v.getId() == R.id.btnA12){
            if(cA12==0){
                colorirVermelho(v);
                cont++;
                cA12=1;
            }else{
                mensagem("Esta cadeira já está reservada!");
            }
        }

    }

    public void cancelar(View v){
        texto = (EditText)findViewById(R.id.edtCancelar);
        switch (texto.getText().toString()){
            case "A1":
                if(cA1==1){
                    colorirVerde(btnA1);
                    cont--;
                    cA1=0;
                }else{
                    mensagem("Esta cadeira já está livre!");
                }
                    break;

            case "A2":
                if(cA2==1){
                    colorirVerde(btnA2);
                    cont--;
                    cA2=0;
                }else{
                    mensagem("Esta cadeira já está livre!");
                }
                break;
            case "A3":
                if(cA3==1){
                    colorirVerde(btnA3);
                    cont--;
                    cA3=0;
                }else{
                    mensagem("Esta cadeira já está livre!");
                }
                break;
            case "A4":
                if(cA4==1){
                    colorirVerde(btnA4);
                    cont--;
                    cA4=0;
                }else{
                    mensagem("Esta cadeira já está livre!");
                }
                break;
            case "A5":
                if(cA5==1){
                    colorirVerde(btnA5);
                    cont--;
                    cA5=0;
                }else{
                    mensagem("Esta cadeira já está livre!");
                }
                break;
            case "A6":
                if(cA6==1){
                    colorirVerde(btnA6);
                    cont--;
                    cA6=0;
                }else{
                    mensagem("Esta cadeira já está livre!");
                }
                break;
            case "A7":
                if(cA7==1){
                    colorirVerde(btnA7);
                    cont--;
                    cA7=0;
                }else{
                    mensagem("Esta cadeira já está livre!");
                }
                break;
            case "A8":
                if(cA8==1){
                    colorirVerde(btnA8);
                    cont--;
                    cA8=0;
                }else{
                    mensagem("Esta cadeira já está livre!");
                }
                break;
            case "A9":
                if(cA9==1){
                    colorirVerde(btnA9);
                    cont--;
                    cA9=0;
                }else{
                    mensagem("Esta cadeira já está livre!");
                }
                break;
            case "A10":
                 if(cA10==1){
                    colorirVerde(btnA10);
                    cont--;
                    cA10=0;
                 }else{
                     mensagem("Esta cadeira já está livre!");
                 }
                break;
            case "A11":
                if(cA11==1){
                    colorirVerde(btnA11);
                    cont--;
                    cA11=0;
                }else{
                    mensagem("Esta cadeira já está livre!");
                }
                break;
            case "A12":
                if(cA12==1){
                    colorirVerde(btnA12);
                    cont--;
                    cA12=0;
                }else{
                    mensagem("Esta cadeira já está livre!");
                }
                break;
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_cinema, menu);
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
