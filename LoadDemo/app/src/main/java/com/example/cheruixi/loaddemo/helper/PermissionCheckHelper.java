package com.example.cheruixi.loaddemo.helper;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;

import java.util.ArrayList;

/**
 * Created by cheruixi on 2018/2/12.
 */

public class PermissionCheckHelper {
    public static boolean checkPermission(Activity context){
        ArrayList<String> requeiredPermissions = new ArrayList<>();

        //request for the read contact permission
        if(ContextCompat.checkSelfPermission(context, Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED){
            requeiredPermissions.add(Manifest.permission.READ_CONTACTS);
        }

        if(!requeiredPermissions.isEmpty()){
            ActivityCompat.requestPermissions(context, requeiredPermissions.toArray(new String[requeiredPermissions.size()]), 100);
            return false;
        }
        return true;
    }
}
