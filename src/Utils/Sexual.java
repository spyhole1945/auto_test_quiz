package Utils;

/**
 * Created by idoudou on 16/12/8.
 */
public class Sexual {
    public static String isSex(String idNum)
    {

        char c[]=idNum.toCharArray();
        char flag=c[c.length-2];
        //System.out.println(c[c.length-2]);
        if(flag%2==0)
        {
            return "female";
        }
        return "male";
    }
}
