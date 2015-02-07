package com.example.eduardo.strandeddeepguide;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;


public class MainActivity extends Activity {

    // Declara objeto do layout
    ImageView ivBola1, ivBola2, ivBola3, ivBola4, ivBola5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        ivBola1 = (ImageView) findViewById(R.id.ivBola1);
        ivBola2 = (ImageView) findViewById(R.id.ivBola2);
        ivBola3 = (ImageView) findViewById(R.id.ivBola3);
        ivBola4 = (ImageView) findViewById(R.id.ivBola4);
        ivBola5 = (ImageView) findViewById(R.id.ivBola5);

        // Anima bola1
        TranslateAnimation animation = new TranslateAnimation(0.0f, 0.0F, ivBola1.getY(), -6500f);
        animation.setDuration(13000);
        animation.setRepeatCount(-1);
        animation.setRepeatMode(1);
        animation.setFillAfter(true);
        ivBola1.startAnimation(animation);


        // Anima bola2
        TranslateAnimation animation2 = new TranslateAnimation(0.0f, 0.0F, ivBola2.getY(), -6500f);
        animation2.setDuration(13000);
        animation2.setRepeatCount(-1);
        animation2.setRepeatMode(1);
        animation2.setFillAfter(true);
        ivBola2.startAnimation(animation2);

        // Anima bola3
        TranslateAnimation animation3 = new TranslateAnimation(0.0f, 0.0F, ivBola3.getY(), -6500f);
        animation3.setDuration(12000);
        animation3.setRepeatCount(-1);
        animation3.setRepeatMode(1);
        animation3.setFillAfter(true);
        ivBola3.startAnimation(animation3);

        // Anima bola4
        TranslateAnimation animation4 = new TranslateAnimation(0.0f, 0.0F, ivBola4.getY(), -6500f);
        animation4.setDuration(14000);
        animation4.setRepeatCount(-1);
        animation4.setRepeatMode(1);
        animation4.setFillAfter(true);
        ivBola4.startAnimation(animation4);

        // Anima bola5
        TranslateAnimation animation5 = new TranslateAnimation(0.0f, 0.0F, ivBola5.getY(), -6500f);
        animation5.setDuration(15000);
        animation5.setRepeatCount(-1);
        animation5.setRepeatMode(1);
        animation5.setFillAfter(true);
        ivBola5.startAnimation(animation5);

    }

    /**
     * Função que vai mostrar todas as opções de crafting_details
     */
    // Ao clicar em algum botão da dashboard
    public void onClickFeature(View v) {

        // Inicializa variável
        int id = v.getId();

        // Faz switch para pegar alguma das opções
        switch (id) {

            // Caso clique no botão add
            case R.id.btnCrafting:

                startActivity(new Intent(getApplicationContext(), CraftingList.class));
                //overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                overridePendingTransition(R.anim.slide_in, R.anim.slide_out);

                break;

            // Caso clique no botão add
            case R.id.btnTips:

                startActivity(new Intent(getApplicationContext(), ShowTips.class));

                overridePendingTransition(R.anim.slide_in, R.anim.slide_out);

                break;

            // Caso clique no botão add
            case R.id.btnAbout:

                startActivity(new Intent(getApplicationContext(), ShowAbout.class));

                overridePendingTransition(R.anim.slide_in, R.anim.slide_out);

                break;


            default:
                break;
        }
    }


    public void exibeMensagem(String titulo, String texto) {

        // Apresenta mensagem de erro
        AlertDialog.Builder mensagem = new AlertDialog.Builder(MainActivity.this);
        mensagem.setTitle(titulo);
        mensagem.setMessage(texto);
        mensagem.setNeutralButton("OK", null);
        mensagem.show();

    }


}
