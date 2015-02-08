package com.example.eduardo.strandeddeepguide;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.GestureDetectorCompat;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

/**
 * Criado por eduardo
 * Data de criação: 03/02/15
 * <p/>
 * Classe que vai exibir os botões com as opções de crafting_details
 */
public class CraftingList extends Activity {

    // Declara objeto do layout
    ImageView ivBola1, ivBola2, ivBola3, ivBola4, ivBola5;

    // Define variáveis de controle do gestor de movimentos
    private static final int SWIPE_MIN_DISTANCE = 150;
    private static final int SWIPE_MAX_OFF_PATH = 250;
    private static final int SWIPE_THRESHOLD_VELOCITY = 100;


    // Declaro variável para o Detector de movimentos
    private GestureDetectorCompat mDetector;

    // Declara intent
    Intent ICraftDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.crafting_list);

        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

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

    @Override
    public void onBackPressed() {
        // finish() is called in super: we only override this method to be able to override the transition
        super.onBackPressed();

        overridePendingTransition(R.anim.slide_back_in, R.anim.slide_back_out);
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
        //overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
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

        // Repassa o drawable para activity como um inteiro
        ICraftDetails.putExtra("imagem", drawableId);

        // Seta ingredientes
        ICraftDetails.putExtra("ingredientes", ingredientes);

        // Seta descrição
        ICraftDetails.putExtra("descricao", descricao);

    }

}
