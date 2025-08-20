package Utils;

import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.Message.RecipientType;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class JavaMail {
    public JavaMail() {
    }

    public static String setText(String apiName, String statuscode, String message) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("-----------------------------------------------------------");
        stringBuilder.append("\napi接口: " + apiName + " -执行失败\n");
        stringBuilder.append("statuscode: " + statuscode + "\n");
        stringBuilder.append("message: " + message + "\n");
        stringBuilder.append("-----------------------------------------------------------");
        return stringBuilder.toString();
    }

    public static void send(String title, String content) {
        String host = "smtp.exmail.qq.com";
        int port = 465;
        String username = "apitester@scienjoy.com";
        String password = "Api123";
        Properties props = new Properties();
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.auth", true);
        props.put("mail.smtp.starttls.enable", true);
        props.put("mail.smtp.ssl.enable", true);
        props.put("mail.smtp.port", Integer.valueOf(port));
        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("apitester@scienjoy.com", "Api123");
            }
        });

        try {
            String address = PropertiesUtils.getProperty("address");
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("apitester@scienjoy.com"));
            message.setRecipients(RecipientType.TO, InternetAddress.parse(address));
            message.setSubject(title);
            message.setText(content);
            Transport transport = session.getTransport("smtp");
            transport.connect(host, port, "apitester@scienjoy.com", "Api123");
            Transport.send(message);
            System.out.println("成功发送email.");
        } catch (MessagingException var11) {
            throw new RuntimeException(var11);
        }
    }

    public static void main(String[] args) {
       // send(Page.appPackage + ": finished", "Test result URL: http://192.168.83.184:8080/reporter/");
        JavaMail.send("测试邮件to健滔","");
    }
}
