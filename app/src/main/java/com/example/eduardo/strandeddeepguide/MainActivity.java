package com.example.eduardo.strandeddeepguide;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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


}
