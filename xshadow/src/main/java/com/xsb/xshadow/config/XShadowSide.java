package com.xsb.xshadow.config;

import android.support.annotation.IntDef;

/**
 * 阴影边的所有情况
 *
 * Created by yyp on 2018/7/11
 */
@IntDef(flag = true, value = {XShadowSide.LEFT, XShadowSide.TOP,
        XShadowSide.RIGHT, XShadowSide.BOTTOM, XShadowSide.ALL})
public @interface XShadowSide {

    int ALL = 0x1111;
    int LEFT = 0x0001;
    int TOP = 0x0010;
    int RIGHT = 0x0100;
    int BOTTOM = 0x1000;
}