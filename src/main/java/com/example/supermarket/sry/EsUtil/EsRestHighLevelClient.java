package com.example.supermarket.sry.EsUtil;

import org.apache.http.HttpHost;
import org.apache.logging.log4j.core.util.Assert;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.rest.RestStatus;
import org.elasticsearch.common.xcontent.XContentBuilder;

import java.io.IOException;
import java.util.Map;

public class EsRestHighLevelClient {
     private  HttpHost[] hosts;
     private  String index;
     private  String type;
     private  String id;

     public EsRestHighLevelClient(String index, String type, String id, HttpHost[] hosts){
         this.hosts = hosts;
         this.index = index;
         this.type = type;
         this.id = id;
     }

    /**
     * @param index
     * @param type
     * @param hosts
     */
    public EsRestHighLevelClient(String index, String type, String... hosts){
        this.hosts = IpHelper.getHostArrByStr(hosts);
        this.index = index;
        this.type = type;
    }
    public RestHighLevelClient client(){
        Assert.requireNonEmpty(this.hosts, "无效的es连接");
        RestHighLevelClient client = new RestHighLevelClient(RestClient.builder(this.hosts));
        return client;
    }

    public IndexRequest indexRequest() {
        return new IndexRequest(this.index, this.type, this.id);
    }

    public RestStatus createIndex(Map<String, Object> map) throws IOException{
        return client().index(this.indexRequest().source(map), RequestOptions.DEFAULT).status();
    }
}
