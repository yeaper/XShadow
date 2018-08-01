package com.xsb.xshadow.config;

import java.io.Serializable;

public class XShadowProperty implements Serializable {

    /**
     * 阴影颜色
     */
    private int shadowColor;
    /**
     * 阴影模糊半径，而不是外圆角半径，值越大越模糊
     */
    private float shadowRadius;
    /**
     * 阴影内角半径
     */
    private float cornerRadius;
    /**
     * 阴影宽度
     */
    private float shadowWidth;

    /**
     * 阴影边
     */
    @XShadowSide
    private int shadowSide;

    public int getShadowSide() {
        return shadowSide;
    }

    public XShadowProperty setShadowSide(@XShadowSide int shadowSide) {
        this.shadowSide = shadowSide;
        return this;
    }

    public int getShadowColor() {
        return shadowColor;
    }

    public XShadowProperty setShadowColor(int shadowColor) {
        this.shadowColor = shadowColor;
        return this;
    }

    public float getShadowRadius() {
        return shadowRadius;
    }

    public XShadowProperty setShadowRadius(float shadowRadius) {
        this.shadowRadius = shadowRadius;
        return this;
    }

    public float getCornerRadius() {
        return cornerRadius;
    }

    public XShadowProperty setCornerRadius(float cornerRadius) {
        this.cornerRadius = cornerRadius;
        return this;
    }

    public float getShadowWidth() {
        return shadowWidth;
    }

    public XShadowProperty setShadowWidth(float shadowWidth) {
        this.shadowWidth = shadowWidth;
        return this;
    }
}