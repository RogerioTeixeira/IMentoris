package com.texsoft.imentoris.views.auth.signup;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.texsoft.imentoris.R;
import com.texsoft.imentoris.base.BaseEvent;
import com.texsoft.imentoris.base.BaseFragment;
import com.texsoft.imentoris.components.FragmentComponent;
import com.texsoft.imentoris.util.Roles;

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

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getUserVisibleHint()) {
            setTitleToolBar(R.string.title_choose_fragment);
        }
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isResumed() && isVisibleToUser) {
            setTitleToolBar(R.string.title_register_fragment);
        }

    }

    @OnClick({R.id.imageStudent, R.id.imageTeacher})
    public void onClick(View view) {
        BaseEvent<String> event = new BaseEvent<>();
        event.addClassFilter(SignUpActivity.class);
        event.addClassFilter(RegisterEmailFragment.class);
        switch (view.getId()) {
            case R.id.imageStudent:
                event.setData(Roles.STUDENT);
                break;
            case R.id.imageTeacher:
                event.setData(Roles.TEACHER);
                break;
        }
        EventBus.getDefault().post(event);
    }
}
