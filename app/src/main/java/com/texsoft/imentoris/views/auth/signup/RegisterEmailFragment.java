package com.texsoft.imentoris.views.auth.signup;


import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.texsoft.imentoris.R;
import com.texsoft.imentoris.base.BaseFragment;
import com.texsoft.imentoris.components.FragmentComponent;
import com.texsoft.imentoris.events.EventChangeRole;
import com.texsoft.imentoris.util.Roles;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;

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
    public void OnEvent(EventChangeRole e) {
        emailInputLayout.clearFocus();
        passwordInputLayout.clearFocus();
        nameInputLayout.clearFocus();
        switch (e.getRole()) {
            case Roles.STUDENT:
                imageView.setImageResource(R.drawable.students);
                break;
            case Roles.TEACHER:
                imageView.setImageResource(R.drawable.teacher);
                break;
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }
}
