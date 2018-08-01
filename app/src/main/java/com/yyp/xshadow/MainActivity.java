package com.yyp.xshadow;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.xsb.xshadow.XShadow;
import com.xsb.xshadow.config.XShadowProperty;
import com.xsb.xshadow.config.XShadowSide;

public class MainActivity extends AppCompatActivity {

    private XShadow shadow1;
    private XShadow shadow2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initShadow();
    }

    private void initView() {
        shadow1 = findViewById(R.id.shadow1);
        shadow2 = findViewById(R.id.shadow2);
    }

    private void initShadow() {

        shadow2.setProperty(new XShadowProperty()
                .setShadowColor(0x21000000)
                .setShadowRadius(dip2px(10))
                .setCornerRadius(dip2px(2))
                .setShadowWidth(dip2px(10))
                .setShadowSide(XShadowSide.ALL));
    }

    public int dip2px(float dpValue) {
        final float scale = getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }
}
