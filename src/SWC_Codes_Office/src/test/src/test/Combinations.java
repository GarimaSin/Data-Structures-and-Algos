package test.src.test;

public class Combinations {
    private StringBuilder output = new StringBuilder();
    private final String inputstring;
    public Combinations( final String str ){
        inputstring = str;
        System.out.println("The input string  is  : " + inputstring);
    }
    static int count = 0;
    
    
    public static void main (String args[])
    {
        Combinations combobj= new Combinations("1234");
        combobj.combine(0,1, "1234");
    }
    
    private void combine(int start, int end, String in){
        for( int i = start; i < inputstring.length(); ++i ){
            output.append( inputstring.charAt(i) );
            System.out.println( output );
            if ( i < inputstring.length() )
            	combine( i + 1,0,"");
            output.setLength( output.length() - 1 );
        }
    	
    }
} 