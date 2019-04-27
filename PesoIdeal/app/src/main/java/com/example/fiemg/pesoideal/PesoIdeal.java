package com.example.fiemg.pesoideal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class PesoIdeal extends AppCompatActivity {

    public RadioGroup rGr;
    public EditText altura;
    public TextView txtResultado;
    private double altu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_peso_ideal);

        rGr = (RadioGroup)findViewById(R.id.rGr);
        altura = (EditText)findViewById(R.id.altura);


    }



    public void calcula(View v){
        altu = Double.parseDouble(altura.getText().toString());
        double resulta = calculaPeso(altu ,rGr.getCheckedRadioButtonId());
        String x = String.valueOf(resulta);
        mensagem(x);
    }
    public double calculaPeso(double altura, int sexo){
        //int escolhido = rGr.getCheckedRadioButto1nId();
        double resultado = 1;
        if(sexo == R.id.rbFem){
            resultado = altura-100-((altura-150)/2);
        }else
            if(sexo == R.id.rbMas){
                resultado = altura-100-((altura-150)/4);
            }
        return resultado;
    }

    public void mensagem(String s){
        Toast msg = Toast.makeText(this, s, Toast.LENGTH_SHORT);
        msg.show();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_peso_ideal, menu);
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
