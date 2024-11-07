import java.util.Arrays;

public class App {

    //Rod Cut Function
    /*
     *  
     */
    static int memoizedCutRod(int[] p, int n){
        int[] r = new int[n+1];
        Arrays.fill(r, Integer.MIN_VALUE);
        return memoizedCutRodAux(p, n, r);
    }

    static int memoizedCutRodAux(int[] p, int n, int[] r){
        if(r[n] >= 0){
            return r[n];
        }

        if(n == 0){
            return 0;
        }

        int q = Integer.MIN_VALUE; //min

        for(int i = 1; i <= n; i++){
            q = Math.max(q, p[i-1] + memoizedCutRodAux(p, n - i, r));
        }

        r[n] = q;
        return q;
    }

    //Bottoms Up Approach
    static int bottomsUp(int[] p, int n){
        int[] r = new int[n+1];
        Arrays.fill(r, 0);

        for(int i = 1; i <= n; i++){
            int q = Integer.MIN_VALUE; //min
            for(int j = 1; j <= i; j++){
                q = Math.max(q, p[j-1] + r[i-j]);
            }
            r[i] = q;
        }

        return r[n];
    }

    public static void main(String[] args) throws Exception {

                // Test Case 1: Basic case
        int[] prices1 = {1, 5, 8, 9, 10, 17, 17, 20};
        int n1 = 8;
        System.out.println("Max Revenue for rod of length " + n1 + ": " + bottomsUp(prices1, n1));
        // Expected output: 22 (cut into 2 pieces of length 2 and 6 -> 5 + 17 = 22)

        // Test Case 2: No profit case (all prices are 0)
        int[] prices2 = {0, 0, 0, 0, 0, 0, 0, 0};
        int n2 = 8;
        System.out.println("Max Revenue for rod of length " + n2 + ": " + bottomsUp(prices2, n2));
        // Expected output: 0 (no profit, because all prices are zero)

        // Test Case 3: Single piece is best
        int[] prices3 = {2, 3, 4, 5, 6};
        int n3 = 3;
        System.out.println("Max Revenue for rod of length " + n3 + ": " + bottomsUp(prices3, n3));
        // Expected output: 6 (cut the rod into one piece of length 3, price 6)

        // Test Case 4: Long rod with mixed prices
        int[] prices4 = {1, 5, 8, 9, 10, 17, 17, 20};
        int n4 = 4;
        System.out.println("Max Revenue for rod of length " + n4 + ": " + bottomsUp(prices4, n4));
        // Expected output: 10 (cut into pieces of length 2 and 2 -> 5 + 5 = 10)

        // Test Case 5: Rod length 1
        int[] prices5 = {10};  // Only one price, rod length is 1
        int n5 = 1;
        System.out.println("Max Revenue for rod of length " + n5 + ": " + bottomsUp(prices5, n5));
        // Expected output: 10 (no choice but to sell the rod of length 1)

        // Test Case 6: Rod length 6 with custom prices
        int[] prices6 = {1, 5, 8, 9, 10, 17};
        int n6 = 6;
        System.out.println("Max Revenue for rod of length " + n6 + ": " + bottomsUp(prices6, n6));
        // Expected output: 17 (cut the rod into one piece of length 6 -> 17)

        // Test Case 7: Large Rod Length
        int[] prices7 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int n7 = 10;
        System.out.println("Max Revenue for rod of length " + n7 + ": " + bottomsUp(prices7, n7));
        // Expected output: 10 (no cuts, just sell the rod as a whole)
       
    }
}

