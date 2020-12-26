package com.example.dnddice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintSet;

import android.app.Activity;
import android.content.Context;
import android.location.LocationManager;
import android.media.Image;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewDebug;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class DiceAdd extends AppCompatActivity{


    EditText baslik;
    String baslikdata;

    Button zar1tipeksi;
    Button zar1tipatri;
    Button zar1sayieksi;
    Button zar1sayiarti;
    Button zar1bonuseksi;
    Button zar1bonusarti;
    Button zarekle;

    Button zar2tipeksi;
    Button zar2tiparti;
    Button zar2sayieksi;
    Button zar2sayiarti;
    Button zar2bonuseksi;
    Button zar2bonusarti;
    Button zarcikar;

    TextView zar1tip;
    TextView zar1sayi;
    TextView zar1bonus;

    TextView zar2tip;
    TextView zar2sayi;
    TextView zar2bonus;

    ImageView zar1imaji;
    ImageView zar2imaji;


    int[] zarimajlar = {R.drawable.d4,R.drawable.d6,R.drawable.d8,
    R.drawable.d10,R.drawable.d12,R.drawable.d20,R.drawable.d100};

    String[] zardegerler = {"d4","d6","d8","d10","d12","d20","d100"};

    int imagecursor1 = 0;
    int degercursor1 = 0;

    int imagecursor2 = 0;
    int degercursor2 = 0;

    int zar1sayisi = 1;
    String zar1sayisiS = "1";

    int zar1bonusu = 0;
    String zar1bonusuS = "+0";

    int zar2sayisi = 1;
    String zar2sayisiS = "1";

    int zar2bonusu = 0;
    String zar2bonusuS = "+0";



    boolean ciftzar = false;

    Button kaybuton;
    Button iptalbuton;


    Runnable run;
    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dice_add);

        baslik = (EditText) findViewById(R.id.basliktxt);

        zar1tipatri = (Button) findViewById(R.id.zar1tipart);
        zar1tipeksi = (Button) findViewById(R.id.zar1tipeks);
        zar1sayieksi = (Button) findViewById(R.id.zar1sayieks);
        zar1sayiarti = (Button) findViewById(R.id.zar1sayiart);
        zar1bonusarti = (Button) findViewById(R.id.zar1bonart);
        zar1bonuseksi = (Button) findViewById(R.id.zar1boneks);

        zar2tiparti = (Button) findViewById(R.id.zar2tipart);
        zar2tipeksi = (Button) findViewById(R.id.zar2tipeks);
        zar2sayieksi = (Button) findViewById(R.id.zar2sayeks);
        zar2sayiarti = (Button) findViewById(R.id.zar2sayart);
        zar2bonusarti = (Button) findViewById(R.id.zar2bonart);
        zar2bonuseksi = (Button) findViewById(R.id.zar2boneks);

        zarekle = (Button) findViewById(R.id.adddie);
        zarcikar = (Button) findViewById(R.id.deletedie);

        zar1tip = (TextView) findViewById(R.id.zar1tip);
        zar1sayi = (TextView) findViewById(R.id.zar1sayi);
        zar1bonus = (TextView) findViewById(R.id.zar1bonus);

        zar2tip = (TextView) findViewById(R.id.zar2tip);
        zar2sayi = (TextView) findViewById(R.id.zar2sayi);
        zar2bonus = (TextView) findViewById(R.id.zar2bonus);

        zar1imaji = (ImageView) findViewById(R.id.zar1img);
        zar2imaji = (ImageView) findViewById(R.id.zar2img);

        kaybuton=(Button) findViewById(R.id.kaybuton);
        iptalbuton=(Button) findViewById(R.id.iptalbuton);

        handler = new Handler();

        //*****************************************************

        zar1tipeksi.setText("<");
        zar2tipeksi.setText("<");




        zar2imaji.setVisibility(View.INVISIBLE);
        zar2tip.setVisibility(View.INVISIBLE);
        zar2tipeksi.setVisibility(View.INVISIBLE);
        zar2tiparti.setVisibility(View.INVISIBLE);
        zar2sayi.setVisibility(View.INVISIBLE);
        zar2sayiarti.setVisibility(View.INVISIBLE);
        zar2sayieksi.setVisibility(View.INVISIBLE);
        zar2bonus.setVisibility(View.INVISIBLE);
        zar2bonusarti.setVisibility(View.INVISIBLE);
        zar2bonuseksi.setVisibility(View.INVISIBLE);
        zarcikar.setVisibility(View.INVISIBLE);

        zar2tip.setText("");
        zar2sayi.setText("");
        zar2bonus.setText("");






        zarekle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ciftzar = true;


                zar2imaji.setVisibility(View.VISIBLE);
                zar2tip.setVisibility(View.VISIBLE);
                zar2tipeksi.setVisibility(View.VISIBLE);
                zar2tiparti.setVisibility(View.VISIBLE);
                zar2sayi.setVisibility(View.VISIBLE);
                zar2sayiarti.setVisibility(View.VISIBLE);
                zar2sayieksi.setVisibility(View.VISIBLE);
                zar2bonus.setVisibility(View.VISIBLE);
                zar2bonusarti.setVisibility(View.VISIBLE);
                zar2bonuseksi.setVisibility(View.VISIBLE);
                zarcikar.setVisibility(View.VISIBLE);

                zar2tip.setText(zardegerler[degercursor2]);
                zar2sayi.setText(zar2sayisiS);
                zar2sayi.append("d");
                zar2bonus.setText(zar2bonusuS);


                zarekle.setEnabled(false);
            }
        });

        zarcikar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ciftzar = false;


                zar2imaji.setVisibility(View.INVISIBLE);
                zar2tip.setVisibility(View.INVISIBLE);
                zar2tipeksi.setVisibility(View.INVISIBLE);
                zar2tiparti.setVisibility(View.INVISIBLE);
                zar2sayi.setVisibility(View.INVISIBLE);
                zar2sayiarti.setVisibility(View.INVISIBLE);
                zar2sayieksi.setVisibility(View.INVISIBLE);
                zar2bonus.setVisibility(View.INVISIBLE);
                zar2bonusarti.setVisibility(View.INVISIBLE);
                zar2bonuseksi.setVisibility(View.INVISIBLE);
                zarcikar.setVisibility(View.INVISIBLE);

                zar2tip.setText("");
                zar2sayi.setText("");
                zar2bonus.setText("");


                zarekle.setEnabled(true);
            }
        });



        zar1tipatri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(imagecursor1 < 6 && degercursor1 < 6 ){

                    degercursor1 += 1;
                    imagecursor1 += 1;

                    zar1imaji.setImageResource(zarimajlar[imagecursor1]);

                    if(zardegerler[degercursor1].equals("d100")){
                        zar1tip.setTextSize(22);
                        zar1tip.setText(zardegerler[degercursor1]);
                    }else{
                        zar1tip.setText(zardegerler[degercursor1]);
                    }



                }else{
                    return;
                }



            }
        });


        zar1tipeksi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                if(imagecursor1 > 0 && degercursor1 > 0){

                    degercursor1 -= 1;
                    imagecursor1 -= 1;

                    zar1imaji.setImageResource(zarimajlar[imagecursor1]);
                    zar1tip.setText(zardegerler[degercursor1]);


                }


            }
        });




        zar1sayieksi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(zar1sayisi <= 1){
                    Toast.makeText(getApplicationContext(),"Dice Number Cannot Be Less Than One",Toast.LENGTH_LONG).show();
                    return;
                }else{


                    zar1sayisi -= 1;
                    zar1sayisiS = String.valueOf(zar1sayisi);
                    zar1sayi.setText(zar1sayisiS);
                    zar1sayi.append("d");
                }


            }
        });

        zar1sayiarti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {




                zar1sayisi += 1;
                zar1sayisiS = String.valueOf(zar1sayisi);
                zar1sayi.setText(zar1sayisiS);
                zar1sayi.append("d");

            }
        });




        zar1bonuseksi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                zar1bonusu -= 1;
                zar1bonusuS = String.valueOf(zar1bonusu);

                if(zar1bonusu >= 0){

                    zar1bonusuS = "+" + zar1bonusuS;

                    zar1bonus.setText(zar1bonusuS);
                }else{
                    zar1bonus.setText(zar1bonusuS);
                }




            }
        });


        zar1bonusarti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                zar1bonusu += 1;
                zar1bonusuS = String.valueOf(zar1bonusu);

                if(zar1bonusu >= 0){
                    zar1bonusuS = "+" + zar1bonusuS;

                    zar1bonus.setText(zar1bonusuS);
                }else{
                    zar1bonus.setText(zar1bonusuS);
                }



            }
        });







        //*******************************************





        zar2tiparti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(imagecursor2 < 6 && degercursor2 < 6 ){

                    degercursor2 += 1;
                    imagecursor2 += 1;

                    zar2imaji.setImageResource(zarimajlar[imagecursor2]);

                    if(zardegerler[degercursor2].equals("d100")){
                        zar2tip.setTextSize(22);
                        zar2tip.setText(zardegerler[degercursor2]);
                    }else{
                        zar2tip.setText(zardegerler[degercursor2]);
                    }



                }else{
                    return;
                }



            }
        });


        zar2tipeksi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                if(imagecursor2 > 0 && degercursor2 > 0){

                    degercursor2 -= 1;
                    imagecursor2 -= 1;

                    zar2imaji.setImageResource(zarimajlar[imagecursor2]);
                    zar2tip.setText(zardegerler[degercursor2]);


                }


            }
        });




        zar2sayieksi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(zar2sayisi <= 1){
                    Toast.makeText(getApplicationContext(),"Dice Number Cannot Be Less Than One",Toast.LENGTH_LONG).show();
                    return;
                }else{


                    zar2sayisi -= 1;
                    zar2sayisiS = String.valueOf(zar2sayisi);
                    zar2sayi.setText(zar2sayisiS);
                    zar2sayi.append("d");
                }


            }
        });

        zar2sayiarti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {




                zar2sayisi += 1;
                zar2sayisiS = String.valueOf(zar2sayisi);
                zar2sayi.setText(zar2sayisiS);
                zar2sayi.append("d");

            }
        });




        zar2bonuseksi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                zar2bonusu -= 1;
                zar2bonusuS = String.valueOf(zar2bonusu);

                if(zar2bonusu >= 0){

                    zar2bonusuS = "+" + zar2bonusuS;

                    zar2bonus.setText(zar2bonusuS);

                }else{
                    zar2bonus.setText(zar2bonusuS);
                }




            }
        });


        zar2bonusarti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                zar2bonusu += 1;
                zar2bonusuS = String.valueOf(zar2bonusu);

                if(zar2bonusu >= 0){
                    zar2bonusuS = "+" + zar2bonusuS;

                    zar2bonus.setText(zar2bonusuS);
                }else{
                    zar2bonus.setText(zar2bonusuS);
                }



            }
        });







        kaybuton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                try {

                    baslikdata = baslik.getText().toString();

                    if(baslikdata.equals("")){
                        Toast.makeText(getApplicationContext(),"Title is missing", Toast.LENGTH_LONG).show();
                        return;
                    }

                    DiceDatabase db=new DiceDatabase(DiceAdd.this);

                    if(ciftzar == true){
                        db.VeriEkle(baslikdata,zar1sayisiS,zardegerler[degercursor1],zar1bonusuS,zar2sayisiS,zardegerler[degercursor2],zar2bonusuS);
                    }else{
                        db.VeriEkle(baslikdata,zar1sayisiS,zardegerler[degercursor1],zar1bonusuS,"","","");
                    }

                    finish();



                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });


        iptalbuton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

}
