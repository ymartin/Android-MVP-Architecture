package com.ymartin.ui;

import com.ymartin.data.DataModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(
    modules = {
        DataModule.class,
        ApplicationModule.class
    }
)
public interface ApplicationComponent {
    void inject(MainActivity mainActivity);
}