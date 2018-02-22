package Laba1;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class task1 {

    public static class myCalendar{
        private Calendar myCal = new GregorianCalendar();

        public myCalendar(String str) {

            SimpleDateFormat format = new SimpleDateFormat();
            format.applyPattern("yyyy-MM-dd'T'hh:mm:ss Z");
            Date date = null;
            try {
                date = format.parse(str);
                System.out.println("Ваша дата:");
            } catch (ParseException ex) {
                date = new Date();
                System.out.println("Введена не верная дата. По умолчанию установлена текущая дата. Ваша дата:" );
            }
            Calendar myCal = new GregorianCalendar();
            myCal.setTime(date);
            print(myCal);
            this.myCal = myCal;
        }

        public myCalendar() {
            Date date = new Date();
            Calendar myCal = new GregorianCalendar();
            myCal.setTime(date);
            System.out.println("Ваша дата:");
            print(myCal);
            this.myCal = myCal;
        }

        public Calendar getMyCal() {
            return myCal;
        }

        public void setMyCal(Calendar myCal) {
            this.myCal = myCal;
        }

        public void nextDay(){
            Calendar copyCal = new GregorianCalendar();
            copyCal.setTime(myCal.getTime());
            copyCal.add(Calendar.DAY_OF_YEAR, 1);
            timeZero(copyCal);
            System.out.println("Начало следующего дня:");
            print(copyCal);
        }

        public void startWeek(){
            Calendar copyCal = new GregorianCalendar();
            copyCal.setTime(myCal.getTime());
            timeZero(copyCal);
            copyCal.set(Calendar.DAY_OF_WEEK, myCal.getActualMinimum(Calendar.DAY_OF_WEEK));
            copyCal.add(Calendar.DAY_OF_WEEK, -6);
            System.out.println("Начало текущей недели:");
            print(copyCal);
        }

        public void finishWeek(){
            Calendar copyCal = new GregorianCalendar();
            copyCal.setTime(myCal.getTime());
            timeZero(copyCal);
            copyCal.set(Calendar.DAY_OF_WEEK, myCal.getActualMaximum(Calendar.DAY_OF_WEEK));
            copyCal.add(Calendar.DAY_OF_WEEK, 1);
            System.out.println("Конец текущей недели:");
            print(copyCal);
        }

        public void nextMonth(){
            Calendar copyCal = new GregorianCalendar();
            copyCal.setTime(myCal.getTime());
            timeZero(copyCal);
            copyCal.add(Calendar.MONTH, 1);
            copyCal.set(Calendar.DAY_OF_MONTH, 1);
            System.out.println("Начало следующего месяца:");
            print(copyCal);
        }

        private void timeZero(Calendar Cal){
            Cal.set(Calendar.HOUR_OF_DAY, 0);
            Cal.set(Calendar.MINUTE, 0);
            Cal.set(Calendar.SECOND, 0);
        }

        private void print(Calendar Cal){
            SimpleDateFormat formatForDateNow = new SimpleDateFormat("yyyy-MM-dd'T'kk:mm:ss Z");
            System.out.println(formatForDateNow.format(Cal.getTime()));
        }

        public String toString(){
            SimpleDateFormat formatForDateNow = new SimpleDateFormat("yyyy-MM-dd'T'kk:mm:ss Z");
            return formatForDateNow.format(myCal.getTime());
        }
    }


    public static void main(String[] args) {
        String str = "2017-11-21T20:32:33 +0400";//если надо переделать на буквенный часовой пояс, то добавить zzz и писать  MSK
        myCalendar newCal = new myCalendar(str);
        newCal.nextDay();
        newCal.startWeek();
        newCal.finishWeek();
        newCal.nextMonth();
    }
}

