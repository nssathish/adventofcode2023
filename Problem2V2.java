import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Problem2V2 {
    public static void main(String[] args) throws Exception{
        File file = new File("C:\\repos\\inputDocument.txt");
        Scanner scan = new Scanner(file);
        int x = 0;
        String[] nums = {"one","two","three","four","five","six","seven","eight","nine"};
        int[] ints = {1,2,3,4,5,6,7,8,9};
        while (scan.hasNextLine()){
            String s = scan.nextLine();
//            System.out.println(s);
            //array of all indexes
            ArrayList<Integer> list = new ArrayList<Integer>();
            //finds indexes of all spelled out out numbers (first letter)
            for(String num : nums){
                list=IndexFinder(list, s, num);
            }
            //finds indexes of all numerical values
            for (int i : ints){
                list=IndexFinder(list, s, String.valueOf(i));
            }
            //sorts indexes, reverse order first
            Collections.sort(list, Collections.reverseOrder());
            int first=0, last=0;
            last = HelperMethod(s, list.get(0));
            //flip the list so I'm only ever dealing with the first value
            Collections.reverse(list);
            first = HelperMethod(s, list.get(0));
            x+= (first*10)+last;
            System.out.println("total: "+x+" nums: "+ first+last);
        }
    }
    public static ArrayList<Integer> IndexFinder(ArrayList<Integer> list, String s, String num){
        int index=0;
        while (index != -1){
            index = s.indexOf(num, index);
            if (index != -1){
                list.add(index);
                index++;
            }
        }
        return list;
    }
    //returns the numerical value present at index
    public static int HelperMethod(String s, int index){
        int first = 0;
        char a = s.charAt(index);
        if (Character.isLetter(s.charAt(index))){
            char b = s.charAt(index+1);
            if (a == 'o'){
                first=1;
            }
            else if (a == 't'){
                if (b == 'w'){
                    first=2;
                }
                else{
                    first=3;
                }
            }
            else if (a == 'f'){
                if (b == 'o'){
                    first=4;
                }
                else{
                    first=5;
                }
            }
            else if (a == 's'){
                if (b == 'i'){
                    first=6;
                }
                else{
                    first=7;
                }
            }
            else if (a == 'e'){
                first=8;
            }
            else {
                first=9;
            }
        }
        else {
            first = Character.getNumericValue(a);
        }
        return first;
    }
}
