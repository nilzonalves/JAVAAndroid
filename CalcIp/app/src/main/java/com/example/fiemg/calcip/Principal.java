package com.example.fiemg.calcip;

import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.app.AlertDialog;

public class Principal extends AppCompatActivity {

    private EditText edtQtd;
    private Button btnUm;
    public String masc;
    public int max;
    public int host;
    public int oct;
    private EditText edtIpUm;
    private EditText edtIpDois;
    private EditText edtIpTres;
    private EditText edtIpQuatro;
    private int octUmInt;
    private int octDoisInt;
    private int octTresInt;
    private int octQuatroInt;
    private int pre;
    private String octUmStr;
    private String octDoisStr;
    private String octTresStr;
    private String octQuatroStr;
    private String octResul;
    private String ipDeciRede = "";
    private String ipDeciBroa = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        edtQtd = (EditText)findViewById(R.id.edtQtd);
        btnUm = (Button)findViewById(R.id.btnUm);
        edtIpUm = (EditText)findViewById(R.id.edtIpUm);
        edtIpDois = (EditText)findViewById(R.id.edtIpDois);
        edtIpTres = (EditText)findViewById(R.id.edtIpTres);
        edtIpQuatro = (EditText)findViewById(R.id.edtIpQuatro);

        if (savedInstanceState != null) {
            // Restore value of members from saved state
                ipDeciBroa = savedInstanceState.getString("ipDeciBroa");
                ipDeciRede = savedInstanceState.getString("ipDeciRede");
                masc = savedInstanceState.getString("masc");
                max = savedInstanceState.getInt("max");
                pre = savedInstanceState.getInt("pre");
                /*edtQtd.setText(savedInstanceState.getString("edtQtd"));
                edtIpUm.setText(savedInstanceState.getString("edtIpUm"));
                edtIpDois.setText(savedInstanceState.getString("edtIpDois"));
                edtIpTres.setText(savedInstanceState.getString("edtIpTres"));
                edtIpQuatro.setText(savedInstanceState.getString("edtIpQuatro"));*/
                AlertDialog alertDialog = new AlertDialog.Builder(this).create();
                alertDialog.setTitle("Resultado");
                alertDialog.setMessage("Endereço de Rede: " + ipDeciRede + "\n" + "Broadcast: " + ipDeciBroa + "\n" + "Mascara: " + masc + "\n" + "Prefixo: " + pre + "\n" + "Endereços válidos: " + max);
                alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {}});
                alertDialog.show();
            }
        }





    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        /*savedInstanceState.putString("edtQtd",edtQtd.getText().toString());
        savedInstanceState.putString("edtIpUm",edtIpUm.getText().toString());
        savedInstanceState.putString("edtIpDois",edtIpDois.getText().toString());
        savedInstanceState.putString("edtIpTres",edtIpTres.getText().toString());
        savedInstanceState.putString("edtIpQuatro",edtIpQuatro.getText().toString());*/
        savedInstanceState.putString("ipDeciRede", ipDeciRede);
        savedInstanceState.putString("ipDeciBroa", ipDeciBroa);
        savedInstanceState.putString("masc", masc);
        savedInstanceState.putInt("pre", pre);
        savedInstanceState.putInt("max", max);
        // etc.// etc.
    }

    public void click(View v){
        octUmStr = edtIpUm.getText().toString();
        octDoisStr = edtIpDois.getText().toString();
        octTresStr = edtIpTres.getText().toString();
        octQuatroStr = edtIpQuatro.getText().toString();
        if(Integer.parseInt(octUmStr)> 255 ||Integer.parseInt(octDoisStr)> 255||Integer.parseInt(octTresStr)> 255||Integer.parseInt(octQuatroStr)> 254||Integer.parseInt(edtQtd.getText().toString())> 16777216||Integer.parseInt(edtQtd.getText().toString())==0){
            mensagem("Valores Inválidos!");
        }else{
            verificaMasc(edtQtd);
            if (oct == 4) {
                ipDeciBroa = "";
                ipDeciRede = "";
                octResul = zeraHost(octQuatroStr);
                String rede = zera(octResul);
                String broadcast = broa(octResul);
                int octRede = Integer.parseInt(rede, 2);
                int octBroa = Integer.parseInt(broadcast, 2);
                ipDeciRede += octUmStr + "." + octDoisStr + "." + octTresStr + "." + octRede;
                ipDeciBroa += octUmStr + "." + octDoisStr + "." + octTresStr + "." + octBroa;
            } else if (oct == 3) {
                ipDeciBroa = "";
                ipDeciRede = "";
                octResul = zeraHost(octTresStr);
                String rede = zera(octResul);
                String broadcast = broa(octResul);
                mensagem("rede" + rede + "broa" + broadcast);
                int octRede = Integer.parseInt(rede, 2);
                int octBroa = Integer.parseInt(broadcast, 2);
                ipDeciRede += octUmStr + "." + octDoisStr + "." + octRede + "." + "0";
                ipDeciBroa += octUmStr + "." + octDoisStr + "." + octBroa + "." + "255";
            } else if (oct == 2) {
                ipDeciBroa = "";
                ipDeciRede = "";
                octResul = zeraHost(octDoisStr);
                String rede = "";
                String broadcast = "";
                rede = zera(octResul);
                broadcast = broa(octResul);

                int octRede = Integer.parseInt(rede, 2);
                int octBroa = Integer.parseInt(broadcast, 2);
                ipDeciRede += octUmStr + "." + octRede + "." + "0" + "." + "0";
                ipDeciBroa += octUmStr + "." + octBroa + "." + "255" + "." + "255";
            }
            //mensagem("Rede: "+ipDeciRede+"\n"+"Broa:"+ipDeciBroa);
            AlertDialog alertDialog = new AlertDialog.Builder(this).create();
            alertDialog.setTitle("Resultado");
            alertDialog.setMessage("Endereço de Rede: " + ipDeciRede + "\n" + "Broadcast: " + ipDeciBroa + "\n" + "Mascara: " + masc + "\n" + "Prefixo: " + pre + "\n" + "Endereços válidos: " + max);
            alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                }
            });
            alertDialog.show();
        }
    }
    public void mensagem(String s){
        Toast msg = Toast.makeText(this, s, Toast.LENGTH_LONG);
        msg.show();
    }

    public String zeraHost(String str){
        String bin = Integer.toBinaryString(Integer.valueOf(str));

        String resul = "";
        for(int i = 0;i<bin.length();i++) {
            resul += bin.substring(i,i+1);
        }
        int contador = resul.length();
        if(contador<8){
            for(int cont = contador;cont<8;cont++){
                String temp = "0"+resul;
                resul = temp;
            }
        }
        return resul;
        }

    public String zera(String str){
        String zerada = "";
        if(oct==3 || oct ==2){
            int contador = host;
            for(int i = 0;i<8;i++) {
                if(i < contador){
                    zerada += str.substring(i,i+1);
                }else{
                    zerada += "0";
                }
            }
        }else{
            int contador = 8-host;
            for(int i = 0;i<8;i++) {
                if(i < contador){
                    zerada += str.substring(i,i+1);
                }else{
                    zerada += "0";
                }
            }
        }
        return zerada;
}
    public String broa(String str){
        String zerada = "";
        if(oct==3 || oct ==2){
            int contador = host;
            for(int i = 0;i<8;i++) {
                if(i < contador){
                    zerada += str.substring(i,i+1);
                }else{
                    zerada += "1";
                }
            }
        }else{
            int contador = 8-host;
            for(int i = 0;i<8;i++) {
                if(i < contador){
                    zerada += str.substring(i,i+1);
                }else{
                    zerada += "1";
                }
            }
        }
        return zerada;
    }



    public void verificaMasc(EditText txt) {
        String x = txt.getText().toString();
        int qtd = Integer.parseInt(x);
        if (qtd > 0 && qtd < 3) {
            masc = "255.255.255.252";
            max = 2;
            host = 2;
            oct = 4;
            pre = 30;
        } else if(qtd > 2 && qtd<7){
            masc = "255.255.255.248";
            max = 6;
            host = 3;
            oct = 4;
            pre = 29;
        } else if(qtd>6 && qtd<15){
            masc = "255.255.255.240";
            max=14;
            host = 4;
            oct = 4;
            pre = 28;
        } else if(qtd>14 && qtd < 31){
            masc = "255.255.255.224";
            max =30;
            host = 5;
            oct = 4;
            pre = 27;
        } else if(qtd>30 && qtd < 63){
            masc = "255.255.255.192";
            max = 62;
            host = 6;
            oct = 4;
            pre = 26;
        } else if(qtd>62 && qtd < 127){
            masc = "255.255.255.128";
            max=126;
            host = 7;
            oct = 4;
            pre = 25;
        } else if(qtd > 126 && qtd < 255){
            masc = "255.255.255.0";
            max = 254;
            host = 8;
            oct = 4;
            pre = 24;
        } else if(qtd > 254 && qtd <511){
            masc = "255.255.254.0";
            max = 510;
            host = 7;
            oct = 3;
            pre = 23;
        } else if(qtd > 510 && qtd < 1023){
            masc = "255.255.252.0";
            max = 1022;
            host = 6;
            oct = 3;
            pre = 22;
        } else if(qtd > 1022 && qtd < 2047){
            masc = "255.255.248.0";
            max = 2046;
            host = 5;
            oct = 3;
            pre = 21;
        } else if(qtd > 2046 && qtd < 4095){
            masc = "255.255.240.0";
            max = 4094;
            host = 4;
            oct = 3;
            pre = 20;
        } else if(qtd > 4094 && qtd < 8191){
            masc = "255.255.224.0";
            max = 8190;
            host = 3;
            oct = 3;
            pre = 19;
        } else if(qtd > 8190 && qtd < 16383){
            masc = "255.255.192.0";
            max = 16382;
            host = 2;
            oct = 3;
            pre = 18;
        } else if(qtd > 16382 && qtd < 32767){
            masc = "255.255.128.0";
            max = 32766;
            host = 1;
            oct = 3;
            pre = 17;
        } else if(qtd > 32766 && qtd < 65535){
            masc = "255.255.0.0";
            max = 65534;
            host = 8;oct = 3;
            pre = 16;
        } else if(qtd > 65534 && qtd < 131071){
            masc = "255.254.0.0";
            max = 131070;
            host = 7;
            oct = 2;
            pre = 15;
        } else if(qtd > 131070 && qtd < 262143){
            masc = "255.252.0.0";
            max = 262142;
            host = 6;
            pre = 14;
        } else if(qtd > 262142 && qtd < 524287){
            masc = "255.248.0.0";
            max = 524286;
            host = 5;
            oct = 2;
            pre = 13;
        } else if(qtd > 524286 && qtd < 1048575){
            masc = "255.240.0.0";
            max = 1048574;
            host = 4;
            oct = 2;
            pre = 12;
        } else if(qtd > 1048574 && qtd < 2097151){
            masc = "255.224.0.0";
            max = 2097150;
            host = 3;
            oct = 2;
            pre = 11;
        } else if(qtd > 2097150 && qtd < 4194303){
            masc = "255.192.0.0";
            max = 4194302;
            host = 2;
            oct = 2;
            pre = 10;
        } else if(qtd > 4194302 && qtd < 8388607){
            masc = "255.128.0.0";
            max = 8388606;
            host = 1;
            oct = 2;
            pre = 9;
        } else if(qtd > 8388606 && qtd < 16777215){
            masc = "255.0.0.0";
            max = 16777216;
            host = 8;
            oct = 2;
            pre = 8;
        } else {
            masc="0";
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_principal, menu);
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
