package com.texsoft.imentoris.views.auth.signup;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.widget.ImageView;

import com.texsoft.imentoris.R;
import com.texsoft.imentoris.base.BaseEvent;
import com.texsoft.imentoris.base.BaseFragment;
import com.texsoft.imentoris.components.FragmentComponent;
import com.texsoft.imentoris.util.Roles;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class RegisterEmailFragment extends BaseFragment {


    @BindView(R.id.imageView)
    ImageView imageView;
    @BindView(R.id.email_input_edit)
    TextInputEditText emailInputEdit;
    @BindView(R.id.email_input_layout)
    TextInputLayout emailInputLayout;
    @BindView(R.id.password_input_edit)
    TextInputEditText passwordInputEdit;
    @BindView(R.id.password_input_layout)
    TextInputLayout passwordInputLayout;
    @BindView(R.id.name_input_edit)
    TextInputEditText nameInputEdit;
    @BindView(R.id.name_input_layout)
    TextInputLayout nameInputLayout;

    public RegisterEmailFragment() {
        // Required empty public constructor
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_register_email;
    }

    @Override
    protected void inject(FragmentComponent component) {

    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void OnEvent(BaseEvent<String> e) {
        if (!e.isEventFor(this)) {
            return;
        }
        switch (e.getData()) {
            case Roles.STUDENT:
                imageView.setImageResource(R.drawable.students);
                break;
            case Roles.TEACHER:
                imageView.setImageResource(R.drawable.teacher);
                break;
        }
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getUserVisibleHint()) {
            setTitleToolBar(R.string.title_register_fragment);
        }
    }


    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isResumed() && isVisibleToUser) {
            setTitleToolBar(R.string.title_register_fragment);
        }

    }

}
