package com.demo.merchandisemot.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.demo.architect.data.model.ListFieldEntity;
import com.demo.architect.data.model.UserEntity;
import com.goitho.employeeapp.R;
import com.goitho.employeeapp.manager.UserManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Skull on 24/03/2018.
 */

public class TechniqueAdapter extends RecyclerView.Adapter<TechniqueAdapter.TechniqueViewHolder> {

    private List<ListFieldEntity.Field> list;
    private final OnItemClickListener listener;
    private Context context;
    private ArrayList<UserEntity.Field> userList;

    public TechniqueAdapter(List<ListFieldEntity.Field> list, Context context, OnItemClickListener listener) {
        this.list = list;
        this.listener = listener;
        this.context = context;
        this.userList= new ArrayList<>();
    }

    public void setData(List<ListFieldEntity.Field> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    public void addData(ListFieldEntity.Field field) {
        list.add(0,field);
        notifyDataSetChanged();
    }

    public ArrayList<UserEntity.Field> getUserListField() {
        return userList;
    }

    @Override
    public TechniqueViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_technique, parent, false);
        TechniqueViewHolder holder = new TechniqueViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(TechniqueViewHolder holder, int position) {
        if (list != null && 0 <= position && position < list.size()) {
            setDataToViews(holder, position);
            //holder.bind(list.get(position), listener,  position);
            holder.bind(list.get(position), position);
        }

    }

    private void setDataToViews(TechniqueViewHolder holder, int position) {
        holder.textView.setText(list.get(position).getName().toString());
        holder.txtNumber.setText(String.valueOf(position+1));
        if(UserManager.getInstance().isUserField(list.get(position).getId())) {
            holder.imgCheck.setVisibility(View.VISIBLE);
            UserEntity.Field field = new UserEntity().new Field();
            field.setId(list.get(position).getId());
            field.setName(list.get(position).getName());
            userList.add(field);
        }
        else {
            holder.imgCheck.setVisibility(View.GONE);
        }

    }



    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    public class TechniqueViewHolder extends RecyclerView.ViewHolder {
        private TextView txtNumber;
        private TextView textView;
        private ImageView imgCheck;


        private TechniqueViewHolder(View v) {
            super(v);
            txtNumber = v.findViewById(R.id.txt_number);
            textView = v.findViewById(R.id.edit_text);
            imgCheck = v.findViewById(R.id.img_check);

        }

        private void bind(final ListFieldEntity.Field item, int position) {

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(item, position);
                    UserEntity.Field field = new UserEntity().new Field();
                    field.setId(list.get(position).getId());
                    field.setName(list.get(position).getName());
                    if (imgCheck.getVisibility() == View.GONE) {
                        imgCheck.setVisibility(View.VISIBLE);
                        userList.add(field);
                    } else {
                        imgCheck.setVisibility(View.GONE);
                        userList.remove(field);
                    }
                }
            });
        }
    }

    public interface OnItemClickListener {
        void onItemClick(ListFieldEntity.Field item, int position);
    }
}
