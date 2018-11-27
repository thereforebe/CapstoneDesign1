package com.example.thflf.myapplication;

        import android.content.Intent;
        import android.content.pm.ActivityInfo;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.util.Log;
        import android.view.View;
        import android.widget.ImageButton;
        import android.widget.ImageView;
        import android.widget.TextView;

public class AudioActivity extends AppCompatActivity {

    int score;
    ImageView bg1, audio_result_bg, audio_result_level, audio_result_line, audio_result_score;
    ImageButton button1, button2, audio_result_restart, audio_result_back;
    TextView audio_result_level_txt, audio_result_score_txt;
    int selected_game = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE );

        bg1 = (ImageView)findViewById(R.id.audio_select_bg1);
        button1 = (ImageButton)findViewById(R.id.audio_select_button1);
        button2 = (ImageButton)findViewById(R.id.audio_select_button2);

        audio_result_bg = (ImageView)findViewById(R.id.audio_result_bg);
        audio_result_level = (ImageView)findViewById(R.id.audio_result_level);
        audio_result_line = (ImageView)findViewById(R.id.audio_result_line);
        audio_result_score = (ImageView)findViewById(R.id.audio_result_score);

        audio_result_restart = (ImageButton)findViewById(R.id.audio_result_restart);
        audio_result_back = (ImageButton)findViewById(R.id.audio_result_back);

        audio_result_level_txt = (TextView) findViewById(R.id.audio_result_level_txt);
        audio_result_score_txt = (TextView) findViewById(R.id.audio_result_score_txt);
        //getSupportActionBar().hide();
    }
    public void onClickButton(View v)
    {
        switch (v.getId()) {
            case R.id.audio_select_button1:
                selected_game = 1;
                Intent intent1 = new Intent(AudioActivity.this, Audio_1.class);
                startActivityForResult(intent1, score);
                Log.e("asdf","asdf");
                break;
            case R.id.audio_select_button2:
                selected_game = 2;
                Intent intent2 = new Intent(AudioActivity.this, Audio_2.class);
                startActivityForResult(intent2, score);
                Log.e("asdf","asdf");
                break;
            case R.id.audio_result_restart:
                bg1.setVisibility(View.VISIBLE);
                button1.setVisibility(View.VISIBLE);
                button2.setVisibility(View.VISIBLE);

                audio_result_bg.setVisibility(View.INVISIBLE);
                audio_result_level.setVisibility(View.INVISIBLE);
                audio_result_line.setVisibility(View.INVISIBLE);
                audio_result_score.setVisibility(View.INVISIBLE);

                audio_result_restart.setVisibility(View.INVISIBLE);
                audio_result_back.setVisibility(View.INVISIBLE);

                audio_result_level_txt.setVisibility(View.INVISIBLE);
                audio_result_score_txt.setVisibility(View.INVISIBLE);
                if (selected_game == 1)
                {
                    Intent intent3 = new Intent(AudioActivity.this, Audio_1.class);
                    startActivityForResult(intent3, score);
                    Log.e("asdf","asdf");
                }
                else if (selected_game == 2)
                {
                    Intent intent4 = new Intent(AudioActivity.this, Audio_2.class);
                    startActivityForResult(intent4, score);
                }
                break;
            case R.id.audio_result_back:
                bg1.setVisibility(View.VISIBLE);
                button1.setVisibility(View.VISIBLE);
                button2.setVisibility(View.VISIBLE);

                audio_result_bg.setVisibility(View.INVISIBLE);
                audio_result_level.setVisibility(View.INVISIBLE);
                audio_result_line.setVisibility(View.INVISIBLE);
                audio_result_score.setVisibility(View.INVISIBLE);

                audio_result_restart.setVisibility(View.INVISIBLE);
                audio_result_back.setVisibility(View.INVISIBLE);

                audio_result_level_txt.setVisibility(View.INVISIBLE);
                audio_result_score_txt.setVisibility(View.INVISIBLE);
                break;
        }
    }

    @Override
    protected void onActivityResult (int requestCode, int resultCode, Intent data)
    {
        if (resultCode == RESULT_OK)
        {
            int score = data.getIntExtra("Score", 0);

            bg1.setVisibility(View.INVISIBLE);
            button1.setVisibility(View.INVISIBLE);
            button2.setVisibility(View.INVISIBLE);

            audio_result_bg.setVisibility(View.VISIBLE);
            audio_result_level.setVisibility(View.VISIBLE);
            audio_result_line.setVisibility(View.VISIBLE);
            audio_result_score.setVisibility(View.VISIBLE);

            audio_result_restart.setVisibility(View.VISIBLE);
            audio_result_back.setVisibility(View.VISIBLE);

            audio_result_level_txt.setVisibility(View.VISIBLE);
            audio_result_score_txt.setVisibility(View.VISIBLE);
            audio_result_score_txt.setText(score+" %");
        }
    }
}
