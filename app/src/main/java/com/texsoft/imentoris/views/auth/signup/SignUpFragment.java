package com.texsoft.imentoris.views.auth.signup;


import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.widget.Button;

import com.texsoft.imentoris.R;
import com.texsoft.imentoris.base.BaseFragment;
import com.texsoft.imentoris.components.FragmentComponent;
import com.texsoft.imentoris.util.Validator;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class SignUpFragment extends BaseFragment {

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

    @Inject
    SignUpContract.Presenter presenter;
    @BindView(R.id.btn_continue)
    Button btnContinue;

    public SignUpFragment() {
        // Required empty public constructor
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_sign_up;
    }

    @Override
    protected void inject(FragmentComponent component) {
        component.inject(this);
    }

    @OnClick(R.id.btn_continue)
    public void onClick() {
        boolean isValid = true;
        String email = emailInputEdit.getText().toString();
        if (!Validator.isValidEmail(email)) {
            emailInputLayout.setError(getString(R.string.error_email_valid));
            isValid = false;
        } else {
            emailInputLayout.setError("");
        }

        String password = passwordInputEdit.getText().toString();
        if (!Validator.isValidPassword(password)) {
            passwordInputLayout.setError(getString(R.string.error_password_valid));
            isValid = false;
        } else {
            passwordInputLayout.setError("");
        }

        if (isValid)
            presenter.signUpWithPassword(email, password, "mmmm", getActivity());
    }


}
