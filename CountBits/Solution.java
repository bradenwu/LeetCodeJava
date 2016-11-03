public class Solution {
    private int func (int n) {
//        System.out.println("input =" + n);

        int result = 0;
        while (n>0) {
            int temp = n & 0x0001;
//            System.out.println("n=" + n + ", n&0x0001=" + temp);
            result = (temp == 1)  ? result + 1 : result;
            n = n >> 1;
        }
        return result;
    }
    public int[] countBits(int num) {
        int [] results = new int[num+1];
        for (int i=0; i <= num; ++i) {
            results[i] = func(i);
        }
        return results;
    }

    public static void main(String[] args) {
        Solution so = new Solution();
        int [] results = so.countBits(5);
        for (int result : results) {
            System.out.println(result);
        }
    }
}
