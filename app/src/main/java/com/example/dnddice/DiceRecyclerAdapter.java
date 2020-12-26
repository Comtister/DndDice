package com.example.dnddice;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class DiceRecyclerAdapter extends RecyclerView.Adapter<DiceRecyclerAdapter.DiceViewHolder> {

        private List<CustomDice> diceList;
        private OnClickListener onClickListener;
        private OnLongClickListener onLongClickListener;

    public DiceRecyclerAdapter(){

        }

    @NonNull
    @Override
    public DiceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.dice_list_card,parent,false);
       return new DiceViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull DiceViewHolder holder, int position) {
            final CustomDice customDice=diceList.get(position);

            holder.title.setText(customDice.getTitle());
            holder.sayi1.setText(customDice.getNumber());
            holder.tip1.setText(customDice.getType());
            holder.ek1.setText(customDice.getBonus());
            holder.sayi2.setText(customDice.getNumber2());
            holder.tip2.setText(customDice.getType2());
            holder.ek2.setText(customDice.getBonus2());

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(onClickListener!=null){
                        onClickListener.Clicked(customDice);
                    }
                }
            });

            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    if(onLongClickListener!=null){
                        onLongClickListener.LongClicked(customDice);
                    }
                    return false;
                }
            });

    }

    @Override
    public int getItemCount() {
        return diceList.size();
    }

    public static class DiceViewHolder extends RecyclerView.ViewHolder{
            public TextView title;
            public TextView sayi1;
            public TextView tip1;
            public TextView ek1;
            public TextView sayi2;
            public TextView tip2;
            public TextView ek2;
            public DiceViewHolder(View view){
                super(view);
                title=view.findViewById(R.id.title);
                sayi1=view.findViewById(R.id.sayi1);
                tip1=view.findViewById(R.id.tip1);
                ek1=view.findViewById(R.id.ek1);
                sayi2=view.findViewById(R.id.sayi2);
                tip2=view.findViewById(R.id.tip2);
                ek2=view.findViewById(R.id.ek2);
            }
    }

    public void setDiceList(List<CustomDice> list){
        this.diceList=list;
        notifyDataSetChanged();
    }

    public void setOnClickListener(OnClickListener onClickListener){
       this.onClickListener=onClickListener;
    }

    public void setOnLongClickListener(OnLongClickListener onLongClickListener ){
        this.onLongClickListener=onLongClickListener;
    }

   public interface OnClickListener{
        void Clicked(CustomDice customDice);
   }

   public interface OnLongClickListener{
        void LongClicked(CustomDice customDice);
   }

}
