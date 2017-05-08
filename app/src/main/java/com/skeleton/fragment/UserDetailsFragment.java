package com.skeleton.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.skeleton.R;
import com.skeleton.adapter.UserRecyclerAdapter;
import com.skeleton.model.Posts;
import com.skeleton.model.User;
import com.skeleton.retrofit.APIError;
import com.skeleton.retrofit.ApiInterface;
import com.skeleton.retrofit.ResponseResolver;
import com.skeleton.retrofit.RestClient;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by darknight on 4/5/17.
 */

public class UserDetailsFragment extends BaseFragment {
    public static final String TAG = "UserDetailsFragment";
    private TextView textViewId, textViewName, textViewEmail, textViewAddress, textViewPhone,
            textViewSite, textViewCompany;
    private ImageView imageView;
    private RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable final ViewGroup container,
                             @Nullable final Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.item_user_details, container, false);
        init(view);
        return view;
    }

    /**
     * Instantiate views and variables
     *
     * @param view : rootView
     */
    private void init(final View view) {
        textViewId = (TextView) view.findViewById(R.id.item_user_tv_id);
        textViewName = (TextView) view.findViewById(R.id.item_user_tv_name);
        textViewEmail = (TextView) view.findViewById(R.id.item_user_tv_email);
        textViewAddress = (TextView) view.findViewById(R.id.item_user_tv_address);
        textViewPhone = (TextView) view.findViewById(R.id.item_user_tv_phone);
        textViewSite = (TextView) view.findViewById(R.id.item_user_tv_site);
        textViewCompany = (TextView) view.findViewById(R.id.item_user_tv_company);
        imageView = (ImageView) view.findViewById(R.id.item_user_iv);

    }

    /**
     * updates the posts using userId
     *
     * @param user : userid of selected user
     */
    public void showUserDetails(final User user) {
        imageView.setVisibility(View.VISIBLE);
        String id = "UserID : " + user.getId();
        String name = "Name : " + user.getName();
        String email = "Email : " + user.getEmail();
        String address = "Address : " + user.getAddress().getSuite() + ","
                + user.getAddress().getStreet() + ","
                + user.getAddress().getCity() + ","
                + user.getAddress().getZipcode();
        String phone = "Phone : " + user.getPhone();
        String site = "Website : " + user.getWebsite();
        String company = "Company : " + user.getCompany().getName();
        textViewId.setText(id);
        textViewName.setText(name);
        textViewEmail.setText(email);
        textViewAddress.setText(address);
        textViewPhone.setText(phone);
        textViewSite.setText(site);
        textViewCompany.setText(company);
        // fetchPosts(userId);

    }

    /**
     * fetch posts for userId
     *
     * @param userId : userId of selected user
     */
    private void fetchPosts(final int userId) {
        ApiInterface apiInterface = RestClient.getApiInterface();
        apiInterface.getUserPosts(String.valueOf(userId)).enqueue(new ResponseResolver<List<Posts>>(
                getContext(), true, true) {

            @Override
            public void success(final List<Posts> postsList) {

                List<Object> list = new ArrayList<>();
                list.addAll(postsList);
                UserRecyclerAdapter userRecyclerAdapter = new UserRecyclerAdapter(list, UserRecyclerAdapter.MODE_POST_LIST);
                recyclerView.setAdapter(userRecyclerAdapter);
            }

            @Override
            public void failure(final APIError error) {

            }
        });

    }

}
