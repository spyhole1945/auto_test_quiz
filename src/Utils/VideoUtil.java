package Utils;



import it.sauronsoftware.jave.Encoder;
import it.sauronsoftware.jave.EncoderException;
import it.sauronsoftware.jave.MultimediaInfo;

import java.awt.image.RasterFormatException;
import java.io.*;
import java.math.BigDecimal;
import java.nio.channels.FileChannel;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class VideoUtil {
    public static void main(String[] args) {
       // VideoUtil.getVideoInfo("result/image/test.mp4");
       // System.out.println(VideoUtil.judgeVerticalAndHorizontal("result/image/test.mp4"));
      //  VideoUtil.modifyVerticalOrHorizontal("result/image/");
      //  VideoUtil.renameVerticalOrHorizontal("D:\\元宇宙视频下载\\颜值5-2023-05-19_11-38-51.mp4");

       // System.out.println(VideoUtil.finder("D:\\元宇宙视频下载\\test")[0]);
        VideoUtil.readTxtByLine("D:\\元宇宙视频下载\\test\\视频标题文案_搞笑2023-03-15.log");
    }

    /**
     *  举例：System.out.println(VideoUtil.finder("D:\\元宇宙视频下载\\test")[0]);
     * @param dirName 指定目标路径
     * @return 返回一个文件数组。
     */
    public static File[] finder( String dirName){
        File dir = new File(dirName);

        return dir.listFiles(new FilenameFilter() {
            public boolean accept(File dir, String filename)
            { return filename.endsWith(".log"); }
        } );

    }

    public static void readTxtByLine(String txtPath)
    {
        try {
            // open file to read
            Scanner scanner = new Scanner(new File(txtPath));

            // read until end of file (EOF)
            while (scanner.hasNextLine()) {
               /* String filepath=scanner.nextLine().replace("[","").replace("]","");
                System.out.println(filepath);
                String[] splitResult=filepath.split("/");
                System.out.println(splitResult[splitResult.length-1]);
                String filename=splitResult[splitResult.length-1];
                System.out.println(filename);
                FileUtil.copyFile(filepath,"roomImage/failtest/"+filename);*/
                System.out.println(scanner.nextLine());
            }

            // close the scanner
            scanner.close();

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }


    /**
     * 修改文件夹中所有的文件“横屏”“竖屏”
     * @param filePath
     */
    public static void uploadVideo(String filePath)
    {
       File text =VideoUtil.finder(filePath)[0];
        Map videoTitleMap= new HashMap<>();
        try {
            //   BufferedImage pic1 = ImageIO.read(sourcePic);
            File dir = new File(filePath);

            String[] children = dir.list();
            System.out.println(filePath+"中共有"+children.length+"个文件");
            if (children == null) {
                System.out.println( "目录不存在或它不是一个目录");
            }
            else  {
                for (int i=0; i< children.length; i++) {


                    if(children[i].contains(".mp4"))
                    {
                        videoTitleMap.put(children[i],"");
                    }

                }
            }
        } catch ( RasterFormatException e1) {
            e1.printStackTrace();
        }
    }

    /**
     * 修改文件夹中所有的文件“横屏”“竖屏”
     * @param filePath
     */
    public static void modifyVerticalOrHorizontal(String filePath)
    {
      /*  String filename =null;
        String fullName=null;*/
        try {
            //   BufferedImage pic1 = ImageIO.read(sourcePic);
            File dir = new File(filePath);

            String[] children = dir.list();
            System.out.println(filePath+"中共有"+children.length+"个文件");
            if (children == null) {
                System.out.println( "目录不存在或它不是一个目录");
            }
            else  {
                for (int i=0; i< children.length; i++) {


                    if(children[i].contains(".log"))
                    {
                        System.out.println(children[i]+"是日志文件");
                        continue;
                    }

                    else if(children[i].contains("横屏")||children[i].contains("竖屏"))
                    {
                        System.out.println(children[i]+"是已处理文件");
                        continue;
                    }else if(children[i].contains(".mp4")){

                        String filename = children[i];
                        String fullName=filePath+filename;
                        System.out.println("fullName: "+fullName);
                        String flag=VideoUtil.judgeVerticalAndHorizontal(fullName);

                        String newfilename = children[i].replace(".mp4",flag+".mp4");
                        File oldfile=new File(fullName);
                        File newfile=new File(filePath+newfilename);
                      //  oldfile.renameTo(newfile);
                        if(oldfile.renameTo(newfile)) {
                            System.out.println("已重命名");
                        } else {
                            System.out.println("Error");
                            System.out.println(fullName);
                            System.out.println(filePath+newfilename);
                            oldfile.renameTo(newfile);
                        }
                    }


                }
            }
        } catch ( RasterFormatException e1) {
            e1.printStackTrace();
        }
    }

    /**
     * 判断特定文件“横屏”“竖屏”，并修改
     * @param filePath
     */
    public static void renameVerticalOrHorizontal(String filePath)
    {
        try {

                String flag=VideoUtil.judgeVerticalAndHorizontal(filePath);

                String newfilename = filePath.replace(".mp4",flag+".mp4");
               /*   File oldfile=new File(filePath);
                File newfile=new File(newfilename);
                //  oldfile.renameTo(newfile);
              if(oldfile.renameTo(newfile)) {
                    System.out.println("已重命名");
                } else {
                    System.out.println("Error");
                    System.out.println(filePath);
                    System.out.println(newfilename);
                    oldfile.renameTo(newfile);
                }*/
            FileUtil.copyFile(filePath,newfilename);
            FileUtil.deletefile(filePath);

        } catch ( RasterFormatException e1) {
            e1.printStackTrace();
        }
    }

   /**

     * @author alex hou

     * @Description TODO 判断视频纵向还是横向

     * @param

     * @return 1 横 0 竖

     */
   public static String judgeVerticalAndHorizontal(String filePath) {
       System.setProperty("ffmpeg.home", "ffmpegbin");
       float v = 0F;
       File source = new File(filePath);
       Encoder encoder = new Encoder();

       FileChannel fc = null;
       try {
           MultimediaInfo mi = encoder.getInfo(source);
           System.out.println(mi.getVideo()); //视频信息
           System.out.println(mi.getAudio());  //音频信息

           int width = mi.getVideo().getSize().getWidth();
           int height = mi.getVideo().getSize().getHeight();

           System.out.println("★★★★★★★★★【" + source + "】★★★★★★★★★");

           System.out.println("尺寸:" + width + "×" + height);
           v = ((float) width / (float) height);


       } catch (Exception e) {
           e.printStackTrace();
       } finally {
           if (null != fc) {
               try {
                   fc.close();
               } catch (IOException e) {
                   e.printStackTrace();
               }
           }
       }
       return v>1?"横屏":"竖屏";
   }

    public static void getVideoInfo(String filePath) {
        System.setProperty("ffmpeg.home", "ffmpegbin");
        File source = new File(filePath);
        Encoder encoder = new Encoder();
        FileChannel fc = null;
        try {
            MultimediaInfo mi = encoder.getInfo(source);
            System.out.println(mi.getVideo()); //视频信息
            System.out.println(mi.getAudio());  //音频信息
            //String duration = LxTimeUtil.msecToTime(mi.getDuration());
            int width = mi.getVideo().getSize().getWidth();
            int height = mi.getVideo().getSize().getHeight();
            String format = mi.getFormat();
            int audioChannels = mi.getAudio().getChannels();
            String audioDecoder = mi.getAudio().getDecoder();
            int audioSamplingRate = mi.getAudio().getSamplingRate();
            String videoDecoder = mi.getVideo().getDecoder();
            float videoFrameRate = mi.getVideo().getFrameRate();


            System.out.println("★★★★★★★★★【" + source + "】★★★★★★★★★");
            System.out.println("格式:" + format);
            //  System.out.println("时长:" + duration);
            System.out.println("尺寸:" + width + "×" + height);
            System.out.println("音频编码：" + audioDecoder);
            System.out.println("音频轨道:" + audioChannels);
            System.out.println("音频采样率:" + audioSamplingRate);
            System.out.println("视频编码:" + videoDecoder);
            System.out.println("视频帧率:" + videoFrameRate);
            //获取视频大小
            FileInputStream fis = new FileInputStream(source);
            fc = null;
            fc = fis.getChannel();
            BigDecimal fileSize = new BigDecimal(fc.size());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != fc) {
                try {
                    fc.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
