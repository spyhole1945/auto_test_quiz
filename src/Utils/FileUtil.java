package Utils;


import org.apache.tools.zip.ZipEntry;
import org.apache.tools.zip.ZipFile;
import org.apache.tools.zip.ZipOutputStream;

import java.awt.image.RasterFormatException;
import java.io.*;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

/**
 * @ClassName ZipUtil
 * @Description 压缩或解压缩zip：由于直接使用java.util.zip工具包下的类，会出现中文乱码问题，所以使用ant.jar中的org.apache.tools.zip下的工具类
 * @Author AlphaJunS
 * @Date 2020/3/8 11:30
 * @Version 1.0
 */

public class FileUtil {

    public static void main(String[] args) throws Exception {
      //  deleteFiles("InfoConfig_qbk");


        /*String srcfile="result_qbk/image/temp.png";
        String destnfile="numImage/"+GetDate.getDateHms()+"temp.png";*/

        /*String srcfile="\\\\192.168.82.240\\appiumAutoTest\\result\\image";
        String destnfile="E:\\result\\image6";
        FileUtil.copyFile(srcfile,destnfile);*/
       // goThroughFile();
       // copyFile("E:\\result\\image1\\66006784_20220627173918.jpg","E:\\result\\image2\\66006784_20220627173918.jpg");
      /*  ArrayList<String> srcfileLists= getFileList("E:\\result\\image1\\");
        System.out.println("第30个元素"+srcfileLists.get(30));*/

     /*   String filePath="E:\\result\\image4\\";
        FileUtil.updateFileNames(filePath);*/


    }
    public static ArrayList<String> getFileList(String srcPath) {
        /////准备本站图片,分组10个每组//////////////////
        // File sourcePic = new File(soursePicPath);
        ArrayList<String> srcfileLists = new ArrayList<String>();//每10个一组的list集合
        String filename = null;
        try {
            //   BufferedImage pic1 = ImageIO.read(sourcePic);
            File dir = new File(srcPath);
            String[] children = dir.list();
          //  System.out.println(srcPath + "中共有" + children.length + "张图片");
            if (children == null) {
                System.out.println("目录不存在或它不是一个目录");
            } else {
                for (int i = 0; i < children.length; i++) {

                    srcfileLists.add(srcPath+children[i]);
                  //  System.out.println("第" + i + "个元素" + children[i]);
                   // System.out.println("第" + i + "个元素完整路径: "+srcPath+children[i]);
                }
            }
        } catch (RasterFormatException e1) {
            e1.printStackTrace();
        }
        return srcfileLists;
    }
    public static void copyFile(String srcfile,String destnfile)
    {
        File orgFile = new File(srcfile);
        File desFile = new File(destnfile);
        try {
            // 创建目标文件
            if (!desFile.createNewFile()) {
                System.out.println("创建文件失败" + desFile);
            }
            // 读取原文件
            FileInputStream fis = new FileInputStream(orgFile);
            // 写入到目标文件
            FileOutputStream fos = new FileOutputStream(desFile);
            int len = 0;
            byte[] by = new byte[1024];
            while ((len = fis.read(by)) != -1) {
                // 直接将读取的字节流写入到目标文件
                fos.write(by, 0, len);
            }
            // 刷新下输出流
            fos.flush();
            // 关闭输入流，输出流
            fis.close();
            fos.close();
           /* IoUtil.close(fis);
            IoUtil.close(fos);*/
            System.out.println("复制文件成功");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void copyAndDeleteFile(String srcfile,String destnfile,String tempPath)
    {
        /*System.out.println("destnfile: "+destnfile);
        String tempPath=null;
        if(destnfile.contains("image1"))
        {
            tempPath=destnfile.replace("image1","imageBack");
        }else if(destnfile.contains("mf")) {
            tempPath = destnfile.replace("mf", "mfs");
        }*/
       // String newpath=destnfile.replace("image1","imageBack");
       // String newpath="E:\\imageBack\\";
        System.out.println("带新增审核图片放置位置: "+tempPath);
      //  System.out.println(tempPath);
        File orgFile = new File(srcfile);
        File desFile = new File(destnfile);
        File desNewFile = new File(tempPath);
        try {
            // 创建目标文件
            if (!desFile.createNewFile()) {
              //  System.out.println("创建文件失败" + desFile);
                return;
            }
            // 读取原文件
            FileInputStream fis = new FileInputStream(orgFile);
            // 写入到目标文件
          //  FileOutputStream fos = new FileOutputStream(desFile);
            FileOutputStream fos = new FileOutputStream(desNewFile);
            int len = 0;
            byte[] by = new byte[1024];
            while ((len = fis.read(by)) != -1) {
                // 直接将读取的字节流写入到目标文件
                fos.write(by, 0, len);
            }
            // 刷新下输出流
            fos.flush();
            // 关闭输入流，输出流
            fis.close();
            fos.close();
           /* IoUtil.close(fis);
            IoUtil.close(fos);*/
          //  System.out.println("复制文件成功");
            deletefile(srcfile);
            deletefile(destnfile);
            System.out.println("删除文件: "+srcfile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void moveFile(String srcfile,String destnfile)
    {
        /*System.out.println("destnfile: "+destnfile);
        String tempPath=null;
        if(destnfile.contains("image1"))
        {
            tempPath=destnfile.replace("image1","imageBack");
        }else if(destnfile.contains("mf")) {
            tempPath = destnfile.replace("mf", "mfs");
        }*/
        // String newpath=destnfile.replace("image1","imageBack");
        // String newpath="E:\\imageBack\\";
        System.out.println("文件放置位置: "+destnfile);
        //  System.out.println(tempPath);
        File orgFile = new File(srcfile);
        File desFile = new File(destnfile);
        try {
            // 创建目标文件
            if (!desFile.createNewFile()) {
                //  System.out.println("创建文件失败" + desFile);
                return;
            }
            // 读取原文件
            FileInputStream fis = new FileInputStream(orgFile);
            // 写入到目标文件
            //  FileOutputStream fos = new FileOutputStream(desFile);
            FileOutputStream fos = new FileOutputStream(desFile);
            int len = 0;
            byte[] by = new byte[1024];
            while ((len = fis.read(by)) != -1) {
                // 直接将读取的字节流写入到目标文件
                fos.write(by, 0, len);
            }
            // 刷新下输出流
            fos.flush();
            // 关闭输入流，输出流
            fis.close();
            fos.close();
            deletefile(srcfile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * 复制整个文件夹内容
     * @param oldPath String 原文件路径 如：c:/fqf
     * @param newPath String 复制后路径 如：f:/fqf/ff
     * @return boolean
     */
    public static void copyFolder(String oldPath, String newPath) {
        try {
            (new File(newPath)).mkdirs(); //如果文件夹不存在 则建立新文件夹
            File a=new File(oldPath);
            String[] file=a.list();
            File temp=null;
            for (int i = 0; i < file.length; i++) {
                if(oldPath.endsWith(File.separator)){
                    temp=new File(oldPath+file[i]);
                }
                else{
                    temp=new File(oldPath+File.separator+file[i]);
                }
                if(temp.isFile()){
                    FileInputStream input = new FileInputStream(temp);
                    FileOutputStream output = new FileOutputStream(newPath + "/" +
                            (temp.getName()).toString());
                    byte[] b = new byte[1024 * 5];
                    int len;
                    while ( (len = input.read(b)) != -1) {
                        output.write(b, 0, len);
                    }
                    output.flush();
                    output.close();
                    input.close();
                }
                if(temp.isDirectory()){//如果是子文件夹
                    copyFolder(oldPath+"/"+file[i],newPath+"/"+file[i]);
                }
            }
        }
        catch (Exception e) {
            System.out.println("复制整个文件夹内容操作出错");
            e.printStackTrace();
        }
    }




    public static void goThroughFile() {
        File dir = new File("numImage/");
        String[] children = dir.list();
        if (children == null) {
            System.out.println( "目录不存在或它不是一个目录");
        }
        else {
            for (int i=0; i< children.length; i++) {
                String filename = children[i];
                System.out.println(filename);
            }
        }
    }

    /**
     * 当前功能去除文件_store后缀
     * @param filePath
     */
    public static void updateFileNames(String filePath) {
        //获取文件所在目录
        File file = new File(filePath);
        // 获取文件夹绝对路径
        String path = file.getAbsolutePath();
        // 判断文件目录是否存在，且是文件目录，非文件
        if (file.exists() && file.isDirectory()) {
            // 遍历文件夹下的所有文件
            File[] childFiles = file.listFiles();
            for (int i = 0; i < childFiles.length; i++) {
                File file2 = childFiles[i];
                if (file2.isFile()) {
                    //下面是对文件重命名的操作，可根据需要修改。利用String里面的方法
                    String oldName = file2.getName();
                   // int index = oldName.indexOf("哈哈哈");
                   // String newName = oldName.substring(0, index);
                    String newName =oldName.replace("_store","");
                    file2.renameTo(new File(path + "\\" + newName));
                    //如果是文件夹，继续递归
                } else if (file2.isDirectory()) {
                    updateFileNames(file2.getAbsolutePath());
                } else {
                    System.out.println("不是一个文件！！！");
                }
            }
        }
    }



    /**
     * @Author AlphaJunS
     * @Date 11:32 2020/3/8
     * @Description
     * @param zip 压缩目的地址
     * @param srcFiles 压缩的源文件
     * @return void
     */

    public static List<String> list=new ArrayList<>();
    public static String outPutPath=null;
    public static String deletePath=null;
    public static void zipFile( String zip , File[] srcFiles ) {
        try {
            if( zip.endsWith(".zip") || zip.endsWith(".ZIP") ){
                FileOutputStream fos = new FileOutputStream(new File(zip));
                ZipOutputStream _zipOut = new ZipOutputStream(fos) ;
                _zipOut.setEncoding("GBK");
                for( File _f : srcFiles ){
                    handlerFile(zip , _zipOut , _f , "");
                }
                fos.close();
                _zipOut.close();
            }else{
                System.out.println("target file[" + zip + "] is not .zip type file");
            }
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
        }
    }

    /**
     * @Author AlphaJunS
     * @Date 11:33 2020/3/8
     * @Description
     * @param zip 压缩的目的地址
     * @param zipOut
     * @param srcFile 被压缩的文件信息
     * @param path 在zip中的相对路径
     * @return void
     */
    private static void handlerFile(String zip , ZipOutputStream zipOut , File srcFile , String path) throws IOException {
        System.out.println(" begin to compression file[" + srcFile.getName() + "]");
        if( !"".equals(path) && ! path.endsWith(File.separator)){
            path += File.separator ;
        }
        if( ! srcFile.getPath().equals(zip) ){
            if( srcFile.isDirectory() ){
                File[] _files = srcFile.listFiles() ;
                if( _files.length == 0 ){
                    zipOut.putNextEntry(new ZipEntry( path + srcFile.getName() + File.separator));
                    zipOut.closeEntry();
                }else{
                    for( File _f : _files ){
                        handlerFile( zip ,zipOut , _f , path + srcFile.getName() );
                    }
                }
            }else{
                InputStream _in = new FileInputStream(srcFile) ;
                zipOut.putNextEntry(new ZipEntry(path + srcFile.getName()));
                int len = 0 ;
                byte[] _byte = new byte[1024];
                while( (len = _in.read(_byte)) > 0  ){
                    zipOut.write(_byte, 0, len);
                }
                _in.close();
                zipOut.closeEntry();
            }
        }
    }

    /**
     * @Author AlphaJunS
     * @Date 11:34 2020/3/8
     * @Description 解压缩ZIP文件，将ZIP文件里的内容解压到targetDIR目录下
     * @param zipPath 待解压缩的ZIP文件名
     * @param descDir 目标目录
     * @return java.util.List<java.io.File>
     */
    public static List<File> unzipFile(String zipPath, String descDir) {
        return unzipFile(new File(zipPath) , descDir) ;
    }

    /**
     * @Author AlphaJunS
     * @Date 11:36 2020/3/8
     * @Description 对.zip文件进行解压缩
     * @param zipFile 解压缩文件
     * @param descDir 压缩的目标地址，如：D:\\测试 或 /mnt/d/测试
     * @return java.util.List<java.io.File>
     */
    @SuppressWarnings("rawtypes")
    public static List<File> unzipFile(File zipFile, String descDir) {
        List<File> _list = new ArrayList<File>() ;
        try {
            ZipFile _zipFile = new ZipFile(zipFile , "GBK") ;
            for( Enumeration entries = _zipFile.getEntries() ; entries.hasMoreElements() ; ){
                ZipEntry entry = (ZipEntry)entries.nextElement() ;
                File _file = new File(descDir + File.separator + entry.getName()) ;
                if( entry.isDirectory() ){
                    _file.mkdirs() ;
                }else{
                    File _parent = _file.getParentFile() ;
                    if( !_parent.exists() ){
                        _parent.mkdirs() ;
                    }
                    InputStream _in = _zipFile.getInputStream(entry);
                    OutputStream _out = new FileOutputStream(_file) ;
                    int len = 0 ;
                    byte[] _byte = new byte[1024];
                    while( (len = _in.read(_byte)) > 0){
                        _out.write(_byte, 0, len);
                    }
                    _in.close();
                    _out.flush();
                    _out.close();
                    _list.add(_file) ;
                }
            }
        } catch (IOException e) {
        }
        return _list ;
    }

    /**
     * @Author AlphaJunS
     * @Date 11:36 2020/3/8
     * @Description 对临时生成的文件夹和文件夹下的文件进行删除
     * @param delpath
     * @return void
     */
    public static void deletefile(String delpath) {
        System.out.println("删除文件： "+delpath);
        try {
            File file = new File(delpath);
            if (!file.isDirectory()) {
                file.delete();
            } else if (file.isDirectory()) {
                String[] fileList = file.list();
                for (int i = 0; i < fileList.length; i++) {
                    File delfile = new File(delpath + File.separator + fileList[i]);
                    if (!delfile.isDirectory()) {
                        delfile.delete();
                    } else if (delfile.isDirectory()) {
                        //deletefile(delpath + File.separator + fileList[i]);
                        String[] fileList1 = delfile.list();
                        for (int i1 = 0; i1 < fileList1.length; i1++) {
                            System.out.println(delfile.getPath() + File.separator + fileList1[i1]);
                            File delfile1 = new File(delfile.getPath() + File.separator + fileList1[i1]);
                            if (!delfile1.isDirectory()) {
                                delfile1.delete();
                            }
                        }
                    }
                    // file.delete();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void zipAll(String proName)
    {
        String propPath="config/"+proName+".properties";
        String rootPath = System.getProperty("user.dir").replace("\\", "/");
        // String inputPath= Page.getPropertie(propPath,"screenShotsPath");
        //输入路径为result_xxx
        String inputPath=rootPath+ Page.getPropertie(propPath,"filePath");
        //拼出打包名:
       // String dateStr= GetDate.getdate2DaysBefore();

        String dateStr=null;//GetDate.getTimestamp();
        String end=Page.getPropertie(propPath,"end");


        outPutPath=rootPath+Page.getPropertie(propPath,"filePath")+dateStr+end+".zip";

        System.out.println("zipInputPath:  "+inputPath);
        System.out.println("zipOutPutPath: "+outPutPath);
        //  zipAllFile(inputPath,outPutPath);
        File destDir = new File(inputPath);
        // 获取临时目录下的所有文件
        File[] files = destDir.listFiles();
        System.out.println("文件夹总数: "+files.length);
        FileUtil.zipFile(outPutPath, files);
        //  ZipUtil.deletefile(inputPath);
    }

    public static int countFile(String proName)
    {
        String propPath="config/"+proName+".properties";
        String rootPath = System.getProperty("user.dir").replace("\\", "/")+"/";
        // String inputPath= Page.getPropertie(propPath,"screenShotsPath");
        //输入路径为result_xxx
        String imagePath=rootPath+Page.getPropertie(propPath,"screenShotsPath");
        //拼出打包名:
        // String dateStr= GetDate.getdate2DaysBefore();

       /* String dateStr=AppstoreTest.getTodayDate();
        String end=Page.getPropertie(propPath,"end");


        String outPutPath=rootPath+Page.getPropertie(propPath,"filePath")+dateStr+end;

        System.out.println("zipInputPath:  "+inputPath);
        System.out.println("zipOutPutPath: "+outPutPath);*/
        //  zipAllFile(inputPath,outPutPath);

        System.out.println("目标文件夹:  "+imagePath);
        File destDir = new File(imagePath);
        // 获取临时目录下的所有文件
        File[] files = destDir.listFiles();
        System.out.println("文件总数: "+files.length);

        return files.length;

    }
    public static void deleteFiles( String proName)
    {
        String propPath="config/"+proName+".properties";
        String rootPath = System.getProperty("user.dir").replace("\\", "/");


        // String inputPath= Page.getPropertie(propPath,"screenShotsPath");
       // deletePath=rootPath+Page.getPropertie(propPath,"filePath");
        deletePath=rootPath+Page.getPropertie(propPath,"deletePath");
        System.out.println(deletePath);
        deletefile(deletePath);
    }
    public static void getFileName(String path) {
      //  String path = "F:/测试目录"; // 路径

        File f = new File(path);//获取路径  F:\测试目录
        if (!f.exists()) {
            System.out.println(path + " not exists");//不存在就输出
            return ;
        }

        File fa[] = f.listFiles();//用数组接收  F:\笔记总结\C#, F:\笔记总结\if语句.txt
        for (int i = 0; i < fa.length; i++) {//循环遍历
            File fs = fa[i];//获取数组中的第i个
            if (fs.isDirectory()) {
               // System.out.println(fs.getName() + " [目录]");//如果是目录就输出
                String[] fileList1 = fs.list();
                for (int i1 = 0; i1 < fileList1.length; i1++) {
                 //   System.out.println(fs.getPath() + File.separator + fileList1[i1]);
                    File delfile1 = new File(fs.getPath() + File.separator + fileList1[i1]);
                    if (!delfile1.isDirectory()) {
                   //     System.out.println("文件名: "+delfile1.getName());
                        list.add(delfile1.getName());
                    }
                }
            } else {
              //  System.out.println(fs.getName());//否则直接输出
            }
        }
       // return list;
    }

    public static List getFileNames( String proName)
    {
        String propPath="config/"+proName+".properties";
        String rootPath = System.getProperty("user.dir").replace("\\", "/");


        // String inputPath= Page.getPropertie(propPath,"screenShotsPath");
        String inputPath=rootPath+Page.getPropertie(propPath,"filePath");
       // System.out.println(inputPath);
        getFileName(inputPath);
        return list;
    }
    public static boolean isNewFile()
    {
        list= FileUtil.getFileNames("hr_InfoConfig");
        // System.out.println(list.toString());
        // System.out.println(list.get(0));
        if(list.size()==0)
        {
            return false;
        }
        boolean flag=StringUtils.getDateStr((String) list.get(0)).equals(GetDate.getdate2DaysBefore());
        System.out.println(flag);
        return flag;
    }

   /* public static void main(String[] args) {

        //zipAll("InfoConfig");
       // deleteFiles("InfoConfig");
       *//* deleteFiles("xs_InfoConfig");
        deleteFiles("mf_InfoConfig");*//*

      //  List list= FileUtil.getFileNames("hr_InfoConfig");
       // System.out.println(list.toString());
       // System.out.println(list.get(0));
      //  System.out.println(StringUtils.getDateStr((String) list.get(0)).equals(GetDate.getdate2DaysBefore()));
      //  FileUtil.countFile("hr_InfoConfig");
    }*/

}
