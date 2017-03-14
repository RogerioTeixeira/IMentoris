package com.texsoft.imentoris.views.auth.signup;


import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.texsoft.imentoris.R;
import com.texsoft.imentoris.base.BaseFragment;
import com.texsoft.imentoris.components.FragmentComponent;
import com.texsoft.imentoris.events.EventChangePage;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class ChooseRoleFragment extends BaseFragment {


    @BindView(R.id.imageStudent)
    ImageView imageStudent;
    @BindView(R.id.imageTeacher)
    ImageView imageTeacher;

    public ChooseRoleFragment() {
        // Required empty public constructor
        Log.v("AdaperPager", "Fragment Creator create" + this.getClass().getName());
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_choose_role;
    }

    @Override
    protected void inject(FragmentComponent component) {

    }

    @OnClick({R.id.imageStudent, R.id.imageTeacher})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.imageStudent:
                EventBus.getDefault().post(new EventChangePage(1));
                break;
            case R.id.imageTeacher:
                break;
        }
    }
}
