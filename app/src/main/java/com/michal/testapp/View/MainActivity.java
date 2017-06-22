package com.michal.testapp.View;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.michal.testapp.Adaptery.MyAdapter;
import com.michal.testapp.App;
import com.michal.testapp.Model.User;
import com.michal.testapp.Presenter.UserPresenter;
import com.michal.testapp.R;

import org.parceler.Parcels;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements IUsersView, View.OnClickListener {

    private static final String TAG = "MainActivity";
    @Inject
    UserPresenter userPresenter;

    @BindView(R.id.UserList)
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startComponent();

    }

    private void startComponent() {
        ButterKnife.bind(this);
        ((App) getApplication()).getPresenterComponent().inject(this);
        userPresenter.setView(this);
        loadUsers();
    }

    @Override
    public void loadUsers() {
        userPresenter.getAllUsers();
    }

    @Override
    public void showUsers(List<User> list) {
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(new MyAdapter(list, this));
    }


    @Override
    public void showLoading() {

    }

    @Override
    public void onClick(View v) {
        User user = (User) v.getTag();
        Intent intent = new Intent(this,UserCard.class);
        intent.putExtra("user", Parcels.wrap(user));
        startActivity(intent);

    }
}
