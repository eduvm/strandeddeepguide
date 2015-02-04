package com.example.eduardo.strandeddeepguide;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

/**
 * Criado por eduardo
 * Data de criação: 03/02/15
 */
public class CraftingDetails extends Activity {

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
    }

}
