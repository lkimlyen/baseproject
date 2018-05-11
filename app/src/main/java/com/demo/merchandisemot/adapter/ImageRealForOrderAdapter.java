package com.demo.merchandisemot.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.demo.architect.data.model.WalletPayEntity;
import com.demo.architect.data.model.offline.ImageEntity;
import com.goitho.employeeapp.R;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Skull on 27/11/2017.
 */

public class ImageRealForOrderAdapter extends RecyclerView.Adapter<ImageRealForOrderAdapter.ImageRealViewHolder> {

    private List<Object> list = new ArrayList<>();
    private ArrayList<ImageEntity> listRemovedImageEnities = new ArrayList<>();
    private final OnItemClickListener listener;
    private Context context;

    public ImageRealForOrderAdapter(List<ImageEntity> list, Context context, OnItemClickListener listener) {
        this.list.addAll(list);
        this.listener = listener;
        this.context = context;
    }

    public void setData(List<ImageEntity> list) {
        this.list.clear();
        this.list.addAll(list);
        notifyDataSetChanged();
    }

    public void addData(Bitmap bitmap) {
        list.add(0, bitmap);
        notifyDataSetChanged();
    }

    public void removeData(Object object){
        list.remove(object);
        if(object instanceof ImageEntity && !listRemovedImageEnities.contains(object)){
            listRemovedImageEnities.add((ImageEntity) object);
        }
        notifyDataSetChanged();
    }

    @Override
    public ImageRealViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_row_image_detail_order, parent, false);
        ImageRealViewHolder holder = new ImageRealViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ImageRealViewHolder holder, int position) {
        if (list != null && 0 <= position && position < list.size()) {
            setDataToViews(holder, position);
            holder.bind(list.get(position), listener);
        }

    }

    private void setDataToViews(ImageRealViewHolder holder, int position) {
        if (list.get(position) instanceof Bitmap) {
            holder.imgReal.setImageBitmap((Bitmap) list.get(position));
        } else if (!TextUtils.isEmpty(((ImageEntity)list.get(position)).getImageUrl())) {
            Picasso.with(context).load(((ImageEntity)list.get(position)).getImageUrl()).networkPolicy(NetworkPolicy.NO_CACHE).memoryPolicy(MemoryPolicy.NO_CACHE, MemoryPolicy.NO_STORE).into(holder.imgReal);
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ImageRealViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgReal;

        private ImageRealViewHolder(View v) {
            super(v);
            imgReal = (ImageView) v.findViewById(R.id.img_detail_real);
        }

        private void bind(final Object item, final OnItemClickListener listener) {

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (item instanceof Bitmap) {
                        listener.onItemClick(null, (Bitmap) item);
                    } else {
                        listener.onItemClick((ImageEntity) item, null);
                    }
                }
            });
        }
    }

    public List<Bitmap> getListAddedBitmaps(){
        List<Bitmap> results = new ArrayList<>();
        for(Object obj : list) {
            if(obj instanceof Bitmap){
                results.add((Bitmap) obj);
            }
        }
        return results;
    }

    public ArrayList<ImageEntity> getListRemovedImageEntities(){
        return listRemovedImageEnities;
    }

    public interface OnItemClickListener {
        void onItemClick(ImageEntity itemAsAnImageEntity, Bitmap itemAsABitmap);
    }
}
