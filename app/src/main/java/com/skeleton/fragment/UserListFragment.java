package com.skeleton.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.skeleton.R;
import com.skeleton.activity.MainActivity;
import com.skeleton.adapter.UserRecyclerAdapter;
import com.skeleton.model.User;
import com.skeleton.retrofit.APIError;
import com.skeleton.retrofit.ApiInterface;
import com.skeleton.retrofit.ResponseResolver;
import com.skeleton.retrofit.RestClient;
import com.skeleton.util.RecyclerTouchListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by darknight on 4/5/17.
 */

public class UserListFragment extends BaseFragment implements MainActivity.OnGetPosts {
    public static final String TAG = "UserListFragment";
    private RecyclerView recyclerView;
    private int mSelectedUserId = -1;

    /**
     * return instance
     *
     * @return instance of {@link UserListFragment}
     */
    public static UserListFragment getInstance() {
        return new UserListFragment();
    }

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable final ViewGroup container,
                             @Nullable final Bundle savedInstanceState) {
        View view = inflater.from(container.getContext()).inflate(R.layout.fragment_list, container, false);
        init(view);
        return view;
    }

    /**
     * Intializes the variables and views
     *
     * @param view : rootView
     */
    private void init(final View view) {
        fetchUserData();
        recyclerView = (RecyclerView) view.findViewById(R.id.frag_list_rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getActivity(), recyclerView,
                new RecyclerTouchListener.ClickListener() {
                    @Override
                    public void onClick(final View view, final int position) {
                        UserDetailsFragment fragment = (UserDetailsFragment) getActivity()
                                .getSupportFragmentManager()
                                .findFragmentByTag(UserDetailsFragment.TAG);
                        UserRecyclerAdapter adapter = (UserRecyclerAdapter) recyclerView.getAdapter();
                        if (fragment != null) {
                            Toast.makeText(getActivity(), "here", Toast.LENGTH_SHORT).show();
                            mSelectedUserId = adapter.getUserId(position);

                            Toast.makeText(getActivity(), "onClick " + adapter.getUserId(position),
                                    Toast.LENGTH_SHORT).show();
                            fragment.showUserDetails(adapter.getUser(position));

                        }
                    }

                    @Override
                    public void onLongClick(final View view, final int position) {
                        onClick(view, position);

                    }
                }));
    }

    /**
     * fetch data from api
     */
    private void fetchUserData() {
        ApiInterface apiInterface = RestClient.getApiInterface();
        apiInterface.getUsers().enqueue(new ResponseResolver<List<User>>(getActivity(), true, true) {
            @Override
            public void success(final List<User> userList) {

                List<Object> list = new ArrayList<>();
                list.addAll(userList);

                UserRecyclerAdapter userRecyclerAdapter = new UserRecyclerAdapter(list,
                        UserRecyclerAdapter.MODE_USER_LIST);
                recyclerView.setAdapter(userRecyclerAdapter);

            }

            @Override
            public void failure(final APIError error) {

            }
        });
    }

    @Override
    public void onGetPostsClick() {
        Log.d(TAG, "onGetPostsClick: ");
    }

    /**
     * return id of selected user
     *
     * @return : id of user
     */
    public int getSelectedUserId() {
        return mSelectedUserId;
    }
}
