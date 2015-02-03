package com.example.eduardo.strandeddeepguide;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    /**
     * Função que vai mostrar todas as opções de crafting
     */
    // Ao clicar em algum bot�o da dashboard
    public void onClickFeature(View v) {

        // Inicializa vari�vel
        int id = v.getId();

        // Faz switch para pegar alguma das opções
        switch (id) {

            // Caso clique no bot�o add
            case R.id.btnCrafting:

                // Devo carregar o layout de crafting
                setContentView(R.layout.crafting);

                // Atualiza dados com o item selecionado


                //  startActivity(new Intent(getApplicationContext(), Calcular.class));
                //    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);

                break;


            default:
                break;
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
