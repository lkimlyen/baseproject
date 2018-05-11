package com.demo.merchandisemot.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.demo.architect.data.model.offline.ReceiveOrderEntity;
import com.goitho.employeeapp.R;
import com.goitho.employeeapp.constants.Constants;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

/**
 * Created by Skull on 25/03/2018.
 */

public class ReceiveOrderAdapter extends RecyclerView.Adapter<ReceiveOrderAdapter.ReceiveOrderViewHolder> {

    private List<ReceiveOrderEntity> list;
    private final OnItemClickListener listener;
    private Context context;

    public ReceiveOrderAdapter(List<ReceiveOrderEntity> list, Context context, OnItemClickListener listener) {
        this.list = list;
        this.listener = listener;
        this.context = context;
    }

//    public NewOrderAdapter(ArrayList<NewOrderEntity> list, Context context, OnItemClickListener listener) {
//        this.list = list;
//        this.listener = listener;
//        this.context = context;
//    }

    public void setData(List<ReceiveOrderEntity> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    public void addData(List<ReceiveOrderEntity> list) {
        this.list.addAll(list);
        notifyDataSetChanged();
    }

    public void addData(ReceiveOrderEntity entity) {
        this.list.add(entity);
        notifyDataSetChanged();
    }

    @Override
    public ReceiveOrderViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_receive_order, parent, false);
        ReceiveOrderViewHolder holder = new ReceiveOrderViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ReceiveOrderViewHolder holder, int position) {
        if (list != null && 0 <= position && position < list.size()) {
            setDataToViews(holder, position);
            //holder.bind(list.get(position), listener,  position);
            holder.bind(list.get(position), position);
        }

    }

    private void setDataToViews(ReceiveOrderViewHolder holder, int position) {
        holder.txtAddress.setText(list.get(position).getCustomerAddress());
        holder.txtTitle.setText(list.get(position).getTitle());


        DateFormat df = new SimpleDateFormat("HH:mm:ss MM/dd/yyyy", Locale.US);
        if (list.get(position).getDate() != null) {
            String stringDate = df.format(list.get(position).getDate());
            holder.txtDate.setText(stringDate);
        } else {
            holder.txtDate.setVisibility(View.GONE);
        }
        switch (list.get(position).getState()) {
            case Constants.ORDER_STATE_NOT_CONTACTED_YET:
                holder.txtStatus.setText(context.getResources().getString(R.string.text_not_contact));
                holder.txtStatus.setTextColor(context.getResources().getColor(R.color.warmGreyFive));
                holder.txtDate.setTextColor(context.getResources().getColor(R.color.warmGreyFive));
                break;
            case Constants.ORDER_STATE_WAITING_FOR_CONSTRUCTION:
                holder.txtStatus.setText(context.getResources().getString(R.string.text_not_success));
                holder.txtStatus.setTextColor(context.getResources().getColor(R.color.tomatoTwo));
                holder.txtDate.setTextColor(context.getResources().getColor(R.color.tomatoTwo));
                break;
            case Constants.ORDER_STATE_WAITING_FOR_SURVEY:
                holder.txtStatus.setText(context.getResources().getString(R.string.text_wait_consider));
                holder.txtStatus.setTextColor(context.getResources().getColor(R.color.squash));
                holder.txtDate.setTextColor(context.getResources().getColor(R.color.squash));
                break;
            case Constants.ORDER_STATE_GIVING_QUOTATION_SUCCESSFULLY:
                holder.txtStatus.setText(context.getResources().getString(R.string.text_wait_construction));
                holder.txtStatus.setTextColor(context.getResources().getColor(R.color.lightNavyFour));
                holder.txtDate.setTextColor(context.getResources().getColor(R.color.lightNavyFour));
                break;
            default:
                holder.txtStatus.setText(context.getResources().getString(R.string.text_not_contact));
                holder.txtStatus.setTextColor(context.getResources().getColor(R.color.warmGreyFive));
                holder.txtDate.setTextColor(context.getResources().getColor(R.color.warmGreyFive));
                break;
        }
    }


    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    public class ReceiveOrderViewHolder extends RecyclerView.ViewHolder {
        private TextView txtTitle;
        private TextView txtAddress;
        private TextView txtStatus;
        private TextView txtDate;
        private LinearLayout lnV1;
        private LinearLayout lnV2;
        private LinearLayout lnV3;


        private ReceiveOrderViewHolder(View v) {
            super(v);
            txtTitle = v.findViewById(R.id.txt_title);
            txtAddress = v.findViewById(R.id.txt_address);
            txtDate = v.findViewById(R.id.txt_date);
            txtStatus = v.findViewById(R.id.txt_status);
            lnV1 = v.findViewById(R.id.ln_view1);
            lnV2 = v.findViewById(R.id.ln_view2);
            lnV3 = v.findViewById(R.id.ln_view3);
        }

        private void bind(final ReceiveOrderEntity item, int position) {

//            itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    listener.onItemClick(item, position);
//                }
//            });
            lnV1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(item, position, 1);
                }
            });
            lnV2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(item, position, 1);
                }
            });
            lnV3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(item, position, 2);
                }
            });


        }
    }

    public interface OnItemClickListener {

        void onItemClick(ReceiveOrderEntity item, int position, int type);
    }
}