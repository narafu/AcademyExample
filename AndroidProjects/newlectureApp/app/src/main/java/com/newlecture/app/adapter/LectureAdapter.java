package com.newlecture.app.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.newlecture.app.R;
import com.newlecture.app.entity.Lecture;


import java.util.List;

public class LectureAdapter extends BaseAdapter {

    private Context context; // 껍데기
    private List<Lecture> list; // 데이터

    private LayoutInflater inflater;

    public LectureAdapter(Context context, List<Lecture> list) {
//        context는 mainActivity의 기능 축소

        this.context = context;
        this.list = list;
        this.inflater = LayoutInflater.from(context);

    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View ConvertView, ViewGroup parentView) {

        // 1. 껍대기를 객체화
        View v = inflater.inflate(R.layout.item_lecture, parentView, false);
        // 2. 껍데기에 데이터를 입히는 작업
        Lecture lecture = list.get(i);
        TextView tvTitle = v.findViewById(R.id.tvTitle);
        tvTitle.setText(lecture.getTitle());

        return v;
    }
}
