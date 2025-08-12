/**
 * Created by Dev Computer on 6/14/2015.
 */
public class stringPattern {
    static String test = "jjmmmmmmjj";
    static int count = 0;

    public static void main(String[] args) {
        char first = test.charAt(0);
        String temp = first+"";
        for(int i=1; i<test.length(); i++){
            if(temp.charAt(0)== test.charAt(i)){
                temp = temp + test.charAt(i);
            } else {
                generateSequence(0, 1, temp);
                temp = "";
                temp = temp + test.charAt(i);
            }
            if(i == test.length()-1)
//                    && test.charAt(i-1) == test.charAt(i))
                generateSequence(0, 1, temp);
        }
        System.out.println(count+"..");
    }

    private static void generateSequence(int start, int end, String in) {
        if(start == in.length() && end == in.length()){
            return;
        }else{
            if(end == in.length()+1){
                generateSequence(start + 1, start + 1, in);
            }else{
                if(start != end) {
                    System.out.println(in.substring(start, end));
                    count = count + 1;
                }
                generateSequence(start, end+1,in);
            }
        }
    }
}