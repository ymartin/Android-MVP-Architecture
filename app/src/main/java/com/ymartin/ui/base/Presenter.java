package com.ymartin.ui.base;

public interface Presenter<V extends View> {
    void attachView(V view);

    void detachView();
}
