package com.dev.Lipstick_AR.form.service;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.dev.Lipstick_AR.form.FormOrder;

public class Check_Internet {

    public boolean isConnected(FormOrder formOrder) {
        ConnectivityManager connectivityManager = (ConnectivityManager) formOrder.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo wifi_info = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        NetworkInfo mobile_info = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);

        if(
                (wifi_info != null && wifi_info.isConnected() || mobile_info != null && mobile_info.isConnected())
        ){
            return true;

        }else{
            return false;
        }
    }
}
