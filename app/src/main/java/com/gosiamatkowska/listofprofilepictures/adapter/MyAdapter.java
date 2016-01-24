package com.gosiamatkowska.listofprofilepictures.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.gosiamatkowska.listofprofilepictures.R;
import com.gosiamatkowska.listofprofilepictures.model.User;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private Context mContext;
    private List<User> mUsers;

    public MyAdapter(Context context, List<User> imageURLs) {
        mContext = context;
        mUsers = imageURLs;
    }

    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ImageView v = ((ImageView) inflater.inflate(R.layout.list_item, parent, false));
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.setPhoto(mContext, mUsers.get(position).getPhotoURL());
    }

    @Override
    public int getItemCount() {
        return mUsers.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private final ImageView mImageView;

        public ViewHolder(ImageView view) {
            super(view);
            mImageView = view;
        }

        public void setPhoto(Context context, String photoURL) {
            Picasso.with(context).load(photoURL).into(mImageView);
        }
    }
}
