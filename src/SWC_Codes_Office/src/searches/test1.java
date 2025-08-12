package searches;

public class test1 {
	public static void main(String a[]) {
//		int[][] rows = new int[2][4];
//		int[][] cols = new int[2][4];
//		for(int row=0; row<2; row++){
//			for(int col=0; col<4; col++){
//				System.out.print(rows[row][col]+" ");
//			}
//			System.out.println();
//		}
		test1 t1 = new test1("woorry");
		System.out.println(t1.greet("hellooo"));
	}
	String name="woww";
	
	public test1(String personName) {
        name = personName;
    }

    public String greet(String yourName) {
        return String.format("Hi %s, my name is %s", name, yourName);
    }
}
