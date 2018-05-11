package com.demo.merchandisemot.screen.dashboard;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;

import com.goitho.employeeapp.R;
import com.goitho.employeeapp.app.base.BaseActivity;
import com.goitho.employeeapp.app.di.Precondition;
import com.goitho.employeeapp.constants.Constants;
import com.goitho.employeeapp.util.LocationHelper;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;

import javax.inject.Inject;

/**
 * Created by admin on 4/8/17.
 */

public class DashboardActivity extends BaseActivity implements  GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener {
    public static final String TAG = DashboardActivity.class.getName();
    private LocationHelper mLocationHelper;

    @Inject
    DashboardPresenter presenter;

    private DashboardFragment fragment;

    public static void start(Context context) {
        Intent intent = new Intent(context, DashboardActivity.class);
        context.startActivity(intent);
    }

    public static void startNotification(Context context) {
        Intent intent = new Intent(context, DashboardActivity.class);
        intent.putExtra(Constants.KEY_START_NOTIFICATION, true);
        context.startActivity(intent);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);

        initializeIntent();
        initializeFragment();

        if (savedInstanceState != null) {

        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    private void initializeIntent() {
        Intent intent = getIntent();
    }

    private void initializeFragment() {
        fragment = (DashboardFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentContainer);
        if (fragment == null) {
            fragment = DashboardFragment.newInstance();
            addFragmentToBackStack(fragment, R.id.fragmentContainer);
        }
    }

    protected void addFragmentToBackStack(Fragment fragment, int frameId) {
        Precondition.checkNotNull(fragment);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(frameId, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    public void onBackPressed() {
        if (DashboardFragment.positionOrderFragment) {
            super.onBackPressed();
        } else {
            fragment.goOrder();
        }
    }

    @Override
    public void onConnected(@Nullable Bundle bundle) {

    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        mLocationHelper.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(fragment != null) {
            fragment.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }
}
