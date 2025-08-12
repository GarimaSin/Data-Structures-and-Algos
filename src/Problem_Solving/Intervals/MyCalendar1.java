package Problem_Solving.Intervals;

import java.util.TreeMap;

public class MyCalendar1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	// Working
	TreeMap<Integer, Integer> calendar = new TreeMap<>();
    public boolean book(int start, int end) {
        // Condition around start time
        // start < Lower Entry End Time
        if(calendar.floorEntry(start) !=null && start < calendar.floorEntry(start).getValue()){ 
            return false;
        }
        // Condition around end
        // end > Higher Entry Start Time
        if(calendar.ceilingEntry(start) !=null && end > calendar.ceilingEntry(start).getKey()){ 
            return false;
        }
        calendar.put(start, end);
        return true;
    }

}
