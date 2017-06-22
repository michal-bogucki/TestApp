package com.michal.testapp.Adaptery;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.michal.testapp.Model.User;
import com.michal.testapp.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private final View.OnClickListener onClickListener;
    private List<User> mUserList = new ArrayList<User>();


    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @BindView(R.id.FirstName)
        public TextView mFirstName;
        @BindView(R.id.LastName)
        public TextView mLastName;
        @BindView(R.id.AvatarUser)
        public ImageView mAvatarUser;

        public MyViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            ButterKnife.bind(this, itemView);
            itemView.setTag(this);
        }


        @Override
        public void onClick(View v) {

            onClickListener.onClick(v);
        }
    }

    public MyAdapter(List<User> pUserList,View.OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
        mUserList = pUserList;

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.user_row_layout, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        User mUser = mUserList.get(position);
        (holder).mFirstName.setText(mUser.getFirstName());
        (holder).mLastName.setText(mUser.getLastName());
        Picasso.with((holder).mAvatarUser.getContext()).load(mUser.getAvatar())
                .into((holder).mAvatarUser);

        holder.itemView.setTag(mUser);


    }

    @Override
    public int getItemCount() {
        return mUserList.size();
    }
}
