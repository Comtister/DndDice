package com.example.dnddice;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class Popup extends Activity  {

    TextView degerler;
    TextView textbasliki;
    TextView textdegeri;
    int zarDeger;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.popwindow);

        ConstraintLayout closedLayout =( ConstraintLayout) findViewById(R.id.l1);

        degerler=(TextView)findViewById(R.id.degerler);
        textbasliki=(TextView)findViewById(R.id.textbaslik);
        textdegeri=(TextView)findViewById(R.id.textdeger);

        Bundle dizi=getIntent().getBundleExtra("dizi");
        ArrayList<String> tekdegerler=(ArrayList<String>) dizi.getSerializable("tekdegerler");

        Intent intent=getIntent();
        String cekilen=intent.getStringExtra("deger");
        String cekilenisim=intent.getStringExtra("isim");

        zarDeger = Integer.parseInt(cekilen);

        if(zarDeger < 1){
            textdegeri.setText("0");
        }else{
            textdegeri.setText(cekilen);
        }



        textbasliki.setText(cekilenisim);
       int z=0;
       for(int i=0;i<tekdegerler.size();i++){
           int y=Integer.parseInt(tekdegerler.get(i));
           if(y>9){

               z++;

           }
       }


        if(tekdegerler.size()>1){ degerler.append(tekdegerler.get(0)); degerler.append(","+tekdegerler.get(1)); }
        if(tekdegerler.size()>2) { degerler.append(","+tekdegerler.get(2)); }
        if(tekdegerler.size()>3) { degerler.append(","+tekdegerler.get(3)); }
        if(tekdegerler.size()>4) { degerler.append(","+tekdegerler.get(4)); }
        if(tekdegerler.size()>5) { degerler.append(","+tekdegerler.get(5)); }
        if(tekdegerler.size()>6) { degerler.append(","+tekdegerler.get(6)); }
        if(tekdegerler.size()>7) { degerler.append(","+tekdegerler.get(7)); }
        if(tekdegerler.size()>8) { degerler.append(","+tekdegerler.get(8)); }
        if(tekdegerler.size()>9) { degerler.append(","+tekdegerler.get(9)); }
        if(tekdegerler.size()>10) { degerler.append(","+tekdegerler.get(10)); }
        if(tekdegerler.size()>11) { degerler.append(","+tekdegerler.get(11)); }
        if(tekdegerler.size()>12) { degerler.append(","+tekdegerler.get(12)); }
        if(tekdegerler.size()>13) { degerler.append(","+tekdegerler.get(13)); }
        if(tekdegerler.size()>14) { degerler.append(","+tekdegerler.get(14)); }
        if(tekdegerler.size()>15) { degerler.append(","+tekdegerler.get(15)); }
        if(tekdegerler.size()>16) { degerler.append(","+tekdegerler.get(16)); }
        if(tekdegerler.size()>17) { degerler.append(","+tekdegerler.get(17)); }
        if(tekdegerler.size()>18) { degerler.append(","+tekdegerler.get(18)); }
        if(tekdegerler.size()>19) { degerler.append(","+tekdegerler.get(19)); }


        DisplayMetrics dm=new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width=dm.widthPixels;
        int heigth =dm.heightPixels;

        getWindow().setLayout((int)(width*.4),(int)(heigth*.3));

       WindowManager.LayoutParams params=getWindow().getAttributes();
        params.gravity= Gravity.CENTER;
        params.x=0;
        params.y=0;

        getWindow().setAttributes(params);


        closedLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
            }
        });

    }


}
