package com.example.thflf.myapplication;

        import android.content.Intent;
        import android.content.pm.ActivityInfo;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.util.Log;
        import android.view.View;

public class audio extends AppCompatActivity {

    int score;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE );

        //getSupportActionBar().hide();
    }
    public void onClickButton(View v)
    {
        switch (v.getId()) {
            case R.id.imageButton1:
                Intent intent1 = new Intent(audio.this, audio_1.class);
                startActivityForResult(intent1, score);
                Log.e("asdf","asdf");
                break;
            case R.id.imageButton2:
                Intent intent2 = new Intent(audio.this, audio_2.class);
                startActivityForResult(intent2, score);
                Log.e("asdf","asdf");
                break;
        }
    }
}
