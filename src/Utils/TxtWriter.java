package Utils;

import org.testng.annotations.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class TxtWriter {


    public static void writeTxt(String txtPath,String content){
        FileOutputStream fileOutputStream = null;
        File file = new File(txtPath);
        try {
            if(!file.exists()){
                //判断文件是否存在，如果不存在就新建一个txt
                file.createNewFile();
            }
            fileOutputStream = new FileOutputStream(file,true);
            fileOutputStream.write(content.getBytes());
            fileOutputStream.write("\r\n".getBytes());
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void flushTxt(String txtPath){
        FileOutputStream fileOutputStream = null;
        File file = new File(txtPath);
        try {
            // 使用FileWriter不需要考虑原文件不存在的情况
            // 当该文件不存在时，new FileWriter(file)会自动创建一个真实存在的空文件
            FileWriter fileWriter = new FileWriter(file);
            // 往文件重写内容
            fileWriter.write("");// 清空
            fileWriter.flush();
            fileWriter.close();
           // log.info("原文件内容清除完毕");
            System.out.println("原文件内容清除完毕");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void readTxtByLine(File file)
    {
        try {
            // open file to read
            Scanner scanner = new Scanner(file, StandardCharsets.UTF_8.name());
            String title="";
            String titleFlag="";
            String videoFlag="";

            // read until end of file (EOF)
            while (scanner.hasNextLine()) {
                // System.out.println(scanner.nextLine().split("-")[0]);
                title=scanner.nextLine();

            }

            // close the scanner
            scanner.close();

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String str="{\n" +
                "        \"destFilePath\": \"result/image3/66032306.jpg\",\n" +
                "        \"srcFilePath\": \"result/image2/143551.jpg\",\n" +
                "        \"similarity\": 45.41\n" +
                "\t},\n" +
                "\t{\n" +
                "        \"destFilePath\": \"result/image3/66032306.jpg\",\n" +
                "        \"srcFilePath\": \"result/image2/143843.jpg\",\n" +
                "        \"similarity\": 46.45\n" +
                "\t}," +
                "\n";//Page.getInfoPropertie("textPath");
      /*  System.out.println(path);
        TxtWriter.writeTxt(path,"test");*/
        TxtWriter.writeTxt("logs/constellationsql.log",str);
    }

}