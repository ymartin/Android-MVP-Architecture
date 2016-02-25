package com.ymartin.ui.example;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.ymartin.data.model.User;
import com.ymartin.AndroidApplication;
import com.ymartin.ui.R;

import java.util.List;

import javax.inject.Inject;

public class ExampleActivity extends BaseActivity<ExampleView, ExamplePresenter> implements ExampleView {

    @Inject
    ExamplePresenter examplePresenter;

    @NonNull
    @Override
    public ExamplePresenter getPresenter() {
        return examplePresenter;
    }

    @Override
    protected void injectDependencies() {
        AndroidApplication.get(this).component().inject(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
        examplePresenter.loadUsers();
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
