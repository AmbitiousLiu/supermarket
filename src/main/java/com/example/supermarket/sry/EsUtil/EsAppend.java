package com.example.supermarket.sry.EsUtil;

import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.Layout;
import org.apache.log4j.spi.LoggingEvent;
import org.springframework.util.CollectionUtils;

import java.io.IOException;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EsAppend extends AppenderSkeleton {
  //  private static  EsRestHighLevelClient esClient;//es客户端
    private String confName;//es配置文件名
    private ExecutorService executorService = Executors.newFixedThreadPool(10);

    @Override
    protected void append(LoggingEvent loggingEvent) {
        if (this.isAsSevereAsThreshold(loggingEvent.getLevel())){
            executorService.execute(new EsAppendTask(loggingEvent, this.layout));
        }
    }

    @Override
    public void close() {
        this.closed = true;
    }

    @Override
    public boolean requiresLayout() {
        return false;
    }

    public void activateOptions(){
        super.activateOptions();
        try {
            System.out.println("初始化 - EsAppend...");
            if (this.getConfName() == null || this.getConfName().isEmpty()){
                this.setConfName("eslog.properties");
            }
            PropertiesHelper propertiesHelper = new PropertiesHelper(this.getConfName());
            String strHosts = propertiesHelper.getProperty("es.links", "127.0.0.1:9200");
            String esLogIndex = propertiesHelper.getProperty("es.indexName", "eslog");
            esClient = new EsRestHighLevelClient(esLogIndex, "docs", strHosts);
            System.out.println("初始化完成 - EsAppend");
        } catch (Exception ex){
            System.out.println("初始化失败 - EsAppend");
            ex.printStackTrace();
        }
    }

    public String getConfName(){
        return confName;
    }

    public void setConfName(String confName){
        this.confName = confName;
    }

    class EsAppendTask implements Runnable {
        private HashMap<String, Object> map;

        public EsAppendTask(LoggingEvent loggingEvent, Layout layout){
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd\'T\'HH:mm:ss.SSSZ");
            map = new HashMap<String,Object>(){
                {
                    put("timeStamp", df.format(new Date()));
                    put("ServerIp", IpHelper.getHostIp().get());
                    put("hostname", IpHelper.getHostName().get());
                    put("level", loggingEvent.getLevel().toString());
                    put("className", loggingEvent.getLocationInformation().getClassName());
                    put("methodName",loggingEvent.getLocationInformation().getMethodName());
                    put("data", loggingEvent.getMessage());
                    if (loggingEvent.getThrowableInformation() != null && !CollectionUtils.isEmpty(Arrays.asList(loggingEvent.getThrowableInformation().getThrowableStrRep()))){
                        put("exception", String.join(";",loggingEvent.getThrowableInformation().getThrowableStrRep()));
                    } else {
                        put("exception", "");
                    }
                }
            };
        }

        @Override
        public void run() {
            try {
                EsAppend.esClient.createIndex(map);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
