package com.demo.merchandisemot.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.demo.architect.data.model.offline.IncomeEntity;
import com.goitho.employeeapp.R;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.goitho.employeeapp.util.ConvertUtils;

/**
 * Created by Skull on 27/11/2017.
 */

public class IncomeAdapter extends RecyclerView.Adapter<IncomeAdapter.IncomeViewHolder> {

    private ArrayList<IncomeEntity> list;
    private final OnItemClickListener listener;
    private Context context;

    public IncomeAdapter(ArrayList<IncomeEntity> list, Context context, OnItemClickListener listener) {
        this.list = list;
        this.listener = listener;
        this.context = context;
    }

    public void setData(ArrayList<IncomeEntity> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @Override
    public IncomeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_row_income, parent, false);
        IncomeViewHolder holder = new IncomeViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(IncomeViewHolder holder, int position) {
        if (list != null && 0 <= position && position < list.size()) {
            setDataToViews(holder, position);
            holder.bind(list.get(position), listener);
        }

    }

    private void setDataToViews(IncomeViewHolder holder, int position) {
            Date  dateAccept = ConvertUtils.ConvertStringToShortDate(list.get(position).getAcceptanceTime()+"");
            if (dateAccept.getDay()<10){
                holder.txtDay.setText("0"+dateAccept.getDay());
            }else
            {
                holder.txtDay.setText(""+dateAccept.getDay());
            }

        if (dateAccept.getMonth() <10){
            holder.txtMonth.setText(context.getResources().getString(R.string.text_month_income) +
                    " 0" + dateAccept.getMonth());
        }else
        {
            holder.txtMonth.setText(context.getResources().getString(R.string.text_month_income) +
                    " " + dateAccept.getMonth());
        }


        holder.txtMoneyPlus.setText("+ " + list.get(position).getMoney() + " đ");
        holder.txtMess.setText(list.get(position).getNote());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class IncomeViewHolder extends RecyclerView.ViewHolder {
        private TextView txtDay;
        private TextView txtMonth;
        private TextView txtMoneyPlus;
        private TextView txtMess;


        private IncomeViewHolder(View v) {
            super(v);
            txtDay = (TextView) v.findViewById(R.id.text_day_income);
            txtMonth = (TextView) v.findViewById(R.id.text_month_income);
            txtMoneyPlus = (TextView) v.findViewById(R.id.text_money_plus);
            txtMess = (TextView) v.findViewById(R.id.text_status_order);


        }

        private void bind(final IncomeEntity item, final OnItemClickListener listener) {

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(item);
                }
            });
        }
    }

    public interface OnItemClickListener {
        void onItemClick(IncomeEntity item);
    }
}
