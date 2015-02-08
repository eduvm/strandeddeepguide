package com.example.eduardo.strandeddeepguide;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.GestureDetectorCompat;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

/**
 * Criado por eduardo
 * Data de criação: 03/02/15
 */
public class CraftingDetails extends Activity {

    // Declara objeto do layout
    ImageView ivBola1, ivBola2, ivBola3, ivBola4, ivBola5;

    // Define variáveis de controle do gestor de movimentos
    private static final int SWIPE_MIN_DISTANCE = 150;
    private static final int SWIPE_MAX_OFF_PATH = 250;
    private static final int SWIPE_THRESHOLD_VELOCITY = 100;

    // Declaro variável para o Detector de movimentos
    private GestureDetectorCompat mDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.crafting_details);

        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        // Define intent que vai receber os parâmetros
        Intent ICraftRecebido = getIntent();

        // Define objetos de layout
        TextView tvTitulo = (TextView) findViewById(R.id.tvTitulo);
        ImageView image = (ImageView) findViewById(R.id.ivCraftImage);
        TextView tvIngredientes = (TextView) findViewById(R.id.tvIngredientes);
        TextView tvDesc = (TextView) findViewById(R.id.tvDesc);

        // Seta título no objeto TextView
        tvTitulo.setText(ICraftRecebido.getStringExtra("titulo"));

        // Recebe como inteiro (id da imagem) e seta no objeto ImageView
        image.setImageResource(ICraftRecebido.getIntExtra("imagem", 0));

        // Seta ingredientes no TextView
        tvIngredientes.setText(ICraftRecebido.getStringExtra("ingredientes"));

        // Seta descrição no TextView
        tvDesc.setText(ICraftRecebido.getStringExtra("descricao"));

        // Instância o detector
        mDetector = new GestureDetectorCompat(this, new MyGestureListener());

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


    @Override
    public void onBackPressed() {
        // finish() is called in super: we only override this method to be able to override the transition
        super.onBackPressed();

        overridePendingTransition(R.anim.slide_back_in, R.anim.slide_back_out);
    }

    // Faço override dos métodos de detecção
    @Override
    public boolean onTouchEvent(MotionEvent event) {

        this.mDetector.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    /**
     * Classe responsável por tratar os movimentos
     */
    class MyGestureListener extends GestureDetector.SimpleOnGestureListener {

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {

            Log.d("---onFling---", e1.toString() + e2.toString() + "");

            try {
                if (Math.abs(e1.getY() - e2.getY()) > SWIPE_MAX_OFF_PATH) {
                    return false;
                }
                // right to left swipe
                if (e1.getX() - e2.getX() > SWIPE_MIN_DISTANCE && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {
                    //do your code

                } else if (e2.getX() - e1.getX() > SWIPE_MIN_DISTANCE && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {

                    // Finaliza activity
                    finish();

                    // Override de transição das activities
                    overridePendingTransition(R.anim.slide_back_in, R.anim.slide_back_out);

                }

            } catch (Exception e)

            {
                // nothing
            }

            return false;
        }

    }

    /**
     * Classe responsavel por dispachar os eventos de movimento
     *
     * @param ev
     *
     * @return
     */
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {

        super.dispatchTouchEvent(ev);
        return mDetector.onTouchEvent(ev);
    }

}
