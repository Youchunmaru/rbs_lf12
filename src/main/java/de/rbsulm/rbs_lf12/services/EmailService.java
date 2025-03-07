package de.rbsulm.rbs_lf12.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendMail(String to, String subject, String body) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(body);

        try {
            mailSender.send(message);
            System.out.println("Email sent successfully to: " + to); //Logging. Consider a real logging framework
        } catch (Exception e) {
            System.err.println("Failed to send email to: " + to + ". Error: " + e.getMessage()); //Logging with error.
            // Consider more robust error handling, such as throwing a custom exception.
        }
    }

    //Example of sending HTML email.
    //If you need to send HTML you will need to use MimeMessage and MimeMessageHelper
    //and set the html parameter to true.
    //Example usage (not a complete, production-ready implementation):
    /*
    public void sendHtmlMail(String to, String subject, String htmlBody) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8"); // Enable multipart and UTF-8

        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(htmlBody, true); // Set HTML content

        mailSender.send(message);
    }
    */
}