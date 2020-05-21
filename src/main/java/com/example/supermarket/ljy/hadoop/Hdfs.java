package com.example.supermarket.ljy.hadoop;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author jleo
 * @date 2020/5/20
 */
public class Hdfs {

//    public void upToHdfs() throws URISyntaxException, IOException, InterruptedException {
//        Configuration configuration = new Configuration();
//        FileSystem fileSystem = FileSystem.get(new URI("hdfs://node1:9000"), configuration, "jleo");
//        // 日志文件目录
//        String logFilePath = "D:/supermarket/logFile/";
//        // hdfs文件目录
//        String hdfsFilePath = "/supermarket/";
//        // 拷贝到待上传目录
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmm");
//        String todayStr = sdf.format(new Date());
//        // 上传到hdfs
//        String path = logFilePath + "supermarket.log";
//        try {
//            fileSystem.copyFromLocalFile(new Path(path), new Path(hdfsFilePath + todayStr + "_supermarket.log"));
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            fileSystem.close();
//        }
//    }

}
