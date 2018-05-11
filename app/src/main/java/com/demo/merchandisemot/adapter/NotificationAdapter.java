package com.demo.merchandisemot.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.demo.architect.data.model.NotificationEntity;
import com.goitho.employeeapp.R;

import java.util.List;

/**
 * Created by Skull on 22/03/2018.
 */

public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.NotificationViewHolder> {

    private List<NotificationEntity> list;
    private final OnItemClickListener listener;
    private Context context;

    public NotificationAdapter(List<NotificationEntity> list, Context context, OnItemClickListener listener) {
        this.list = list;
        this.listener = listener;
        this.context = context;
    }

//    public NotificationAdapter(ArrayList<NotificationEntity> list, Context context, OnItemClickListener listener) {
//        this.list = list;
//        this.listener = listener;
//        this.context = context;
//    }

    public void setData(List<NotificationEntity> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    public void addData(List<NotificationEntity> list) {
        this.list.addAll(list);
        notifyDataSetChanged();
    }

    public void addData(NotificationEntity entity) {
        this.list.add(entity);
        notifyDataSetChanged();
    }

    @Override
    public NotificationViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_notification, parent, false);
        NotificationViewHolder holder = new NotificationViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(NotificationViewHolder holder, int position) {
        if (list != null && 0 <= position && position < list.size()) {
            setDataToViews(holder, position);
            //holder.bind(list.get(position), listener,  position);
            holder.bind(list.get(position), position);
        }

    }

    private void setDataToViews(NotificationViewHolder holder, int position) {
        holder.txtDescription.setText(list.get(position).getNotificationContent());
        holder.txtTitle.setText(list.get(position).getNotificationName());
        if(list.get(position).getStatus() == 0) {
            holder.imgNew.setVisibility(View.VISIBLE);
        }
        if(list.get(position).getStatus() == 1) {
            holder.imgNew.setVisibility(View.GONE);
        }

    }



    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    public class NotificationViewHolder extends RecyclerView.ViewHolder {
        private TextView txtTitle;
        private TextView txtDescription;
        private ImageView imgNew;


        private NotificationViewHolder(View v) {
            super(v);
            txtTitle = v.findViewById(R.id.txt_title);
            txtDescription = v.findViewById(R.id.txt_description);
            imgNew = v.findViewById(R.id.img_new);

        }

        private void bind(final NotificationEntity item, int position) {

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(item, position);
                }
            });
        }
    }

    public interface OnItemClickListener {
        void onItemClick(NotificationEntity item, int position);
    }
}
