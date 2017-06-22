package com.michal.testapp.Dagger.module;

import com.michal.testapp.App;
import com.michal.testapp.Presenter.UserCardPresenter;
import com.michal.testapp.Presenter.UserPresenter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by michal on 17.06.17.
 */
@Module
public class PresenterModule {
    App app;

    public PresenterModule(App app) {
        this.app = app;
    }

    @Provides
    @Singleton
    UserPresenter userPresenter() {
        return new UserPresenter(app.getComponent());
    }

    @Provides
    @Singleton
    UserCardPresenter userCardPresenter(){
        return new UserCardPresenter(app.getComponent());
    }
}
