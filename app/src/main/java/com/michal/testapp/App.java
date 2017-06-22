package com.michal.testapp;

import android.app.Application;

import com.michal.testapp.Dagger.component.DaggerMyComponent;
import com.michal.testapp.Dagger.component.DaggerPresenterComponent;
import com.michal.testapp.Dagger.component.MyComponent;
import com.michal.testapp.Dagger.component.PresenterComponent;
import com.michal.testapp.Dagger.module.AppModule;
import com.michal.testapp.Dagger.module.NetModule;
import com.michal.testapp.Dagger.module.PresenterModule;

/**
 * Created by michal on 14.06.17.
 */

public class App extends Application {
    private MyComponent mMyComponent;
    private PresenterComponent mPresenterComponent;
    private static final String mURL = "https://reqres.in/";

    @Override
    public void onCreate() {
        super.onCreate();
        mMyComponent = DaggerMyComponent.builder()
                .appModule(new AppModule(this))
                .netModule(new NetModule(mURL))
                .build();
        mPresenterComponent = DaggerPresenterComponent.builder()
                .presenterModule(new PresenterModule(this))
                .build();

    }
    public MyComponent getComponent() {
        return mMyComponent;
    }

    public PresenterComponent getPresenterComponent(){return  mPresenterComponent;}

}
