package com.example.fiemg.cinema;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    public EditText login;
    public EditText senha;
    public Button btnLogin;

    public void mensagem(String s){
        Toast msg = Toast.makeText(this, s, Toast.LENGTH_SHORT);
        msg.show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login = (EditText)findViewById(R.id.edtUser);
        senha = (EditText)findViewById(R.id.edtSenha);
    }

    public void verificaLogin(View v){
        if(login.getText().toString().equals("admin")&&senha.getText().toString().equals("admin")){
            Intent it = new Intent(Login.this, MainCinema.class);
            startActivity(it);
        }else{
            mensagem("Usuário e/ou senha inválidos!");
            senha.setText("");
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
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
