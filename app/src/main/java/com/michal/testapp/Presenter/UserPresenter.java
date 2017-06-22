package com.michal.testapp.Presenter;

import com.michal.testapp.Dagger.component.MyComponent;
import com.michal.testapp.Model.ObjListUsers;
import com.michal.testapp.Model.User;
import com.michal.testapp.Restapi;
import com.michal.testapp.View.MainActivity;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by michal on 15.06.17.
 */

public class UserPresenter implements IUsersPresenter {
    @Inject
    Retrofit retrofit;

    private MainActivity mainActivity;

    public UserPresenter(MyComponent myComponent) {
        myComponent.inject(this);

    }

    public void setView(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    public void getAllUsers() {

        Call<ObjListUsers> groupList = retrofit.create(Restapi.class).groupList(1);
        groupList.enqueue(new Callback<ObjListUsers>() {
            @Override
            public void onResponse(Call<ObjListUsers> call, Response<ObjListUsers> response) {
                List<User> list = new ArrayList<User>();
                for (int i = 0 ;i<30;i++){
                    list.add(response.body().getUserList().get(i%3));
                }
                mainActivity.showUsers(list);

            }

            @Override
            public void onFailure(Call<ObjListUsers> call, Throwable t) {

            }
        });

    }


}
