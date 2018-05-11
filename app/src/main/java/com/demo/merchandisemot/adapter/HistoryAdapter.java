package com.demo.merchandisemot.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.demo.architect.data.model.OrderEntity;
import com.demo.architect.data.model.OrderEntity;
import com.goitho.employeeapp.R;

import java.util.List;

/**
 * Created by Skull on 14/12/2017.
 */

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.HistoryViewHolder> {

    private List<OrderEntity> list;
    private final OnItemClickListener listener;
    private Context context;

    public HistoryAdapter(List<OrderEntity> list, Context context, OnItemClickListener listener) {
        this.list = list;
        this.context = context;
        this.listener = listener;
    }

//    public HistoryAdapter(ArrayList<HistoryEntity> list, Context context, OnItemClickListener listener) {
//        this.list = list;
//        this.listener = listener;
//        this.context = context;
//    }

    public void setData(List<OrderEntity> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    public void addData(List<OrderEntity> list) {
        this.list.addAll(list);
        notifyDataSetChanged();
    }

    public void addData(OrderEntity entity) {
        this.list.add(entity);
        notifyDataSetChanged();
    }

    @Override
    public HistoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_history, parent, false);
        HistoryViewHolder holder = new HistoryViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(HistoryViewHolder holder, int position) {
        if (list != null && 0 <= position && position < list.size()) {
            setDataToViews(holder, position);
            //holder.bind(list.get(position), listener,  position);
            holder.bind(list.get(position), position);
        }

    }

    private void setDataToViews(HistoryViewHolder holder, int position) {
        //holder.txtAddress.setText(list.get(position).get());
        holder.txtAction.setText(list.get(position).getOrderContent());
        if(list.get(position).getPrice() == null) {
            holder.txtPrice.setText("0 vnđ");
        } else {
            holder.txtPrice.setText(String.valueOf(list.get(position).getPrice()) + " vnđ");
        }
    }



    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    public class HistoryViewHolder extends RecyclerView.ViewHolder {
        private TextView txtAction;
        private TextView txtAddress;
        private TextView txtPrice;


        private HistoryViewHolder(View v) {
            super(v);
//            txtProductOld = (TextView) v.findViewById(R.id.txt_product_old);
//            txtProductNew = (TextView) v.findViewById(R.id.txt_product_new);
//            txtProductTitle = (TextView) v.findViewById(R.id.txt_title_product);
            txtAction = v.findViewById(R.id.txt_action);
            txtAddress = v.findViewById(R.id.txt_address);
            txtPrice = v.findViewById(R.id.txt_price);

        }

//        private void bind(final HistoryEntity item, final OnItemClickListener  listener, int position) {
//
//            itemView.setOnClickListener(new View.OnClickListener() {
//                @Override public void onClick(View v) {
//                    listener.onItemClick(item, position);
//                }
//            });
//        }

        private void bind(final OrderEntity item, int position) {

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(item, position);
                }
            });
        }
    }

    public interface OnItemClickListener {
        void onItemClick(OrderEntity item, int position);
    }
}
