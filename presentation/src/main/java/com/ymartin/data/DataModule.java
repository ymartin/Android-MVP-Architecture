package com.ymartin.data;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ymartin.data.repository.UserRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit.Endpoint;
import retrofit.Endpoints;
import retrofit.RestAdapter;
import retrofit.converter.Converter;
import retrofit.converter.GsonConverter;

@Module
public class DataModule {
    private static final String BASE_URL = "http://jsonplaceholder.typicode.com";

    @Provides @Singleton
    Endpoint provideEndpoint() {
        return Endpoints.newFixedEndpoint(BASE_URL);
    }

    @Provides @Singleton
    Converter provideJsonConverter() {
        return new GsonConverter(new Gson());
    }

    @Provides @Singleton
    RestAdapter provideRestAdapter(Endpoint endpoint, Converter jsonConverter) {
        return new RestAdapter.Builder()
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setEndpoint(endpoint)
                .setConverter(jsonConverter)
                .build();
    }

    @Provides @Singleton
    UserRepository provideUserRepository(RestAdapter restAdapter) {
        return restAdapter.create(UserRepository.class);
    }
}