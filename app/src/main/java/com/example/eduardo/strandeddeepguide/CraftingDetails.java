package com.example.eduardo.strandeddeepguide;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
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

        // Seta variaveis nos objetos
        tvTitulo.setText(ICraftRecebido.getStringExtra("titulo"));


        // Recebe array de bytes
        byte[] b = ICraftRecebido.getByteArrayExtra("imagem");

        // Transforma o array em imagem
        Bitmap bmp = BitmapFactory.decodeByteArray(b, 0, b.length);

        // Define a imagem como background no imageview
        image.setImageBitmap(bmp);


        tvIngredientes.setText(ICraftRecebido.getStringExtra("ingredientes"));
        tvDesc.setText(ICraftRecebido.getStringExtra("descricao"));
    }

}
