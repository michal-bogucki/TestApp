package com.michal.testapp.Dagger.module;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by michal on 14.06.17.
 */
@Module
public class AppModule {
    private Application mApplication;
    public AppModule(Application mApplication){
        this.mApplication = mApplication;
    }
    @Provides
    @Singleton
    Application providesApplication(){
        return mApplication;
    }


}
