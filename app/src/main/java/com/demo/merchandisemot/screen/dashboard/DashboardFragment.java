package com.demo.merchandisemot.screen.dashboard;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AlertDialog;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.demo.architect.data.model.offline.ContactEntity;
import com.goitho.employeeapp.R;
import com.goitho.employeeapp.app.CoreApplication;
import com.goitho.employeeapp.app.base.BaseFragment;
import com.goitho.employeeapp.constants.Constants;
import com.goitho.employeeapp.dialogs.CustomDialogBooking;
import com.goitho.employeeapp.manager.ListContactManager;
import com.goitho.employeeapp.manager.UserManager;
import com.goitho.employeeapp.screen.employeewallet.EmployeeWalletFragment;
import com.goitho.employeeapp.screen.employeewallet.EmployeeWalletModule;
import com.goitho.employeeapp.screen.employeewallet.EmployeeWalletPresenter;
import com.goitho.employeeapp.screen.history.HistoryFragment;
import com.goitho.employeeapp.screen.history.HistoryModule;
import com.goitho.employeeapp.screen.history.HistoryPresenter;
import com.goitho.employeeapp.screen.login.LoginActivity;
import com.goitho.employeeapp.screen.notification.NotificationFragment;
import com.goitho.employeeapp.screen.notification.NotificationModule;
import com.goitho.employeeapp.screen.notification.NotificationPresenter;
import com.goitho.employeeapp.screen.order.OrderFragment;
import com.goitho.employeeapp.screen.order.OrderModule;
import com.goitho.employeeapp.screen.order.OrderPresenter;
import com.goitho.employeeapp.screen.promotion.PromotionFragment;
import com.goitho.employeeapp.screen.promotion.PromotionModule;
import com.goitho.employeeapp.screen.promotion.PromotionPresenter;
import com.goitho.employeeapp.screen.screen_goitho.profile.ProfileFragment;
import com.goitho.employeeapp.screen.screen_goitho.profile.ProfileModule;
import com.goitho.employeeapp.screen.screen_goitho.profile.ProfilePresenter;
import com.goitho.employeeapp.util.Precondition;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

import java.util.Timer;
import java.util.TimerTask;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by admin on 4/9/17.
 */

public class DashboardFragment extends BaseFragment implements DashboardContract.View {
    private final static String TAG = DashboardFragment.class.getName();
    public static boolean positionOrderFragment;
    private DashboardContract.Presenter mPresenter;
    @Inject
    OrderPresenter orderPresenter;

    @Inject
    EmployeeWalletPresenter employeeWalletPresenter;

    @Inject
    ProfilePresenter profilePresenter;

    @Inject
    HistoryPresenter historyPresenter;

    @Inject
    PromotionPresenter promotionPresenter;

    @Inject
    NotificationPresenter notificationPresenter;

    @Inject
    DashboardPresenter dashboardPresenter;

    private OrderFragment orderFragment;
    private EmployeeWalletFragment employeeWalletFragment;
    private ProfileFragment profileFragment;
    private HistoryFragment historyFragment;
    private PromotionFragment promotionFragment;
    private NotificationFragment notificationFragment;

    private boolean startNoti = false;

    @Bind(R.id.ln_go_order)
    LinearLayout lnGoOrder;

    @Bind(R.id.ln_go_wallet)
    LinearLayout lnGoWallet;

    @Bind(R.id.ln_go_profile)
    LinearLayout lnGoProfile;

    @Bind(R.id.ln_go_history)
    LinearLayout lnGoHistory;

    @Bind(R.id.ln_go_program)
    LinearLayout lnGoProgram;

    @Bind(R.id.ln_go_notification)
    LinearLayout lnGoNotification;

    @Bind(R.id.ln_go_logout)
    LinearLayout lnGoLogOut;

    @Bind(R.id.drawer_layout)
    DrawerLayout drawer;

    @Bind(R.id.img_avt)
    CircleImageView img_avt;

    @Bind(R.id.txt_name)
    TextView tvName;

    @Bind(R.id.txt_user_id)
    TextView tvUserId;

    @Bind(R.id.tv_number_notification)
    TextView tvNumberNotification;

    @Bind(R.id.rl_number_notification)
    RelativeLayout rlNumberNotification;

    public static DashboardFragment newInstance() {
        DashboardFragment fragment = new DashboardFragment();
        return fragment;
    }

