package com.tsien.ssvpn.ui.fragment.notice;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.blankj.utilcode.util.LogUtils;
import com.tsien.ssvpn.R;
import com.tsien.ssvpn.mvp.MVPBaseFragment;

/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class NoticeFragment extends MVPBaseFragment<NoticeContract.View, NoticePresenter> implements NoticeContract.View {

    private String TAG = getClass().getSimpleName();

    private View mRootView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mRootView = inflater.inflate(R.layout.fragment_notice, container, false);
        return mRootView;
    }
}
