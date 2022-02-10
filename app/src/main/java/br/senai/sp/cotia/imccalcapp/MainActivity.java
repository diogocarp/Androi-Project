package br.senai.sp.cotia.imccalcapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editPeso, editAltura;
    private Button btCalcular, btLimpar;
    private TextView classificacao, imce;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editPeso = findViewById(R.id.edit_peso);
        editAltura = findViewById(R.id.edit_altura);
        btCalcular = findViewById(R.id.bt_calcular);
        btLimpar = findViewById(R.id.bt_limpar);
        classificacao = findViewById(R.id.classificacao);
        imce = findViewById(R.id.imce);

        imce.setText("");

        btCalcular.setOnClickListener(v -> {



            //validar campos
            if(editPeso.getText().toString().isEmpty()){
                editPeso.setError(getString(R.string.valida_peso));
                Toast.makeText(getBaseContext(), R.string.valida_peso, Toast.LENGTH_SHORT).show();


            }else if(editAltura.getText().toString().isEmpty()){
                editAltura.setError(getString(R.string.valida_altura));
                Toast.makeText(getBaseContext(), R.string.valida_altura, Toast.LENGTH_SHORT).show();

            }else{
                double peso, altura, imc;
                peso = Double.parseDouble(editPeso.getText().toString());
                altura = Double.parseDouble(editAltura.getText().toString());
                imc = peso / (altura * altura);

                if(imc < 18.5){

                    classificacao.setText(R.string.magreza);
                    classificacao.setBackgroundColor(getResources().getColor(R.color.green));


                }else if(imc < 25){

                    classificacao.setText(R.string.normal);
                    classificacao.setBackgroundColor(getResources().getColor(R.color.light_green));

                }else if(imc < 30){

                    classificacao.setText(R.string.sobrepeso);
                    classificacao.setBackgroundColor(getResources().getColor(R.color.orange));

                }else if(imc > 30){

                    classificacao.setText((R.string.obesidade));
                    classificacao.setBackgroundColor(getResources().getColor(R.color.red));

                }

                imce.setText(getString(R.string.imce,imc));

            }

            btLimpar.setOnClickListener(a ->{

                editAltura.getText().clear();
                editPeso.getText().clear();
                classificacao.setBackgroundColor(getResources().getColor(R.color.gray));
                editPeso.requestFocus();
                classificacao.setText("");
                imce.setText("");




            });

        });

    }


}



