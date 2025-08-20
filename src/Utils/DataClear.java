package Utils;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.sql.SQLException;

/**
 * Created by idoudou on 16/7/15.
 */
public class DataClear {
    /**
     * Ӧ��Utils.mysql��,���и���ָ�����ֻ��Ų���,���ֻ���:13311073589����Ϊnull.
     * @throws SQLException
     */
    public WebDriver driver;
    public DataClear(WebDriver driver){
        this.driver=driver;
    }

    @Test
    public void clear() throws SQLException {
        MysqlUtil msql=new MysqlUtil("123.56.232.53","qjs_db","QA","qjs@Aw2ff2M#fM");
        String selectSql="select * from uc_member where member_mobile=\"13311073589\";";
        String columnName="member_id";
        String member_id=msql.selectData(selectSql,columnName);
       // System.out.println("��ѯmember_id:"+member_id);

        String clearURL="https://testfe3.qianjins.com/sheld.php?v=1.2&r=QAClean/unbindCard&id="+member_id+"&del_uc=1";

        driver.get(clearURL);

    }
    public void clear(String mobileNum) throws SQLException {
        System.out.println("��ɾ���ֻ���"+mobileNum);
        MysqlUtil msql=new MysqlUtil("123.56.232.53","qjs_db","QA","qjs@Aw2ff2M#fM");
        String selectSql="select * from uc_member where member_mobile=\""+mobileNum+"\";";
        String columnName="member_id";
        String member_id=msql.selectData(selectSql,columnName);
        System.out.println("��ѯmember_id:"+member_id);

        String clearURL="https://testfe3.qianjins.com/sheld.php?v=1.2&r=QAClean/unbindCard&id="+member_id+"&del_uc=1";

        driver.get(clearURL);

    }

    //@Test
    public void test() throws SQLException {
        String member_id="15048";
        MysqlUtil msql=new MysqlUtil("123.56.232.53","qjs_db","QA","qjs@Aw2ff2M#fM");

        String selectSql="select * from uc_member WHERE member_id=\""+member_id+"\";";

        String beforeresult=msql.selectData(selectSql,"member_mobile");
        System.out.println("����ǰ�ֻ���:"+beforeresult);

        String updateSql="UPDATE uc_member SET member_mobile=\"13311073589\" where member_id=\""+member_id+"\";";
        msql.updateData(updateSql);

        String afterresult=msql.selectData(selectSql,"member_mobile");
        System.out.println("���º��ֻ���:"+afterresult);

    }


    public void clearTest() throws SQLException {
        //public mysql(String ip,String database,String username,String password)
        MysqlUtil msql=new MysqlUtil("123.56.232.53","qjs_db","QA","qjs@Aw2ff2M#fM");
        String selectSql="select * from uc_member where member_mobile=\"13311073589\";";
        String columnName="member_id";
        String member_id=msql.selectData(selectSql,columnName);
        System.out.println("��ѯmember_id:"+member_id);

		/*String member_mobile=msql.selectData(selectSql,"member_mobile");
		System.out.println("��ѯmember_mobile:"+member_mobile);*/

        String beforeresult=msql.selectData(selectSql,"member_mobile");
        System.out.println("�������ֻ���:"+beforeresult);

        String updateSql="UPDATE uc_member SET member_mobile=\"\" where member_id=\""+member_id+"\";";
        //String updateSql="UPDATE uc_member SET member_mobile=\"\" where member_id=\""+"15048"+"\";";
        msql.updateData(updateSql);


        String afterresult=msql.selectData(selectSql,"member_mobile");
        if(afterresult == null || afterresult.length() <= 0) {
            System.out.println("�ֻ��Ÿ��³ɹ�,���º��ֻ���:" + afterresult);
        }
        else {
            System.out.println("Ŀǰ�ֻ�����:"+afterresult);
        }

    }


}
