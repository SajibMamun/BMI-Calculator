package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.io.IOException;

public class calculateAcitvity extends AppCompatActivity {
    Button retrybtn;
    TextView mbmidisplay, mbmicatagory, mgender;
    Intent intent;
    ImageView mimageview;
    String mbmi;
    float intbmi;
    String height, weight;
    float intheight, intweight;
    RelativeLayout mbackground;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate_acitvity);


        //SetActionbardesign
        getSupportActionBar().setElevation(0);
        getSupportActionBar().setTitle(Html.fromHtml("<font color=\"white\"></font>"));
        getSupportActionBar().setTitle("Your BMI Result");
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#1D1E33"));
        getSupportActionBar().setBackgroundDrawable(colorDrawable);


        // for getting Intent
        intent = getIntent();


        mbmidisplay = findViewById(R.id.bmiddisplay);
        mbmicatagory = findViewById(R.id.Bmicatagoryid);
        mgender = findViewById(R.id.genderdisplay);
        mbackground = findViewById(R.id.ConetentLayout);
        mimageview=findViewById(R.id.imageviewidcal);
        retrybtn=findViewById(R.id.Recalculatebtnid);


        height = intent.getStringExtra("height");
        weight = intent.getStringExtra("weight");

        intheight = Float.parseFloat(height);
        intweight = Float.parseFloat(weight);

        intheight=intheight/100;
        Float totalheight=intheight*intheight;


        intbmi=intweight/totalheight;





        mbmi = Float.toString(intbmi);


        if (intbmi < 16) {
            mbmicatagory.setText("Severe Thinness");
            mbackground.setBackgroundColor(Color.RED);
            mimageview.setImageResource(R.drawable.crosss);
        }
        else if(intbmi<16.9 && intbmi>16)
        {
            mbmicatagory.setText("Moderate Thinness");
            mbackground.setBackgroundColor(Color.YELLOW);
            mimageview.setImageResource(R.drawable.warning);

        }
        else if(intbmi<18.4&& intbmi>16.9)
        {
            mbmicatagory.setText("Mild Thinness");
            mbackground.setBackgroundColor(Color.YELLOW);
            mimageview.setImageResource(R.drawable.warning);

        }
        else if(intbmi<25 && intbmi>18.4)
        {
            mbmicatagory.setText("Normal");
            mbackground.setBackgroundColor(Color.GREEN);
            mimageview.setImageResource(R.drawable.ok);

        }
        else if(intbmi<29.4 && intbmi>25)
        {
            mbmicatagory.setText("Over weight");
            mbackground.setBackgroundColor(Color.YELLOW);
            mimageview.setImageResource(R.drawable.warning);

        }
        else
        {
            mbmicatagory.setText("Obese Class I");
            mbackground.setBackgroundColor(Color.YELLOW);
            mimageview.setImageResource(R.drawable.warning);

        }

        mgender.setText(intent.getStringExtra("gender"));
        mbmidisplay.setText(mbmi);



        retrybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent tryagainIntent=new Intent(calculateAcitvity.this,MainActivity.class);
                startActivity(tryagainIntent);

            }
        });





    }
}