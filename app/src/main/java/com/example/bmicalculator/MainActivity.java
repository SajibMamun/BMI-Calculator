package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView mcurrentheight,mcurrentage,mcurrentweight;
    ImageView mincreamentage,mincreamentweight,mdecrementage,mdecrementweight;
    SeekBar mseekbar;
    Button calculatebtn;
    RelativeLayout mmale,mfemlae;
    int intweight=50;
    int intage=18;
    int currentprogress;
    String mintprogress="170";
    String typeofuser="0";
    String weight2="50";
    String age2="18";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        calculatebtn=findViewById(R.id.calculatebtnid);
        mcurrentage=findViewById(R.id.CurrentAgeid);
        mcurrentweight=findViewById(R.id.Currentweightid);
        mcurrentheight=findViewById(R.id.Currentheighttvid);
        mincreamentage=findViewById(R.id.icreamentAgeid);
        mincreamentweight=findViewById(R.id.icreamentweightid);
        mdecrementage=findViewById(R.id.decreamentAgeid);
        mdecrementweight=findViewById(R.id.decreamentweightid);
        mseekbar=findViewById(R.id.Seekbarforheightid);
        mmale=findViewById(R.id.male);
        mfemlae=findViewById(R.id.female);



        //malefemale focus

        mmale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mmale.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.malefocusbg));
                mfemlae.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.maleunfocusbg));
           typeofuser="Male";
            }
        });
      mfemlae.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mfemlae.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.malefocusbg));
                mmale.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.maleunfocusbg));
           typeofuser="Female";
            }

        });








    //seekbar Section
      mseekbar.setMax(300);
      mseekbar.setProgress(170);
      mseekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
          @Override
          public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
              currentprogress=i;
              mintprogress=String.valueOf(currentprogress);
              mcurrentheight.setText(mintprogress);


          }

          @Override
          public void onStartTrackingTouch(SeekBar seekBar) {

          }

          @Override
          public void onStopTrackingTouch(SeekBar seekBar) {

          }
      });



      //Age section
        mincreamentage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                intage=intage+1;
                age2=String.valueOf(intage);
                mcurrentage.setText(age2);
            }
        });


          mdecrementage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                intage=intage-1;
                age2=String.valueOf(intage);
                mcurrentage.setText(age2);
            }
        });





          //weight section

        mincreamentweight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                intweight=intweight+1;
                weight2=String.valueOf(intweight);
                mcurrentweight.setText(weight2);
            }
        });
        mdecrementweight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                intweight=intweight-1;
                weight2=String.valueOf(intweight);
                mcurrentweight.setText(weight2);
            }
        });












        calculatebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if(typeofuser.equals("0"))
                {
                    Toast.makeText(getApplicationContext(),"Please Select Gender",Toast.LENGTH_SHORT).show();
                }
                else if(mintprogress.equals("0"))
                {
                    Toast.makeText(getApplicationContext(),"Enter Your Valid Height ",Toast.LENGTH_SHORT).show();
                }
                else if(intage==0 || intage<0)
                {
                    Toast.makeText(getApplicationContext(),"Enter Your Valid Age",Toast.LENGTH_SHORT).show();
                }
                else if(intweight==0 || intweight<0)
                {
                    Toast.makeText(getApplicationContext(),"Enter Your Valid Weight",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Intent  intent=new Intent(MainActivity.this,calculateAcitvity.class);
                    intent.putExtra("gender",typeofuser);
                    intent.putExtra("height",mintprogress);
                    intent.putExtra("weight",weight2);
                    intent.putExtra("age",age2);
                    startActivity(intent);





                }

            }
        });
    }
}