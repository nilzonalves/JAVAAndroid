package com.example.fiemg.numerocinco;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText nome;
    private EditText idade;

    private Button btnUm;

    private TextView txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nome = (EditText)findViewById(R.id.edtNome);
        idade = (EditText)findViewById(R.id.edtIdade);

        btnUm = (Button)findViewById(R.id.btnUm);

        txtResult = (TextView)findViewById(R.id.txtResult);
    }

    public void consultar(View v){
        int id = Integer.parseInt(idade.getText().toString());
        String nm = nome.getText().toString();
        verificar(id,nm);
    }
    public void verificar(int idade, String nm){
        if(idade<8){
            txtResult.setText(nm+" pertence a categoria Infantil");
        }
        if (idade>=8&&idade<=15){
            txtResult.setText(nm+" pertence a categoria Juvenil");
        }
        if (idade>=16&&idade<=50){
            txtResult.setText(nm+" pertence a categoria Adulto");
        }
        if (idade>50){
            txtResult.setText(nm+" pertence a categoria Sênior");
        }
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
