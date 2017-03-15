package com.texsoft.imentoris.views.auth.signup;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.inputmethod.InputMethodManager;

import com.google.firebase.auth.EmailAuthProvider;
import com.texsoft.imentoris.R;
import com.texsoft.imentoris.adapters.ViewPageAdapter;
import com.texsoft.imentoris.base.BaseActivity;
import com.texsoft.imentoris.components.ActivityComponent;
import com.texsoft.imentoris.events.EventChangeRole;
import com.texsoft.imentoris.widgets.ViewPagerNoSwipe;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import javax.inject.Inject;

import butterknife.BindView;

public class SignUpActivity extends BaseActivity {

    static final String EXTRA_PARAM = "PARAM_EXTRA";
    @Inject
    ViewPageAdapter viewPageAdapter;

    @BindView(R.id.viewpager)
    ViewPagerNoSwipe viewpager;
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    public static void startActivity(String provider, Activity activity) {
        Intent intent = new Intent(activity, SignUpActivity.class);
        intent.putExtra(EXTRA_PARAM, provider);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        Bundle b = getIntent().getExtras();
        String provideId = b.getString(EXTRA_PARAM);

        if (savedInstanceState == null) {
            viewPageAdapter.addFragment(new ChooseRoleFragment());
            if (provideId.equalsIgnoreCase(EmailAuthProvider.PROVIDER_ID)) {
                viewPageAdapter.addFragment(new RegisterEmailFragment());
            }
        } else {
            viewPageAdapter.setFragments(getSupportFragmentManager().getFragments());
        }

        viewpager.setAdapter(viewPageAdapter);
        setCurrentpage(viewpager.getCurrentItem());

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_sign_up;
    }

    @Override
    protected void inject(ActivityComponent component) {
        component.inject(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void OnEvent(EventChangeRole e) {
        setCurrentpage(viewpager.getCurrentItem() + 1);
    }

    public void setCurrentpage(int page) {
        viewpager.setCurrentItem(page);
        switch (page) {
            case 0:
                getSupportActionBar().setTitle("Scegli ruolo");
                break;
            case 1:
                getSupportActionBar().setTitle("Dati personali");
                break;
        }
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(viewpager.getWindowToken(), 0);
    }

    @Override
    public void onBackPressed() {
        if (viewpager.getCurrentItem() == 0) {
            finish();
        } else {
            setCurrentpage(viewpager.getCurrentItem() - 1);
        }
    }
}
