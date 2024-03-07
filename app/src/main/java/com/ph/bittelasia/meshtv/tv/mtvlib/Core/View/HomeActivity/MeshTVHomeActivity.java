package com.ph.bittelasia.meshtv.tv.mtvlib.Core.View.HomeActivity;

import android.os.Bundle;

import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.ph.bittelasia.meshtv.tv.mtvlib.R;

public abstract class MeshTVHomeActivity extends AppCompatActivity
{
    //===========================================Variable===========================================
    //-------------------------------------------Constant-------------------------------------------
    public static final String TAG = MeshTVHomeActivity.class.getSimpleName();
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //==========================================LifeCycle===========================================

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.meshtv_home_activty);
    }
    //==============================================================================================
    //==========================================Abstract============================================
    public abstract Class setSetUpActivity();
    public abstract Class setIPTVActivity();
    //==============================================================================================
}
