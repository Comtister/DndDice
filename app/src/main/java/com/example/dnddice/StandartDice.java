package com.example.dnddice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class StandartDice extends Fragment {



    ImageButton butond4;
    ImageButton butond6;
    ImageButton butond8;
    ImageButton butond10;
    ImageButton butond12;
    ImageButton butond20;
    ImageButton butond100;
    Button butoneksi;
    Button butonarti;
    Button butoneksi1;
    Button butonarti1;
    TextView katlatext;
    TextView arttırtext;
    View aview;

    final DiceRoller dr = new DiceRoller();


    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState ){

        aview=inflater.inflate(R.layout.activity_standart_dice,container,false);

        butond4=(ImageButton) aview.findViewById(R.id.ibutond4);
        butond6=(ImageButton) aview.findViewById(R.id.ibutond6);
        butond8=(ImageButton) aview.findViewById(R.id.ibutond8);
        butond10=(ImageButton) aview.findViewById(R.id.ibutond10);
        butond12=(ImageButton) aview.findViewById(R.id.ibutond12);
        butond20=(ImageButton) aview.findViewById(R.id.ibutond20);
        butond100=(ImageButton) aview.findViewById(R.id.ibutond100);

        butonarti=(Button) aview.findViewById(R.id.buttonarti);
        butoneksi=(Button) aview.findViewById(R.id.buttoneksi);
        butonarti1=(Button) aview.findViewById(R.id.buttonarti1);
        butoneksi1=(Button) aview.findViewById(R.id.buttoneksi1);

        katlatext=(TextView) aview.findViewById(R.id.zarkatlatext);
        arttırtext=(TextView) aview.findViewById(R.id.zararttirtext);



        butond4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dr.ZarAt(getActivity(),getResources().getResourceEntryName(view.getId()));

            }
        });


        butond6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dr.ZarAt(getActivity(),getResources().getResourceEntryName(view.getId()));

            }
        });


        butond8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dr.ZarAt(getActivity(),getResources().getResourceEntryName(view.getId()));

            }
        });


        butond10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dr.ZarAt(getActivity(),getResources().getResourceEntryName(view.getId()));

            }
        });


        butond12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dr.ZarAt(getActivity(),getResources().getResourceEntryName(view.getId()));

            }
        });


        butond20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dr.ZarAt(getActivity(),getResources().getResourceEntryName(view.getId()));

            }
        });


        butond100.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dr.ZarAt(getActivity(),getResources().getResourceEntryName(view.getId()));

            }
        });


        butonarti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                katlatext.setText(dr.ZarKatla());
            }
        });


        butoneksi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                katlatext.setText(dr.ZarEksilt(getActivity()));

            }
        });


        butoneksi1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    arttırtext.setText(dr.ZarBonusEksilt());

            }
        });

        butonarti1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    arttırtext.setText(dr.ZarBonusArttir());

            }
        });


       return aview;
    }






}
