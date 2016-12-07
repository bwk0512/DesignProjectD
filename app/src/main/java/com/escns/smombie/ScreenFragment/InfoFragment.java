package com.escns.smombie.ScreenFragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.escns.smombie.MainActivity;
import com.escns.smombie.PointActivity;
import com.escns.smombie.R;

/**
 * Created by hyo99 on 2016-08-23.
 */

/**
 * 내정보 화면
 */
public class InfoFragment extends Fragment {

    Context mContext;

    private SharedPreferences pref; // 내정보 화면에서 유저정보를 파일에서 가져오기 위한 객체

    View rootView;

    RelativeLayout layout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_info, container, false);

        init(); // 초기화

        return rootView;
    }

    /**
     * 초기화 함수
     */
    public void init() {

        mContext = getActivity().getApplicationContext();
        pref = mContext.getSharedPreferences(getResources().getString(R.string.app_name), mContext.MODE_PRIVATE);

        // 내정보 출력
        ((TextView) rootView.findViewById(R.id.info_name)).setText(pref.getString("userName",""));
        ((TextView) rootView.findViewById(R.id.info_gender)).setText(pref.getString("userGender",""));
        ((TextView) rootView.findViewById(R.id.info_age)).setText(pref.getInt("userAge",00)+"세");
        ((TextView) rootView.findViewById(R.id.info_email)).setText(pref.getString("userEmail",""));

        layout = (RelativeLayout) rootView.findViewById(R.id.layoutClick);

        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( getActivity().getApplicationContext(), PointActivity.class);
                startActivity(intent);
            }
        });
    }
}
