package Utils;

import java.util.Random;

/**
 * Created by idoudou on 16/8/26.
 */
public class RandomInt {
    public static String getInt1020(){
        int num=new Random().nextInt(10)+10;
        String result= String.valueOf(num);
        return result;
    }
    public static String getInt010(){
        int num=new Random().nextInt(10)+1;
        String result= String.valueOf(num);
        return result;
    }
    public static String getIntXXX(){
        int num=new Random().nextInt(10)+100;
        String result= String.valueOf(num);
        return result;
    }

    public static void main(String[] args) {

            System.out.println(RandomInt.getInt010());
            System.out.println(RandomInt.getInt1020());
        System.out.println(RandomInt.getIntXXX());

    }

}
