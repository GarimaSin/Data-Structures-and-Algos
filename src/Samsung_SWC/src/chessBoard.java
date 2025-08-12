/**
 * Created by Dev Computer on 6/15/2015.
 */
public class chessBoard {
    static char[] chess = new char[]{
            'w', '?', '?', '?', '?',
            '?', '?', '?', '?', '?',
            'w', '?', '?', '?', '?',
            'b', '?', 'b', '?', '?',
            '?', 'b', '?', 'b', '?'
    };
    static int size = 5, index = 0;
    static boolean found = false, isEven = false, isPossible = true;
    public static void main(String[] args) {
        System.out.println(checkSolution());
    }

    private static boolean checkSolution() {
        for(int i=0; i<size*size; i++){
            if(chess[i] != '?' && found != true){
                found = true;
                index = i;
                isEven = isEvenIndex(i);
            }
            else if(chess[i] != '?' && found == true){
                if(isEvenIndex(i) == isEven) {
                    if (chess[index] != chess[i])
                        return false;
                } else {
                    if (chess[index] == chess[i])
                        return false;
                }
            }
        }
        return isPossible;
    }

    private static boolean isEvenIndex(int i) {
        if(i%2 == 0)
            return true;
        else
            return false;
    }
}
