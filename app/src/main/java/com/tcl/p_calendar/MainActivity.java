package com.tcl.p_calendar;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.tcl.calendar.CalendarDay;
import com.tcl.calendar.MaterialCalendarView;

import org.threeten.bp.LocalDate;

public class MainActivity extends AppCompatActivity {

    SelectedDecorator selectedDecorator;
    private MaterialCalendarView calendarView;
    private long selectDate;
    private SettingsResponse.ReminderBean reminderBean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calendarView = findViewById(R.id.remider_calendarView);

        init();

        selectDate = (int) DateUtils.getCurrentDateLong();
        calendarView.setCurrentDate(transDateFormat(selectDate));
        calendarView.setSelectedDate(transDateFormat(selectDate));
    }

    private CalendarDay transDateFormat(long selectDate) {
        return CalendarDay.from(DateUtils.getYear(selectDate), DateUtils.getMonth(selectDate), DateUtils.getDay(selectDate));
    }

    private void init() {
        //显示reminders的日历
        calendarView.setTitleFormatter(new MonthDefaultTitleFormatter());
        calendarView.setWeekDayLabels(getWeeks());
        reminderBean = new SettingsResponse.ReminderBean();
        selectedDecorator = new SelectedDecorator(reminderBean, this);
        calendarView.addDecorators(selectedDecorator, new AfterDayDecorator(), new TodayDecorator(this));
//        calendarView.addDecorator(new AfterDayDecorator());
//        calendarView.addDecorator(new TodayDecorator(getActivity()));
        calendarView.setSelectionColor(Color.RED);
        calendarView.setTileHeightDp(30);
        calendarView.setTitleAnimationOrientation(MaterialCalendarView.HORIZONTAL);
        calendarView.setLeftArrowVisibility(View.GONE);
        calendarView.setRightArrowVisibility(View.GONE);
        calendarView.setSelectedDate(LocalDate.now());
        calendarView.setOnDateChangedListener((widget, date, selected) -> {
            String str = (date.getMonth()) + "-" + date.getDay() + "-" + date.getYear();
            selectDate = (int) DateUtils.getDateTimestampLong(str);
            calendarView.setCurrentDate(CalendarDay.from(date.getYear(), date.getMonth(), date.getDay()));
        });
    }


    private CharSequence[] getWeeks() {
        CharSequence[] stringArray = new CharSequence[]{
                getString(R.string.monday_short),
                getString(R.string.tuesday_short),
                getString(R.string.wednesday_short),
                getString(R.string.thursday_short),
                getString(R.string.friday_short),
                getString(R.string.saturday_short),
                getString(R.string.sunday_short),
        };
        return stringArray;
    }

}
