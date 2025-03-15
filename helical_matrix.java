import java.util.ArrayList;
import java.util.List;

public class helical_matrix {
    //螺旋矩阵力扣59题
    public int[][] generateMatrix(int n) {
        int[][] num = new int[n][n];
        int loop=1;
        int i=0;
        int N=n-1;
        int count=1;
        while(loop<=n/2){
            for (i=loop-1;i<N;i++){
                num[loop-1][i]=count++;
            }
            for (i=loop-1;i<N;i++){
                num[i][N]=count++;
            }
            for (i=N;i>loop-1;i--){
                num[N][i]=count++;
            }
            for (i=N;i>loop-1;i--){
                num[i][loop-1]=count++;
            }
            N--;
            loop++;
        }
        if (n%2==1){
            num[n/2][n/2]=n*n;
        }
        return num;
    }

    //力扣54题
    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> num = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return num;
        }
        int row=matrix.length;
        int col=matrix[0].length;
        int left=0,right=col-1,top=0,bottom=row-1;
        while(left<=right&&top<=bottom){
            for (int i=left; i<=right; i++){
                num.add(matrix[top][i]);
            }
            top++;
            for (int i=top; i<=bottom; i++){
                num.add(matrix[i][right]);
            }
            right--;
            if (top<=bottom){
                for (int i=right; i>=left; i--){
                    num.add(matrix[bottom][i]);
                }
                bottom--;
            }
            if (left<=right){
                for (int i=bottom; i>=top; i--){
                    num.add(matrix[i][left]);
                }
                left++;
            }
        }
        return num;
    }
}
