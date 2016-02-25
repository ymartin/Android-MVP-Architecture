package com.ymartin.data;


import com.ymartin.data.repository.UserRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class DataModule {
    private static final String BASE_URL = "http://jsonplaceholder.typicode.com";

    @Provides @Singleton
    Retrofit provideRetrofit() {
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }

    @Provides @Singleton
    UserRepository provideUserRepository(Retrofit retrofit) {
        return retrofit.create(UserRepository.class);
    }
}