package com.example.admin.tp7;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class MainActivity3 extends AppCompatActivity {

    private int cpt = 0;
    private int res = 0;

    private List<VraiFaux> questions = new ArrayList<VraiFaux>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        //On initialize les questions
        questions.add(new VraiFaux("Les violons pleurent des bégonias", false));
        questions.add(new VraiFaux("Les haricots sont généralement verts", true));
        questions.add(new VraiFaux("Superman est plus fort que Batman", true));
        questions.add(new VraiFaux("Il fait beau", true));

        TextView question = (TextView) findViewById(R.id.question);
        question.setText(questions.get(cpt).getQuestion());
    }

    public void onClickVrai(View view) {
        if(questions.get(cpt).isReponse()) {
            res++;
        }
        questionSuivante();
    }

    public void onClickFaux(View view) {
        if(!questions.get(cpt).isReponse()) {
            res++;
        }
        questionSuivante();
    }

    /**
     * On passe à la question suivante
     */
    private void questionSuivante() {
        TextView question = (TextView) findViewById(R.id.question);

        //Question suivante si il y en a une
        cpt++;
        if(cpt < questions.size()) {
            question.setText(questions.get(cpt).getQuestion());
        }
        //Affichage du nombre de bonnes réponses
        else {
            question.setText("Vous avez " + res + " bonnes réponses");

            //Boutons masqués
            Button boutonVrai = (Button) findViewById(R.id.vrai);
            boutonVrai.setVisibility(View.INVISIBLE);

            Button boutonFaux = (Button) findViewById(R.id.faux);
            boutonFaux.setVisibility(View.INVISIBLE);
        }
    }
}
