package Problem_Solving.Backtrack_Recur_DC;

//Not Working, Convert to time
public class BinaryWatch {
	public static void main(String[] args) {
		BinaryWatch bin = new BinaryWatch();
		int num = 1;
		bin.readBinaryWatch(num);
	}


	private String[] readBinaryWatch(int num) {
		String leds[] = {"1:00","2:00","4:00","8:00","0:01", "0:02", "0:04", "0:08", "0:16", "0:32"};
		boolean vis[] = new boolean[leds.length];
		int desiredLength = num;
		String[] list = new String[desiredLength];
		return findResult(vis, leds, list, 0, desiredLength, 0);
	}


	private String[] findResult(boolean[] vis, String[] leds, String[] list, int index , int desiredLength, int start) {

		if (index >= desiredLength) {
			for(int j=0; j<list.length; j++) {
				System.out.print(list[j] + " ");
			}
			System.out.println();
			return list;
		}
		for(int i=start; i<leds.length; i++) {
			if(!vis[i]) {
				vis[i] = true;
				list[index] = leds[i];
				findResult(vis, leds, list, index+1, desiredLength, i);
				list[index] = "";
				vis[i] = false;
			}
		}
		return list;
	}
}
