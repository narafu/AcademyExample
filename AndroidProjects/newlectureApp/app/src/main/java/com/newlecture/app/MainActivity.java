package com.newlecture.app;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import androidx.annotation.Nullable;

import com.newlecture.app.adapter.LectureAdapter;
import com.newlecture.app.entity.Lecture;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main); // 메모리에 화면 객체를 로드
        // 위의 로드에서 ListView가 lvlecture2라는 이름으로 메모리에 있을 것임.

        // 임시데이터
        List<Lecture> list = new ArrayList<Lecture>();
        list.add(new Lecture(1, "웹 표준 기반의 HTML5&CSS3", 33000, 1000, new Date()));
        list.add(new Lecture(2, "오라클 SQL 입문", 22000, 2000, new Date()));
        list.add(new Lecture(3, "Sevlet & JSP", 27500, 3000, new Date()));
        list.add(new Lecture(4, "C 프로그래밍 입문", 55000, 500, new Date()));
        list.add(new Lecture(5, "Spring MVC 입문", 99000, 1100, new Date()));
        list.add(new Lecture(6, "Sevlet & JSP", 11000, 2000, new Date()));
        list.add(new Lecture(7, "C 프로그래밍 입문", 34000, 300, new Date()));
        list.add(new Lecture(8, "Spring MVC 입문", 23000, 500, new Date()));

        ListView listView = findViewById(R.id.lvLecture2);
        listView.setAdapter(new LectureAdapter(this, list)); // 어댑터(MVC 지원 프레임워크) 생성
        // 어댑터가 동적으로 데이터를 관리한다. 직접 inflate 하는 것보다 유용하다.



    }
}
