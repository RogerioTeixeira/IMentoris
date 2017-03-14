package com.texsoft.imentoris.views.auth.signup;

import android.os.Bundle;

import com.texsoft.imentoris.R;
import com.texsoft.imentoris.ViewPageAdapter;
import com.texsoft.imentoris.base.BaseActivity;
import com.texsoft.imentoris.components.ActivityComponent;
import com.texsoft.imentoris.events.EventChangePage;
import com.texsoft.imentoris.widgets.ViewPagerNoSwipe;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import javax.inject.Inject;

import butterknife.BindView;

public class SignUpActivity extends BaseActivity {

    @Inject
    ViewPageAdapter viewPageAdapter;

    @BindView(R.id.viewpager)
    ViewPagerNoSwipe viewpager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null) {
            viewPageAdapter.addFragment(new ChooseRoleFragment());
            viewPageAdapter.addFragment(new RegisterEmailFragment());
        } else {
            viewPageAdapter.setFragments(getSupportFragmentManager().getFragments());
        }

        viewpager.setAdapter(viewPageAdapter);

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
    public void OnEvent(EventChangePage e) {
        switch (e.getNumPage()) {
            case 0:
                break;
            case 1:
                viewpager.setCurrentItem(e.getNumPage());
                break;

        }
    }
}
