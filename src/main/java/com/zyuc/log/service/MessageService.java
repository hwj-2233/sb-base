package com.zyuc.log.service;

import com.sun.org.apache.xml.internal.resolver.readers.ExtendedXMLCatalogReader;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * @author hongwj
 * @date 2020/12/22
 **/
@Service
@Slf4j
public class MessageService {


    @Value("${message.key}")
    private static String messageKey;

    @Value("${message.uid}")
    private static String messageUid;

    /**
     * @param sendPhoneNum
     * @param content
     * @throws Exception
     */
    public void sendMessage(String sendPhoneNum, String content) throws Exception {

        HttpClient client = new HttpClient();
        PostMethod post = new PostMethod("http://gbk.api.smschinese.cn");
        post.addRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=gbk");
        NameValuePair[] data = {new NameValuePair("Uid", "hwj2233"), new NameValuePair("Key", "d41d8cd98f00b204e980"), new NameValuePair("smsMob", sendPhoneNum), new NameValuePair("smsText", content)};
        post.setRequestBody(data);

        client.executeMethod(post);
        Header[] headers = post.getResponseHeaders();
        int statusCode = post.getStatusCode();
        log.info("statusCode:" + statusCode);
        for (Header h : headers) {
            log.info(h.toString());
        }
        String result = new String(post.getResponseBodyAsString().getBytes("gbk"));
        log.info(result);
        post.releaseConnection();
    }
}

