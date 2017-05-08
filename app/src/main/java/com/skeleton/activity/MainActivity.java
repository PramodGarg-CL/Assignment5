package com.skeleton.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.skeleton.R;
import com.skeleton.fragment.UserDetailsFragment;
import com.skeleton.fragment.UserListFragment;

/**
 * Created by darknight on 4/5/17.
 */

public class MainActivity extends BaseActivity {
    private static final String TAG = "MainActivity";
    private Button buttonGetPosts;

    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activty_main);
        init();

        buttonGetPosts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                UserListFragment userListFragment = (UserListFragment) getSupportFragmentManager()
                        .findFragmentByTag(UserListFragment.TAG);
                int userId = userListFragment.getSelectedUserId();
                Toast.makeText(MainActivity.this, "userid   " + userId, Toast.LENGTH_SHORT).show();
                if (userId != -1) {
                    Intent intent = new Intent(MainActivity.this, UserPostActivity.class);
                    intent.putExtra(UserPostActivity.KEY_USERID, userId);
                    startActivity(intent);
                }
            }
        });
    }

    /**
     * Intializes the views and variables
     */
    private void init() {
        buttonGetPosts = (Button) findViewById(R.id.main_bt_get_posts);
        setFragments(R.id.main_fl_list, new UserListFragment(), UserListFragment.TAG);
        setFragments(R.id.main_fl_details, new UserDetailsFragment(), UserDetailsFragment.TAG);
    }

    /**
     * set fragments at placeholders
     *
     * @param placeHolderId : id of placeholder
     * @param fragment      : fragment to be attached
     * @param tag           : tag of fragment
     */
    private void setFragments(final int placeHolderId, final Fragment fragment,
                              final String tag) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(placeHolderId, fragment, tag);
        fragmentTransaction.commit();
    }


    /**
     * interface implemented in {@link UserListFragment}
     */
    public interface OnGetPosts {
        /**
         * abstract method : called on click of button
         */
        void onGetPostsClick();
    }
}
