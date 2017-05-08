package com.skeleton.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.skeleton.R;
import com.skeleton.model.Posts;
import com.skeleton.model.User;

import java.util.List;

/**
 * Created by darknight on 4/5/17.
 */

public class UserRecyclerAdapter extends RecyclerView.Adapter<UserRecyclerAdapter.UserRecylerVH> {
    public static final int MODE_USER_LIST = 1;
    public static final int MODE_POST_LIST = 2;

    private List<Object> mList;
    private int mode;


    /**
     * Constructor
     *
     * @param mList : list
     * @param mode  : mode
     */
    public UserRecyclerAdapter(final List<Object> mList, final int mode) {
        this.mList = mList;
        this.mode = mode;
    }


    @Override
    public UserRecylerVH onCreateViewHolder(final ViewGroup parent, final int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user_list, parent, false);
        return new UserRecylerVH(view);
    }

    @Override
    public void onBindViewHolder(final UserRecylerVH holder, final int position) {


        if (mode == MODE_USER_LIST) {
            User currentUser = (User) mList.get(position);

            holder.textViewName.setText(currentUser.getName());
            holder.textViewId.setVisibility(View.GONE);
        } else if (mode == MODE_POST_LIST) {
            Posts currentUser = (Posts) mList.get(position);
            holder.textViewId.setText(currentUser.getTitle());
            holder.textViewName.setText(currentUser.getBody());


        }
    }


    @Override
    public int getItemCount() {
        return mList.size();
    }

    /**
     * Return User id
     *
     * @param position : position of click
     * @return userid of selected user
     */

    public int getUserId(final int position) {
        if (mode == MODE_USER_LIST) {
            User user = (User) mList.get(position);
            return user.getId();
        }
        return -1;
    }

    /**
     * Return User id
     *
     * @param position : position of click
     * @return userid of selected user
     */

    public User getUser(final int position) {
        if (mode == MODE_USER_LIST) {
            User user = (User) mList.get(position);
            return user;
        }
        return null;
    }


    /**
     * Viewholder class
     */
    public class UserRecylerVH extends RecyclerView.ViewHolder {
        private TextView textViewName, textViewId;

        /**
         * constructor
         *
         * @param itemView : view of the row
         */
        public UserRecylerVH(final View itemView) {
            super(itemView);

            textViewName = (TextView) itemView.findViewById(R.id.item_user_tv_name);
            textViewId = (TextView) itemView.findViewById(R.id.item_user_tv_id);
        }
    }

}
