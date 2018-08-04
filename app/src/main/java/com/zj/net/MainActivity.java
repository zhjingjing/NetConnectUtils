package com.zj.net;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.zj.network.BaseActivity;

public class MainActivity extends BaseActivity {

    boolean netState;
    TextView tvNet;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvNet=findViewById(R.id.tv_net);
        netState=this.isConnectNet();
        if (netState){
            tvNet.setText("xxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        }else{
            tvNet.setText("网络不给力，请检查网络设置");
        }

    }

    @Override
    public void onNetChange(int netWorkState) {
        super.onNetChange(netWorkState);
        if (netWorkState==-1){
            tvNet.setText("网络不给力，请检查网络设置");
        }else{
            tvNet.setText("xxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        }
    }
}
