package com.example.thflf.myapplication;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.drawable.AnimationDrawable;
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

public class elevator_game extends AppCompatActivity {
    ImageView exbg; TextView extxt;  ImageButton exnext;
    ImageView exbg2; ImageButton exup; ImageButton exdown; ImageButton exstop;  ImageButton exnext2;
    ImageView startfloorbg; TextView startfloortxt;
    ImageView gamebg; ImageView gamebear;
    ImageButton[] ansbtn; TextView[] anstxt;
    ImageView gamemirrorball;
    AnimationDrawable animdrawble;
    Timer timer;
    int CurFloor;
    int[] answers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_elevator_game);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE );

        exbg = (ImageView)findViewById(R.id.exlapain_background);
        extxt   = (TextView)findViewById(R.id.explain_text);
        exnext = (ImageButton)findViewById(R.id.explain_nextbutton);

        exbg2 = (ImageView)findViewById(R.id.explain2_background);
        exup = (ImageButton)findViewById(R.id.explain2_up);
        exdown = (ImageButton)findViewById(R.id.explain2_down);
        exstop = (ImageButton)findViewById(R.id.explain2_stop);
        exnext2 = (ImageButton)findViewById(R.id.explain_nextbutton2);

        startfloorbg = (ImageView)findViewById(R.id.game_startfloor_background);
        startfloortxt = (TextView)findViewById(R.id.game_startfloor_text);

        gamebg = (ImageView)findViewById(R.id.game_background);
        gamebear = (ImageView)findViewById(R.id.game_bear);

        ansbtn = new ImageButton[6]; anstxt = new TextView[6];
        ansbtn[0] = (ImageButton)findViewById(R.id.game_answer_1);
        anstxt[0] = (TextView)findViewById(R.id.game_answer_1_text);
        ansbtn[1] = (ImageButton)findViewById(R.id.game_answer_2);
        anstxt[1] = (TextView)findViewById(R.id.game_answer_2_text);
        ansbtn[2] = (ImageButton)findViewById(R.id.game_answer_3);
        anstxt[2] = (TextView)findViewById(R.id.game_answer_3_text);
        ansbtn[3] = (ImageButton)findViewById(R.id.game_answer_4);
        anstxt[3] = (TextView)findViewById(R.id.game_answer_4_text);
        ansbtn[4] = (ImageButton)findViewById(R.id.game_answer_5);
        anstxt[4] = (TextView)findViewById(R.id.game_answer_5_text);
        ansbtn[5] = (ImageButton)findViewById(R.id.game_answer_6);
        anstxt[5] = (TextView)findViewById(R.id.game_answer_6_text);

        gamemirrorball = (ImageView)findViewById(R.id.game_mirror_ball);

        exbg.setVisibility(View.VISIBLE);
        extxt.setVisibility(View.VISIBLE);
        exnext.setVisibility(View.VISIBLE);

    }

    public void onClickButton(View v)
    {
        switch (v.getId()) {
            case R.id.explain_nextbutton:
                exbg.setVisibility(View.INVISIBLE);
                extxt.setVisibility(View.INVISIBLE);
                exnext.setVisibility(View.INVISIBLE);

                exbg2.setVisibility(View.VISIBLE);
                exup.setVisibility(View.VISIBLE);
                exdown.setVisibility(View.VISIBLE);
                exstop.setVisibility(View.VISIBLE);
                exnext2.setVisibility(View.VISIBLE);

                exstop.setImageResource(R.drawable.stop0002);
                break;

            case R.id.explain2_up:
                exup.setImageResource(R.drawable.up0002);
                exdown.setImageResource(R.drawable.up0001);
                exstop.setImageResource(R.drawable.stop0001);
                //상승음 재생
                break;

            case R.id.explain2_down:
                exdown.setImageResource(R.drawable.up0002);
                exup.setImageResource(R.drawable.up0001);
                exstop.setImageResource(R.drawable.stop0001);
                //하강음 재생
                break;

            case R.id.explain2_stop:
                exup.setImageResource(R.drawable.up0001);
                exdown.setImageResource(R.drawable.up0001);
                exstop.setImageResource(R.drawable.stop0002);
                //재생 중단
                break;

            case R.id.explain_nextbutton2:
                exup.setVisibility(View.INVISIBLE);
                exdown.setVisibility(View.INVISIBLE);
                exstop.setVisibility(View.INVISIBLE);
                exnext2.setVisibility(View.INVISIBLE);

                gameMainF(true);
                break;

            case R.id.game_answer_1:
                if (answers[0] == CurFloor)
                {//정답
                    correctF(true);
                }
                else
                {//오답

                }
                break;

            case R.id.game_answer_2:
                if (answers[1] == CurFloor)
                {//정답
                    correctF(true);
                }
                else
                {//오답

                }
                break;

            case R.id.game_answer_3:
                if (answers[2] == CurFloor)
                {//정답
                    correctF(true);
                }
                else
                {//오답

                }
                break;

            case R.id.game_answer_4:
                if (answers[3] == CurFloor)
                {//정답
                    correctF(true);
                }
                else
                {//오답

                }
                break;

            case R.id.game_answer_5:
                if (answers[4] == CurFloor)
                {//정답
                    correctF(true);
                }
                else
                {//오답

                }
                break;

            case R.id.game_answer_6:
                if (answers[5] == CurFloor)
                {//정답
                    correctF(true);
                }
                else
                {//오답

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
        }, 6000);

        //현재 층 맞추기
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
               gameAnswer(true);
            }
        }, 12000);

        //게임 리셋 후 다시시작 버튼 활성화
    }

    private void gamestartfloorF(boolean bool) {

        //현재 층 랜덤 선택 후 깜빡임
        Random random = new Random();

        CurFloor = random.nextInt(9) + 1;
        startfloorbg.setVisibility(View.VISIBLE);
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
                exbg2.setVisibility(View.INVISIBLE);
                startfloorbg.setVisibility(View.INVISIBLE);
                startfloortxt.setVisibility(View.INVISIBLE);
            }
        }, 3000);
    }

    private void gameBeartoelevator(boolean bool) {

        //곰이 엘리베이터로 들어감
        gamebg.setVisibility(View.VISIBLE);
        gamebear.setVisibility(View.VISIBLE);
        animdrawble = (AnimationDrawable) gamebear.getDrawable();
        animdrawble.start();

        Animation scaleanim = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.scaletosmall);
        gamebear.startAnimation(scaleanim);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                animdrawble.stop();
                gamebear.clearAnimation();
                gamebear.setVisibility(View.INVISIBLE);
            }
        },3000);
    }

    private void gameMoveElevator(boolean bool)
    {
        //램덤한 수만큼 랜덤하게 위 아래로 움직임
        Random random = new Random();
        boolean goup;
        for (int i = 0; i < 5; i++)
        {
            goup = random.nextBoolean();
            if (goup)
            {
                if (CurFloor == 9)
                {
                    i--;
                    continue;
                }
                CurFloor += 1;
                //상승음 재생
            }
            else
            {
                if (CurFloor == 1)
                {
                    i--;
                    continue;
                }
                CurFloor -= 1;
                //하강음 재생
            }
        }
    }

    private  void gameAnswer(boolean bool)
    {


        answers = new int[6];

        Random random = new Random();



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
                    answers_[i] = random.nextInt(8) + 1;
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

        gamebear.setVisibility(View.VISIBLE);
        animdrawble = (AnimationDrawable) gamebear.getDrawable();
        animdrawble.start();

        Animation scaleanim = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.scaletolarge);
        gamebear.startAnimation(scaleanim);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                animdrawble.stop();
                gamebear.clearAnimation();
                gamebear.setVisibility(View.INVISIBLE);
                gamebg.setVisibility(View.INVISIBLE);
                exbg2.setVisibility(View.VISIBLE);
                for(int i = 0; i < 6; i++)
                {
                    ansbtn[i].setVisibility(View.VISIBLE);
                    anstxt[i].setText(Integer.toString(answers[i]));
                    anstxt[i].setVisibility(View.VISIBLE);
                }
            }
        },3000);

    }

    private void correctF(boolean bool)
    {
        gamemirrorball.setVisibility(View.VISIBLE);
        animdrawble = (AnimationDrawable) gamemirrorball.getDrawable();
        animdrawble.start();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                animdrawble.stop();
                gamemirrorball.setVisibility(View.INVISIBLE);
            }
        },1000);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < 6; i++)
                {
                    ansbtn[i].setVisibility(View.INVISIBLE);
                    anstxt[i].setVisibility(View.INVISIBLE);
                }
                exbg2.setVisibility(View.INVISIBLE);
                gameMainF(true);
            }
        },3000);
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
