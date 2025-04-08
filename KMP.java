public class KMP {
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) return 0;
        int[] next = new int[needle.length()];
        getNext(next, needle);
        int j = 0;
        for (int i = 0; i < haystack.length(); i++) {
            while (j>0&&needle.charAt(j)!=haystack.charAt(i)){
                j = next[j-1];
            }
            if(haystack.charAt(i)==needle.charAt(j)){
                j++;
            }
            if(j==needle.length()){
                return i-needle.length()+1;
            }
        }
        return -1;
    }
    private void getNext(int[] next, String s) {
        int j = 0;
        next[0] = 0;
        for (int i = 1; i < s.length(); i++) {
            while (j > 0 && s.charAt(j) != s.charAt(i))
                j = next[j - 1];
            if (s.charAt(j) == s.charAt(i))
                j++;
            next[i] = j;
        }
    }
    public boolean repeatedSubstringPattern(String s) {
        int n=s.length();
        int[] next=new int[n];
        getNext(next,s);
        if(next[n-1]>0&&n%(n-next[n-1])==0){
            return true;
        }else {
            return false;
        }
    }

}
