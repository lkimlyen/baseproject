package com.demo.merchandisemot.screen.notification;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.demo.architect.data.model.NotificationEntity;
import com.goitho.employeeapp.R;
import com.goitho.employeeapp.adapter.NotificationAdapter;
import com.goitho.employeeapp.app.base.BaseFragment;
import com.goitho.employeeapp.manager.ListNotificationsManager;
import com.goitho.employeeapp.screen.dashboard.DashboardFragment;
import com.goitho.employeeapp.util.Precondition;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.pedant.SweetAlert.SweetAlertDialog;

/**
 * Created by Skull on 22/03/2018.
 */

public class NotificationFragment extends BaseFragment implements NotificationContract.View {

    private NotificationContract.Presenter mPresenter;

    @Bind(R.id.recycler_view)
    RecyclerView recyclerView;

    @Bind(R.id.swipe_refresh)
    SwipeRefreshLayout swipeRefresh;

    @Bind(R.id.tv_no_data)
    TextView tvNoData;

    NotificationAdapter adapter;

    public NotificationFragment() {
        // Required empty public constructor
    }


    public static NotificationFragment newInstance() {
        NotificationFragment fragment = new NotificationFragment();
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
        View view = inflater.inflate(R.layout.fragment_notification, container, false);
        ButterKnife.bind(this, view);
        configRecyclerView();
        swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mPresenter.loadListNoti();
            }
        });
        return view;
    }

    private void configRecyclerView() {
        adapter= new NotificationAdapter(new ArrayList<NotificationEntity>(), getActivity(),
                new NotificationAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(NotificationEntity item, int position) {
                        if(item.getStatus() == 0) {
                            mPresenter.setReadNotification(item.getNotificationId());
                            item.setStatus(1);
                            adapter.notifyDataSetChanged();
                        }
                        Dialog dialog = new Dialog(getActivity(), android.R.style.Theme_Translucent_NoTitleBar_Fullscreen);
                        dialog.setContentView(R.layout.dialog_notification);
                        TextView txtTitle= dialog.findViewById(R.id.txt_title);
                        TextView txtMessage= dialog.findViewById(R.id.txt_message);
                        txtTitle.setText(item.getNotificationName());
                        txtMessage.setText(item.getNotificationContent());
                        LinearLayout layout = dialog.findViewById(R.id.layout_noti);
                        layout.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                dialog.dismiss();
                            }
                        });
                        dialog.show();
                    }
                });

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void setPresenter(NotificationContract.Presenter presenter) {
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

    @Override
    public void showListNoti(List<NotificationEntity> list) {
        adapter.setData(list);
        if(list.size() == 0) {
            showImageRefresh(true);
        } else {
            showImageRefresh(false);
        }


    }

    @OnClick(R.id.img_nav)
    public void openNavigation(){
        Fragment parentFragment = getParentFragment();
        if(parentFragment != null && parentFragment instanceof DashboardFragment){
            ((DashboardFragment)parentFragment).openNavigation();
        }
    }

    @Override
    public void setSwipeRefresh(boolean isRefresh) {
        swipeRefresh.setRefreshing(isRefresh);
    }

    @Override
    public void showImageRefresh(boolean isShow) {
        if(isShow) {
            tvNoData.setVisibility(View.VISIBLE);
        } else {
            tvNoData.setVisibility(View.GONE);
        }
    }

    @Override
    public void showError() {
        Activity activity = getActivity();
        if (activity != null) {
            new SweetAlertDialog(activity, SweetAlertDialog.ERROR_TYPE)
                    .setTitleText(getString(R.string.text_sweet_dialog_title))
                    .setContentText(getString(R.string.text_sweet_dialog_error))
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
    public void refreshNewNotificationInNavigation() {
        Fragment parentFragment = getParentFragment();
        if (parentFragment != null && parentFragment instanceof DashboardFragment) {
            ((DashboardFragment) parentFragment).setNotificationNumber(ListNotificationsManager.getInstance()
                    .getListNotifications().size());
        }
    }
}

