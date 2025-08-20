package part1_automationQuiz;


public  class PracticePage  {


    //链接进入TestLogin页面
    static String Link_TestLoginPage= "/html/body/div/div/section/div/div/article/div[2]/div[1]/div[1]/p/a";

    //用户名
    static String TextBox_username= "/html/body/div/div/section/section/div[1]/div[1]/input";
    //密码
    static String TextBox_password= "/html/body/div/div/section/section/div[1]/div[2]/input";
    //提交按钮
    static String Button_submit= "/html/body/div/div/section/section/div[1]/button";

    //登出按钮
    static String Button_logout= " /html/body/div/div/section/div/div/article/div[2]/div/div/div/a";

    //error提示
    static String Message_error= " /html/body/div/div/section/section/div[2]";

    //链接进入Test Exceptions页面
    static String Link_TestExceptionsPage= "/html/body/div/div/section/div/div/article/div[2]/div[2]/div[1]/p/a";

    //添加按钮
    static String Button_Add= "/html/body/div/div/section/section/div/div[1]/div/button[3]";

    //rowAdd提示
    static String Message_rowAdd= "/html/body/div/div/section/section/div/div[4]";

    //row2
    static String Row2Add= "/html/body/div/div/section/section/div/div[3]/div/input";


    //第二行保存成功
    static String AddSuccess= "/html/body/div/div/section/section/div/div[4]";

    //row1
    static String Row1= "/html/body/div/div/section/section/div/div[1]/div/input";


    //row1前说明
    static String instructions= "/html/body/div/div/section/section/p[2]";


}
