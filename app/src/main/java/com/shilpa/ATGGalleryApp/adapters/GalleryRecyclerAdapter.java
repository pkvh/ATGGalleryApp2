package com.shilpa.ATGGalleryApp.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.shilpa.ATGGalleryApp.R;
import com.shilpa.ATGGalleryApp.activity.HomeActivity;
import com.shilpa.ATGGalleryApp.model.Photo;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GalleryRecyclerAdapter extends RecyclerView.Adapter<GalleryRecyclerAdapter.MyViewHolder> {
    private List<Photo> galleryList;
    private Context mContext;
    public HomeActivity a;
    public GalleryRecyclerAdapter(List<Photo> galleryList, HomeActivity activity, Context mContext) {
        this.galleryList = galleryList;
        this.a = activity;
        this.mContext = mContext;
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @Override
        public void onClick(View view) {

          // a.onItemClick(getAdapterPosition(), null);
        }

        @BindView(R.id.recycler_text)
        TextView title;
        @BindView(R.id.recycler_image)
        ImageView image;


        @BindView(R.id.home_icon_holder)
        RelativeLayout homeIconHolder;
        MyViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);

           }

    }
    public void onBindViewHolder(MyViewHolder holder, int position) {
       final  Photo galleryDetails = galleryList.get(position);
        holder.title.setText(galleryDetails.getId());
        holder.homeIconHolder.setBackgroundResource(R.drawable.square_box);
        holder.homeIconHolder.setOnClickListener(holder);






        Glide.with(mContext)
                .load(galleryDetails.getUrl_s())

                .fitCenter()
                .into(holder.image);
    }


    public int getItemCount() {
        return galleryList.size();
    }

    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.home_icon_list_row, parent, false);

        return new MyViewHolder(itemView);

    }
}

