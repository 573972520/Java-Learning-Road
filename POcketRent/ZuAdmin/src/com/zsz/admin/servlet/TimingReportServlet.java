package com.zsz.admin.servlet;


import java.util.TimeZone;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

@WebServlet(value="/TimingReportServlet",loadOnStartup=1)
public class TimingReportServlet extends BaseServlet {
	private static final Logger log = LogManager.getLogger(TimingReportServlet.class);
	
	@Override
	public void init() throws ServletException {
		super.init();
		try
		{
			log.debug("开始执行发送表的定时任务的安排");
			Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
			JobDetail job = JobBuilder.newJob(ReportJob.class).build();
			CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.dailyAtHourAndMinute(15, 51).inTimeZone(TimeZone.getTimeZone("GTM+08:00"));
			CronTrigger trigger = TriggerBuilder.newTrigger().withSchedule(cronScheduleBuilder).build();
			scheduler.scheduleJob(job,trigger);
			scheduler.start();//不要忘记启动
			log.debug("完成执行发送表的定时任务的安排");
		}
		catch(Throwable ex)
		{
			log.error("启动定时任务错误",ex);
		}
	}
}
