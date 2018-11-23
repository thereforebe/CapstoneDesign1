package com.example.thflf.myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.os.Handler;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class audio_1 extends AppCompatActivity {
    ImageView gamebg; TextView extxt;  ImageButton exnext;
    ImageButton exup; ImageButton exdown; ImageButton exstop;  ImageButton exnext2;
    ImageView startfloorbg; TextView startfloortxt;
    ImageView gameanim;
    ImageButton[] ansbtn; TextView[] anstxt;
    ImageView viewox;
    AnimationDrawable animdrawble;
    Timer timer;
    int CurFloor;
    int[] answers;
    MediaPlayer elavator_sound;
    MediaPlayer effect_sound;
    int score = 0;
    int gameCount = 5;
    Random random = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio_1);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE );

        gamebg = (ImageView)findViewById(R.id.elevator_game_background);
        extxt   = (TextView)findViewById(R.id.elevator_explain_text);
        exnext = (ImageButton)findViewById(R.id.elevator_explain_nextbutton);

        exup = (ImageButton)findViewById(R.id.elevator_explain2_up);
        exdown = (ImageButton)findViewById(R.id.elevator_explain2_down);
        exstop = (ImageButton)findViewById(R.id.elevator_explain2_stop);
        exnext2 = (ImageButton)findViewById(R.id.elevator_explain_nextbutton2);

        startfloorbg = (ImageView)findViewById(R.id.elevator_game_startfloor_background);
        startfloortxt = (TextView)findViewById(R.id.elevator_game_startfloor_text);

        gameanim = (ImageView)findViewById(R.id.elevator_game_anim);

        ansbtn = new ImageButton[6]; anstxt = new TextView[6];
        ansbtn[0] = (ImageButton)findViewById(R.id.elevator_game_answer_1);
        anstxt[0] = (TextView)findViewById(R.id.elevator_game_answer_1_text);
        ansbtn[1] = (ImageButton)findViewById(R.id.elevator_game_answer_2);
        anstxt[1] = (TextView)findViewById(R.id.elevator_game_answer_2_text);
        ansbtn[2] = (ImageButton)findViewById(R.id.elevator_game_answer_3);
        anstxt[2] = (TextView)findViewById(R.id.elevator_game_answer_3_text);
        ansbtn[3] = (ImageButton)findViewById(R.id.elevator_game_answer_4);
        anstxt[3] = (TextView)findViewById(R.id.elevator_game_answer_4_text);
        ansbtn[4] = (ImageButton)findViewById(R.id.elevator_game_answer_5);
        anstxt[4] = (TextView)findViewById(R.id.elevator_game_answer_5_text);
        ansbtn[5] = (ImageButton)findViewById(R.id.elevator_game_answer_6);
        anstxt[5] = (TextView)findViewById(R.id.elevator_game_answer_6_text);

        viewox = (ImageView)findViewById(R.id.elevator_ox) ;

        elavator_sound = MediaPlayer.create(this, R.raw.elevator_up);
        effect_sound = MediaPlayer.create(audio_1.this, R.raw.o);


        gamebg.setVisibility(View.VISIBLE);
        extxt.setVisibility(View.VISIBLE);
        exnext.setVisibility(View.VISIBLE);
    }

    public void onClickButton(View v)
    {
        switch (v.getId()) {
            case R.id.elevator_explain_nextbutton:
                gamebg.setImageResource(R.drawable.wharfloor_bg);
                extxt.setVisibility(View.INVISIBLE);
                exnext.setVisibility(View.INVISIBLE);

                exup.setVisibility(View.VISIBLE);
                exdown.setVisibility(View.VISIBLE);
                exstop.setVisibility(View.VISIBLE);
                exnext2.setVisibility(View.VISIBLE);

                break;

            case R.id.elevator_explain2_up:
                exup.setImageResource(R.drawable.up0002);
                exdown.setImageResource(R.drawable.up0001);
                exstop.setImageResource(R.drawable.stop0001);
                elavator_sound.stop();
                elavator_sound.release();
                elavator_sound = MediaPlayer.create(this, R.raw.elevator_up);
                elavator_sound.start();
                break;

            case R.id.elevator_explain2_down:
                exdown.setImageResource(R.drawable.up0002);
                exup.setImageResource(R.drawable.up0001);
                exstop.setImageResource(R.drawable.stop0001);
                //하강음 재생
                elavator_sound.stop();
                elavator_sound.release();
                elavator_sound = MediaPlayer.create(this, R.raw.elevator_down);
                elavator_sound.start();
                break;

            case R.id.elevator_explain2_stop:
                exup.setImageResource(R.drawable.up0001);
                exdown.setImageResource(R.drawable.up0001);
                exstop.setImageResource(R.drawable.stop0002);
                elavator_sound.stop();
                elavator_sound.release();
                elavator_sound = MediaPlayer.create(this, R.raw.elevator_stop);
                elavator_sound.start();
                break;

            case R.id.elevator_explain_nextbutton2:
                exup.setVisibility(View.INVISIBLE);
                exdown.setVisibility(View.INVISIBLE);
                exstop.setVisibility(View.INVISIBLE);
                exnext2.setVisibility(View.INVISIBLE);

                gameMainF(true);
                break;

            case R.id.elevator_game_answer_1:
                if (answers[0] == CurFloor)
                {//정답
                    correctF(true);
                }
                else
                {//오답
                    falseF(true);
                }
                break;

            case R.id.elevator_game_answer_2:
                if (answers[1] == CurFloor)
                {//정답
                    correctF(true);
                }
                else
                {//오답
                    falseF(true);
                }
                break;

            case R.id.elevator_game_answer_3:
                if (answers[2] == CurFloor)
                {//정답
                    correctF(true);
                }
                else
                {//오답
                    falseF(true);
                }
                break;

            case R.id.elevator_game_answer_4:
                if (answers[3] == CurFloor)
                {//정답
                    correctF(true);
                }
                else
                {//오답
                    falseF(true);
                }
                break;

            case R.id.elevator_game_answer_5:
                if (answers[4] == CurFloor)
                {//정답
                    correctF(true);
                }
                else
                {//오답
                    falseF(true);
                }
                break;

            case R.id.elevator_game_answer_6:
                if (answers[5] == CurFloor)
                {//정답
                    correctF(true);
                }
                else
                {//오답
                    falseF(true);
                }
                break;
        }
    }


    public void gameMainF(boolean gamebool)//게임 메인 함수
    {
        int CurFloor = 0;
        boolean startFloorOn = true;
        long startTime;
        int i;


        //현재 층 랜덤 선택 후 깜빡임
        gamestartfloorF(true);

        //곰이 엘리베이터로 들어감
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                gameBeartoelevator(true);
            }
        }, 3000);

        //램덤한 수만큼 랜덤하게 위 아래로 움직임
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                gameMoveElevator(true);
            }
        }, 5500);

        //현재 층 맞추기
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
               gameAnswer(true);
            }
        }, 18000);

        //게임 리셋 후 다시시작 버튼 활성화
    }

    private void gamestartfloorF(boolean bool) {

        //현재 층 랜덤 선택 후 깜빡임

        CurFloor = random.nextInt(9) + 1;
        gamebg.setImageResource(R.drawable.wharfloor_curver);
        startfloortxt.setVisibility(View.VISIBLE);
        startfloortxt.setText(Integer.toString(CurFloor));

        Animation startFloorAnim = new AlphaAnimation(0.0f, 2.0f);
        startFloorAnim.setDuration(300); //You can manage the time of the blink with this parameter
        startFloorAnim.setStartOffset(0);
        startFloorAnim.setRepeatMode(Animation.REVERSE);
        startFloorAnim.setRepeatCount(10);
        startfloortxt.startAnimation(startFloorAnim);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startfloortxt.clearAnimation();
                startfloortxt.setVisibility(View.INVISIBLE);
            }
        }, 3000);
    }

    private void gameBeartoelevator(boolean bool) {

        //곰이 엘리베이터로 들어감
        gamebg.setImageResource(R.drawable.wharfloor_bg_1);
        gameanim.setImageResource(R.drawable.bear_anim);
        gameanim.setVisibility(View.VISIBLE);
        animdrawble = (AnimationDrawable) gameanim.getDrawable();
        animdrawble.start();

        Animation scaleanim = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.scaletosmall);
        gameanim.startAnimation(scaleanim);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                animdrawble.stop();
                gameanim.clearAnimation();
                gameanim.setVisibility(View.INVISIBLE);
            }
        },2000);
    }

    private void gameMoveElevator(boolean bool)
    {
        //램덤한 수만큼 랜덤하게 위 아래로 움직임
        boolean goup;
        for (int i = 0; i < 5; i++)
        {
            goup = random.nextBoolean();
            if (goup)
            {
                if (CurFloor == 9)
                {
                    --i;
                }
                else
                {
                    CurFloor += 1;
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            //상승음 재생
                            elavator_sound.stop();
                            elavator_sound.release();
                            elavator_sound = MediaPlayer.create(audio_1.this, R.raw.elevator_up);
                            elavator_sound.start();
                        }
                    }, i * 2500);
                }
            }
            else
            {
                if (CurFloor == 1)
                {
                    --i;
                }
                else {
                    CurFloor -= 1;
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            //하강음 재생
                            elavator_sound.stop();
                            elavator_sound.release();
                            elavator_sound = MediaPlayer.create(audio_1.this, R.raw.elevator_down);
                            elavator_sound.start();
                        }
                    }, i * 2500);
                }
            }
        }
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //정지음 재생
                elavator_sound.stop();
                elavator_sound.release();
                elavator_sound = MediaPlayer.create(audio_1.this, R.raw.elevator_stop);
                elavator_sound.start();
            }
        }, 12500);
    }

    private  void gameAnswer(boolean bool)
    {
        answers = new int[6];

        int[] answers_ = new int[6];
        answers_[0] = CurFloor;
        for (int i = 1; i < 6; i++)
        {
            answers_[i] = random.nextInt(9) + 1;
            while(true)
            {
                boolean isthere = false;
                for (int j = 0;j<i;j++)
                {
                    if (answers_[i] == answers_[j])
                        isthere = true;
                }
                if (isthere)
                    answers_[i] = random.nextInt(9) + 1;
                else
                    break;
            }
        }

        for (int i = 0; i < 6; i++)
        {
            answers[i] = random.nextInt(6);
            while(true)
            {
                boolean isthere = false;
                for (int j = 0;j<i;j++)
                {
                    if (answers[i] == answers[j])
                        isthere = true;
                }
                if (isthere)
                    answers[i] = random.nextInt(6);
                else
                    break;
            }
        }

        for (int i = 0; i < 6; i++)
            answers[i] = answers_[answers[i]];

        gameanim.setVisibility(View.VISIBLE);
        animdrawble = (AnimationDrawable) gameanim.getDrawable();
        animdrawble.start();

        Animation scaleanim = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.scaletolarge);
        gameanim.startAnimation(scaleanim);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                animdrawble.stop();
                gameanim.clearAnimation();
                gameanim.setVisibility(View.INVISIBLE);
                gamebg.setImageResource(R.drawable.wharfloor_bg);
                for(int i = 0; i < 6; i++)
                {
                    ansbtn[i].setVisibility(View.VISIBLE);
                    anstxt[i].setText(Integer.toString(answers[i]));
                    anstxt[i].setVisibility(View.VISIBLE);
                }
            }
        },2000);

    }

    private void correctF(boolean bool)
    {
        for(int i = 0; i < 6; i++)
        {
            ansbtn[i].setVisibility(View.INVISIBLE);
            anstxt[i].setVisibility(View.INVISIBLE);
        }
        viewox.setImageResource(R.drawable.audio_2_correct);
        viewox.setVisibility(View.VISIBLE);
        effect_sound.stop();
        effect_sound.release();
        effect_sound = MediaPlayer.create(audio_1.this, R.raw.o);
        effect_sound.start();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                viewox.setVisibility(View.INVISIBLE);
                gameCount--;
                if (gameCount == 0)
                {
                    elavator_sound.stop();
                    elavator_sound.release();
                    effect_sound.stop();
                    effect_sound.release();
                    setResult(score);
                    finish();
                }
                else
                {
                    viewox.setVisibility(View.INVISIBLE);
                    gameMainF(true);
                }
            }
        },500);
    }

    private void falseF(boolean bool)
    {
        for(int i = 0; i < 6; i++)
        {
            ansbtn[i].setVisibility(View.INVISIBLE);
            anstxt[i].setVisibility(View.INVISIBLE);
        }
        viewox.setImageResource(R.drawable.audio_2_incorrect);
        viewox.setVisibility(View.VISIBLE);
        effect_sound.stop();
        effect_sound.release();
        effect_sound = MediaPlayer.create(audio_1.this, R.raw.x);
        effect_sound.start();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                viewox.setVisibility(View.INVISIBLE);
                gameCount--;
                if (gameCount == 0)
                {
                    elavator_sound.stop();
                    elavator_sound.release();
                    effect_sound.stop();
                    effect_sound.release();
                    setResult(score);
                    finish();
                }
                else
                {
                    viewox.setVisibility(View.INVISIBLE);
                    score += 20;
                    gameMainF(true);
                }
            }
        },500);
    }

    private class DelayThread extends Thread
    {
        private long utimetosleep;

        public DelayThread()
        {
        }

        public DelayThread(long utimetosleep)
        { // 초기화 작업
            this.utimetosleep = utimetosleep;
        }

        public void setDelay(long utimetosleep)
        {
            this.utimetosleep = utimetosleep;
        }

        public void run() {
            try { // 스레드에게 수행시킬 동작들 구현
                Thread.sleep(utimetosleep);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
