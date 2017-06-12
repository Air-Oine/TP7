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

    private QuestionnaireVraiFaux questionnaire = new QuestionnaireVraiFaux();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        //On initialize les questions
        List<VraiFaux> questions = new ArrayList<VraiFaux>();
        questions.add(new VraiFaux("Les violons pleurent des bégonias", false));
        questions.add(new VraiFaux("Les haricots sont généralement verts", true));
        questions.add(new VraiFaux("Superman est plus fort que Batman", true));
        questions.add(new VraiFaux("Il fait beau", true));

        questionnaire.setQuestions(questions);

        TextView question = (TextView) findViewById(R.id.question);
        question.setText(questionnaire.getQuestionTexte());
    }

    public void onClickVrai(View view) {
        questionnaire.reponseBonne(true);
        questionSuivante();
    }

    public void onClickFaux(View view) {
        questionnaire.reponseBonne(false);
        questionSuivante();
    }

    /**
     * On passe à la question suivante
     */
    private void questionSuivante() {
        TextView question = (TextView) findViewById(R.id.question);

        //Question suivante si il y en a une
        if(questionnaire.questionSuivante()) {
            question.setText(questionnaire.getQuestionTexte());
        }
        //Affichage du nombre de bonnes réponses
        else {
            question.setText("Vous avez " + questionnaire.getRes() + " bonnes réponses");

            //Boutons masqués
            Button boutonVrai = (Button) findViewById(R.id.vrai);
            boutonVrai.setVisibility(View.INVISIBLE);

            Button boutonFaux = (Button) findViewById(R.id.faux);
            boutonFaux.setVisibility(View.INVISIBLE);
        }
    }
}
