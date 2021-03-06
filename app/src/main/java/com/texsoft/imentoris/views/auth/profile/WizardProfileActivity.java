package com.texsoft.imentoris.views.auth.profile;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.inputmethod.InputMethodManager;

import com.texsoft.imentoris.R;
import com.texsoft.imentoris.adapters.PagerAdapterSignUp;
import com.texsoft.imentoris.base.BaseActivity;
import com.texsoft.imentoris.components.ActivityComponent;
import com.texsoft.imentoris.events.PageChangeEvent;
import com.texsoft.imentoris.widgets.ViewPagerNoSwipe;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import javax.inject.Inject;

import butterknife.BindView;

public class WizardProfileActivity extends BaseActivity {

    private static final String EXTRA_PARAM = "PARAM_EXTRA";
    @Inject
    PagerAdapterSignUp viewPageAdapter;

    @BindView(R.id.viewpager)
    ViewPagerNoSwipe viewpager;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    private InputMethodManager inputMethodManager;

    public static void startActivity(Activity activity) {
        Intent intent = new Intent(activity, WizardProfileActivity.class);
        //intent.putExtra(EXTRA_PARAM, provider);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        viewpager.setAdapter(viewPageAdapter);

        inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);

        viewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (inputMethodManager.isAcceptingText())
                    inputMethodManager.hideSoftInputFromWindow(viewpager.getWindowToken(), 0);
                viewpager.clearFocus();
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
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
        return R.layout.activity_wizard_profile;
    }

    @Override
    protected void inject(ActivityComponent component) {
        component.inject(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void OnEvent(PageChangeEvent e) {
        switch (e.getPage()) {
            case AVANTI:
                viewpager.setCurrentItem(viewpager.getCurrentItem() + 1);
                break;
            case INDIETRO:
                viewpager.setCurrentItem(viewpager.getCurrentItem() - 1);
                break;
        }
    }


    @Override
    public void onBackPressed() {
        if (viewpager.getCurrentItem() == 0) {
            finish();
        } else {
            viewpager.setCurrentItem(viewpager.getCurrentItem() - 1);
        }
    }

}
