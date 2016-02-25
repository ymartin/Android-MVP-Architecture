package com.ymartin.data.repository;

import com.ymartin.data.model.User;

import java.util.List;

import retrofit2.http.GET;
import rx.Observable;

public interface UserRepository {
    @GET("/users")
    Observable<List<User>> users();
}
