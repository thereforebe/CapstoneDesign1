package com.example.thflf.myapplication;

import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class animal_game extends AppCompatActivity {

    ImageView gamebg; TextView extxt;  ImageButton exnext;
    ImageButton animalbtn[];
    int answer;
    int animallist[] = new int[7];
    MediaPlayer effect_sound;
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
        setContentView(R.layout.activity_animal_game);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE );


        gamebg = (ImageView)findViewById(R.id.game_background);
        extxt   = (TextView)findViewById(R.id.explain_text);
        exnext = (ImageButton)findViewById(R.id.explain_nextbutton);

        animalbtn = new ImageButton[6];
        animalbtn[0] = (ImageButton)findViewById(R.id.animal_button1);
        animalbtn[1] = (ImageButton)findViewById(R.id.animal_button2);
        animalbtn[2] = (ImageButton)findViewById(R.id.animal_button3);
        animalbtn[3] = (ImageButton)findViewById(R.id.animal_button4);
        animalbtn[4] = (ImageButton)findViewById(R.id.animal_button5);
        animalbtn[5] = (ImageButton)findViewById(R.id.animal_button6);
        animalbtn[6] = (ImageButton)findViewById(R.id.animal_button7);

        gamebg.setVisibility(View.VISIBLE);
        extxt.setVisibility(View.VISIBLE);
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
        extxt.setVisibility(View.INVISIBLE);
        exnext.setVisibility(View.INVISIBLE);
        gamebg.setImageResource(R.drawable.animal_background);
        Random random = new Random();

        answer = random.nextInt(7);
        for (int i = 0; i < 7; i++)
        {
            animallist[i] = random.nextInt(7);
            while(true)
            {
                boolean isthere = false;
                for (int j = 0;j<i;j++)
                {
                    if (animallist[i] == animallist[j])
                        isthere = true;
                }
                if (isthere)
                    animallist[i] = random.nextInt(7);
                else
                    break;
            }
            switch (animallist[i])
            {
                case CAT:
                    animalbtn[i].setImageResource(R.drawable.cat);
                    break;
                case CHICK:
                    animalbtn[i].setImageResource(R.drawable.chick);
                    break;
                case COW:
                    animalbtn[i].setImageResource(R.drawable.cow);
                    break;
                case DOG:
                    animalbtn[i].setImageResource(R.drawable.dog);
                    break;
                case DUCK:
                    animalbtn[i].setImageResource(R.drawable.duck);
                    break;
                case HORSE:
                    animalbtn[i].setImageResource(R.drawable.horse);
                    break;
                case LION:
                    animalbtn[i].setImageResource(R.drawable.lion);
                    break;
            }
            animalbtn[i].setVisibility(View.VISIBLE);
        }



        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                switch (answer)
                {//울음소리 재생
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
        },300);
    }

    private void  correctF()
    {
        effect_sound.stop();
        effect_sound = MediaPlayer.create(this, R.raw.o);
        effect_sound.start();
    }

    private void  falseF()
    {
        effect_sound.stop();
        effect_sound = MediaPlayer.create(this, R.raw.x);
        effect_sound.start();
    }
}
