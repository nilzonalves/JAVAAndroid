package com.example.fiemg.numeroseis;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    public double resul = 0;
    public double sAnt;
    public double perc;

    public EditText salarioA;
    public RadioGroup rGr;
    public Button btnMostrar;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnMostrar = (Button)findViewById(R.id.btnMostrar);
        rGr = (RadioGroup)findViewById(R.id.rGr);
        salarioA = (EditText)findViewById(R.id.edtSal);
    }

    public void calcula(View v){
        sAnt = Double.parseDouble(salarioA.getText().toString());
        if(rGr.getCheckedRadioButtonId()==R.id.rbQuarenta){
            perc = 40;
        }
        if(rGr.getCheckedRadioButtonId()==R.id.rbQuaretaCinco){
            perc = 45;
        }
        if(rGr.getCheckedRadioButtonId()==R.id.rbCinquenta){
            perc = 50;
        }
        Intent it = new Intent(MainActivity.this, resultado.class);
        resul = sAnt + (sAnt*(perc/100));
        it.putExtra("resul",resul);
        it.putExtra("sAnti",sAnt);
        it.putExtra("perc", perc);
        startActivity(it);

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
