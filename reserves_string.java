public class reserves_string {
    public void reverseString(char[] s,int i,int j) {
        for(i=i,j=j;i<j;i++,j--){
            char temp=s[i];
            s[i]=s[j];
            s[j]=temp;
        }
    }
    public String reverseStr(String s, int k) {
        char[] ch = s.toCharArray();
        for(int i=0;i<ch.length;i+=2*k){
            if(i+k<=ch.length){
                reverseString(ch,i,i+k-1);
                continue;
            }
            reverseString(ch,i,ch.length-1);
        }
        return new String(ch);
    }
    public String reverseWords(String s) {
//        1.去除多余空格
        StringBuilder stringBuilder = removeSpace(s);
//        2.将整个字符串反转
        reverseString(stringBuilder,0,stringBuilder.length()-1);
//        3.翻转单词
        reverseEachWord(stringBuilder);
        return stringBuilder.toString();

    }
    private StringBuilder removeSpace(String s){
        int start=0,end=s.length()-1;
        while (s.charAt(start)==' '){
            start++;
        }
        while (s.charAt(end)==' '){
            end--;
        }
        StringBuilder sb=new StringBuilder();
        while (start<=end){
            char c=s.charAt(start);
            if (c!=' '||sb.charAt(sb.length()-1)!=' '){
                sb.append(c);
            }
            start++;
        }
        return sb;
    }
    private void reverseString(StringBuilder sb,int start,int end){
        while (start<end){
            char temp=sb.charAt(start);
            sb.setCharAt(start,sb.charAt(end));
            sb.setCharAt(end,temp);
            start++;
            end--;
        }
    }
    private void reverseEachWord(StringBuilder sb){
        int start=0,end=1,n=sb.length();
        while (start<n){
            while (end<n&&sb.charAt(end)!=' '){
                end++;
            }
            reverseString(sb,start,end-1);
            start=end+1;
            end=start+1;
        }
    }
}
