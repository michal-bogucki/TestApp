package com.michal.testapp.View;

import com.michal.testapp.Model.User;

import java.util.List;

/**
 * Created by michal on 15.06.17.
 */

public interface IUsersView {

    void loadUsers();

    void showUsers(List<User> list);


    void showLoading();
}

