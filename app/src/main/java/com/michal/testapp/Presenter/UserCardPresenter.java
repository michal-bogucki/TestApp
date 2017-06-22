package com.michal.testapp.Presenter;

import com.michal.testapp.Dagger.component.MyComponent;
import com.michal.testapp.Model.ObjUser;
import com.michal.testapp.Model.User;
import com.michal.testapp.Restapi;
import com.michal.testapp.View.UserCard;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by michal on 20.06.17.
 */

public class UserCardPresenter implements IUserCardPresenter  {

    @Inject
    Retrofit retrofit;
    private UserCard userCard;
    private User user;

    public UserCardPresenter(MyComponent myComponent) {
        myComponent.inject(this);
    }

    public void setView(UserCard userCard) {
        this.userCard = userCard;
    }

    @Override
    public void loadUser(int idUser)  {
        Call<ObjUser> objUser = retrofit.create(Restapi.class).getObjUser(idUser);
        objUser.enqueue(new Callback<ObjUser>() {
            @Override
            public void onResponse(Call<ObjUser> call, Response<ObjUser> response) {
                user = response.body().getUser();
                userCard.showUser(user);
            }

            @Override
            public void onFailure(Call<ObjUser> call, Throwable t) {

            }
        });
    }


}
