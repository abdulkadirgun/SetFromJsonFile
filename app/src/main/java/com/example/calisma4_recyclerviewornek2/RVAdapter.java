package com.example.calisma4_recyclerviewornek2;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.MyViewHolder>{
    private final Context mContext;
    private final List<Object> depo;

    public RVAdapter(Context mContext, List<Object> depo) {
        this.mContext = mContext;
        this.depo = depo;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView id;
        private TextView title;
        private TextView fact;
        private TextView source;
        private CardView card;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            id = (TextView) itemView.findViewById(R.id.satirYazi);
            title = (TextView) itemView.findViewById(R.id.satirYazi2);
            fact = (TextView) itemView.findViewById(R.id.satirYazi3);
            source = (TextView) itemView.findViewById(R.id.satirYazi4);
            card = (CardView) itemView.findViewById(R.id.satirCardView);

        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        try {
            View layoutView = LayoutInflater.from(parent.getContext()).inflate(
                    R.layout.card_tasarim, parent, false);

            return new MyViewHolder((layoutView));

        }catch (Exception e){
            Log.d("HATA", "onCreateViewHolder: ");
            return null;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        try {
            MyViewHolder itemViewHolder = (MyViewHolder) holder;
            System.out.println("hata1");
            System.out.println(depo);
            Card mCard = (Card) depo.get(position);
            System.out.println("hata2");

            itemViewHolder.id.setText(mCard.getId());
            System.out.println("hata3");

            itemViewHolder.title.setText(mCard.getTitle());
            itemViewHolder.fact.setText(mCard.getFact());
            itemViewHolder.source.setText(mCard.getSource());
            System.out.println("hata4");
            System.out.println("onBindViewHolder");
            itemViewHolder.card.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(mContext, itemViewHolder.title.getText() , Toast.LENGTH_SHORT).show();
                }
            });
        }catch (Exception e){
            Log.d("HATA", "onBindViewHolder'da",e);
        }

    }

    @Override
    public int getItemCount() {
        return depo.size();
    }


}
