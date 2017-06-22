package com.michal.testapp.View;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.michal.testapp.App;
import com.michal.testapp.Model.User;
import com.michal.testapp.Presenter.UserCardPresenter;
import com.michal.testapp.R;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class UserCard extends AppCompatActivity implements IUserCard {
    @BindView(R.id.profile_image)
    ImageView profile_image;
    @BindView(R.id.UserName)
    TextView UserName;
    @Inject
    UserCardPresenter userCardPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_card);
        startComponent();
    }

    private void startComponent() {
        ButterKnife.bind(this);
        User user = Parcels.unwrap(getIntent().getParcelableExtra("user"));
        ((App) getApplication()).getPresenterComponent().inject(this);
        userCardPresenter.setView(this);
        getUser(user.getId());

    }

    @Override
    public void getUser(int userId) {
        userCardPresenter.loadUser(userId);
    }

    @Override
    public void showUser(User user) {
        UserName.setText(user.getLastName()+" "+ user.getFirstName());
        Picasso.with(getApplicationContext()).load(user.getAvatar()).into(profile_image);

    }
}
