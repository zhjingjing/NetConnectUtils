package com.zj.network;

import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;

/**
 * create by zj on 2018/8/3
 */
public class BaseActivity extends FragmentActivity implements NetBroadcastReceiver.NetEvevt{
    public static NetBroadcastReceiver.NetEvevt evevt;

    public static int netState;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        evevt=this;
        this.netState=NetUtils.getNetState(this);
        isConnectNet();

        NetBroadcastReceiver receiver=new NetBroadcastReceiver();
        IntentFilter intentFilter=new IntentFilter();
        intentFilter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(receiver,intentFilter);


    }



    @Override
    public void onNetChange(int netWorkState) {
        this.netState=netWorkState;
        isConnectNet();
    }


    public static boolean isConnectNet(){
        if (netState==-1){
            return false;
        }else{
            return true;
        }

    }

}
