
/**
 * Created by Garima on 6/16/2015.
 */
public class longestSequenceInMatrix {

    static int size = 6;
    static int[][] mat = new int[][]{
            {1, 2, 2, 2, 2, 4},      //0, 0, 0, 0},
            {1, 3, 1, 0, 4, 0},      //0, 0, 0, 0},
            {1, 0, 3, 4, 1, 0},      //0, 0, 0, 0},
            {1, 1, 4, 3, 1, 1},      //1, 1, 0, 0},
            {1, 4, 4, 5, 5, 5},      //0, 0, 0, 0},
            {1, 3, 2, 5, 5, 5},      //0, 0, 0, 0},
//            {0, 1, 0, 0, 0, 0, 1, 1, 1, 1},
//            {0, 1, 0, 0, 0, 0, 1, 0, 0, 1},
//            {0, 1, 1, 1, 1, 1, 1, 0, 0, 1},
//            {0, 0, 0, 0, 0, 0, 1, 1, 0, 1},
    };
    static int maxSize = 1, num = -1, temp1 = -1, tempSize1 = 1, temp2 = -1, tempSize2 = 1;

    public static void main(String[] args) {
        String seqType = "";
        for(int row=0; row<size; row++){
            temp1 = mat[row][0]; tempSize1 = 1; tempSize2 = 1; temp2 = mat[row][0];
            for(int col=0; col<size; col++){
                if(col != 0){
                    if(temp1 == mat[row][col]) {
                        tempSize1++;
                        seqType = "H";
                        if(col == size-1){
                            compare(tempSize1, temp1);
                        }
                    } else {
                        compare(tempSize1, temp1);
                        temp1 = mat[row][col];
                        tempSize1 = 1;
                    }
                }
                if(row != 0){
                    if(temp2 == mat[col][row]) {
                        tempSize2++;
                        seqType = "V";
                        if(col == size-1){
                            compare(tempSize2, temp2);
                        }
                    } else {
                        compare(tempSize2, temp2);
                        temp2 = mat[col][row];
                        tempSize2 = 1;
                    }
                }
            }
        }
        System.out.println(maxSize+".."+num);
    }

    public static void compare(int tempSize, int temp1){
        if(maxSize < tempSize) {
            maxSize = tempSize;
            num = temp1;
        }
    }
}
