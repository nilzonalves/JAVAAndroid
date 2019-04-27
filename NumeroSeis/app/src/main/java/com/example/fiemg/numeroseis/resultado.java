package com.example.fiemg.numeroseis;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class resultado extends AppCompatActivity {

    private TextView salA;
    private TextView salN;
    private TextView percet;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);
        salA = (TextView)findViewById(R.id.salA);
        salN = (TextView)findViewById(R.id.salN);
        percet = (TextView)findViewById(R.id.txtPerce);

        Intent it = getIntent();
        double sAnt = it.getDoubleExtra("sAnti", 0);
        salA.setText(String.valueOf(sAnt));

        double perce = it.getDoubleExtra("perc", 0);
        percet.setText(String.valueOf(perce));

        double resulta = it.getDoubleExtra("resul", 0);
        salN.setText(String.valueOf(resulta));



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_resultado, menu);
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
