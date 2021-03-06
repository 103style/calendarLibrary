# calendarLibrary

modify base on [material-calendarview](https://github.com/prolificinteractive/material-calendarview)    
[material-calendarview wiki](https://github.com/prolificinteractive/material-calendarview/wiki)


### Demo apk
[download demo apk](https://github.com/103style/calendarLibrary/blob/master/apk/app-debug.apk)


### Installation
add `maven { url "https://jitpack.io" }` in  **project** build.gradle
```
allprojects {
    repositories {
        ...
        maven { url "https://jitpack.io" }
        ...
    }
}
```

add the following code in  **app** build.gradle's **dependencies**
```
implementation 'com.github.103style.calendarLibrary:calendarLibrary:0.0.17'
```

### Usage
[MainActivity](https://github.com/103style/calendarLibrary/blob/master/app/src/main/java/com/tcl/p_calendar/MainActivity.java)
```
public class MainActivity extends AppCompatActivity {

    private MaterialCalendarView calendarView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calendarView = findViewById(R.id.test);

        //设置月份格式
        calendarView.setTitleFormatter(new MonthDefaultTitleFormatter(getResources().getStringArray(R.array.month_array)));


        //设置月份的左右点击按钮
        calendarView.setLeftArrow(R.drawable.calendar_select_left);
        calendarView.setRightArrow(R.drawable.calendar_select_right);

        // 设置右上角文字的颜色和文字
        calendarView.setTodayTextColor(R.color.calendar_taday_text_color);
        calendarView.setTvRightTopText(R.string.tv_today);

        //选中今天
        calendarView.setSelectedDate(CalendarDay.today());


        //设置 今天之后的日期不能点击  并且不能滑动到 今天之后的月份
        calendarView.setAfterTodayClickable(false);

        // 设置 今天之前的10天 添加标记的日期
        HashSet<CalendarDay> dates = new HashSet<>();
        CalendarDay today = CalendarDay.today();
        for (int i = 0; i < 10; i++) {
            today = today.toPreviousDay();
            dates.add(today);
        }
        calendarView.addDecorator(new EventDecorator(Color.parseColor("#FF01E9C3"),
                getResources().getDisplayMetrics().widthPixels / 120, dates));

        //click today
        calendarView.setTvRightTopClickListener(v -> {
            calendarView.setSelectedDate(CalendarDay.today());
            calendarView.setCurrentDate(CalendarDay.today());
        });

    }
}

```

[R.layout.activity_main](https://github.com/103style/calendarLibrary/blob/master/app/src/main/res/layout/activity_main.xml)
```
<com.prolificinteractive.materialcalendarview.MaterialCalendarView
    android:id="@+id/test"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:background="#FFFFFF"
    app:mcv_calendarMode="month"
    app:mcv_headerTextAppearance="@style/CustomTextAppearance"
    app:mcv_monthLabels="@array/month_array"
    app:mcv_selectionColor="#FF398EFF"
    app:mcv_after_today_clickable="true"
    app:mcv_showOtherDates="other_months"
    app:mcv_weekDayLabels="@array/week_array"
    app:mcv_weekDayTextAppearance="@style/WeekextAppearance" />
```
---
### Screenshot
<img src="https://github.com/103style/calendarLibrary/blob/master/screenshot/Screenshot_20190521-163512.png" width="216" height="384"/>     <img src="https://github.com/103style/calendarLibrary/blob/master/screenshot/Screenshot_20190521-163519.png" width="216" height="384"/>

---

### Modifitions
 
* files：
    * [MaterialCalendarView.java](https://github.com/prolificinteractive/material-calendarview/tree/v1.4.3/library/src/main/java/com/prolificinteractive/materialcalendarview/MaterialCalendarView.java)  ->  [MaterialCalendarView.java](https://github.com/103style/calendarLibrary/blob/master/calendarLibrary/src/main/java/com/prolificinteractive/materialcalendarview/MaterialCalendarView.java)

    * [CalendarPagerAdapter.java](https://github.com/prolificinteractive/material-calendarview/tree/v1.4.3/library/src/main/java/com/prolificinteractive/materialcalendarview/CalendarPagerAdapter.java)  ->  [CalendarPagerAdapter.java](https://github.com/103style/calendarLibrary/blob/master/calendarLibrary/src/main/java/com/prolificinteractive/materialcalendarview/CalendarPagerAdapter.java)

    * [CalendarPagerView.java](https://github.com/prolificinteractive/material-calendarview/tree/v1.4.3/library/src/main/java/com/prolificinteractive/materialcalendarview/CalendarPagerView.java)  ->  [CalendarPagerView.java](https://github.com/103style/calendarLibrary/blob/master/calendarLibrary/src/main/java/com/prolificinteractive/materialcalendarview/CalendarPagerView.java)

    * [DayView.java](https://github.com/prolificinteractive/material-calendarview/tree/v1.4.3/library/src/main/java/com/prolificinteractive/materialcalendarview/DayView.java)  ->  [DayView.java](https://github.com/103style/calendarLibrary/blob/master/calendarLibrary/src/main/java/com/prolificinteractive/materialcalendarview/DayView.java)
 
    * [calendar_view.xml](https://github.com/prolificinteractive/material-calendarview/blob/v1.4.3/library/src/main/res/values/attrs.xml)  ->  [calendar_view.xml](https://github.com/103style/calendarLibrary/blob/master/calendarLibrary/src/main/res/values/attrs.xml)
