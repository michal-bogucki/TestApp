package com.michal.testapp.Dagger.component;

import com.michal.testapp.Dagger.module.AppModule;
import com.michal.testapp.Dagger.module.NetModule;
import com.michal.testapp.Presenter.UserCardPresenter;
import com.michal.testapp.Presenter.UserPresenter;

import javax.inject.Singleton;

/**
 * Created by michal on 14.06.17.
 */
@Singleton
@dagger.Component(modules = {AppModule.class, NetModule.class})
public interface MyComponent {
    void inject(UserPresenter activity);
    void inject(UserCardPresenter activity);

}
