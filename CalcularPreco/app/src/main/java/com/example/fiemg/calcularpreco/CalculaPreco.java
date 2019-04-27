package com.example.fiemg.calcularpreco;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CalculaPreco extends AppCompatActivity {
    private EditText pdtUm;
    private EditText vlrUm;
    private EditText mvUm;

    private EditText pdtDois;
    private EditText vlrDois;
    private EditText mvDois;

    private TextView txtSete;

    private Button btnUm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calcula_preco);

        pdtUm = (EditText)findViewById(R.id.pdtUm);
        vlrUm = (EditText)findViewById(R.id.vlrUm);
        mvUm = (EditText)findViewById(R.id.mvUm);

        mvDois = (EditText)findViewById(R.id.mvDois);
        vlrDois = (EditText)findViewById(R.id.vlrDois);
        pdtDois = (EditText)findViewById(R.id.pdtDois);

        txtSete = (TextView)findViewById(R.id.txtSete);
    }

    public void calcular(View v){
        Double vUm = Double.parseDouble(vlrUm.getText().toString());
        Double mUm = Double.parseDouble(mvUm.getText().toString());

        Double vDois = Double.parseDouble(vlrDois.getText().toString());
        Double mDois = Double.parseDouble(mvDois.getText().toString());

        Double rUm = vUm/mUm;
        Double rDois = vDois/mDois;

        if (rUm < rDois){
            txtSete.setText("O Produto 1 '"+pdtUm.getText().toString()+"' tem um melhor custo benefício!");
        }else{
            if(rUm > rDois){
                txtSete.setText("O Produto 2 '"+pdtDois.getText().toString()+"' tem um melhor custo benefício!");
            }else{
                txtSete.setText("Os dois produtos possuem o mesmo custo!");
            }

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_calcula_preco, menu);
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
