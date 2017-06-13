package com.example.admin.tp7;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Onclick du bouton "android" menant sur l'activity 2
        Button button = (Button) findViewById(R.id.button_android);

        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Log.d("boutons", "On click bouton 1");
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtra("param", "bouton 1");
                startActivity(intent);
            }
        });

        //Go sur le questionnaire
        Button go = (Button) findViewById(R.id.go_questionnaire);

        go.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ActivityRecursive.class);
                startActivity(intent);
            }
        });
    }

    //Onlick du bouton "ios" menant sur l'activity 2
    public void bouton2(View view) {
        Log.d("boutons", "On click bouton 2");
        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
        intent.putExtra("param", "bouton 2");
        startActivity(intent);
    }
}
