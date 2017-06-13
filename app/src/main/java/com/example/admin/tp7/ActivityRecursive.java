package com.example.admin.tp7;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Même questionnaire que dans la MainActivity3, mais fonctionnant de façon récursive
 */
public class ActivityRecursive extends AppCompatActivity {

    public static final String COMPTEUR = "compteur";
    public static final String RESULTAT = "resultat";

    private int indexQuestion = 0;
    private int nbBonnesReponses = 0;
    private List<VraiFaux> questions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recursive);

        //On charge l'intent de l'activity
        Intent intent = getIntent();
        if(intent != null) {
            indexQuestion = intent.getIntExtra(COMPTEUR, 0);
            nbBonnesReponses = intent.getIntExtra(RESULTAT, 0);
        }

        //On initialize les questions
        questions = new ArrayList<VraiFaux>();
        questions.add(new VraiFaux("Les violons pleurent des bégonias", false));
        questions.add(new VraiFaux("Les haricots sont généralement verts", true));
        questions.add(new VraiFaux("Superman est plus fort que Batman", true));
        questions.add(new VraiFaux("Il fait beau", true));

        TextView question = (TextView) findViewById(R.id.question2);

        //Si le questionnaire n'est pas fini
        if(indexQuestion < questions.size()) {
            question.setText(questions.get(indexQuestion).getQuestion());
        }
        //Affichage du nombre de bonnes réponses
        else {
            question.setText("Vous avez " + nbBonnesReponses + " bonnes réponses");

            //Colorisation du résultat
            float reussite = (float) nbBonnesReponses / (float) indexQuestion;

            int color = Color.BLACK;
            if(reussite < 0.25f) {
                color = Color.RED;
            }
            else if(reussite > 0.75f) {
                color = Color.GREEN;
            }
            question.setTextColor(color);

            //Affiche la réussite au questionnaire
            ProgressBar progressBar = (ProgressBar) findViewById(R.id.reussite);
            progressBar.setProgress((int) (reussite*100));
            progressBar.setVisibility(View.VISIBLE);

            //Boutons masqués
            Button boutonVrai = (Button) findViewById(R.id.vrai2);
            boutonVrai.setVisibility(View.INVISIBLE);

            Button boutonFaux = (Button) findViewById(R.id.faux2);
            boutonFaux.setVisibility(View.INVISIBLE);
        }
    }

    public void onClickVrai(View view) {
        if(questions.get(indexQuestion).isReponse()) {
            nbBonnesReponses++;
        }
        questionSuivante();
    }

    public void onClickFaux(View view) {
        if(!questions.get(indexQuestion).isReponse()) {
            nbBonnesReponses++;
        }
        questionSuivante();
    }

    /**
     * On passe à la question suivante
     */
    private void questionSuivante() {
        indexQuestion++;

        //On envoie le compteur et le résultat à la nouvelle instance de l'activity
        Intent intent = new Intent(ActivityRecursive.this, ActivityRecursive.class);
        intent.putExtra(COMPTEUR, indexQuestion);
        intent.putExtra(RESULTAT, nbBonnesReponses);
        startActivity(intent);
    }
}
