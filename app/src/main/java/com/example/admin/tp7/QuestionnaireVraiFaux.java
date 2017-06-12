package com.example.admin.tp7;

import java.util.List;

/**
 * Created by Air-Oine on 12/06/2017.
 */

public class QuestionnaireVraiFaux {

    private int cpt;
    private int res;

    private List<VraiFaux> questions;

    public QuestionnaireVraiFaux() {
        super();
    }

    public QuestionnaireVraiFaux(List<VraiFaux> questions) {
        this.questions = questions;
        this.cpt = 0;
        this.res = 0;
    }

    public String getQuestionTexte() {
        return questions.get(cpt).getQuestion();
    }

    public boolean reponseBonne(boolean reponse) {
        boolean reponseTrouvee = questions.get(cpt).isReponse() == reponse;
        if(reponseTrouvee) {
            res++;
        }
        return reponseTrouvee;
    }

    public boolean questionSuivante() {
        cpt++;
        return cpt < questions.size();
    }

    public int getCpt() {
        return cpt;
    }

    public void setCpt(int cpt) {
        this.cpt = cpt;
    }

    public int getRes() {
        return res;
    }

    public void setRes(int res) {
        this.res = res;
    }

    public List<VraiFaux> getQuestions() {
        return questions;
    }

    public void setQuestions(List<VraiFaux> questions) {
        this.questions = questions;
    }
}
