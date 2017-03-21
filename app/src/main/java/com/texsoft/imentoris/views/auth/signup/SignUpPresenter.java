package com.texsoft.imentoris.views.auth.signup;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.util.Log;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.texsoft.imentoris.events.ProgressDialogEvent;
import com.texsoft.imentoris.events.ShowToastEvent;
import com.texsoft.imentoris.events.onCompleteEvent;
import com.texsoft.imentoris.model.UserProfile;
import com.texsoft.imentoris.util.enums.Provider;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by Rogerio Lavoro on 23/02/2017.
 */

public class SignUpPresenter implements SignUpContract.Presenter {
    private FirebaseAuth auth;

    public SignUpPresenter(FirebaseAuth auth) {
        this.auth = auth;
        Log.v("TestDagger", "SignInPresenter const");

    }

    @Override
    public void signUpWithPassword(final String email, final String password, final String name, final Activity activity) {
        Log.d("Login", "Callpresente");
        EventBus.getDefault().post(new ProgressDialogEvent("", ProgressDialogEvent.DialogState.SHOW));
        auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(activity, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        EventBus.getDefault().post(new ProgressDialogEvent("", ProgressDialogEvent.DialogState.HIDE));
                        if (task.isSuccessful()) {
                            Log.d("Login", "Complete");
                            UserProfile profile = new UserProfile.Builder()
                                    .setEmail(email)
                                    .setName(name)
                                    .setProvider(Provider.PASSWORD)
                                    .build();
                            EventBus.getDefault().post(new onCompleteEvent<UserProfile>(true, profile));
                        } else {
                            Log.d("Login", "nonCmplete");
                            EventBus.getDefault().post(new ShowToastEvent(task.getException().getMessage()));
                        }
                    }
                });

    }

    @Override
    public void onStart() {

    }

    @Override
    public void onStop() {

    }
}
