package net.bigdataer.demo.log4j.logwriter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by liuxuecheng on 2018/6/29.
 *
 * @58corp
 */
public class WriteLogToFlume {

    public static void main(String args[]) throws InterruptedException {
        Logger log = LogManager.getLogger(WriteLogToFlume.class);
        //the default buffer size in AsyncAppender is 1024,so you variable must bigger than 1024
        for(int i = 0;i<10000;i++){
            AdxWinLog.AdxLog adxLog = AdxWinLog.AdxLog.newBuilder()
                    .setTs("ts"+System.currentTimeMillis())
                    .setUserId("userid"+i)
                    .setImei("ime"+i)
                    .setDisplayId("displayid"+i)
                    .setCookieId("cookie=="+i)
                    .build();
            // log.info can accept Object kinds paramter,invoke method toByteArray() to transfer adxLog to byte[]
            log.info(adxLog.toByteArray());
        }
    }
}
