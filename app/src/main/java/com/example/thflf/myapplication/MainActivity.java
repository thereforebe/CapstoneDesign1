package com.example.thflf.myapplication;

        import android.content.Intent;
        import android.content.pm.ActivityInfo;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE );

        //getSupportActionBar().hide();
    }
    public void onClickButton(View v)
    {
        Intent intent1 = new Intent(MainActivity.this, elevator_game.class);
        startActivity(intent1);
    }
}
