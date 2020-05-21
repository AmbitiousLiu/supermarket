package com.example.supermarket.ljy.hadoop;

import org.springframework.boot.context.event.ApplicationPreparedEvent;
import org.springframework.context.ApplicationListener;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 * @author jleo
 * @date 2020/5/21
 */
public class ApplicationPreparedEventListener implements ApplicationListener<ApplicationPreparedEvent> {
    @Override
    public void onApplicationEvent(ApplicationPreparedEvent event) {
//        try {
//            new Hdfs().upToHdfs();
//        } catch (URISyntaxException | IOException | InterruptedException e) {
//            e.printStackTrace();
//        }
    }
}
