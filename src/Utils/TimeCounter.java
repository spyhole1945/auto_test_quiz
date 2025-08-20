package Utils;

import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by idoudou on 16/7/28.
 */
public class TimeCounter {
    @Test
    public void start() throws InterruptedException {
        long ll;
        long l = System.currentTimeMillis();
        ll = l;
        System.out.println("倒计时开始！");
        while (true) {

            l = System.currentTimeMillis();
            long d = l - ll;
            if (d % 1000 == 0) {
                System.out.println(new SimpleDateFormat("mm:ss").format(new Date(60000-d)));
                Thread.sleep(200);
               // System.out.println(new SimpleDateFormat("yy-MM-dd HH:mm:ss").format(new Date(60-d%1000)));
            }
            if (d > 60000) {
                System.out.println("倒计时结束！");
                break;
            }
            //Thread.sleep(200);
        }
    }
}
