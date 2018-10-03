package mvvmdemo.bhagyawant.com.mvvmdemo.pojo;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import mvvmdemo.bhagyawant.com.mvvmdemo.BR;

public class LoginViewModel extends BaseObservable {
    private User user;


    private String successMessage = "Login was successful";
    private String errorMessage = "Email or Password not valid";

    @Bindable
    public String toastMessage = null;

    @Bindable
    String toast2Message = null;

    public String getToast2Message() {
        return toast2Message;
    }

    public void setToast2Message(String toast2Message) {
        this.toast2Message = toast2Message;
    }

    public String getToastMessage() {
        return toastMessage;
    }

    private void setToastMessage(String toastMessage) {

        this.toastMessage = toastMessage;
        notifyPropertyChanged(BR.toastMessage);
    }

    public LoginViewModel() {
        user = new User("", "");
    }

    public void afterEmailTextChanged(CharSequence s) {
        user.setEmail(s.toString());
    }

    public void afterPasswordTextChanged(CharSequence s) {
        user.setPassword(s.toString());
    }

    public void onLoginClicked() {
        if (user.isInputDataValid())
            setToastMessage(successMessage);
        else
            setToastMessage(errorMessage);
    }

    public boolean onLoginLongClicked() {
        if (user.isUserBhagyawant())
            setToastMessage(successMessage);
        else
            setToastMessage(errorMessage);
        return true;
    }

}