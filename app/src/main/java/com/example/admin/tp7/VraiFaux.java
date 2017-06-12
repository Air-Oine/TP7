package com.example.admin.tp7;

/**
 * Created by Air-Oine on 12/06/2017.
 */

public class VraiFaux {

    private String question;

    //La réponse est soit vrai, soit faux
    private boolean reponse;

    public VraiFaux(String question, boolean reponse) {
        this.question = question;
        this.reponse = reponse;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public boolean isReponse() {
        return reponse;
    }

    public void setReponse(boolean reponse) {
        this.reponse = reponse;
    }
}
