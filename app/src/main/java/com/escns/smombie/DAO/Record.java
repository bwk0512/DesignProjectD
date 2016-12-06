package com.escns.smombie.DAO;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 2016-08-17.
 */

/**
 * Record의 정보들을 관리하는 class
 */
public class Record {

    @SerializedName("POINT")
    private int mPoint; // 포인트
    @SerializedName("PURPOSE")
    private String mPurpose;  // 목적
    @SerializedName("YEAR")
    private int mYear;  //  연도
    @SerializedName("MONTH")
    private int mMonth; // 달
    @SerializedName("DAY")
    private int mDay;   // 일
    @SerializedName("HOUR")
    private int mHour;  // 시간

    /**
     * 생성자
     * @param mPoint 유저 고유 번호
     * @param mPurpose 목적
     * @param mYear 연도
     * @param mMonth 달
     * @param mDay 일
     * @param mHour 시간
     */
    public Record(int mPoint, String mPurpose, int mYear, int mMonth, int mDay, int mHour) {
        this.mPoint = mPoint;
        this.mPurpose = mPurpose;
        this.mYear = mYear;
        this.mMonth = mMonth;
        this.mDay = mDay;
        this.mHour = mHour;
    }

    public int getmPoint() {
        return mPoint;
    }

    public void setmPoint(int mPoint) {
        this.mPoint = mPoint;
    }

    public String getmPurpose() {
        return mPurpose;
    }

    public void setmPurpose(String mPurpose) {
        this.mPurpose = mPurpose;
    }

    public int getmYear() {
        return mYear;
    }

    public void setmYear(int mYear) {
        this.mYear = mYear;
    }

    public int getmMonth() {
        return mMonth;
    }

    public void setmMonth(int mMonth) {
        this.mMonth = mMonth;
    }

    public int getmDay() {
        return mDay;
    }

    public void setmDay(int mDay) {
        this.mDay = mDay;
    }

    public int getmHour() {
        return mHour;
    }

    public void setmHour(int mHour) {
        this.mHour = mHour;
    }

    @Override
    public String toString() {
        return "Record {" +
                "mPoint='" + mPoint + '\'' +
                ", mYear=" + mYear +
                ", mMonth=" + mMonth +
                ", mDay=" + mDay +
                ", mHour=" + mHour +
                ", mPurpose=" + mPurpose +
                '}';
    }
}
