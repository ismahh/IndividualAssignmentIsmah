package com.example.individualassignmentismah;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
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
import android.widget.ToggleButton;

public class bmiactivity extends AppCompatActivity {

    android.widget.Button mrecalculatebmi;

    TextView mbmidisplay,mbmicategory,mgender, currentheight;
    Intent intent;
    ImageView mimageview;
    Context context;
    String mbmi;
    float intbmi;

    String height;
    String weight;
    public float intheight,intweight;
    RelativeLayout mbackground;
    boolean convert=false;
    Button unit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmiactivity);

        getSupportActionBar().setElevation(0);
        getSupportActionBar().setTitle(Html.fromHtml("<font color=\"white\"></font>"));
        getSupportActionBar().setTitle("Result");
        ColorDrawable colorDrawable=new ColorDrawable(Color.parseColor("#1E1D1D"));
        getSupportActionBar().setBackgroundDrawable(colorDrawable);

        intent=getIntent();
        mbmidisplay=findViewById(R.id.bmidisplay);
        mbmicategory=findViewById(R.id.bmicategory);
        mgender=findViewById(R.id.genderdisplay);
        mbackground=findViewById(R.id.contentLayout);
        mimageview=(ImageView)findViewById(R.id.imageview);
        mrecalculatebmi=findViewById(R.id.recalculatebmi);
        unit =findViewById(R.id.toggleButton);
        currentheight=findViewById(R.id.currentheight);
        context = getApplicationContext();

        height=intent.getStringExtra("height");
        weight=intent.getStringExtra("weight");

        intheight=Float.parseFloat(height);
        intweight=Float.parseFloat(weight);

        intheight=intheight/100;

        intbmi=intweight/(intheight*intheight);
        mbmi=Float.toString(intbmi);

        if(Float.compare(intbmi, 18.4f) <= 0)
        {
            mbmicategory.setText("BMI Category: Under Weight\n\nHealth risk: Malnutrition Risk");
            mbackground.setBackgroundColor(Color.rgb(0,153,153));
            mimageview.setImageResource(R.drawable.warning);
        }
        else if (Float.compare(intbmi, 18.5f) > 0  &&  Float.compare(intbmi, 24.9f) <= 0)
        {
            mbmicategory.setText("BMI Category: Normal Weight\n\nHealth risk: Low Risk");
            mbackground.setBackgroundColor(Color.rgb(0,153,153));
            mimageview.setImageResource(R.drawable.ok);
        }
        else if (Float.compare(intbmi, 25f) > 0  &&  Float.compare(intbmi, 29.9f) <= 0)
        {
            mbmicategory.setText("BMI Category: Over Weight\n\nHealth risk: Enchanced Risk");
            mbackground.setBackgroundColor(Color.rgb(0,153,153));
            mimageview.setImageResource(R.drawable.warning);
        }
        else if (Float.compare(intbmi, 30f) > 0  &&  Float.compare(intbmi, 34.9f) <= 0)
        {
            mbmicategory.setText("BMI Category: Moderately Obese\n\nHealth risk: Medium Risk");
            mbackground.setBackgroundColor(Color.rgb(0,153,153));
            mimageview.setImageResource(R.drawable.warning);
        }
        else if (Float.compare(intbmi, 30f) > 0  &&  Float.compare(intbmi, 34.9f) <= 0)
        {
            mbmicategory.setText("BMI Category: Severely Obese\n\nHealth risk: High Risk");
            mbackground.setBackgroundColor(Color.rgb(0,153,153));
            mimageview.setImageResource(R.drawable.warning);
        }
        else
        {
            mbmicategory.setText("BMI Category: Very Severely Obese\n\nHealth risk: Very High Risk");
            mbackground.setBackgroundColor(Color.rgb(0,153,153));
            mimageview.setImageResource(R.drawable.warning);
        }

        mgender.setText(intent.getStringExtra("gender"));
        mbmidisplay.setText(mbmi+" kg/m");

        getSupportActionBar().hide();
        mrecalculatebmi=findViewById(R.id.recalculatebmi);

        mrecalculatebmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent intent=new Intent(bmiactivity.this,MainActivity.class);
                startActivity(intent);
                finish();
                System.out.println("App specific directory ->"+context.getFilesDir().getAbsolutePath());
            }
        });



    }
}