package com.example.thflf.myapplication;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.util.Random;

public class Audio_2 extends AppCompatActivity {

    ImageView gamebg; ImageButton exnext;
    ImageView viewox;
    ImageButton animalbtn[];
    int answer;
    int animallist[] = new int[7];
    MediaPlayer effect_sound;
    MediaPlayer animal_sound;
    int correctCount = 0;
    int gameCount = 10;
    int score = 0;
    final static int CAT = 0;
    final static int CHICK = 1;
    final static int COW = 2;
    final static int DOG = 3;
    final static int DUCK = 4;
    final static int HORSE = 5;
    final static int LION = 6;
    boolean touchable = true;
    Random random = new Random();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio_2);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE );


        gamebg = (ImageView)findViewById(R.id.animal_game_background);
        exnext = (ImageButton)findViewById(R.id.animal_explain_nextbutton);

        animalbtn = new ImageButton[7];
        animalbtn[0] = (ImageButton)findViewById(R.id.animal_button1);
        animalbtn[1] = (ImageButton)findViewById(R.id.animal_button2);
        animalbtn[2] = (ImageButton)findViewById(R.id.animal_button3);
        animalbtn[3] = (ImageButton)findViewById(R.id.animal_button4);
        animalbtn[4] = (ImageButton)findViewById(R.id.animal_button5);
        animalbtn[5] = (ImageButton)findViewById(R.id.animal_button6);
        animalbtn[6] = (ImageButton)findViewById(R.id.animal_button7);

        viewox = (ImageView)findViewById(R.id.animal_ox) ;

        gamebg.setVisibility(View.VISIBLE);
        exnext.setVisibility(View.VISIBLE);

        effect_sound = MediaPlayer.create(this, R.raw.o);
        animal_sound = MediaPlayer.create(this, R.raw.audio_2_cat);
    }

    public void onClickButton(View v) {
        if(touchable) {
            switch (v.getId()) {
                default:
                    break;
                case R.id.animal_explain_nextbutton:
                    gamebg.setImageResource(R.drawable.audio_2_background_normal);
                    exnext.setVisibility(View.INVISIBLE);
                    for (int i = 0; i < 7; i++) {
                        animalbtn[i].setVisibility(View.VISIBLE);
                    }
                    gameMainF(true);
                    break;
                case R.id.animal_button1:
                    if (answer == 0)
                        correctF();
                    else
                        falseF();
                    break;
                case R.id.animal_button2:
                    if (answer == 1)
                        correctF();
                    else
                        falseF();
                    break;
                case R.id.animal_button3:
                    if (answer == 2)
                        correctF();
                    else
                        falseF();
                    break;
                case R.id.animal_button4:
                    if (answer == 3)
                        correctF();
                    else
                        falseF();
                    break;
                case R.id.animal_button5:
                    if (answer == 4)
                        correctF();
                    else
                        falseF();
                    break;
                case R.id.animal_button6:
                    if (answer == 5)
                        correctF();
                    else
                        falseF();
                    break;
                case R.id.animal_button7:
                    if (answer == 6)
                        correctF();
                    else
                        falseF();
                    break;
            }
        }
    }

    private void gameMainF(boolean bool)
    {

        answer = random.nextInt(7);
        animal_sound.stop();
        animal_sound.release();
        switch (answer) {//울음소리 재생
            case CAT:
                animal_sound = MediaPlayer.create(Audio_2.this, R.raw.audio_2_cat);
                animal_sound.start();
                break;

                case CHICK:
                    animal_sound = MediaPlayer.create(Audio_2.this, R.raw.audio_2_chick);
                    animal_sound.start();
                    break;
                case COW:
                    animal_sound = MediaPlayer.create(Audio_2.this, R.raw.audio_2_cow);
                    animal_sound.start();
                    break;
                case DOG:
                    animal_sound = MediaPlayer.create(Audio_2.this, R.raw.audio_2_dog);
                    animal_sound.start();
                    break;
                case DUCK:
                    animal_sound = MediaPlayer.create(Audio_2.this, R.raw.audio_2_duck);
                    animal_sound.start();
                    break;
                case HORSE:
                    animal_sound = MediaPlayer.create(Audio_2.this, R.raw.audio_2_horse);
                    animal_sound.start();
                    break;
                case LION:
                    animal_sound = MediaPlayer.create(Audio_2.this, R.raw.audio_2_lion);
                    animal_sound.start();
                    break;
            }


    }

    private void  correctF()
    {
        touchable = false;
        score += 10;
        effect_sound.stop();
        effect_sound.release();
        effect_sound= MediaPlayer.create(this, R.raw.o);
        effect_sound.start();
        viewox.setImageResource(R.drawable.audio_2_correct);
        viewox.setVisibility(View.VISIBLE);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                gameCount--;
                if (gameCount == 0)
                {
                    animal_sound.stop();
                    animal_sound.release();
                    effect_sound.stop();
                    effect_sound.release();
                    Intent temp = new Intent();
                    temp.putExtra("Score", score);
                    setResult(RESULT_OK, temp);
                    finish();
                }
                else
                {
                    viewox.setVisibility(View.INVISIBLE);
                    touchable = true;
                    gameMainF(true);
                }
            }
        },500);

    }

    private void  falseF()
    {
        touchable = false;
        effect_sound.stop();
        effect_sound.release();
        effect_sound= MediaPlayer.create(this, R.raw.x);
        effect_sound.start();
        viewox.setImageResource(R.drawable.audio_2_incorrect);
        viewox.setVisibility(View.VISIBLE);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                gameCount--;
                if (gameCount == 0)
                {
                    animal_sound.stop();
                    animal_sound.release();
                    effect_sound.stop();
                    effect_sound.release();
                    Intent temp = new Intent();
                    temp.putExtra("Score", score);
                    setResult(RESULT_OK, temp);
                    finish();
                }
                else
                {
                    viewox.setVisibility(View.INVISIBLE);
                    touchable = true;
                    gameMainF(true);
                }
            }
        },500);
    }
}
