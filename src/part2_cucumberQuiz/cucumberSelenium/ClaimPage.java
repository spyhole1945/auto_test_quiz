package part2_cucumberQuiz.cucumberSelenium;


public  class ClaimPage {



    //用户名
   public  String TextBox_username= "/html/body/div/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/div[2]/input";
    //密码
    public String TextBox_password= "/html/body/div/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/div[2]/input";
    //提交按钮
    public String Button_login= "/html/body/div/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button";



    //Claim
    public String Span_Claim= " /html/body/div/div[1]/div[1]/aside/nav/div[2]/ul/li[11]/a/span";

   //EmployeeClaims
   public String Button_EmployeeClaims="/html/body/div/div[1]/div[1]/header/div[2]/nav/ul/li[4]/a";

    //添加按钮
    public String Button_AssignClaim = "/html/body/div/div[1]/div[2]/div[2]/div[2]/div[1]/button";

    //Employee Name
    public String TextBox_EmployeeName= "/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div/div/div[2]/div/div/input";


    public String Check_EmployeeName="/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div/div/div[2]/div/div[2]";
    //下拉框Event
    public String Select_Event= "/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[1]/div/div[2]/div/div/div[1]";

    //下拉框Currency
    public String Select_Currency= "/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[2]/div/div[2]/div/div/div[1]";


    //Create按钮
    public String Button_Create= "/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[4]/button[2]";

    //Assign Claim EmployeeName
    public String CheckAssignClaimEmployeeName= "/html/body/div/div[1]/div[2]/div[2]/div/div/div[1]/form/div[1]/div/div/div/div[2]/input";
    //Assign Claim Envent
    public String CheckAssignClaimEvent= "/html/body/div/div[1]/div[2]/div[2]/div/div/div[1]/form/div[2]/div/div[2]/div/div[2]/input";
    //Assign Claim Currency
    public String CheckAssignClaimCurrency= "/html/body/div/div[1]/div[2]/div[2]/div/div/div[1]/form/div[3]/div/div/div/div[2]/input";


    //添加Expense
    public String Button_Add= "/html/body/div/div[1]/div[2]/div[2]/div/div/div[2]/div/button";

    //下拉框Expense Type
    public String Select_ExpenseType= "/html/body/div/div[1]/div[2]/div[2]/div/div/div[6]/div/div/div/form/div[1]/div/div/div/div[2]/div/div";


    //添加日期
    public String TextBox_Date= "/html/body/div/div[1]/div[2]/div[2]/div/div/div[6]/div/div/div/form/div[2]/div/div[1]/div/div[2]/div/div/input";

    //添加Amount
    public String TextBox_Amount= "/html/body/div/div[1]/div[2]/div[2]/div/div/div[6]/div/div/div/form/div[2]/div/div[2]/div/div[2]/input";

    //保存按钮
    public String Button_save= "/html/body/div/div[1]/div[2]/div[2]/div/div/div[6]/div/div/div/form/div[4]/button[2]";

    //检查 Expense Type
    public String CheckExpenseType= "/html/body/div/div[1]/div[2]/div[2]/div/div/div[4]/div/div[2]/div/div/div[1]/div";
                                   // /html/body/div/div[1]/div[2]/div[2]/div/div/div[4]/div/div[2]/div/div/div[1]/div
    //检查 Date
    public String CheckDate= "/html/body/div/div[1]/div[2]/div[2]/div/div/div[4]/div/div[2]/div/div/div[2]/div";
                           // /html/body/div/div[1]/div[2]/div[2]/div/div/div[4]/div/div[2]/div/div/div[2]/div
       //检查 Amount
    public String CheckAmount= "/html/body/div/div[1]/div[2]/div[2]/div/div/div[4]/div/div[2]/div/div/div[4]/div";
                             //  /html/body/div/div[1]/div[2]/div[2]/div/div/div[4]/div/div[2]/div/div/div[4]/div
                             //   /html/body/div/div[1]/div[2]/div[2]/div/div/div[4]/div/div[2]/div/div/div[4]/div
    //按钮Submit
    public String Button_Submit= "/html/body/div/div[1]/div[2]/div[2]/div/div/div[9]/button[2]";
    //按钮Back
    public String Button_Back= "/html/body/div/div[1]/div[2]/div[2]/div/div/div[9]/button";




    //Assign Claim EmployeeName
    public String CheckRecordEmployeeName= "/html/body/div/div[1]/div[2]/div[2]/div[2]/div[3]/div/div[2]/div[1]/div/div[2]/div";
    //Assign Claim Envent
    public String CheckRecordEvent= "/html/body/div/div[1]/div[2]/div[2]/div[2]/div[3]/div/div[2]/div[1]/div/div[3]/div/span";
    //Assign Claim Currency
    public String CheckRecordCurrency= "/html/body/div/div[1]/div[2]/div[2]/div[2]/div[3]/div/div[2]/div[1]/div/div[5]/div";



    //检查 Date
    public String CheckRecordDate= "/html/body/div/div[1]/div[2]/div[2]/div[2]/div[3]/div/div[2]/div[1]/div/div[6]/div";
    //检查 Amount
    public String CheckRecordAmount= "/html/body/div/div[1]/div[2]/div[2]/div[2]/div[3]/div/div[2]/div[1]/div/div[8]/div";



}
