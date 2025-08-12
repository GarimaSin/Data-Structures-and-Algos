package SWC_Codes_Office.src.test.src.threading;

public class Test {
    public static void main(String[] args) throws Exception {  
        new Thread(new Runnable() {  
            public void run() {  
                try {  
                    new Test().m1();  
                } catch (Exception e) {  
                    e.printStackTrace();  
                }  
            }  
        }).start();  
  
        Thread.sleep(1000);  
  
        new Thread(new Runnable() {  
            public void run() {  
                try {
					new Test().m1();
				} catch (Exception e) {
					e.printStackTrace();
				}  
            }  
        }).start();  
    }  
  
    public void m1() throws Exception {  
        // The following code is actually synchronized on Test.class object.  
        System.out.println("m1 is started");  
        inner();
//        Thread.sleep(15000);  
        System.out.println("m1 is completed");  
    }  
    
    public static synchronized void m2() throws Exception {
    	System.out.println("m2 started at class level");
    }
  
    public synchronized void m3() {  
        // This code is not synchronized.  
        System.out.println("m3 is working");  
        try {
			Test.m2();					//(1)or if Test.m1
		} catch (Exception e) {	}
        System.out.println("3 accessed class lock");
    }  
    
    public synchronized void inner() throws InterruptedException {
    	 System.out.println("inner is started");  
         Thread.sleep(15000);  
         System.out.println("inner is completed"); 
    }
}

