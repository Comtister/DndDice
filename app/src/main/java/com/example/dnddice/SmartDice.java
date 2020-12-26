package com.example.dnddice;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SmartDice extends Fragment implements DiceRecyclerAdapter.OnClickListener,DiceRecyclerAdapter.OnLongClickListener {


    Button eklebuton;
    RecyclerView rv;
    AlertDialog.Builder builder;
    private DiceRecyclerAdapter adapter;
    View aview;
    DiceRoller dr = new DiceRoller();

    public SmartDice(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState ){
        aview=inflater.inflate(R.layout.activity_smart_dice,container,false);

        rv=(RecyclerView) aview.findViewById(R.id.zarliste);

        builder=new AlertDialog.Builder(getActivity());

        eklebuton=(Button) aview.findViewById(R.id.addbuton);

        eklebuton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),DiceAdd.class);
                startActivity(intent);
            }
        });

        adapter=new DiceRecyclerAdapter();
        adapter.setOnClickListener(this);
        adapter.setOnLongClickListener(this);

        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        rv.setAdapter(adapter);


        return aview;
    }

    public void Listele(){
        DiceDatabase db=new DiceDatabase(getActivity());
        List<CustomDice> list=db.VeriListele();
        adapter.setDiceList(list);
    }

    @Override
    public void onResume() {
        super.onResume();
        Listele();
    }

    @Override
    public void Clicked(CustomDice customDice) {

        int number2;
        int bonus2;

       String title=customDice.getTitle();
       String snumber1=customDice.getNumber();
       int number1=Integer.parseInt(snumber1);
       String type1=customDice.getType();
       String sbonus1=customDice.getBonus();
       int bonus1=Integer.parseInt(sbonus1);
       String snumber2=customDice.getNumber2();
       if(snumber2.equals("")){
            number2=0;
       }else {
            number2=Integer.parseInt(snumber2);
       }

       String type2=customDice.getType2();
       String sbonus2=customDice.getBonus2();
       if(sbonus2.equals("")) {
            bonus2=0;
       }else{
            bonus2=Integer.parseInt(sbonus2);
       }

        dr.ZarAtCustom(title,number1,type1,bonus1,number2,type2,bonus2,getActivity());




    }

    @Override
    public void LongClicked(final CustomDice customDice) {
        builder.setMessage("asdas").setTitle("dasdasd");
        builder.setMessage("Delete Saved Dice ?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        DiceDatabase db=new DiceDatabase(getActivity());
                        db.VeriSil(customDice.getId());
                        Listele();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

        AlertDialog alert=builder.create();
        alert.setTitle("Alert");
        alert.show();

    }
}
