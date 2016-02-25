package com.ymartin.ui.example;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;

import com.ymartin.ui.base.Presenter;
import com.ymartin.ui.base.View;

public abstract class BaseActivity<V extends View, P extends Presenter<V>> extends AppCompatActivity {

    @NonNull
    protected abstract P getPresenter();

    @NonNull
    @SuppressWarnings("unchecked")
    protected V getView() {
        return (V) this;
    }

    protected abstract void injectDependencies();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        injectDependencies();
        getPresenter().attachView(getView());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        getPresenter().detachView();
    }
}
