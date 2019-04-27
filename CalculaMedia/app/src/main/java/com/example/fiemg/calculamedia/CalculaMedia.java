package com.example.fiemg.calculamedia;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class CalculaMedia extends AppCompatActivity {

    private EditText vlrUm;
    private EditText vlrDois;
    private EditText vlrTres;

    private RadioGroup rGroup;

    private Button calcular;

    double z;
    int x;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calcula_media);

        vlrUm = (EditText) findViewById(R.id.vlrUm);
        vlrDois = (EditText) findViewById(R.id.vlrDois);
        vlrTres = (EditText) findViewById(R.id.vlrTres);

        rGroup = (RadioGroup)findViewById(R.id.rGroup);
        calcular = (Button)findViewById(R.id.btnUm);
    }

    public void calcula(View v){
        x = rGroup.getCheckedRadioButtonId();
        z = media(Double.parseDouble(vlrUm.getText().toString()),Double.parseDouble(vlrDois.getText().toString()),Double.parseDouble(vlrTres.getText().toString()),x);
        mensagem(String.valueOf(z));
    }
    public double media(double v1,double v2,double v3, int tipo) {
        double res = 0;
        if(tipo == R.id.pon){
            res = (v1*1+v2*2+v3*3)/6;
        }else if(tipo == R.id.ari){
            res = (v1+v2+v3)/3;
        }
        return res;
    }

    public void mensagem(String s){
        Toast t = Toast.makeText(this,s,Toast.LENGTH_SHORT);
        t.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_calcula_media, menu);
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
