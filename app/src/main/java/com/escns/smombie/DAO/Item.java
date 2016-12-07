package com.escns.smombie.DAO;

import com.google.gson.annotations.SerializedName;

/**
 * Created by hyo99 on 2016-12-07.
 */

public class Item {

    @SerializedName("NAME")
    private String mName;  //  연도
    @SerializedName("PRICE")
    private int mPrice; // 달
    @SerializedName("IMAGE")
    private String mImage;   // 일
    @SerializedName("ACCOUNT")
    private int mAccount;  // 가격

    /**
     * 생성자
     * @param mName 연도
     * @param mPrice 달
     * @param mImage 일
     * @param mAccount 시간
     */
    public Item(String mName, int mPrice, String mImage, int mAccount) {
        this.mName = mName;
        this.mPrice = mPrice;
        this.mImage = mImage;
        this.mAccount = mAccount;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public int getmPrice() {
        return mPrice;
    }

    public void setmPrice(int mPrice) {
        this.mPrice = mPrice;
    }

    public String getmImage() {
        return mImage;
    }

    public void setmImage(String mImage) {
        this.mImage = mImage;
    }

    public int getmAccount() {
        return mAccount;
    }

    public void setmAccount(int mAccount) {
        this.mAccount = mAccount;
    }

    @Override
    public String toString() {
        return "Item {" +
                "mName='" + mName + '\'' +
                ", mPrice=" + mPrice +
                ", mImage=" + mImage +
                ", mAccount=" + mAccount +
                '}';
    }
}
