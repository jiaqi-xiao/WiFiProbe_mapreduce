package com.codingfairy.mapreduce.test;

import com.codingfairy.mapreduce.save.Reader;
import com.codingfairy.mapreduce.save.Saver;
import com.codingfairy.mapreduce.save.Storer;
import com.codingfairy.tool.HDFSTool;
import org.junit.Test;

import java.io.*;
import java.util.Date;
import java.util.List;

/**
 * Created by darxan on 2017/8/27.
 */
public class StoreTest {


    private static final long HOUR = 1000L*60L*60L;
//    @Test
    public void testLocalFile() {
        try {

            Reader reader = new Reader();
            String __directory = "H:\\code\\javaspace\\WIFIProbe\\mapreduce\\statistic";
            File root = new File(__directory);

            for (String dir : root.list()) {

                String[] statisticFiles = new File(__directory+"/"+dir).list();
                for (String file : statisticFiles) {
                    InputStream inputStream = new FileInputStream(
                            new File(__directory+"/"+dir+"/"+file));
                    reader.readStream(file, inputStream);
                }
            }

            // 计算活跃度
            reader.summary(System.currentTimeMillis(), "test");
            // 将读取出来的结果存入数据库
            new Storer().store(reader);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    @Test
    public void testHDFS() {
        long currentTimeMillis = System.currentTimeMillis();
        long time = currentTimeMillis/HOUR*HOUR;
        long startTime = 1504322260519L;
        new Saver(startTime, currentTimeMillis, "testWifiProb").run();
    }

//    @Test
    public void testTime() {
        System.out.println(new Date(1504324800000L));
    }
}
