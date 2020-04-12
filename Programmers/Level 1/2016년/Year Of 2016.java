import java.util.Calendar;
import java.util.GregorianCalendar;

class Solution {
  public String solution(int a, int b) {
        String[] days = {"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"};

        Calendar startDate = new GregorianCalendar(2016,0,1);
        Calendar lastDate = new GregorianCalendar(2016,a - 1, b);
        long distance = (lastDate.getTimeInMillis() - startDate.getTimeInMillis()) / (24 * 60 * 60 * 1000);
    
        return days[(int)distance % 7];
  }
}
