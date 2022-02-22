package br.senai.sp.cotia.imccalcapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

public class ResultadoActivity extends AppCompatActivity {

    private ImageView imageView;
    private double imc = 0;
    private String genero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        // referencia a image view
        imageView = findViewById(R.id.image_view);


        // verifica se ha imc no intent

        if (getIntent().hasExtra("imc")) {
            imc = getIntent().getDoubleExtra("imc", 0);
        }

        // verifica se existe o gereno na Intent

        if (getIntent().hasExtra("genero")) {
            genero = getIntent().getStringExtra("genero");


        }

        if(genero.equals("masculino")){
            if(imc <= 21){
            imageView.setImageResource(R.drawable.andrew);
            }else if(imc <= 26){
                imageView.setImageResource(R.drawable.jukes);

            }else{
                imageView.setImageResource(R.drawable.pericles);


            }

        }else{
            if(imc <= 21){
                imageView.setImageResource(R.drawable.zendaya);
            }else if(imc <= 26){
                imageView.setImageResource(R.drawable.ana);
            }else{
                imageView.setImageResource(R.drawable.carol);


            }



        }
    }

}