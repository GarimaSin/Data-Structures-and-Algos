package Problem_Solving.Array.Pepcoding;

import java.util.HashMap;
/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */

public class SnapshotArray {

	HashMap<Integer, Integer> arr[];
	int snapId = 0;
	public SnapshotArray(int length) {
		arr = new HashMap[length];
		for(int i=0; i<length; i++) {
			arr[i] = new HashMap<>();
		}
	}

	public void set(int index, int val) {
		arr[index].put(snapId, val);
	}

	public int snap() {
		snapId++;
		return snapId-1;
	}

	public int get(int index, int snap_id) {
		while(snap_id >= 0) {
			if(arr[index].containsKey(snap_id)){
				return arr[index].get(snap_id);
			} else
				snap_id--;
		}
		return 0;
	}
}