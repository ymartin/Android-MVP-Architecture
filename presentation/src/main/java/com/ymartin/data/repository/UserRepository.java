package com.ymartin.data.repository;

import com.ymartin.data.entity.User;

import java.util.List;

import retrofit.http.GET;
import rx.Observable;

public interface UserRepository {
    @GET("/users")
    Observable<List<User>> users();
}
