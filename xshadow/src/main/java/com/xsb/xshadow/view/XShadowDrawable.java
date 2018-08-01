package com.xsb.xshadow.view;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;

import com.xsb.xshadow.config.XShadowProperty;
import com.xsb.xshadow.config.XShadowSide;

/**
 * 阴影控件操作类
 *
 * Created by yyp on 2018/7/11
 */
public class XShadowDrawable extends Drawable {
    private Paint paint;
    private RectF bounds = new RectF();
    private XShadowProperty shadowProperty;
    private RectF drawRect;

    public XShadowDrawable(XShadowProperty XShadowProperty) {
        this.shadowProperty = XShadowProperty;

        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setFilterBitmap(true);
        paint.setDither(true);
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.WHITE);
        /*
         * 设置阴影
         */
        paint.setShadowLayer(XShadowProperty.getShadowRadius() <= 0 ? 1 : XShadowProperty.getShadowRadius()
                , 0, 0, XShadowProperty.getShadowColor());

        drawRect = new RectF();
    }

    @Override
    protected void onBoundsChange(Rect bounds) {
        super.onBoundsChange(bounds);
        if (bounds.right - bounds.left > 0 && bounds.bottom - bounds.top > 0) {
            this.bounds.left = bounds.left;
            this.bounds.right = bounds.right;
            this.bounds.top = bounds.top;
            this.bounds.bottom = bounds.bottom;
            float width = (int) (this.bounds.right - this.bounds.left);
            float height = (int) (this.bounds.bottom - this.bounds.top);

            // 设置阴影宽度和边
            int shadowSide = shadowProperty.getShadowSide();
            float shadowOffset = shadowProperty.getShadowWidth();
            float left = (shadowSide & XShadowSide.LEFT) == XShadowSide.LEFT ? shadowOffset : 0;
            float top = (shadowSide & XShadowSide.TOP) == XShadowSide.TOP ? shadowOffset : 0;
            float right = width - ((shadowSide & XShadowSide.RIGHT) == XShadowSide.RIGHT ? shadowOffset : 0);
            float bottom = height - ((shadowSide & XShadowSide.BOTTOM) == XShadowSide.BOTTOM ? shadowOffset : 0);

            drawRect = new RectF(left, top, right, bottom);

            invalidateSelf();
        }
    }

    @Override
    public void draw(@NonNull Canvas canvas) {
        paint.setXfermode(null);
        canvas.drawRoundRect(drawRect, shadowProperty.getCornerRadius(),
                shadowProperty.getCornerRadius(), paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OUT));
        canvas.drawRoundRect(drawRect, shadowProperty.getCornerRadius(),
                shadowProperty.getCornerRadius(), paint);
    }

    @Override
    public void setAlpha(int alpha) {

    }

    @Override
    public void setColorFilter(ColorFilter cf) {

    }

    @Override
    public int getOpacity() {
        return PixelFormat.UNKNOWN;
    }
}