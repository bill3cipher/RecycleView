package com.example.nsc.recycleview;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;


/**
 * Created by NSC on 8/7/2017.
 */

class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private List<MyData> mDataSet;
    private Context mContext;

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView tvName;
        ImageView ivGlide;
        private Context mContext;
        private CardView cvMenu;

        public ViewHolder(final View v) {
            super(v);
            mContext = v.getContext();
            tvName = (TextView) v.findViewById(R.id.tvName);
            ivGlide = (ImageView) v.findViewById(R.id.ivGlide);
            cvMenu = (CardView) v.findViewById(R.id.cvMenu);

            cvMenu.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Toast.makeText(mContext, "position "+getPosition(), Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(mContext, SecondActivity.class);
            mContext.startActivity(intent);
        }
    }

    public MyAdapter(Context context, List<MyData> dataSet) {
        mDataSet = dataSet;
        mContext = context;
    }

    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = (View) LayoutInflater.from(mContext).inflate(R.layout.recycle_view_row, parent, false);
        ViewHolder viewholder = new ViewHolder(v);

        return viewholder;
    }

    @Override
    public void onBindViewHolder(MyAdapter.ViewHolder holder, final int position) {

        MyData mydata = mDataSet.get(position);
        holder.tvName.setText(mydata.getName());
        //holder.ivGlide.setImageResource(mDataSet.get(position).getImageUrl());

        GlideFunction.GlideImage(mDataSet.get(position).getImageUrl(), holder.ivGlide, mContext);

    }


    @Override
    public int getItemCount() {
        return mDataSet.size();
    }
}
