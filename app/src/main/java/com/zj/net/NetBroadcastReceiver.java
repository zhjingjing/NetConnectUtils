package com.zj.net;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;


/**
 * create by zj on 2018/8/3
 */
public class NetBroadcastReceiver extends BroadcastReceiver {
    public NetEvent evevt = BaseActivity.evevt;

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(ConnectivityManager.CONNECTIVITY_ACTION)){
                int netWorkState = NetUtils.getNetState(context);
                evevt.onNetChange(netWorkState);
        }
    }

    // 自定义接口
    public interface NetEvent {
         void onNetChange(int netWorkState);
    }
}
