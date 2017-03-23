package com.example.guswn_000.homework3;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    LinearLayout llayout;
    ImageView imageView,imageView2;
    TextView textView;
    int degree = 30;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        llayout = (LinearLayout)findViewById(R.id.llayout1);
        imageView = (ImageView)findViewById(R.id.iv);
        imageView2 = (ImageView)findViewById(R.id.iv2);
        textView = (TextView)findViewById(R.id.tv);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu1, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.mnred:
                llayout.setBackgroundColor(Color.RED);
                break;

            case R.id.mnublue:
                llayout.setBackgroundColor(Color.BLUE);
                break;

            case R.id.mnuyellow:
                llayout.setBackgroundColor(Color.YELLOW);
                break;

            case R.id.turn30:

                imageView.setRotation(degree);
                imageView2.setRotation(degree);
                degree +=30;
                break;

            case R.id.showtitle:
                if(item.isChecked())
                {
                    item.setChecked(false);
                    textView.setVisibility(View.INVISIBLE);
                }
                else
                {
                    item.setChecked(true);
                    textView.setVisibility(View.VISIBLE);
                }
                break;

            case R.id.twice:
                if(item.isChecked())
                {
                    item.setChecked(false);
                    imageView.setScaleX(1);
                    imageView.setScaleY(1);
                    imageView2.setScaleX(1);
                    imageView2.setScaleY(1);
                }
                else
                {
                    item.setChecked(true);
                    imageView.setScaleX(2);
                    imageView.setScaleY(2);
                    imageView2.setScaleX(2);
                    imageView2.setScaleY(2);
                }
                break;

            case R.id.chicken:
                imageView2.setVisibility(View.GONE);
                imageView.setVisibility(View.VISIBLE);
                textView.setText("겁나 맛있는 치킨");
                item.setChecked(true);
                break;


            case R.id.spaghetti:
                imageView.setVisibility(View.GONE);
                imageView2.setVisibility(View.VISIBLE);
                textView.setText("새콤한 스파게티");
                item.setChecked(true);
                break;

            case R.id.goto1:
                Intent intent = new Intent(MainActivity.this, MainActivity.class);
                startActivity(intent);
                break;

            case R.id.goto2:
                Intent intent2 = new Intent(MainActivity.this, CalActivity.class);
                startActivity(intent2);
                break;
        }

        return super.onOptionsItemSelected(item);
    }

}
