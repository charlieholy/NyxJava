package utils;

import org.apache.log4j.DailyRollingFileAppender;
import org.apache.log4j.Layout;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.spi.LoggingEvent;

public class AnyWayLog extends DailyRollingFileAppender {
    AnyWayLog(String identify){
        Layout layout = new PatternLayout();
        setFile("./msg/" + identify + ".log");
        setLayout(layout);
        setDatePattern("'.'yyyy-MM-dd");
        activateOptions();
    }
    public void INFO(String msg){
        LoggingEvent loggingEvent = new LoggingEvent(null, org.apache.log4j.Logger.getRootLogger(), Level.ALL,msg,null);
        subAppend(loggingEvent);
    }

    public void ERROR(String msg,Throwable e){
        LoggingEvent loggingEvent = new LoggingEvent(null, Logger.getRootLogger(), Level.ALL,msg,e);
        subAppend(loggingEvent);
    }
}
