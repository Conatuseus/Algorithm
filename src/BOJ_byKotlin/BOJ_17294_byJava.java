package BOJ_byKotlin;

import java.util.Scanner;

public class BOJ_17294_byJava {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        char[] num=sc.nextLine().toCharArray();

        if(num.length<=2){
            System.out.println("◝(⑅•ᴗ•⑅)◜..°♡ 뀌요미!!");
        }
        else{
            int gap=Integer.parseInt(String.valueOf(num[0]))-Integer.parseInt(String.valueOf(num[1]));
            boolean flag=true;
            for (int i = 1; i < num.length-1; i++) {
                if((Integer.parseInt(String.valueOf(num[i]))-Integer.parseInt(String.valueOf(num[i+1])))!=gap){
                    flag=false;
                }
            }
            if(flag){
                System.out.println("◝(⑅•ᴗ•⑅)◜..°♡ 뀌요미!!");
            }
            else{
                System.out.println("흥칫뿡!! <(￣ ﹌ ￣)>");
            }

        }
    }
}
