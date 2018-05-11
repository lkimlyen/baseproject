package com.demo.merchandisemot.screen.login;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.text.InputType;
import android.text.method.PasswordTransformationMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.demo.architect.data.helper.SharedPreferenceHelper;
import com.demo.architect.data.model.offline.UserLogin;
import com.goitho.employeeapp.R;
import com.goitho.employeeapp.app.base.BaseFragment;
import com.goitho.employeeapp.dialogs.CustomDialogForgetPassword;
import com.goitho.employeeapp.dialogs.CustomNotiDialog;
import com.goitho.employeeapp.screen.dashboard.DashboardActivity;
import com.goitho.employeeapp.screen.phone_verification.PhoneVerificationActivity;
import com.goitho.employeeapp.screen.register.RegisterActivity;
import com.goitho.employeeapp.util.Precondition;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.pedant.SweetAlert.SweetAlertDialog;

/**
 * Created by MSI on 26/11/2017.
 */

public class LoginFragment extends BaseFragment implements LoginContract.View {
    private final String TAG = LoginFragment.class.getName();
    private LoginContract.Presenter mPresenter;

    @Bind(R.id.et_username)
    EditText etId;

    @Bind(R.id.et_password)
    EditText etPassword;

    @Bind(R.id.txt_forget_pass)
    TextView txtForgetPass;

    @Bind(R.id.txt_register)
    TextView txtRegister;

    @Bind(R.id.img_logo)
    ImageView imgLogo;

    @Bind(R.id.img_see_password)
    ImageView imgSeePassword;

    @Bind(R.id.layout)
    RelativeLayout layout;

    @Bind(R.id.cb_save_login)
    CheckBox cbLogin;
    private boolean isClicked = false;

    public LoginFragment() {
        // Required empty public constructor
    }


    public static LoginFragment newInstance() {
        LoginFragment fragment = new LoginFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        ButterKnife.bind(this, view);
        setBackground();
        getUserLogin();
        return view;
    }

    private void setBackground() {
        RelativeLayout.LayoutParams relativeParams = (RelativeLayout.LayoutParams) layout.getLayoutParams();
        int heightLogo = imgLogo.getDrawable().getIntrinsicHeight();
        relativeParams.setMargins(0, (heightLogo / 2), 0, 0);  // left, top, right, bottom
        layout.setLayoutParams(relativeParams);
        txtForgetPass.setPaintFlags(txtForgetPass.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        txtRegister.setPaintFlags(txtRegister.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
    }

    private void getUserLogin() {
        UserLogin userLogin = SharedPreferenceHelper.getInstance(getContext()).getUserLoginObject();
        if (userLogin != null) {
            etId.setText(userLogin.getUserName());
            etPassword.setText(userLogin.getPassword());
            cbLogin.setChecked(true);
        }
    }

    @Override
    public void setPresenter(LoginContract.Presenter presenter) {
        this.mPresenter = Precondition.checkNotNull(presenter);
    }

    @Override
    public void showProgressBar() {
        showProgressDialog();
    }

    @Override
    public void hideProgressBar() {
        hideProgressDialog();
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.start();
    }

    @Override
    public void onPause() {
        super.onPause();
        mPresenter.stop();
    }

    @OnClick(R.id.btn_login)
    public void login() {
        if (etId.getText().toString().length() < 6) {
            startDialogNoti(getActivity().getString(R.string.text_username_null));
            return;
        }
        if (etPassword.getText().toString().length() < 6) {
            startDialogNoti(getActivity().getString(R.string.text_password_null));
            return;
        }

        if (cbLogin.isChecked()) {
            SharedPreferenceHelper.getInstance(getContext()).pushUserLoginObject(
                    new UserLogin(etId.getText().toString(), etPassword.getText().toString()));
        } else {
            SharedPreferenceHelper.getInstance(getContext()).pushUserLoginObject(null);
        }
        mPresenter.login(etId.getText().toString(), etPassword.getText().toString());
    }
    public void startDialogNoti(String content) {
        CustomNotiDialog dialog = new CustomNotiDialog();
        dialog.show(getActivity().getFragmentManager(), TAG);
        dialog.setContent(content);
    }

    @OnClick(R.id.txt_register)
    public void register() {
        startRegisterActivity();
    }


    @OnClick(R.id.txt_forget_pass)
    public void forgetPass() {
        startDialogForgetPass();
    }

    @Override
    public void startRegisterActivity() {
        RegisterActivity.start(getActivity());
    }

    @Override
    public void startDialogForgetPass() {
        CustomDialogForgetPassword dialog = new CustomDialogForgetPassword();
        dialog.show(getActivity().getFragmentManager(), TAG);
        dialog.setListener(new CustomDialogForgetPassword.OnClickListener() {
            @Override
            public void onClick(String username, String phone, String newPassword) {
                mPresenter.resetPassword(username, phone, newPassword);
            }
        });

    }

    @Override
    public void startDashboardActivity() {

        DashboardActivity.start(getActivity());
        getActivity().finish();
    }

    @Override
    public void startPhoneVerificationActivity(String userId, String newPassword) {
        PhoneVerificationActivity.startFromResetPassword(getActivity(), userId, newPassword);
    }

    @Override
    public void showError() {
        Activity activity = getActivity();
        if (activity != null) {
            new SweetAlertDialog(activity, SweetAlertDialog.ERROR_TYPE)
                    .setTitleText(getString(R.string.text_sweet_dialog_title))
                    .setContentText(getString(R.string.text_sweet_dialog_check_username_password))
                    .setConfirmText(getString(R.string.text_sweet_dialog_confirm_text))
                    .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                        @Override
                        public void onClick(SweetAlertDialog sweetAlertDialog) {
                            sweetAlertDialog.dismiss();
                        }
                    })
                    .show();
        }
    }

    @Override
    public void showErrorResetPassword() {
        Activity activity = getActivity();
        if (activity != null) {
            new SweetAlertDialog(activity, SweetAlertDialog.ERROR_TYPE)
                    .setTitleText(getString(R.string.text_sweet_dialog_title))
                    .setContentText(getString(R.string.text_username_or_phone_error))
                    .setConfirmText(getString(R.string.text_sweet_dialog_confirm_text))
                    .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                        @Override
                        public void onClick(SweetAlertDialog sweetAlertDialog) {
                            sweetAlertDialog.dismiss();
                        }
                    })
                    .show();
        }
    }

    @OnClick(R.id.img_see_password)
    public void seePassword() {
        if (!isClicked) {
            isClicked = true;
        } else {
            isClicked = false;
        }
        etPassword.setInputType(
                !isClicked ? InputType.TYPE_TEXT_VARIATION_PASSWORD : InputType.TYPE_CLASS_TEXT);
        etPassword.setTransformationMethod(
                !isClicked ? PasswordTransformationMethod.getInstance() : null);

        imgSeePassword.setImageResource(isClicked?R.drawable.ic_see_password : R.drawable.ic_see_password_off);
    }
}
