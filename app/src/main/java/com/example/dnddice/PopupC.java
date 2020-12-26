package com.example.dnddice;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.ArrayList;

public class PopupC extends Activity {

    TextView degerlerc;
    TextView textbasliki;
    TextView textdegeri;
    ConstraintLayout canceledLayout;
    int zarDeger;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.popwindowc);

        canceledLayout = (ConstraintLayout) findViewById(R.id.l2);


        degerlerc=(TextView)findViewById(R.id.degerlerc);
        textbasliki=(TextView)findViewById(R.id.textbaslikc);
        textdegeri=(TextView)findViewById(R.id.textdegerc);

        Bundle dizi=getIntent().getBundleExtra("dizi");
        ArrayList<String> cokdegerler=(ArrayList<String>) dizi.getSerializable("cokdegerler");

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
        for(int i=0;i<cokdegerler.size();i++){
            int y=Integer.parseInt(cokdegerler.get(i));
            if(y>9){

                z++;

            }
        }


        if(cokdegerler.size()>1) { degerlerc.append(cokdegerler.get(0)); degerlerc.append(","+cokdegerler.get(1)); }
        if(cokdegerler.size()>2) { degerlerc.append(","+cokdegerler.get(2)); }
        if(cokdegerler.size()>3) { degerlerc.append(","+cokdegerler.get(3)); }
        if(cokdegerler.size()>4) { degerlerc.append(","+cokdegerler.get(4)); }
        if(cokdegerler.size()>5) { degerlerc.append(","+cokdegerler.get(5)); }
        if(cokdegerler.size()>6) { degerlerc.append(","+cokdegerler.get(6)); }
        if(cokdegerler.size()>7) { degerlerc.append(","+cokdegerler.get(7)); }
        if(cokdegerler.size()>8) { degerlerc.append(","+cokdegerler.get(8)); }
        if(cokdegerler.size()>9) { degerlerc.append(","+cokdegerler.get(9)); }
        if(cokdegerler.size()>10) { degerlerc.append(","+cokdegerler.get(10)); }
        if(cokdegerler.size()>11) { degerlerc.append(","+cokdegerler.get(11)); }
        if(cokdegerler.size()>12) { degerlerc.append(","+cokdegerler.get(12)); }
        if(cokdegerler.size()>13) { degerlerc.append(","+cokdegerler.get(13)); }
        if(cokdegerler.size()>14) { degerlerc.append(","+cokdegerler.get(14)); }
        if(cokdegerler.size()>15) { degerlerc.append(","+cokdegerler.get(15)); }
        if(cokdegerler.size()>16) { degerlerc.append(","+cokdegerler.get(16)); }
        if(cokdegerler.size()>17) { degerlerc.append(","+cokdegerler.get(17)); }
        if(cokdegerler.size()>18) { degerlerc.append(","+cokdegerler.get(18)); }
        if(cokdegerler.size()>19) { degerlerc.append(","+cokdegerler.get(19)); }

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


        canceledLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });



    }
}
