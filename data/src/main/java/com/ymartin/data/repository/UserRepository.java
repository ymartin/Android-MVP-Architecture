package com.ymartin.data.repository;


import com.ymartin.data.entity.User;

import java.util.List;

import retrofit.http.GET;
import retrofit.http.Query;
import rx.Observable;
import sun.misc.Sort;

public interface UserRepository {
    @GET("/users") //
    Observable<List<User>> users();
}
