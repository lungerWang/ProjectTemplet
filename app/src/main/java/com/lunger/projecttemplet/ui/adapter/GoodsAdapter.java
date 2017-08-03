package com.lunger.projecttemplet.ui.adapter;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.lunger.projecttemplet.R;
import com.lunger.projecttemplet.SwitchTask;
import com.lunger.projecttemplet.util.DensityUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lunger on 2017/8/3 0003.
 */

public class GoodsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private Context mContext;

    public GoodsAdapter(Context context) {
        mContext = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new GoodsHolder(LayoutInflater.from(mContext).inflate(R.layout.item_goods, null));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        GoodsHolder holder = (GoodsHolder) viewHolder;
        holder.iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext, "被点击", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return 200;
    }


    public class GoodsHolder extends RecyclerView.ViewHolder {
        ImageView iv;

        public GoodsHolder(View itemView) {
            super(itemView);
            iv = (ImageView) itemView.findViewById(R.id.iv);
        }
    }
}
