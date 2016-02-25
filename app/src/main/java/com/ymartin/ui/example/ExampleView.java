package com.ymartin.ui.example;

import com.ymartin.data.model.User;
import com.ymartin.ui.base.View;

import java.util.List;

public interface ExampleView extends View {
    void showUsers(List<User> users);
}
