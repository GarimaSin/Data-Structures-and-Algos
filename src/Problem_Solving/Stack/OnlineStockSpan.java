package Problem_Solving.Stack;

import java.util.List;
import java.util.Stack;

public class OnlineStockSpan {

	Stack<Integer> st = null;
	List<Integer> list = null;
    int i = 0;
    public OnlineStockSpan() {
        st = new Stack<>();
    }
    
    public int next(int price) {
        list.add(price);
        if(st.isEmpty() || st.peek() > price) {
            st.push(i);
            i++;
            return 1;
        } else {
            while(!st.isEmpty() && st.peek() <= price) {
                st.pop();
            }
            int j = st.peek();
            i++;
            st.push(price);
            return j-i;
        }
    }
    
    public static void main(String[] args) {
    	OnlineStockSpan oss = new OnlineStockSpan();
    	oss.next(100);
    	oss.next(80);
    	oss.next(60);
    	oss.next(70);
    	oss.next(60);
    	oss.next(75);
    	oss.next(85);
	}
}
