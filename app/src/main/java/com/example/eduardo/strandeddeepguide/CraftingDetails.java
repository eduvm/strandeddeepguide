package com.example.eduardo.strandeddeepguide;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.ActionBarActivity;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

/**
 * Criado por eduardo
 * Data de criação: 03/02/15
 */
public class CraftingDetails extends ActionBarActivity {

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
        public boolean onFling(MotionEvent event1, MotionEvent event2, float velocityX, float velocityY) {

            // Movimento da esquerda para a direita
            if (event2.getX() > event1.getX()) {

                // Finaliza activity
                finish();

                // Override de transição das activities
                overridePendingTransition(R.anim.slide_back_in, R.anim.slide_back_out);

            }

            return true;
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
