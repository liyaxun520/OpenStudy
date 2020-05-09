package com.decard.lib.jnistruct.data;

import android.graphics.PointF;
import android.graphics.Rect;

import java.util.Arrays;

public class DataBean {
    private Rect mRect;
    private PointF[] mPoints;
    private Inner mInner;
    private int mID; // 整型
    private float mScore; // 浮点型
    private byte[] mData; // 基本类型数组
    private int[][] mDoubleDimenArray; // 二维数组

    public Rect getRect() {
        return mRect;
    }

    public void setRect(Rect rect) {
        this.mRect = rect;
    }

    public PointF[] getmPoints() {
        return mPoints;
    }

    public void setmPoints(PointF[] mPoints) {
        this.mPoints = mPoints;
    }

    public Inner getmInner() {
        return mInner;
    }

    public void setmInner(Inner mInner) {
        this.mInner = mInner;
    }

    public int getmID() {
        return mID;
    }

    public void setmID(int mID) {
        this.mID = mID;
    }

    public float getmScore() {
        return mScore;
    }

    public void setmScore(float mScore) {
        this.mScore = mScore;
    }

    public byte[] getmData() {
        return mData;
    }

    public void setmData(byte[] mData) {
        this.mData = mData;
    }

    public int[][] getmDoubleDimenArray() {
        return mDoubleDimenArray;
    }

    public void setmDoubleDimenArray(int[][] mDoubleDimenArray) {
        this.mDoubleDimenArray = mDoubleDimenArray;
    }

    public static class Inner {
        public String mMessage; // 字符串
    }

    @Override
    public String toString() {
        return "DataBean{" +
                "rect=" + mRect +
                ", mPoints=" + Arrays.toString(mPoints) +
                ", mInner=" + mInner +
                ", mID=" + mID +
                ", mScore=" + mScore +
                ", mData=" + Arrays.toString(mData) +
                ", mDoubleDimenArray=" + Arrays.toString(mDoubleDimenArray) +
                '}';
    }
}
