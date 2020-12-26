package com.example.dnddice;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Random;

public class DiceRoller {

    int kat=1;
    int ek=0;
    int zar;
    int i=0;

    int zare;
    int j=0;
    int zar1;
    int zar2;
    int zart;

    Dictionary<String, Integer> zar_tip_deger = new Hashtable<String, Integer>();
    Dictionary<String, String> zar_tip = new Hashtable<String, String>();
    Dictionary<String, Integer> zar_tip_custom = new Hashtable<String, Integer>();

    DiceRoller(){

        zar_tip_deger.put("ibutond4",4);
        zar_tip_deger.put("ibutond6",6);
        zar_tip_deger.put("ibutond8",8);
        zar_tip_deger.put("ibutond10",10);
        zar_tip_deger.put("ibutond12",12);
        zar_tip_deger.put("ibutond20",20);
        zar_tip_deger.put("ibutond100",100);

        zar_tip.put("ibutond4","D4");
        zar_tip.put("ibutond6","D6");
        zar_tip.put("ibutond8","D8");
        zar_tip.put("ibutond10","D10");
        zar_tip.put("ibutond12","D12");
        zar_tip.put("ibutond20","D20");
        zar_tip.put("ibutond100","D100");

        zar_tip_custom.put("d4",4);
        zar_tip_custom.put("d6",6);
        zar_tip_custom.put("d8",8);
        zar_tip_custom.put("d10",10);
        zar_tip_custom.put("d12",12);
        zar_tip_custom.put("d20",20);
        zar_tip_custom.put("d100",100);

    }

    public void ZarAtCustom(String title,int number1,String type1,int bonus1,int number2,String type2,int bonus2,Activity activity){


        if(type2.equals("")){


            ArrayList<String> cokdegerler=new ArrayList<String>();

            Bundle dizi=new Bundle();
            dizi.putSerializable("cokdegerler",cokdegerler);

            Intent intent=new Intent(activity,PopupC.class);

            Random random=new Random();
            zare=random.nextInt(zar_tip_custom.get(type1))+1;

            String ilkzar=Integer.toString(zare);
            cokdegerler.add(ilkzar);

            if(number1>1){
                for(;j<number1-1;j++){
                    int ikzar=random.nextInt(zar_tip_custom.get(type1))+1;

                    String sikzar=Integer.toString(ikzar);
                    cokdegerler.add(sikzar);

                    zare+=ikzar;
                }

            }
            intent.putExtra("dizi",dizi);
            zare+=bonus1;
            String szar=Integer.toString(zare);

            if(zare<=0){
                Toast.makeText(activity,"Dice value cannot be less than zero",Toast.LENGTH_SHORT).show();
                //return;
            }


            intent.putExtra("isim",title);
            intent.putExtra("deger",szar);
            activity.startActivity(intent);

            j=0;
            zare=0;


        }else{

            ArrayList<String> cokdegerler=new ArrayList<String>();

            Bundle dizi=new Bundle();
            dizi.putSerializable("cokdegerler",cokdegerler);

            //ilk zar
            Intent intent=new Intent(activity,PopupC.class);

           Random random=new Random();
            zare=random.nextInt(zar_tip_custom.get(type1))+1;
            String ilkzar=Integer.toString(zare);
            cokdegerler.add(ilkzar);
            if(number1>1){
                for(;j<number1-1;j++){
                    int ikzar=random.nextInt(zar_tip_custom.get(type1))+1;
                    String sikzar=Integer.toString(ikzar);
                    cokdegerler.add(sikzar);
                    zare+=ikzar;
                }

            }
            zare+=bonus1;
            zar1=zare;

            j=0;
            zare=0;

            //ikinci zar
            zare=random.nextInt(zar_tip_custom.get(type2))+1;
            ilkzar=Integer.toString(zare);
            cokdegerler.add(ilkzar);
            if(number2>1){
                for(;j<number2-1;j++){
                    int ikzar=random.nextInt(zar_tip_custom.get(type2))+1;
                    String sikzar=Integer.toString(ikzar);
                    cokdegerler.add(sikzar);
                    zare+=ikzar;
                }

            }
            zare+=bonus2;
            zar2=zare;

            zart=zar1+zar2;
            if(zart<=0){
                Toast.makeText(activity,"Dice value cannot be less than zero",Toast.LENGTH_SHORT).show();
                //return;
            }

            String szar=Integer.toString(zart);

            intent.putExtra("isim",title);
            intent.putExtra("deger",szar);
            intent.putExtra("dizi",dizi);
            activity.startActivity(intent);

        }

        j=0;
        zare=0;
        zar1=0;
        zar2=0;
        zart=0;


    }


    public void ZarAt(Activity activity, String id){

        ArrayList<String> tekdegerlerd=new ArrayList<String>();

        Bundle dizi=new Bundle();
        dizi.putSerializable("tekdegerler",tekdegerlerd);

        Intent intent = new Intent(activity, Popup.class);
        Random random = new Random();

        zar = random.nextInt(zar_tip_deger.get(id)) + 1;
        String ilkzar=Integer.toString(zar);
        tekdegerlerd.add(ilkzar);

        if(kat>1){
            for(;i<kat-1;i++){
                int ikzar=random.nextInt(zar_tip_deger.get(id))+1;

                String sikzar=Integer.toString(ikzar);

                tekdegerlerd.add(sikzar);

                zar+=ikzar;
            }

        }
        intent.putExtra("dizi",dizi);
        zar += ek;
        if(zar<=0){
            Toast.makeText(activity,"Dice value cannot be less than zero",Toast.LENGTH_SHORT).show();
            //return;
        }
        String szar = Integer.toString(zar);

        intent.putExtra("deger", szar);
        if(ek>0){
            intent.putExtra("isim", kat+zar_tip.get(id)+"+"+ek);

        }
        else if(ek==0){
            intent.putExtra("isim", kat+zar_tip.get(id));
        }
        else{
            intent.putExtra("isim", kat+zar_tip.get(id)+ek);
        }

        activity.startActivity(intent);
        zar=0;
        i=0;


    }


    public String ZarKatla(){

        kat+=1;
        String skat=Integer.toString(kat)+"D";
        return skat;

    }

    public String ZarEksilt(Activity activity){
        String skat = "";

        if(kat==1){
            Toast.makeText(activity,"Dice count cannot be less than one",Toast.LENGTH_LONG).show();
            skat=Integer.toString(kat)+"D";
        }else{
            kat-=1;
            skat=Integer.toString(kat)+"D";

        }
        return skat;
    }



    public String ZarBonusArttir(){

        ek+=1;
        String sek=Integer.toString(ek);
        if(ek<0){
          //sek = "-"+ek;
        }else{
            sek = "+"+ek;

        }
       return sek;
    }
    public String ZarBonusEksilt(){

        ek-=1;
        String sek=Integer.toString(ek);
        if(ek<0){
            //sek = "-"+ek;
        }else{
            sek = "+"+ek;

        }
        return sek;

    }

}
