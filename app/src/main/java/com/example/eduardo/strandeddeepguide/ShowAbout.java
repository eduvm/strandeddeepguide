package com.example.eduardo.strandeddeepguide;

import android.app.Activity;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.support.v4.view.GestureDetectorCompat;
import android.util.Log;
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
public class ShowAbout extends Activity {

    // Define variáveis de controle do gestor de movimentos
    private static final int SWIPE_MIN_DISTANCE = 150;
    private static final int SWIPE_MAX_OFF_PATH = 250;
    private static final int SWIPE_THRESHOLD_VELOCITY = 100;

    // Declaro variável para o Detector de movimentos
    private GestureDetectorCompat mDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.about);

        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        // Instância o detector
        mDetector = new GestureDetectorCompat(this, new MyGestureListener());

        // Declara objeto do layout
        ImageView ivBola1, ivBola2, ivBola3, ivBola4, ivBola5;

        // Instancia objetos do layout
        ivBola1 = (ImageView) findViewById(R.id.ivBola1);
        ivBola2 = (ImageView) findViewById(R.id.ivBola2);
        ivBola3 = (ImageView) findViewById(R.id.ivBola3);
        ivBola4 = (ImageView) findViewById(R.id.ivBola4);
        ivBola5 = (ImageView) findViewById(R.id.ivBola5);

        // Chama função que cria animação das bolhas
        AnimacaoBolhas.CriaAnimacao(ivBola1, ivBola2, ivBola3, ivBola4, ivBola5);

        // Pega versão do aplicativo
        try {

            PackageInfo pInfo = getPackageManager().getPackageInfo(getPackageName(), 0);
            String version = pInfo.versionName;

            // Declara e instancia objeto TextView para mostrar versão do app
            TextView tvVersion = (TextView) findViewById(R.id.tvVersion);

            // Seta texto da versão
            tvVersion.setText("Version: " + version);

        } catch (Exception error) {

            // Apresenta mensagem de erro
            error.printStackTrace();

        }

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