package com.ctaken.gank4u.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ctaken.gank4u.R;

/**
 * Created by chentaikang on 2017/1/17 11:59.
 */

public class LoadingDialog extends Dialog {

    private TextView tv;
    public LoadingDialog(Context context) {
        super(context, R.style.loadingDialogStyle);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_loading);
        tv = (TextView) findViewById(R.id.tv);
        tv.setVisibility(View.GONE);
        LinearLayout linearLayout = (LinearLayout) this.findViewById(R.id.LinearLayout);
        linearLayout.getBackground().setAlpha(210);
    }

    public void setMessage(String message){
        tv.setText(message);
        tv.setVisibility(View.VISIBLE);
    }
}
