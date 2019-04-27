package com.example.fiemg.subtrair;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Subtrair extends AppCompatActivity {
    private EditText cpUm;
    private EditText cpDois;
    private TextView txtQuatro;
    private Button btnUm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subtrair);
        cpUm = (EditText)findViewById(R.id.cpUm);
        cpDois = (EditText)findViewById(R.id.cpDois);
        btnUm = (Button)findViewById(R.id.btnUm);
        txtQuatro = (TextView)findViewById(R.id.txtQuatro);
    }

    public void subtrair(View v){
        Double numUm = Double.parseDouble(cpUm.getText().toString());
        Double numDois = Double.parseDouble(cpDois.getText().toString());
        Double resultado = numUm - numDois;

        txtQuatro.setText(String.valueOf(resultado));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_subtrair, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
