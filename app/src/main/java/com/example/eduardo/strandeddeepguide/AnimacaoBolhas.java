package com.example.eduardo.strandeddeepguide;

import android.view.animation.TranslateAnimation;
import android.widget.ImageView;


/**
 * Criado por eduardo
 * Data de criação: 08/02/15
 * <p/>
 * Classe responsável por fazer animação das bolhas
 */
public class AnimacaoBolhas {

    /**
     * Método CriaAnimação
     * <p/>
     * Criará a animação das bolhas
     *
     * @param v1 ImageView1
     * @param v2 ImageView2
     * @param v3 ImageView3
     * @param v4 ImageView4
     * @param v5 ImageView5
     */
    public static void CriaAnimacao(ImageView v1, ImageView v2, ImageView v3, ImageView v4, ImageView v5) {

        // Anima bola1
        TranslateAnimation animation = new TranslateAnimation(0.0f, 0.0F, v1.getY(), -6500f);
        animation.setDuration(13000);
        animation.setRepeatCount(-1);
        animation.setRepeatMode(1);
        animation.setFillAfter(true);
        v1.startAnimation(animation);

        // Anima bola2
        TranslateAnimation animation2 = new TranslateAnimation(0.0f, 0.0F, v2.getY(), -6500f);
        animation2.setDuration(13000);
        animation2.setRepeatCount(-1);
        animation2.setRepeatMode(1);
        animation2.setFillAfter(true);
        v2.startAnimation(animation2);

        // Anima bola3
        TranslateAnimation animation3 = new TranslateAnimation(0.0f, 0.0F, v3.getY(), -6500f);
        animation3.setDuration(12000);
        animation3.setRepeatCount(-1);
        animation3.setRepeatMode(1);
        animation3.setFillAfter(true);
        v3.startAnimation(animation3);

        // Anima bola4
        TranslateAnimation animation4 = new TranslateAnimation(0.0f, 0.0F, v4.getY(), -6500f);
        animation4.setDuration(14000);
        animation4.setRepeatCount(-1);
        animation4.setRepeatMode(1);
        animation4.setFillAfter(true);
        v4.startAnimation(animation4);

        // Anima bola5
        TranslateAnimation animation5 = new TranslateAnimation(0.0f, 0.0F, v5.getY(), -6500f);
        animation5.setDuration(15000);
        animation5.setRepeatCount(-1);
        animation5.setRepeatMode(1);
        animation5.setFillAfter(true);
        v5.startAnimation(animation5);

    }

}
