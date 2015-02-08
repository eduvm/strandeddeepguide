package com.example.eduardo.strandeddeepguide;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Chama avaliação
        AppRater.app_launched(this);

        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

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


