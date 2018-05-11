package com.demo.merchandisemot.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.demo.architect.data.model.PromotionEntity;
import com.goitho.employeeapp.R;

import java.util.List;

/**
 * Created by Skull on 25/03/2018.
 */

public class PromotionAdapter extends RecyclerView.Adapter<PromotionAdapter.PromotionViewHolder> {

    private List<PromotionEntity> list;
    private final OnItemClickListener listener;
    private Context context;

    public PromotionAdapter(List<PromotionEntity> list, Context context, OnItemClickListener listener) {
        this.list = list;
        this.listener = listener;
        this.context = context;
    }

//    public PromotionAdapter(ArrayList<PromotionEntity> list, Context context, OnItemClickListener listener) {
//        this.list = list;
//        this.listener = listener;
//        this.context = context;
//    }

    public void setData(List<PromotionEntity> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    public void addData(List<PromotionEntity> list) {
        this.list.addAll(list);
        notifyDataSetChanged();
    }

    public void addData(PromotionEntity entity) {
        this.list.add(entity);
        notifyDataSetChanged();
    }

    @Override
    public PromotionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_promotion, parent, false);
        PromotionViewHolder holder = new PromotionViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(PromotionViewHolder holder, int position) {
        if (list != null && 0 <= position && position < list.size()) {
            setDataToViews(holder, position);
            //holder.bind(list.get(position), listener,  position);
            holder.bind(list.get(position), position);
        }

    }

    private void setDataToViews(PromotionViewHolder holder, int position) {
        holder.txtTitle.setText(list.get(position).getPromotionName());
        holder.txtDescription.setText(context.getString(R.string.text_promotion)+" " + list.get(position).getBonus() + " đ");
        if(list.get(position).getStatus() == 0)
            holder.imgNew.setVisibility(View.VISIBLE);
        else
            holder.imgNew.setVisibility(View.GONE);
    }



    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    public class PromotionViewHolder extends RecyclerView.ViewHolder {
        private TextView txtTitle;
        private TextView txtDescription;
        private ImageView imgNew;


        private PromotionViewHolder(View v) {
            super(v);
            txtTitle = v.findViewById(R.id.txt_title);
            txtDescription = v.findViewById(R.id.txt_description);
            imgNew = v.findViewById(R.id.img_new);

        }

        private void bind(final PromotionEntity item, int position) {

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(item, position);
                }
            });
        }
    }

    public interface OnItemClickListener {
        void onItemClick(PromotionEntity item, int position);
    }
}
