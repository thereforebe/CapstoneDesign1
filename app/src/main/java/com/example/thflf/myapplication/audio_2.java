package com.example.thflf.myapplication;

import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.util.Random;

public class audio_2 extends AppCompatActivity {

    ImageView gamebg; ImageButton exnext;
    ImageButton animalbtn[];
    int answer;
    int animallist[] = new int[7];
    MediaPlayer correctsound;
    MediaPlayer incorrectsound;
    MediaPlayer catsound;
    MediaPlayer chicksound;
    MediaPlayer cowsound;
    MediaPlayer dogsound;
    MediaPlayer ducksound;
    MediaPlayer horsesound;
    MediaPlayer lionsound;
    int correctCount = 0;
    int gameCount = 5;
    int score = 0;
    final static int CAT = 0;
    final static int CHICK = 1;
    final static int COW = 2;
    final static int DOG = 3;
    final static int DUCK = 4;
    final static int HORSE = 5;
    final static int LION = 6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio_2);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE );


        gamebg = (ImageView)findViewById(R.id.animal_game_background);
        exnext = (ImageButton)findViewById(R.id.animal_explain_nextbutton);

        animalbtn = new ImageButton[6];
        animalbtn[0] = (ImageButton)findViewById(R.id.animal_button1);
        animalbtn[1] = (ImageButton)findViewById(R.id.animal_button2);
        animalbtn[2] = (ImageButton)findViewById(R.id.animal_button3);
        animalbtn[3] = (ImageButton)findViewById(R.id.animal_button4);
        animalbtn[4] = (ImageButton)findViewById(R.id.animal_button5);
        animalbtn[5] = (ImageButton)findViewById(R.id.animal_button6);
        animalbtn[6] = (ImageButton)findViewById(R.id.animal_button7);

        incorrectsound = MediaPlayer.create(this, R.raw.x);
        correctsound = MediaPlayer.create(this, R.raw.o);

        gamebg.setVisibility(View.VISIBLE);
        exnext.setVisibility(View.VISIBLE);

    }

    public void onClickButton(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.animal_explain_nextbutton:
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

    private void gameMainF(boolean bool)
    {
        exnext.setVisibility(View.INVISIBLE);
        gamebg.setImageResource(R.drawable.animal_background);
        Random random = new Random();

        answer = random.nextInt(7);
        for (int i = 0; i < 7; i++)
        {
            animalbtn[i].setVisibility(View.VISIBLE);
        }



        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                switch (answer)
                {//울음소리 재생
                    default://정지

                    case CAT:
                        break;
                    case CHICK:
                        break;
                    case COW:
                        break;
                    case DOG:
                        break;
                    case DUCK:
                        break;
                    case HORSE:
                        break;
                    case LION:
                        break;
                }
            }
        },100);

        new Handler().postDelayed(new Runnable() {
        @Override
        public void run() {falseF();
        }
    },3300);
    }

    private void  correctF()
    {
        if (correctsound.isPlaying())
        {
            correctsound.stop();
            correctsound= MediaPlayer.create(this, R.raw.o);
        }
        if (incorrectsound.isPlaying())
        {
            incorrectsound.stop();
            incorrectsound= MediaPlayer.create(this, R.raw.x);
        }
        correctsound.start();
        gameCount--;
        if (gameCount == 0)
            finish();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {gameMainF(true);
            }
        },500);

        score += 20;
    }

    private void  falseF()
    {
        if (correctsound.isPlaying())
        {
            correctsound.stop();
            correctsound= MediaPlayer.create(this, R.raw.o);
        }
        if (incorrectsound.isPlaying())
        {
            incorrectsound.stop();
            incorrectsound= MediaPlayer.create(this, R.raw.x);
        }
        incorrectsound.start();
        gameCount--;
        if (gameCount == 0)
            finish();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {gameMainF(true);
            }
        },500);
    }
}
