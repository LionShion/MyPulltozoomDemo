package com.wenjing.mypulltozoomdemo;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;

import com.ecloud.pulltozoomview.PullToZoomListViewEx;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivity extends Activity {


    //    @BindView(R.id.scroll_view)
    //    PullToZoomScrollViewEx scrollView;

    @BindView(R.id.scroll_view)
    PullToZoomListViewEx scrollView;

    List list=new ArrayList();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        View headView = LayoutInflater.from(this).inflate(R.layout.member_head_view, null);
        View zoomView = LayoutInflater.from(MainActivity.this).inflate(R.layout.member_zoom_view, null, false);
        View contentView = LayoutInflater.from(MainActivity.this).inflate(R.layout.member_content_view, null, false);
        scrollView.setHeaderView(headView);
        scrollView.setZoomView(zoomView);


        for (int i = 0; i < 30; i++) {
            list.add(i);
        }

        scrollView.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list));


        WindowManager wm = (WindowManager) this
                .getSystemService(Context.WINDOW_SERVICE);
        int width = wm.getDefaultDisplay().getWidth();
        int height = wm.getDefaultDisplay().getHeight();

        //自定义宽高
//        scrollView.setHeaderLayoutParams(new LinearLayout.LayoutParams(width, height / 5));


        DisplayMetrics localDisplayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
        int mScreenHeight = localDisplayMetrics.heightPixels;
        int mScreenWidth = localDisplayMetrics.widthPixels;
        AbsListView.LayoutParams localObject = new AbsListView.LayoutParams(mScreenWidth, (int) (9.0F * (mScreenWidth / 16.0F)));
        scrollView.setHeaderLayoutParams(localObject);

//        scrollView.setScrollContentView(contentView);
    }
}
