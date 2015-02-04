package com.example.eduardo.strandeddeepguide;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;

import java.io.ByteArrayOutputStream;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

/**
 * Criado por eduardo
 * Data de criação: 03/02/15
 * <p/>
 * Classe que vai exibir os botões com as opções de crafting_details
 */
public class CraftingList extends Activity {

    // Declara intent
    Intent ICraftDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.crafting_list);

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

        // Define intent responsável por chamar a tela de detalhes e passar os parâmetros para ela
        ICraftDetails = new Intent(getApplicationContext(), CraftingDetails.class);

        // Faz switch para pegar alguma click nos botões
        switch (id) {

            // Ações para cada botão
            case R.id.btnCrudeKnife:

                criaParametros("Crude Knife", R.drawable.crude_knife, "1 Stick + 1 Rock Shard + 1 Lashing", "Used as a makeshift weapon.");

                break;

            case R.id.btnCrudeAxe:

                criaParametros("Crude Axe", R.drawable.crude_axe, "1 Stick + 1 Rock + 1 Lashing", "Used for chopping various things.");

                break;

            case R.id.btnCrudeHammer:

                criaParametros("Crude Hammer", R.drawable.crude_hammer, "1 Stick + 2 Rock + 1 Lashing", "Used to construct structures");

                break;

            case R.id.btnCrudeSpear:

                criaParametros("Crude Spear", R.drawable.crude_spear, "2 Stick + 1 Rock Shard + 1 Lashing", "Used for Fishing and/or is used as a weapon.");

                break;

            case R.id.btnCampFire:

                criaParametros("Campfire", R.drawable.campfire, "5 Stick", "A simple Campfire that has a short term use.");

                break;

            case R.id.btnFirePit:

                criaParametros("Fire Pit", R.drawable.fire_pit, "1 Campfire + 6 Rock", "A Fire Pit is an attachment to a Campfire that has a longer lasting use.");

                break;

            case R.id.btnFireSpit:

                criaParametros("Fire Spit", R.drawable.fire_spit, "1 Fire Pit + 3 Stick + 1 Lashing", "A Fire Spit is an addition to a Fire Pit that allows you to attach Cookable Food to the spit that does not require attention whilst cooking. Fire Spits can also be refilled using Palm Fronds or Sticks.");

                break;

            case R.id.btnRaft:

                criaParametros("Raft", R.drawable.raft, "8 Stick", "The same as a Foundation but placed of the water surface");

                break;

            case R.id.btnBoatMotor:

                criaParametros("Boat Motor", R.drawable.boat_motor, "Tank + 1 Carburetor + 1 Engine + 1 Propeller + 1 Stick + 1 Duct Tape", "Can be attached to a wooden Raft for extra speed!");

                break;

            case R.id.btnFoundation:

                criaParametros("Foundation", R.drawable.foundation, "8 Stick", "If you right click on a Foundation it will break into its pieces. ");

                break;

            case R.id.btnSupports:

                criaParametros("Supports", R.drawable.supports, "1 Foundation + 1 Stick", "Can be placed at each corner of a Foundation or in the middle of a Raft.");

                break;

            case R.id.btnWall:

                criaParametros("Wall", R.drawable.wall, "1 Foundation + 4 Stick + 2 Palm Frond", "Can be placed adjacent to Supports.");

                break;

            case R.id.btnRoof:

                criaParametros("Roof", R.drawable.roof, "1 Foundation + 4 Stick + 4 Palm Frond", "Can be placed on top of 4 Supports.");

                break;

            case R.id.btnSteps:

                criaParametros("Steps", R.drawable.steps, "1 Foundation + 5 Stick + 6 Lashing", "Can be placed at any side of a Foundation that’s not occupied.");

                break;


            case R.id.btnBed:

                criaParametros("Bed", R.drawable.bed, " Stick + 4 Palm Frond + 4 Lashing", "Can be used for sleeping.");

                break;

            default:
                break;
        }

        // Chama Activity passando os parâmetros
        startActivity(ICraftDetails);

        // Sobrepõe transição de telas
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }

    /**
     * Função que grava no intent os parâmetros passados
     * <p/>
     * Criada por Eduardo Vieira Mendes
     * Data de criação: 03/02/2015
     *
     * @param titulo       String com título do item
     * @param drawableId   Id da imagem do item
     * @param ingredientes String com os ingredientes para criar o item
     * @param descricao    String com a descrição do item
     */
    private void criaParametros(String titulo, int drawableId, String ingredientes, String descricao) {

        // Seta título no intent
        ICraftDetails.putExtra("titulo", titulo);

        // Pega arquivo de imagem
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), drawableId);

        // Define novo array de bytes
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        // Faz compressão do bitmap
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, baos);

        // Transforma para array de bytes
        byte[] b = baos.toByteArray();

        // Coloca imagem no intent
        ICraftDetails.putExtra("imagem", b);

        // Seta ingredientes
        ICraftDetails.putExtra("ingredientes", ingredientes);

        // Seta descrição
        ICraftDetails.putExtra("descricao", descricao);

    }

}
