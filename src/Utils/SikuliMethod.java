/**
 * ����ͼ��ʶ��������жϼ�����
 */
package Utils;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Match;
import org.sikuli.script.Screen;

public class SikuliMethod {
	/**
	 * �ж��Ƿ�chrome���������ֹͣ��ť,�������˵����Ҫֹͣ
	 * @return isexists
	 * @throws InterruptedException
	 */
	public static Match isexists() throws InterruptedException {
		 Screen s = new Screen();
		 Thread.sleep(5000);
		 /*	 s.click("pic/createInfo.png");
		 s.click("C:/test-file/highDefinition.png");*/
		Match isexists= s.exists("C:/test-file/stopbutton.png");
		System.out.println(isexists);
		return isexists;
	}
	/**
	 * ִ�е��ֹͣ��ť����
	 * @throws InterruptedException
	 */
	public static void click() throws InterruptedException {
		 Screen s = new Screen();
		 Thread.sleep(5000);
		 try {

		/*	 s.click("pic/createInfo.png");
		     s.click("C:/test-file/highDefinition.png");*/
		    // s.click("C:/test-file/stopbutton.png");
			 s.click("/Users/idoudou/Documents/DevelopSpace/workspace/HCTest/pic/soupUI.png");
			// s.doubleClick("pic/soapUI_button.png");
		     
	 } catch (FindFailed e) {

	     // TODO Auto-generated catch block

	     e.printStackTrace();
	 }
	}
	public static  void main(String args []) throws Exception {
		//isexists() ;
		click();
	}
}
