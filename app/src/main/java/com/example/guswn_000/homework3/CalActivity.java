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
    EditText etheight,etweight, etm;
    TextView bmires, pmres;
    TabHost tabHost;

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
        etheight = (EditText)findViewById(R.id.etheight);
        etweight = (EditText)findViewById(R.id.etweight);
        etm = (EditText)findViewById(R.id.etmeter);
        bmires = (TextView)findViewById(R.id.tvbmires);
        pmres = (TextView)findViewById(R.id.tvmetres);
    }
    //BMI 버튼 리스너
    public void bmilistener(View v)
    {
        if(v.getId() == R.id.bmibutton)
        {
            double h = Double.parseDouble(etheight.getText().toString());
            double w = Double.parseDouble(etweight.getText().toString());
            double bmi = w / ((h/100) * (h/100));
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
    //면적 계산 버튼 리스너
    public void pmlistener(View v)
    {
        switch (v.getId())
        {
            case R.id.ptombutn:
                double ptom = Double.parseDouble(etm.getText().toString()) * 3.305785;
                pmres.setText(ptom + "제곱미터");
                break;
            case R.id.mtopbtn:
                double mtop = Double.parseDouble(etm.getText().toString()) * 0.3025;
                pmres.setText(mtop + "평");
                break;
        }
    }
}
