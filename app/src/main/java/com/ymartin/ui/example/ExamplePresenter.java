package com.ymartin.ui.example;

import com.ymartin.data.model.User;
import com.ymartin.data.repository.UserRepository;
import com.ymartin.ui.base.Presenter;

import java.util.List;

import javax.inject.Inject;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class ExamplePresenter implements Presenter<ExampleView> {
    private UserRepository userRepository;
    private ExampleView view;

    @Inject
    public ExamplePresenter(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void loadUsers() {
        userRepository.users().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<List<User>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(List<User> users) {
                        view.showUsers(users);
                    }
                });
    }

    @Override
    public void attachView(ExampleView view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        view = null;
    }
}