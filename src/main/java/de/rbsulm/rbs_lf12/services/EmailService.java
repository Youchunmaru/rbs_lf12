package de.rbsulm.rbs_lf12.services;

import org.quartz.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mail.MailProperties;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service; // Changed to @Service

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

@Service // Mark as a service
public class EmailService {

   /* private static final Logger logger = LoggerFactory.getLogger(EmailService.class);

    @Autowired
    private Scheduler scheduler;

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private MailProperties mailProperties;


    public void scheduleEmail(String to, String subject, String body, LocalDateTime dateTime) throws SchedulerException {

        // Convert LocalDateTime to Date (Quartz needs Date)
        ZonedDateTime zdt = dateTime.atZone(ZoneId.systemDefault()); // Use your timezone
        Date scheduledDate = Date.from(zdt.toInstant());

        // Create JobDetail
        JobDataMap jobDataMap = new JobDataMap();
        jobDataMap.put("to", to);
        jobDataMap.put("subject", subject);
        jobDataMap.put("body", body);

        JobDetail jobDetail = JobBuilder.newJob(EmailJob.class)
                .withIdentity("emailJob_" + System.currentTimeMillis(), "emailGroup") // Unique name!
                .usingJobData(jobDataMap)
                .storeDurably()
                .build();

        // Create Trigger
        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("emailTrigger_" + System.currentTimeMillis(), "emailGroup") // Unique name!
                .startAt(scheduledDate) // Start at the specified time
                .build();

        // Schedule the job
        scheduler.scheduleJob(jobDetail, trigger);

        logger.info("Email scheduled to {} for: {}", dateTime, to);
    }



    // ... (EmailJob class remains the same as in the previous example) ...
*/
}
