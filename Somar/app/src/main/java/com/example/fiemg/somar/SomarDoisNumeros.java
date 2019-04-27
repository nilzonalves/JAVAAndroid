package com.example.fiemg.somar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SomarDoisNumeros extends AppCompatActivity {
    private EditText cpUm;
    private EditText cpDois;
    private TextView txtQuatro;
    private Button btnUm;
    private Double numUm;
    private Double numDois;
    private Double resultado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_somar_dois_numeros);
        cpUm = (EditText)findViewById(R.id.cpUm);
        cpDois = (EditText)findViewById(R.id.cpDois);
        txtQuatro = (TextView)findViewById(R.id.txtQuatro);

    }

    public void Somar(View v){
        numUm = Double.parseDouble(cpUm.getText().toString());
        numDois = Double.parseDouble(cpDois.getText().toString());
        resultado = numUm + numDois;
        txtQuatro.setText(String.valueOf(resultado));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_somar_dois_numeros, menu);
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
