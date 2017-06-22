package com.michal.testapp.Dagger.component;

import com.michal.testapp.View.MainActivity;
import com.michal.testapp.Dagger.module.PresenterModule;
import com.michal.testapp.View.UserCard;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by michal on 17.06.17.
 */
@Singleton
@Component(modules = {PresenterModule.class})
public interface PresenterComponent {


    void inject(MainActivity activity);
    void inject(UserCard userCard);


}
