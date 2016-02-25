package com.ymartin.injector;

import com.ymartin.data.DataModule;
import com.ymartin.ui.example.ExampleActivity;

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
    void inject(ExampleActivity exampleActivity);
}