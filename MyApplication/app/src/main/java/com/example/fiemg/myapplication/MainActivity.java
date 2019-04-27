package com.example.fiemg.myapplication;

import android.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText edtNome;
    private TextView txtNome;
    private Button btnTres;

    public void onClick(View v){
        txtNome.setText(edtNome.getText().toString());
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
            edtNome = (EditText)findViewById(R.id.edtNome);
            txtNome = (TextView)findViewById(R.id.txtNome);
            btnTres = (Button)findViewById(R.id.btnTres);
            btnTres.setOnClickListener(this);
        // Exemplo Dois
            //btnDois = (Button)findViewById(R.id.btnDois);
            //btnDois.setOnClickListener(new View.OnClickListener() {
            //    @Override
            //    public void onClick(View v) {
            //        txtNome.setText(edtNome.getText().toString());
            //    }
            //});
    }


    public void botaoOk(View V) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        alertDialog.setTitle("Nome Digitado");
        alertDialog.setMessage(edtNome.getText().toString());
        alertDialog.setNeutralButton("OK", null);
        alertDialog.show();
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
