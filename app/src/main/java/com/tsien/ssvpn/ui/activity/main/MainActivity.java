package com.tsien.ssvpn.ui.activity.main;


import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.tsien.ssvpn.R;
import com.tsien.ssvpn.mvp.MVPBaseActivity;
import com.tsien.ssvpn.utils.ToastUtil;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * MVPPlugin
 *  邮箱 784787081@qq.com
 */

public class MainActivity extends MVPBaseActivity<MainContract.View, MainPresenter> implements MainContract.View,NavigationView.OnNavigationItemSelectedListener {


    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawer;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
    }

    private void initView(){
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setLogo(R.drawable.ic_menu_configuration);
        toolbar.setTitle("  配置");
        setSupportActionBar(toolbar);

        //浮动按钮
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        //侧滑菜单
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        //侧滑菜单头部控件初始化
        View headerLayout  = (LinearLayout) navigationView.inflateHeaderView(R.layout.nav_header_main);
        ImageView head = (ImageView) headerLayout.findViewById(R.id.imageView);
        head.setImageResource(R.mipmap.ic_launcher_round);
        TextView myName = (TextView) headerLayout.findViewById(R.id.tv_1);
        myName.setText("SSPVN");

        //设置默认显示第一页（配置）
        navigationView.getMenu().getItem(0).setChecked(true);
    }


    /**
     * 创建右上角三个点的功能
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (item.getItemId()){
            case R.id.nav_configuration:
                toolbar.setLogo(R.drawable.ic_menu_configuration);
                toolbar.setTitle("  配置");
                ToastUtil.show(this,"configuration");
                break;
            case R.id.nav_account:
                toolbar.setLogo(R.drawable.ic_menu_account);
                toolbar.setTitle("  账户");
                ToastUtil.show(this,"account");
                break;
            case R.id.nav_buy:
                toolbar.setLogo(R.drawable.ic_menu_buy);
                toolbar.setTitle("  购买");
                ToastUtil.show(this,"buy");
                break;
            case R.id.nav_system:
                toolbar.setLogo(R.drawable.ic_menu_paper_plane);
                toolbar.setTitle("  公告");
                ToastUtil.show(this,"system");
                break;
            case R.id.nav_share:
                ToastUtil.show(this,"share");
                return true;
            case R.id.nav_send:
                ToastUtil.show(this,"send");
                return true;
        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}
