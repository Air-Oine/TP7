package com.example.admin.tp7;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //Adaptation du résultat en fonction du paramètre de l'intent
        Intent intent = getIntent();
        String param = intent.getStringExtra("param");

        TextView resultat = (TextView) findViewById(R.id.textView2);

        if(param.equals("bouton 1")) {
            resultat.setText(R.string.good_answer);
        }
        else {
            resultat.setText(R.string.wrong_answer);
        }
    }

    public void cancel(View view) {
        TextView resultat = (TextView) findViewById(R.id.textView2);

        resultat.setText("Boouuuuuuuh !!!!");
    }
}
