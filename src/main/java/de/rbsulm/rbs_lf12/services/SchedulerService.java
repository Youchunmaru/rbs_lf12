package de.rbsulm.rbs_lf12.services;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.UUID;

@Service
public class SchedulerService {

    @Autowired
    private Scheduler scheduler;

    public void schedule(LocalDateTime dateTime, Action action) throws SchedulerException {
        String jobName = "job_" + UUID.randomUUID();
        String groupName = "group_" + UUID.randomUUID();

        JobDataMap jobDataMap = new JobDataMap();
        jobDataMap.put("action", action);

        JobDetail job = JobBuilder.newJob(ActionJob.class)
                .withIdentity(jobName, groupName)
                .usingJobData(jobDataMap)
                .build();

        Date runTime = Date.from(dateTime.atZone(ZoneId.systemDefault()).toInstant());

        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("trigger_" + UUID.randomUUID(), groupName)
                .startAt(runTime)
                .build();

        scheduler.scheduleJob(job, trigger);
    }

    public interface Action {
        void action();
    }

    public static class ActionJob implements Job {

        @Override
        public void execute(JobExecutionContext context) throws JobExecutionException {
            JobDataMap jobDataMap = context.getMergedJobDataMap();
            Action action = (Action) jobDataMap.get("action");
            action.action();
        }
    }
}