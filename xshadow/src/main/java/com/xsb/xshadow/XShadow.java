package com.xsb.xshadow;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

import com.xsb.xshadow.config.XShadowProperty;
import com.xsb.xshadow.view.XShadowDrawable;

/**
 * 阴影布局控件
 *
 * Created by yyp on 2018/7/11
 */
public class XShadow extends FrameLayout {

    public XShadow(@NonNull Context context) {
        this(context, null);
    }

    public XShadow(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, -1);
    }

    public XShadow(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        XShadowProperty property = new XShadowProperty();
        TypedArray attr = context.obtainStyledAttributes(attrs, R.styleable.XShadow, 0, 0);
        if (attr == null) {
            return;
        }

        try {
            property.setShadowColor(attr.getColor(R.styleable.XShadow_shadow_color,
                    getResources().getColor(R.color.shadow_color)));
            property.setShadowRadius(attr.getDimension(R.styleable.XShadow_shadow_radius,
                    getResources().getDimension(R.dimen.shadow_radius)));
            property.setCornerRadius(attr.getDimension(R.styleable.XShadow_corner_radius,
                    getResources().getDimension(R.dimen.corner_radius)));
            property.setShadowWidth(attr.getDimension(R.styleable.XShadow_shadow_width,
                    getResources().getDimension(R.dimen.shadow_width)));
            int side = attr.getInteger(R.styleable.XShadow_shadow_side, 0x1111);
            property.setShadowSide(side);
        } finally {
            attr.recycle();
        }

        setProperty(property);
    }

    public void setProperty(XShadowProperty property) {
        XShadowDrawable sd = new XShadowDrawable(property);
        setBackground(sd);
        setLayerType(View.LAYER_TYPE_SOFTWARE, null);
    }
}
