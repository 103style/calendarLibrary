# calendarLibrary

modify base on [material-calendarview](https://github.com/prolificinteractive/material-calendarview)

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
implementation 'com.github.103style.calendarLibrary:calendarLibrary:0.0.15'
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

        calendarView.setTitleFormatter(new MonthDefaultTitleFormatter(getResources().getStringArray(R.array.month_array)));


        calendarView.setLeftArrow(R.drawable.calendar_select_left);
        calendarView.setRightArrow(R.drawable.calendar_select_right);

        calendarView.setTodayTextColor(R.color.calendar_taday_text_color);
        calendarView.setTvRightTopText(R.string.tv_today);
        //设置 今天之后的日期不能点击  并且不能滑动到 今天之后的月份
        calendarView.setAfterTodayClickable(false);

        HashSet<CalendarDay> dates = new HashSet<>();
        for (int i = 0; i < 10; i++) {
            CalendarDay c = CalendarDay.from(LocalDate.of(2019, 3, 10 + i));
            dates.add(c);
        }
        calendarView.addDecorator(new EventDecorator(Color.parseColor("#FF01E9C3"),
                getResources().getDisplayMetrics().widthPixels / 120, dates));

        //click today
        calendarView.setTvRightTopClickListener(v -> {
            calendarView.setSelectedDate(CalendarDay.today());
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
    app:mcv_showOtherDates="other_months"
    app:mcv_weekDayLabels="@array/week_array"
    app:mcv_weekDayTextAppearance="@style/WeekextAppearance" />
```

### attrs  added
```
<!-- 是否显示今天之后的月份-->
<attr name="mcv_after_today_clickable" format="boolean" />
```

---
### Screenshot
<img src="https://github.com/103style/calendarLibrary/blob/master/screenshot/Screenshot_20190510-152543.png" width="216" height="432"/>     

<img src="https://github.com/103style/calendarLibrary/blob/master/screenshot/Screenshot_20190521-163512.png" width="216" height="384"/>     <img src="https://github.com/103style/calendarLibrary/blob/master/screenshot/Screenshot_20190521-163519.png" width="216" height="384"/>
