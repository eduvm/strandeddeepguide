package com.example.eduardo.strandeddeepguide;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);


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
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);

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
