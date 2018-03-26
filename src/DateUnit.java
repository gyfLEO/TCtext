import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUnit {
    private static Date minutes(Date date,int minutes){
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.MINUTE, minutes);
        return c.getTime();
    }

    private static Date hours(Date date, int hours){
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.HOUR, hours);
        return c.getTime();
    }

    private static Date days(Date date, int days){
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DAY_OF_MONTH, days);
        return c.getTime();
    }

    private static Date months(Date date, int months){
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.MONTH, months);
        return c.getTime();
    }

    public static String timeToString(Date date) throws ParseException {
        SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time=formatter.format(date);
        return time;
    }

    public static Date stringToTime(String time) throws ParseException {
        SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = formatter.parse(time);
        return date;
    }

    public static void main(String[] args) throws ParseException {
        System.out.println(new Date());
        System.out.println(DateUnit.minutes(new Date(), 5));
        System.out.println(DateUnit.hours(new Date(), 5));
        System.out.println(DateUnit.days(new Date(), 5));
        System.out.println(DateUnit.months(new Date(), 5));
        System.out.println(DateUnit.timeToString(new Date()));
        System.out.println(DateUnit.stringToTime("2010-11-20 11:10:10"));
    }
}
