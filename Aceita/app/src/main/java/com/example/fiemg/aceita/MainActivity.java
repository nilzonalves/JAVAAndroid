package com.example.fiemg.aceita;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText nome;
    private EditText idade;

    private RadioGroup rGr;

    private Button btnUm;

    private TextView resul;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nome= (EditText)findViewById(R.id.edtNome);
        idade= (EditText)findViewById(R.id.edtIdade);

        rGr = (RadioGroup)findViewById(R.id.rGr);

        btnUm = (Button)findViewById(R.id.btnUm);

        resul = (TextView)findViewById(R.id.resul);
    }

    public void calcula(View v){
        String nm;
        nm = nome.getText().toString();
        String  ida = "0";
        int  id = 0;
        id = Integer.parseInt(idade.getText().toString());
        ida = idade.getText().toString();
        int sx = rGr.getCheckedRadioButtonId();
        int sex = 3;
        if(sx==R.id.rbFemi){
            sex=1;
        }else{
            sex=0;
        }
        if(nm.isEmpty()||rGr.getCheckedRadioButtonId()==-1||ida.equals("0")){
            resul.setText("Informe valores!");
        }/*else if(sex == 3){
            resul.setText("Informe um Sexo!");
        }else if(id==999){
            resul.setText("Informe uma Idade válida!");
        } */else{
        verifica(nm,sex,id);
        }
    }

    private void verifica(String n, int sex, int idade){

        String cx = String.valueOf(idade);
        if(sex == 1&&idade<25){
            resul.setText(" "+n+" está Aprovada!");
        }else{
            resul.setText(" "+n+" está Reprovado(a)!");
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
