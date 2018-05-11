package com.demo.merchandisemot.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.demo.architect.data.model.offline.BonusEntity;
import com.goitho.employeeapp.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Skull on 27/11/2017.
 */

public class WalletPayAdapter extends RecyclerView.Adapter<WalletPayAdapter.WalletPayViewHolder> {

    private ArrayList<BonusEntity> list;
    private final OnItemClickListener listener;
    private Context context;

    public WalletPayAdapter(ArrayList<BonusEntity> list, Context context, OnItemClickListener listener) {
        this.list = list;
        this.listener = listener;
        this.context = context;
    }

    public void setData(ArrayList<BonusEntity> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @Override
    public WalletPayViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_row_detail_money_bonus, parent, false);
        WalletPayViewHolder holder = new WalletPayViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(WalletPayViewHolder holder, int position) {
        if (list != null && 0 <= position && position < list.size()) {
            setDataToViews(holder, position);
            holder.bind(list.get(position), listener);
        }

    }

    private void setDataToViews(WalletPayViewHolder holder, int position) {

        holder.txtMoneyBonus.setText("+ "+list.get(position).getBonus()+" Ví thanh toán");
        holder.txtDescription.setText(list.get(position).getDescription());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class WalletPayViewHolder extends RecyclerView.ViewHolder {

        private TextView txtMoneyBonus;
        private TextView txtDescription;

        private WalletPayViewHolder(View v) {
            super(v);
            txtMoneyBonus = (TextView) v.findViewById(R.id.text_item_money_bonus);
            txtDescription = (TextView) v.findViewById(R.id.text_item_description);



        }

        private void bind(final BonusEntity item, final OnItemClickListener listener) {

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(item);
                }
            });
        }
    }

    public interface OnItemClickListener {
        void onItemClick(BonusEntity item);
    }
}
