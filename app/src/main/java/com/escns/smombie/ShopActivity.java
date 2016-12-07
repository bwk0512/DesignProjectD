package com.escns.smombie;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.escns.smombie.DAO.Item;
import com.escns.smombie.DAO.Record;
import com.escns.smombie.Manager.DBManager;

import java.nio.BufferUnderflowException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by hyo99 on 2016-12-07.
 */

public class ShopActivity extends AppCompatActivity {

    private DBManager mDbManager;
    private SharedPreferences pref;

    List<Item> list; // DB에서 Recod를 가져오기 위한 List

    private Calendar c; // 날짜를 받아오기위한 객체

    private int mPoint; // 포인트
    private String mPurpose;  // 목적
    private int mYear;  //  연도
    private int mMonth; // 달
    private int mDay;   // 일
    private int mHour;  // 시간

    TextView text1;
    TextView text2;
    TextView text3;

    Button button1;
    Button button2;
    Button button3;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);

        mDbManager = new DBManager(this);
        pref = getSharedPreferences(getResources().getString(R.string.app_name), MODE_PRIVATE);

        list = null;
        list = new ArrayList<>();
        list = mDbManager.getItem(); // Local DB에서 record list를 받아옴

        String to = Integer.toString(list.size());
        Log.d("값이다  ", to);

        text1 = (TextView) findViewById(R.id.textViewAccount1);
        text2 = (TextView) findViewById(R.id.textViewAccount2);
        text3 = (TextView) findViewById(R.id.textViewAccount3);

        button1 = (Button) findViewById(R.id.buttonBuy1);
        button2 = (Button) findViewById(R.id.buttonBuy2);
        button3 = (Button) findViewById(R.id.buttonBuy3);

        String str = Integer.toString(list.get(0).getmAccount());
        text1.setText(str);
        str = Integer.toString(list.get(1).getmAccount());
        text2.setText(str);
        str = Integer.toString(list.get(2).getmAccount());
        text3.setText(str);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!pref.getBoolean("switch", false)) {

                    list = mDbManager.getItem();

                    int account = list.get(0).getmAccount();
                    int price = list.get(0).getmPrice();
                    int userPoint = pref.getInt("userPoint", 0);

                    if (account != 0) {
                        if (price <= userPoint) {
                            //item 테이블 수정
                            Item it = new Item(list.get(0).getmName(), list.get(0).getmPrice(), list.get(0).getmImage(), account - 1);
                            mDbManager.updateItem(it);

                            String strr = Integer.toString(it.getmAccount());
                            text1.setText(strr);

                            //유저 보유 포인트 수정
                            int p = userPoint - price;
                            SharedPreferences.Editor editor = pref.edit();
                            editor.putInt("userPoint", p);
                            editor.commit();

                            //record 테이블 추가
                            c = Calendar.getInstance();
                            mPoint = price;
                            mPurpose = "소비";
                            mYear = c.get(Calendar.YEAR);
                            mMonth = c.get(Calendar.MONTH) + 1;
                            mDay = c.get(Calendar.DATE);
                            mHour = c.get(Calendar.HOUR_OF_DAY);
                            Record record = new Record(mPoint, mPurpose, mYear, mMonth, mDay, mHour);
                            mDbManager.insertRecord(record);

                            Toast.makeText(getApplicationContext(), "구입 완료", Toast.LENGTH_LONG).show();

                        } else {
                            Toast.makeText(getApplicationContext(), "포인트가 부족합니다", Toast.LENGTH_LONG).show();
                        }
                    } else {
                        Toast.makeText(getApplicationContext(), "남은 수량이 없습니다", Toast.LENGTH_LONG).show();
                    }

                }
                else {
                    Toast.makeText(getApplicationContext(), "잠금화면을 비활성화 하십시오", Toast.LENGTH_LONG).show();
                }
            }
        });


        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!pref.getBoolean("switch", false)) {

                    list = mDbManager.getItem();

                    int account = list.get(1).getmAccount();
                    int price = list.get(1).getmPrice();
                    int userPoint = pref.getInt("userPoint", 0);

                    if (account != 0) {
                        if (price <= userPoint) {
                            //item 테이블 수정
                            Item it = new Item(list.get(1).getmName(), list.get(1).getmPrice(), list.get(1).getmImage(), account - 1);
                            mDbManager.updateItem(it);

                            String strr = Integer.toString(it.getmAccount());
                            text2.setText(strr);

                            //유저 보유 포인트 수정
                            int p = userPoint - price;
                            SharedPreferences.Editor editor = pref.edit();
                            editor.putInt("userPoint", p);
                            editor.commit();

                            //record 테이블 추가
                            c = Calendar.getInstance();
                            mPoint = price;
                            mPurpose = "소비";
                            mYear = c.get(Calendar.YEAR);
                            mMonth = c.get(Calendar.MONTH) + 1;
                            mDay = c.get(Calendar.DATE);
                            mHour = c.get(Calendar.HOUR_OF_DAY);
                            Record record = new Record(mPoint, mPurpose, mYear, mMonth, mDay, mHour);
                            mDbManager.insertRecord(record);

                            Toast.makeText(getApplicationContext(), "구입 완료", Toast.LENGTH_LONG).show();

                        } else {
                            Toast.makeText(getApplicationContext(), "포인트가 부족합니다", Toast.LENGTH_LONG).show();
                        }
                    } else {
                        Toast.makeText(getApplicationContext(), "남은 수량이 없습니다", Toast.LENGTH_LONG).show();
                    }

                }
                else {
                    Toast.makeText(getApplicationContext(), "잠금화면을 비활성화 하십시오", Toast.LENGTH_LONG).show();
                }
            }
        });


        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!pref.getBoolean("switch", false)) {

                    list = mDbManager.getItem();

                    int account = list.get(2).getmAccount();
                    int price = list.get(2).getmPrice();
                    int userPoint = pref.getInt("userPoint", 0);

                    if (account != 0) {
                        if (price <= userPoint) {
                            //item 테이블 수정
                            Item it = new Item(list.get(2).getmName(), list.get(2).getmPrice(), list.get(2).getmImage(), account - 1);
                            mDbManager.updateItem(it);

                            String strr = Integer.toString(it.getmAccount());
                            text3.setText(strr);

                            //유저 보유 포인트 수정
                            int p = userPoint - price;
                            SharedPreferences.Editor editor = pref.edit();
                            editor.putInt("userPoint", p);
                            editor.commit();

                            //record 테이블 추가
                            c = Calendar.getInstance();
                            mPoint = price;
                            mPurpose = "소비";
                            mYear = c.get(Calendar.YEAR);
                            mMonth = c.get(Calendar.MONTH) + 1;
                            mDay = c.get(Calendar.DATE);
                            mHour = c.get(Calendar.HOUR_OF_DAY);
                            Record record = new Record(mPoint, mPurpose, mYear, mMonth, mDay, mHour);
                            mDbManager.insertRecord(record);

                            Toast.makeText(getApplicationContext(), "구입 완료", Toast.LENGTH_LONG).show();

                        } else {
                            Toast.makeText(getApplicationContext(), "포인트가 부족합니다", Toast.LENGTH_LONG).show();
                        }
                    } else {
                        Toast.makeText(getApplicationContext(), "남은 수량이 없습니다", Toast.LENGTH_LONG).show();
                    }

                }
                else {
                    Toast.makeText(getApplicationContext(), "잠금화면을 비활성화 하십시오", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        list = mDbManager.getItem();

        String str = Integer.toString(list.get(0).getmAccount());
        text1.setText(str);
        str = Integer.toString(list.get(1).getmAccount());
        text2.setText(str);
        str = Integer.toString(list.get(2).getmAccount());
        text3.setText(str);

    }

}
