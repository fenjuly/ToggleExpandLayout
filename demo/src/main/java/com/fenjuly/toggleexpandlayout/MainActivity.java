package com.fenjuly.toggleexpandlayout;

import android.annotation.TargetApi;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;

import com.fenjuly.mylibrary.ToggleExpandLayout;
import com.kyleduo.switchbutton.SwitchButton;


public class MainActivity extends ActionBarActivity {

    @Override
    @TargetApi(21)
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ToggleExpandLayout layout = (ToggleExpandLayout) findViewById(R.id.toogleLayout);
        final ToggleExpandLayout layout2 = (ToggleExpandLayout) findViewById(R.id.toogleLayout2);
        final ToggleExpandLayout layout3 = (ToggleExpandLayout) findViewById(R.id.toogleLayout3);
        SwitchButton switchButton = (SwitchButton) findViewById(R.id.switch_button);

        layout.setOnToggleTouchListener(new ToggleExpandLayout.OnToggleTouchListener() {
            @Override
            public void onStartOpen(int height, int originalHeight) {
            }

            @Override
            public void onOpen() {
               int childCount = layout.getChildCount();
               for(int i = 0; i < childCount; i++) {
                   View view = layout.getChildAt(i);
                   view.setElevation(dp2px(1));
               }
            }

            @Override
            public void onStartClose(int height, int originalHeight) {
                int childCount = layout.getChildCount();
                for(int i = 0; i < childCount; i++) {
                    View view = layout.getChildAt(i);
                    view.setElevation(dp2px(i));
                }
            }

            @Override
            public void onClosed() {

            }
        });

        switchButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    layout.open();
                } else {
                    layout.close();
                }
            }
        });

        SwitchButton switchButton2 = (SwitchButton) findViewById(R.id.switch_button2);

        layout2.setOnToggleTouchListener(new ToggleExpandLayout.OnToggleTouchListener() {
            @Override
            public void onStartOpen(int height, int originalHeight) {
            }

            @Override
            public void onOpen() {
                int childCount = layout2.getChildCount();
                for(int i = 0; i < childCount; i++) {
                    View view = layout2.getChildAt(i);
                    view.setElevation(dp2px(1));
                }
            }

            @Override
            public void onStartClose(int height, int originalHeight) {
                int childCount = layout2.getChildCount();
                for(int i = 0; i < childCount; i++) {
                    View view = layout2.getChildAt(i);
                    view.setElevation(dp2px(i));
                }
            }

            @Override
            public void onClosed() {

            }
        });

        switchButton2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    layout2.open();
                } else {
                    layout2.close();
                }
            }
        });


        SwitchButton switchButton3 = (SwitchButton) findViewById(R.id.switch_button3);

        layout3.setOnToggleTouchListener(new ToggleExpandLayout.OnToggleTouchListener() {
            @Override
            public void onStartOpen(int height, int originalHeight) {
            }

            @Override
            public void onOpen() {
                int childCount = layout3.getChildCount();
                for(int i = 0; i < childCount; i++) {
                    View view = layout3.getChildAt(i);
                    view.setElevation(dp2px(1));
                }
            }

            @Override
            public void onStartClose(int height, int originalHeight) {
                int childCount = layout3.getChildCount();
                for(int i = 0; i < childCount; i++) {
                    View view = layout3.getChildAt(i);
                    view.setElevation(dp2px(i));
                }
            }

            @Override
            public void onClosed() {

            }
        });

        switchButton3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Log.e("switchbutton open", "invoked");
                    layout3.open();
                } else {
                    Log.e("switchbutton close", "invoked");
                    layout3.close();
                }
            }
        });

    }

    public float dp2px(float dp) {
        final float scale = getResources().getDisplayMetrics().density;
        return dp * scale + 0.5f;
    }
}
