package com.skeleton.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.skeleton.R;
import com.skeleton.adapter.UserRecyclerAdapter;
import com.skeleton.model.Posts;
import com.skeleton.retrofit.APIError;
import com.skeleton.retrofit.ApiInterface;
import com.skeleton.retrofit.ResponseResolver;
import com.skeleton.retrofit.RestClient;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by darknight on 4/5/17.
 */

public class UserPostActivity extends BaseActivity {
    public static final String TAG = "UserPostActivity";
    public static final String KEY_USERID = "userid";
    private RecyclerView recyclerView;
    private int userid;

    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_list);
        init();
    }

    /**
     * Instantiate views and variables
     */
    private void init() {
        userid = getIntent().getIntExtra(KEY_USERID, -1);
        if (userid != -1) {
            upDatePosts(userid);
        }
        recyclerView = (RecyclerView) findViewById(R.id.frag_list_rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    /**
     * updates the posts using userId
     *
     * @param userId : userid of selected user
     */
    public void upDatePosts(final int userId) {
        Log.d(TAG, "upDatePosts: " + userId);
        fetchPosts(userId);

    }

    /**
     * fetch posts for userId
     *
     * @param userId : userId of selected user
     */
    private void fetchPosts(final int userId) {
        ApiInterface apiInterface = RestClient.getApiInterface();
        apiInterface.getUserPosts(String.valueOf(userId)).enqueue(new ResponseResolver<List<Posts>>(
                this, true, true) {

            @Override
            public void success(final List<Posts> postsList) {

                List<Object> list = new ArrayList<>();
                list.addAll(postsList);
                UserRecyclerAdapter userRecyclerAdapter = new UserRecyclerAdapter(list,
                        UserRecyclerAdapter.MODE_POST_LIST);
                recyclerView.setAdapter(userRecyclerAdapter);
            }

            @Override
            public void failure(final APIError error) {

            }
        });

    }

}
