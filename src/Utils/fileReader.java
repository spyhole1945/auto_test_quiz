package Utils;

import java.io.*;
import java.util.Scanner;

public class fileReader {
	 public static String readTxtFile(String filePath){
		 String lineTxt = null;
		 try {
			String encoding="utf-8";
			File file=new File(filePath);
			if(file.isFile() && file.exists()){ //判断文件是否存在
			   InputStreamReader read = new InputStreamReader(
				new FileInputStream(file),encoding);//考虑到编码格式
				BufferedReader br= new BufferedReader(read);
				StringBuffer strBuffer = new StringBuffer();
			//	Scanner in=new Scanner(file);

				while(br.readLine()!=null){
					strBuffer.append(br.readLine());
				}


				lineTxt=strBuffer.toString();
	             br.close();
	        }else{
	            System.out.println("找不到指定的文件");
	        }
	                
	        } catch (Exception e) {
	            System.out.println("读取文件内容出错");
	            e.printStackTrace();
	        }
		
			return lineTxt;
	     
	    }
	public static String readJson(String filePath)
	{
		File file = new File(filePath);
		Scanner scanner = null;
		StringBuilder buffer = new StringBuilder();
		try {
			scanner = new Scanner(file, "utf-8");
			while (scanner.hasNextLine()) {
				buffer.append(scanner.nextLine());
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block

		} finally {
			if (scanner != null) {
				scanner.close();
			}
		}
		return buffer.toString();
	}
	public static void writeFile(String filePath, String content)
	{
		try{
		//	String data = " This content will append to the end of the file";

			File file =new File(filePath);

			//if file doesnt exists, then create it
			/*if(!file.exists()){
				file.createNewFile();
			}*/

			//true = append file
			FileWriter fileWritter = new FileWriter(filePath,false);
			BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
			bufferWritter.write(content);
			bufferWritter.close();

			//System.out.println("Done");

		}catch(IOException e){
			e.printStackTrace();
		}
	}
	 public static void main(String argv[]){
	       String filePath = "src/json_hyd/s1_Rigist.json";
		// String filePath = "/Users/idoudou/Documents/DevelopSpace/image/yewushezhi.png";
	     //   String filePath = "D:\\CMStest.txt";

	     //String str=  readTxtFile(filePath);
		 String str=readJson(filePath);
	     System.out.println(str);
	    }
}
