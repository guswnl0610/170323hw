package com.example.guswn_000.homework3;

import android.app.ActivityGroup;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TabHost;
import android.widget.TextView;

import org.w3c.dom.Text;

public class CalActivity extends ActivityGroup
{
    Button bmib,ptomb, mtopb;
    EditText etheight,etweight, etm;
    TextView bmires, pmres;
    TabHost tabHost;
    double bmi, mp, h, w;
    int p,m;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cal);
        setTitle("각종 계산기");
        tabHost = (TabHost)findViewById(R.id.tabhost1);
        tabHost.setup(getLocalActivityManager());
        TabHost.TabSpec tab1 = tabHost.newTabSpec("A").setContent(R.id.tab1).setIndicator("BMI계산기");
        tabHost.addTab(tab1);//1번탭 생성
        TabHost.TabSpec tab2 = tabHost.newTabSpec("B").setContent(R.id.tab2).setIndicator("면적 계산기");
        tabHost.addTab(tab2);//2번탭 생성
        Button bmib = (Button)findViewById(R.id.bmibutton);
        Button ptomb = (Button)findViewById(R.id.ptombutn);
        Button mtopb = (Button)findViewById(R.id.mtopbtn);
        EditText etheight = (EditText)findViewById(R.id.etheight);
        EditText etweight = (EditText)findViewById(R.id.etweight);
        EditText etm = (EditText)findViewById(R.id.etmeter);
        TextView bmires = (TextView)findViewById(R.id.tvbmires);
        TextView pmres = (TextView)findViewById(R.id.tvmetres);
    }

    public void bmilistener(View v)
    {
        if(v.getId() == R.id.bmibutton)
        {
            h = Double.parseDouble(etheight.getText().toString());
            w = Double.parseDouble(etweight.getText().toString());
            bmi = w / ((h/100) * (h/100));
            if (bmi < 18.5)
            {
                bmires.setText("저체중이에요~");
            }
            else if (bmi >= 18.5 && bmi < 23)
            {
                bmires.setText("정상입니다! ^ㅅ^");
            }
            else if (bmi >= 23 && bmi < 25)
            {
                bmires.setText("과체중이에요..;ㅁ;");
            }
            else
            {
                bmires.setText("비만입니다!!! :-(");
            }
        }
    }

    public void pmlistener(View v)
    {
        switch (v.getId())
        {
            case R.id.ptombutn:

                break;
            case R.id.mtopbtn:

                break;
        }
    }

    // 메뉴붙이기
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu1, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        if(item.getItemId() == R.id.goto1)
        {
            Intent intent = new Intent(CalActivity.this, MainActivity.class);
            startActivity(intent);
        }
        if(item.getItemId() == R.id.goto2)
        {
            Intent intent2 = new Intent(CalActivity.this, CalActivity.class);
            startActivity(intent2);
        }
        return super.onOptionsItemSelected(item);
    }
}
