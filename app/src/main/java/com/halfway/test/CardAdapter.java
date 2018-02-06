package com.halfway.test;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.List;

public class CardAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

        Context context;
        public List<Card> items;

        public CardAdapter(Context context, List<Card> items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder vh;
        View v1 = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item, parent, false);
        vh = new CardViewHolder(v1);
        return vh;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
                final CardViewHolder cardViewHolder = (CardViewHolder) holder;
                final Card card = (Card) items.get(position);
                cardViewHolder.tvName.setText(card.getStock().get(position).getName());
                cardViewHolder.tvVolume.setText(String.valueOf(card.getStock().get(position).getVolume()));
                String priceFormat = new DecimalFormat("#0.00").format(card.getStock().get(position).getPrice().getAmount());
                cardViewHolder.tvAmount.setText(priceFormat);

    }

    @Override
    public int getItemCount() {
        if (items == null)
            return 0;
        return items.size();
    }

    class CardViewHolder extends RecyclerView.ViewHolder {

        TextView tvName;
        TextView tvVolume;
        TextView tvAmount;

        public CardViewHolder(View itemView) {
            super(itemView);

            tvName = (TextView) itemView.findViewById(R.id.tv_name);
            tvVolume = (TextView) itemView.findViewById(R.id.tv_volume);
            tvAmount = (TextView) itemView.findViewById(R.id.tv_amount);
        }

    }

}
