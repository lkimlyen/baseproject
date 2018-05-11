package com.demo.merchandisemot.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.demo.architect.data.model.OrderEntity;
import com.demo.architect.data.model.offline.NewOrderEntity;
import com.goitho.employeeapp.R;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

/**
 * Created by Skull on 25/03/2018.
 */

public class NewOrderAdapter extends RecyclerView.Adapter<NewOrderAdapter.NewOrderViewHolder> {

    private List<OrderEntity> list;
    private final OnItemClickListener listener;
    private Context context;

    public NewOrderAdapter(List<OrderEntity> list, Context context, OnItemClickListener listener) {
        this.list = list;
        this.listener = listener;
        this.context = context;
    }

//    public NewOrderAdapter(ArrayList<NewOrderEntity> list, Context context, OnItemClickListener listener) {
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
    public NewOrderViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_new_order, parent, false);
        NewOrderViewHolder holder = new NewOrderViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(NewOrderViewHolder holder, int position) {
        if (list != null && 0 <= position && position < list.size()) {
            setDataToViews(holder, position);
            //holder.bind(list.get(position), listener,  position);
            holder.bind(list.get(position), position);
        }

    }

    private void setDataToViews(NewOrderViewHolder holder, int position) {
        holder.txtID.setText(list.get(position).getCustomerAddress());
        holder.txtTitle.setText(TextUtils.isEmpty(list.get(position).getOrderContent()) ?
                list.get(position).getOrderId() : list.get(position).getOrderContent());
        if (list.get(position).isSubcribe()) {
            holder.imgCheck.setVisibility(View.VISIBLE);
            holder.layoutSubcribe.setVisibility(View.GONE);
        } else {
            holder.imgCheck.setVisibility(View.GONE);
            holder.layoutSubcribe.setVisibility(View.VISIBLE);
        }

        if (list.get(position).getSurveyTime() != null) {
            DateFormat df = new SimpleDateFormat("HH:mm:ss MM/dd/yyyy", Locale.US);
            String stringDate = df.format(list.get(position).getContructionTime());
            holder.txtDate.setText(stringDate);
        }
    }


    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    public class NewOrderViewHolder extends RecyclerView.ViewHolder {
        private TextView txtTitle;
        private TextView txtID;
        private ImageView imgCheck;
        private LinearLayout layoutSubcribe;
        private TextView txtDate;


        private NewOrderViewHolder(View v) {
            super(v);
            txtTitle = v.findViewById(R.id.txt_title);
            txtID = v.findViewById(R.id.txt_id);
            imgCheck = v.findViewById(R.id.img_check);
            layoutSubcribe = v.findViewById(R.id.layout_subscribe);
            txtDate = v.findViewById(R.id.txt_date);
            ;

        }

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
