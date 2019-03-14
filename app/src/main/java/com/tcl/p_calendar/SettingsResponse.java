package com.tcl.p_calendar;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by lewis.zhou on 2017/3/24.
 */

public class SettingsResponse extends BaseResponse {
    public String period;
    public boolean alarm;
    public boolean anti_loss;
    public int anti_loss_length;
    public boolean auto_answer;
    public boolean auto_power_onoff;
    public boolean auto_time;
    public long boot_time;
    public boolean calender;
    public boolean cameraControl;
    public boolean climbing;
    public boolean comunicationIncomingCalls;
    public boolean comunicationMsessages;
    public boolean comunicationNotifyFromVIPS;
    public boolean comunicationNotifyOnWatch;
    public boolean dailyGoalReminder;
    //    public String device_id;
    public boolean dst;
    public boolean flipToMute;
    public boolean flipToMuteCalender;
    public boolean flipToMuteCalls;
    public boolean hour24;
    public boolean inactivity;
    public int inactivity_frequency;
    public boolean incomingCall;
    public boolean musicControl;
    public boolean mute;
    public boolean nfc;
    public boolean not_disturb;
    public boolean notification;
    public ReminderBean reminder;
    public boolean roaming;
    public boolean save_power;
    public List<String> languages;
    public String language;
    public SchoolTimeBean school_time;
    public int screen_timeout;
    public long shutdown_time;
    public boolean syncData;
    public boolean syncDataWifiOnly;
    public int temperatureUnit;
    public String timezone;
    public boolean vibrate;
    public boolean videoControl;
    public boolean watchScreenWakeUp;
    public List<Integer> permissions;
    public List<String> sos;
    public List<String> mode; // 定位模式(accurate, normal, savepower)
    public boolean auto_position;

    public static class ReminderBean extends BaseResponse {
        public List<AlarmsBean> alarms;
        public List<TodoBean> todo;

        public ReminderBean() {
            alarms = new ArrayList<>();
            todo = new ArrayList<>();
        }

        public ReminderBean(List<AlarmsBean> alarms, List<TodoBean> todo) {
            this.alarms = alarms;
            this.todo = todo;
        }

        public static class AlarmsBean extends BaseResponse {
            public boolean active;
            public long alarm;
            public List<Integer> days;

            public AlarmsBean(boolean active, long alarm, List<Integer> days) {
                this.active = active;
                this.alarm = alarm;
                this.days = days;
            }

            @Override
            public String toString() {
                return "AlarmsBean{" +
                        "active=" + active +
                        ", alarm=" + alarm +
                        ", days=" + days +
                        '}';
            }
        }

        public static class TodoBean extends BaseResponse {
            public String content;
            public long end;
            public int repeat;
            public long start;
            public String topic;

            public TodoBean(String content, long end, int repeat, long start, String topic) {
                this.content = content;
                this.end = end;
                this.repeat = repeat;
                this.start = start;
                this.topic = topic;
            }
        }
    }

    public static class SchoolTimeBean extends BaseResponse {
        public boolean active;
        public List<Integer> days;
        public List<PeriodsBean> periods;

        public SchoolTimeBean(boolean active, List<Integer> days, List<PeriodsBean> periods) {
            this.active = active;
            this.days = days;
            this.periods = periods;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof SchoolTimeBean) {
                SchoolTimeBean bean = (SchoolTimeBean) obj;
                return bean.active == this.active
                        && bean.days.equals(this.days)
                        && bean.periods.equals(this.periods);
            }
            return false;
        }

        public static class PeriodsBean extends BaseResponse {
            public int start;
            public int end;

            public PeriodsBean(int start, int end) {
                this.end = end;
                this.start = start;
            }

            @Override
            public boolean equals(Object obj) {
                if (obj instanceof PeriodsBean) {
                    PeriodsBean bean = (PeriodsBean) obj;
                    return bean.end == this.end && bean.start == this.start;
                }
                return false;
            }
        }
    }


}
