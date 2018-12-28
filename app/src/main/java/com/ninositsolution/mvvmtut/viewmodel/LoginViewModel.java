package com.ninositsolution.mvvmtut.viewmodel;

import android.content.Context;
import android.content.Intent;
import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.ninositsolution.mvvmtut.BR;
import com.ninositsolution.mvvmtut.model.User;
import com.ninositsolution.mvvmtut.view.ProfileActivity;

/**
 * Created by bala on 12/28/2018.
 */

public class LoginViewModel extends BaseObservable {

    private User user;
    private Context context;

    private String successMessage = "Login was successful";
    private String errorMessage = "Email or Password not valid";

    @Bindable
    public String toastMessage = null;


    public String getToastMessage() {
        return toastMessage;
    }


    private void setToastMessage(String toastMessage) {

        this.toastMessage = toastMessage;

        notifyPropertyChanged(BR.toastMessage);
    }

    public LoginViewModel(Context context) {
        this.context = context;
        user = new User();
    }

    public void afterEmailTextChanged(CharSequence s) {
        user.setEmail(s.toString());
    }

    public void afterPasswordTextChanged(CharSequence s) {
        user.setPassword(s.toString());
    }

    public void onLoginClicked() {
        if (user.isInputDataValid())
        {
            setToastMessage(successMessage);
            context.startActivity(new Intent(context.getApplicationContext(), ProfileActivity.class));
        }

        else
            setToastMessage(errorMessage);
    }
}
