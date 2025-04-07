import java.util.Scanner;

public class replace_number {

    public static String replaceNumber(String str) {
        int count=0;
        int oldSize=str.length();
        for (int i = 0; i < oldSize; i++) {
            if(Character.isDigit(str.charAt(i))){
                count++;
            }
        }
        char[] ch=new char[oldSize+count*5];
        int newSize=ch.length;
        System.arraycopy(str.toCharArray(), 0, ch, 0, oldSize);
        for (int i=oldSize-1,j=newSize-1; i<j; i--,j--) {
            if(!Character.isDigit(ch[i])){
                ch[j]=ch[i];
            }else {
                ch[j]='r';
                ch[j - 1] = 'e';
                ch[j - 2] = 'b';
                ch[j - 3] = 'm';
                ch[j - 4] = 'u';
                ch[j - 5] = 'n';
                j=j-5;
            }
        }
        return new String(ch);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(replaceNumber(str));
        sc.close();
    }
}
