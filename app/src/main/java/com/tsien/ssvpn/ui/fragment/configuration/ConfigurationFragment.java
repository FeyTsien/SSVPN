package com.tsien.ssvpn.ui.fragment.configuration;


import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.blankj.utilcode.util.LogUtils;
import com.tsien.ssvpn.R;
import com.tsien.ssvpn.mvp.MVPBaseFragment;
import com.tsien.ssvpn.ui.widget.fabbutton.FabButton;

/**
 * MVPPlugin
 *  邮箱 784787081@qq.com
 */

public class ConfigurationFragment extends MVPBaseFragment<ConfigurationContract.View, ConfigurationPresenter> implements ConfigurationContract.View {

    private String TAG = getClass().getSimpleName();

    private View mRootView;
    private TextView mTvLinkState;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mRootView = inflater.inflate(R.layout.fragment_configuration, container, false);
        initView();
        return mRootView;
    }

    private void initView(){
        mTvLinkState = mRootView.findViewById(R.id.tv_link_state);
        final FabButton button = (FabButton) mRootView.findViewById(R.id.determinate);
        final ProgressHelper helper = new ProgressHelper(button, getActivity());

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                helper.startIndeterminate();
                mTvLinkState.setText("连接中...");
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        helper.stopIndeterminate();
                        mTvLinkState.setText("已连接");
                    }
                }, 2000);

            }
        });
    }
}
