import java.util.Scanner;

public class 前缀和 {
/*    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] vec=new int[n];
        int[] p=new int[n];
        int presum=0;
        for (int i = 0; i < n; i++) {
            vec[i]=scanner.nextInt();
            presum+=vec[i];
            p[i]=presum;
        }
        while (scanner.hasNextInt()){
            int a = scanner.nextInt();
            int b = scanner.nextInt();

            int sum;
            if (a==0){
                sum=p[b];
            }else {
                sum=p[b]-p[a-1];
            }
            System.out.println(sum);
        }
        scanner.close();
    }*/
    //分田
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int sum = 0;
        int[][] vec = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                vec[i][j] = scanner.nextInt();
                sum += vec[i][j];
            }
        }

        int result = Integer.MAX_VALUE;
        int count = 0; // 统计遍历过的行

        // 行切分
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                count += vec[i][j];
                // 遍历到行末尾时候开始统计
                if (j == m - 1) {
                    //假设矩阵元素总和为 sum，我们在某一行或者某一列进行分割，分割后一部分的元素和为 count，那么另一部分的元素和就是 sum - count。
                    //两部分元素和的差值可以通过 |(sum - count) - count| 来计算，也就是 |sum - 2 * count|。
                    //这里使用绝对值 Math.abs() 是因为我们只关心差值的大小，而不关心哪一部分的和更大。
                    result = Math.min(result, Math.abs(sum - 2 * count));
                }
            }
        }

        count = 0;
        // 列切分
        for (int j = 0; j < m; j++) {
            for (int i = 0; i < n; i++) {
                count += vec[i][j];
                // 遍历到列末尾时候开始统计
                if (i == n - 1) {
                    result = Math.min(result, Math.abs(sum - 2 * count));
                }
            }
        }

        System.out.println(result);
        scanner.close();
    }
}
