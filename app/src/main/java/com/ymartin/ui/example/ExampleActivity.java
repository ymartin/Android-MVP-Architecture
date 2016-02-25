package com.ymartin.ui.example;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.ymartin.data.model.User;
import com.ymartin.AndroidApplication;
import com.ymartin.ui.R;

import java.util.List;

import javax.inject.Inject;

public class ExampleActivity extends AppCompatActivity implements ExampleView {

    @Inject
    ExamplePresenter examplePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AndroidApplication.get(this).component().inject(this);

        examplePresenter.attachView(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        examplePresenter.loadUsers();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        examplePresenter.detachView();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void showUsers(List<User> users) {
        for (User user : users) {
            Toast.makeText(this, user.getEmail(), Toast.LENGTH_SHORT).show();
        }
    }
}
