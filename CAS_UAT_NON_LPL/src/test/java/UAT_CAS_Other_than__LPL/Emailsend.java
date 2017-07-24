package UAT_CAS_Other_than__LPL;

import java.util.Date;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class Emailsend {

	public static void main(String[] args) {
		
		final String username = "test-run.report@herofincorp.com";
	    final String password = "India@123";
	    // test-run.report@herofincorp.com
	    // India@123
	    Properties props = new Properties();
	    props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
  
	    Session session = Session.getInstance(props,
	            new javax.mail.Authenticator() {
	                protected PasswordAuthentication getPasswordAuthentication() {
	                    return new PasswordAuthentication(username, password);
	                }
	            });
	    try {
	        Message message = new MimeMessage(session);
	        message.setFrom(new InternetAddress(username));
	        message.addRecipients(Message.RecipientType.TO,InternetAddress.parse("nishant.omar@herofincorp.biz"));
	        message.addRecipients(Message.RecipientType.CC,InternetAddress.parse("nishant.omar@herofincorp.biz"));
	        message.setSubject("CAS-Automated Regression Testing Results");
	        message.setSentDate(new Date());
	        
	        BodyPart messageBodyPart1 = new MimeBodyPart();
	        String bodymessage = "Hi, <br><br><br>Please find attached the results of the CAS Regression Run.<br><br><br><b>***This is an automated mail. Please do not respond.***</b>";
	        messageBodyPart1.setContent(bodymessage,"text/html"); 
	        MimeBodyPart messageBodyPart2 = new MimeBodyPart();
	        String file = "C:\\Automation_Softwares\\eclipse\\WorkSpace\\CAS_UAT_NON_LPL\\test-output\\emailable-report.html";
	        String fileName = "CAS_Regression_Report.html";
	        DataSource source = new FileDataSource(file);
	        messageBodyPart2.setDataHandler(new DataHandler(source));
	        messageBodyPart2.setFileName(fileName);	     	      
	        Multipart multipart = new MimeMultipart();
	        multipart.addBodyPart(messageBodyPart1);
	        multipart.addBodyPart(messageBodyPart2);
	        message.setContent(multipart);	      
	        System.out.println("Email is Sending");
	        Transport.send(message);
	        System.out.println("Email has send");
	    } catch (MessagingException e) {
	        e.printStackTrace();
	    	}
		}
	}