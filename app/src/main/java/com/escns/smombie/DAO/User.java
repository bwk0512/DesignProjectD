package com.escns.smombie.DAO;

import com.google.gson.annotations.SerializedName;

/**
 * Created by hyo99 on 2016-08-18.
 */

/**
 * User의 정보들을 관리하는 class
 */
public class User {

    @SerializedName("USER_ID")
    private String mId;         // 유저 아이디
    @SerializedName("USER_PASSWORD")
    private String mPassword;   // 유저 비밀번호
    @SerializedName("NAME")
    private String mName;       // 이름
    @SerializedName("EMAIL")
    private String mEmail;      // 이메일
    @SerializedName("GENDER")
    private String mGender;     // 성별
    @SerializedName("AGE")
    private int mAge;           // 나이
    @SerializedName("POINT")
    private int mPoint;         // 포인트

    /**
     * 생성자
     * @param mId 유저 아이디
     * @param mPassword 유저 비밀번호
     * @param mName 이름
     * @param mEmail 이메일
     * @param mGender 성별
     * @param mAge 나이
     * @param mPoint 포인트
     */
    public User(String mId, String mPassword, String mName, String mEmail, String mGender, int mAge, int mPoint) {
        this.mId = mId;
        this.mPassword = mPassword;
        this.mName = mName;
        this.mEmail = mEmail;
        this.mGender = mGender;
        this.mAge = mAge;
        this.mPoint = mPoint;
    }

    public String getmId() {
        return mId;
    }

    public void setmId(String mId) {
        this.mId = mId;
    }

    public String getmPassword() {
        return mPassword;
    }

    public void setmPassword(String mPassword) {
        this.mPassword = mPassword;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmEmail() {
        return mEmail;
    }

    public void setmEmail(String mEmail) {
        this.mEmail = mEmail;
    }

    public String getmGender() {
        return mGender;
    }

    public void setmGender(String mGender) {
        this.mGender = mGender;
    }

    public int getmAge() {
        return mAge;
    }

    public void setmAge(int mAge) {
        this.mAge = mAge;
    }

    public int getmPoint() {
        return mPoint;
    }

    public void setmPoint(int mPoint) {
        this.mPoint = mPoint;
    }

    @Override
    public String toString() {
        return "User{" +
                "mId='" + mId + '\'' +
                ", mPassword='" + mPassword + '\'' +
                ", mName='" + mName + '\'' +
                ", mEmail='" + mEmail + '\'' +
                ", mGender='" + mGender + '\'' +
                ", mAge=" + mAge +
                ", mPoint=" + mPoint +
                '}';
    }
}