    public DashboardFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_drawer_nav, container, false);
        ButterKnife.bind(this, view);
        startNoti = getActivity().getIntent().getBooleanExtra(Constants.KEY_START_NOTIFICATION, false);

        configFragments();
        initView(view);
        goStartNotifi();
        return view;
    }

    private void goStartNotifi() {
        if (startNoti) {
            goNotification();
        }
    }

    private void configFragments() {
        boolean noFragmentAdded = false;
        Fragment currentFragment = getChildFragmentManager().findFragmentById(R.id.fragmentContainer);
        if (currentFragment != null) {
            if (currentFragment instanceof OrderFragment) {
                orderFragment = (OrderFragment) currentFragment;
            } else if (currentFragment instanceof EmployeeWalletFragment) {
                employeeWalletFragment = (EmployeeWalletFragment) currentFragment;
            } else if (currentFragment instanceof ProfileFragment) {
                profileFragment = (ProfileFragment) currentFragment;
            } else if (currentFragment instanceof HistoryFragment) {
                historyFragment = (HistoryFragment) currentFragment;
            } else if (currentFragment instanceof PromotionFragment) {
                promotionFragment = (PromotionFragment) currentFragment;
            } else if (currentFragment instanceof NotificationFragment) {
                notificationFragment = (NotificationFragment) currentFragment;
            }
        } else {
            noFragmentAdded = true;
        }

        if (orderFragment == null) {
            orderFragment = OrderFragment.newInstance();
        }

        if (employeeWalletFragment == null) {
            employeeWalletFragment = EmployeeWalletFragment.newInstance();
        }

        if (profileFragment == null) {
            profileFragment = ProfileFragment.newInstance();
        }

        if (historyFragment == null) {
            historyFragment = HistoryFragment.newInstance();
        }

        if (promotionFragment == null) {
            promotionFragment = PromotionFragment.newInstance();
        }

        if (notificationFragment == null) {
            notificationFragment = NotificationFragment.newInstance();
        }

//
//        if (incomeFragment == null) {
//            incomeFragment = IncomeFragment.newInstance();
//       }
//        if (walletPayFragment == null) {
//            walletPayFragment = WalletPayFragment.newInstance();
//        }
//        if (techniqueFragment == null) {
//            techniqueFragment = TechniqueFragment.newInstance();
//        }
//        if (editProfileFragment == null) {
//            editProfileFragment = EditProfileFragment.newInstance();
//        }


        CoreApplication.getInstance().getApplicationComponent().plus(
                new OrderModule(orderFragment),
                new EmployeeWalletModule(employeeWalletFragment),
                new ProfileModule(profileFragment),
                new HistoryModule(historyFragment),
                new PromotionModule(promotionFragment),
                new NotificationModule(notificationFragment),
                new DashboardModule(this)
//                ,
//                new IncomeModule(incomeFragment),
//                new WalletPayModule(walletPayFragment),
//                new TechniqueModule(techniqueFragment),
//                new EditProfileModule(editProfileFragment)
        ).inject(this);

        if (noFragmentAdded) {
            addFragment(orderFragment, orderFragment.getClass().toString(), R.id.fragmentContainer);
        }
    }

    private void initView(View view) {
        if (!TextUtils.isEmpty(UserManager.getInstance().getUser().getAvatarImage())) {
            Picasso.with(getContext()).load(UserManager.getInstance().getUser().getAvatarImage()).networkPolicy(NetworkPolicy.NO_CACHE).memoryPolicy(MemoryPolicy.NO_CACHE, MemoryPolicy.NO_STORE).into(img_avt);
        }

        tvName.setText(UserManager.getInstance().getUser().getUserFullName());
        tvUserId.setText("Mã thợ: " + UserManager.getInstance().getUser().getUserId());


    }

    @Override
    public void onSaveInstanceState(Bundle outState) {

    }

    @Override
    public void setPresenter(DashboardContract.Presenter presenter) {
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
        CoreApplication.registerForEvents(this);

        //repeat after 120 second
        Timer timer = new Timer();
        TimerTask myTask = new TimerTask() {
            @Override
            public void run() {
                mPresenter.start();
            }
        };

        timer.schedule(myTask, 1000, 120000);
    }

    @Override
    public void onPause() {
        super.onPause();
        CoreApplication.unregisterForEvents(this);
    }

    @OnClick(R.id.ln_go_order)
    public void goOrder() {
        positionOrderFragment = true;
        setBackgroundLN(lnGoOrder);
        drawer.closeDrawer(GravityCompat.START);
        replaceFragment(orderFragment, orderFragment.getClass().toString(), R.id.fragmentContainer);
    }

    @OnClick(R.id.ln_go_wallet)
    public void goWallet() {
        positionOrderFragment = false;
        setBackgroundLN(lnGoWallet);
        drawer.closeDrawer(GravityCompat.START);
        replaceFragment(employeeWalletFragment, employeeWalletFragment.getClass().toString(), R.id.fragmentContainer);
    }

    @OnClick(R.id.ln_go_profile)
    public void goProfile() {
        positionOrderFragment = false;
        setBackgroundLN(lnGoProfile);
        drawer.closeDrawer(GravityCompat.START);
        replaceFragment(profileFragment, profileFragment.getClass().toString(), R.id.fragmentContainer);
    }

    @OnClick(R.id.ln_go_history)
    public void goHistory() {
        positionOrderFragment = false;
        setBackgroundLN(lnGoHistory);
        drawer.closeDrawer(GravityCompat.START);
        replaceFragment(historyFragment, historyFragment.getClass().toString(), R.id.fragmentContainer);
    }

    @OnClick(R.id.ln_go_program)
    public void goProgram() {
        positionOrderFragment = false;
        setBackgroundLN(lnGoProgram);
        drawer.closeDrawer(GravityCompat.START);
        replaceFragment(promotionFragment, promotionFragment.getClass().toString(), R.id.fragmentContainer);
    }

    @OnClick(R.id.ln_go_notification)
    public void goNotification() {
        positionOrderFragment = false;
        setBackgroundLN(lnGoNotification);
        drawer.closeDrawer(GravityCompat.START);
        replaceFragment(notificationFragment, notificationFragment.getClass().toString(), R.id.fragmentContainer);
    }

    @OnClick(R.id.ln_go_logout)
    public void goLogOut() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Thông báo");
        builder.setMessage("Bạn có muốn đăng xuất không?");
        builder.setCancelable(false);
        builder.setPositiveButton("Không", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        builder.setNegativeButton("Có", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                getActivity().finish();
                UserManager.getInstance().setUser(null);
                LoginActivity.start(getActivity(), true);
                dialogInterface.dismiss();
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();


    }

    @OnClick(R.id.img_ac_call)
    public void call() {
        String phoneHaNoi = "";
        String phoneHCM = "";
        for (ContactEntity item : ListContactManager.getInstance().getContact().getLinkContact()) {
            if (item.getType().equals("phoneHN")) {
                phoneHaNoi = item.getContent();
            }

            if (item.getType().equals("phoneHCM")) {
                phoneHCM = item.getContent();
            }
        }
        CustomDialogBooking dialog = new CustomDialogBooking();
        dialog.show(getActivity().getFragmentManager(), TAG);
        dialog.setPhoneHaNoi(phoneHaNoi);
        dialog.setPhoneHCM(phoneHCM);


    }

    @OnClick(R.id.img_ac_fb)
    public void facebook() {
        String link = "";
        String id = "";
        for (ContactEntity item : ListContactManager.getInstance().getContact().getLinkContact()) {
            if (item.getType().contains("facebook")) {
                link = item.getContent();
            }
            if (item.getType().contains("idFacebook")) {
                id = item.getContent();
            }
        }
        Intent intent = new Intent();
        try {
            getContext().getPackageManager().getPackageInfo("com.facebook.katana", 0);
            intent =  new Intent(Intent.ACTION_VIEW, Uri.parse("fb://page/"+id));
        } catch (PackageManager.NameNotFoundException ignored) {

            intent =  new Intent(Intent.ACTION_VIEW, Uri.parse(link));

        }

        startActivity(intent);

    }

    @OnClick(R.id.img_ac_sms)
    public void email() {
        String email = "";
        for (ContactEntity item : ListContactManager.getInstance().getContact().getLinkContact()) {
            if (item.getType().contains("email")) {

                email = item.getContent();
                break;
            }
        }
        Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                "mailto", email, null));
        startActivity(Intent.createChooser(emailIntent, "Send email..."));
    }

    private void setBackgroundLN(LinearLayout ln) {
        clearBackround();
        ln.setBackgroundResource(R.drawable.bg_solid_grey);

    }

    public void openNavigation() {
        drawer.openDrawer(GravityCompat.START);
    }

    public void setNotificationNumber(int number) {
        if (number > 0) {
            rlNumberNotification.setVisibility(View.VISIBLE);
            tvNumberNotification.setText(number + "");
        } else {
            rlNumberNotification.setVisibility(View.INVISIBLE);
        }
    }

    private void clearBackround() {
        lnGoOrder.setBackground(null);
        lnGoWallet.setBackground(null);
        lnGoProfile.setBackground(null);
        lnGoHistory.setBackground(null);
        lnGoProgram.setBackground(null);
        lnGoNotification.setBackground(null);
    }
}