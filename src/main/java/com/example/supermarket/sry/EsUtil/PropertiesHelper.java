//package com.example.supermarket.sry.EsUtil;
//
//import com.google.common.cache.CacheBuilder;
//import com.google.common.cache.CacheLoader;
//import com.google.common.cache.LoadingCache;
//import org.apache.commons.io.IOUtils;
//
//import java.io.*;
//import java.util.Properties;
//import java.util.concurrent.TimeUnit;
//import java.util.concurrent.locks.ReentrantReadWriteLock;
//
///**
// * 配置文件读取和写入工具类
// */
//public class PropertiesHelper {
//    private static final String DEFAULT_PROPERTIES_HEADER = "Configuration Info";
//    private static final LoadingCache<String, ReentrantReadWriteLock> locks;
//    private final String absolutePath;
//    private final ReentrantReadWriteLock.ReadLock readLock;
//    private final ReentrantReadWriteLock.WriteLock writeLock;
//
//
//    static {
//        locks = CacheBuilder.newBuilder().maximumSize(10).expireAfterWrite(10, TimeUnit.MINUTES)
//                .build(new CacheLoader<String, ReentrantReadWriteLock>() {
//                    public ReentrantReadWriteLock load(String key) {
//                        return new ReentrantReadWriteLock();
//                    }
//                });
//    }
//
//    public PropertiesHelper(String filePath) {
//        this.absolutePath = new File(filePath).getAbsolutePath();
//        ReentrantReadWriteLock lock = locks.getUnchecked(absolutePath);
//        readLock = lock.readLock();
//        writeLock = lock.writeLock();
//    }
//
//    public String getProperty(String key, String defaultValue) {
//        try {
//            readLock.lock();
//            Properties properties = getProperties();
//            return properties.getProperty(key, defaultValue);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return defaultValue;
//        } finally {
//            readLock.unlock();
//        }
//    }
//
//    public void setProperty(String key, String value) throws IOException {
//        try {
//            writeLock.lock();
//            Properties prop = getProperties();
//            prop.setProperty(key, value);
//            saveProperties(prop);
//        } finally {
//            writeLock.unlock();
//        }
//    }
//
//    public void removeProperty(String key) throws IOException {
//        try {
//            writeLock.lock();
//            Properties prop = getProperties();
//            prop.remove(key);
//            saveProperties(prop);
//        } finally {
//            writeLock.unlock();
//        }
//    }
//
//    public boolean containsKey(String key) throws Exception {
//        try {
//            readLock.lock();
//            Properties prop = getProperties();
//            return prop.containsKey(key);
//        } finally {
//            readLock.unlock();
//        }
//    }
//
//    private void saveProperties(Properties prop) throws IOException {
//        OutputStreamWriter writer = null;
//        try {
//            writer = new OutputStreamWriter(new FileOutputStream(absolutePath), "UTF-8");
//            prop.store(writer, DEFAULT_PROPERTIES_HEADER);
//            writer.flush();
//        } finally {
//            IOUtils.closeQuietly(writer);
//        }
//    }
//
//    private Properties getProperties() throws IOException {
//        InputStreamReader reader = null;
//        try {
//            Properties prop = new Properties();
//            reader = new InputStreamReader(new FileInputStream(absolutePath), "UTF-8");
//            prop.load(reader);
//            return prop;
//        } finally {
//            IOUtils.closeQuietly(reader);
//        }
//    }
//}
//
