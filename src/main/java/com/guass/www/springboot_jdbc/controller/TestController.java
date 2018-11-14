package com.guass.www.springboot_jdbc.controller;

import com.guass.www.springboot_jdbc.utils.DownloadUtil;
import com.guass.www.springboot_jdbc.utils.OkHttpUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Controller
public class TestController {

    @GetMapping(value = "/test")
    @ResponseBody
    public String test(){
        return "Test";
    }


    private static String appid = "你的appid，在微信公众号后台获取";
    private static String secret = "你的秘钥，在微信公众号后台获取";
    private static String grant_type = "client_credential";
    private static String tokenurl = "https://api.weixin.qq.com/cgi-bin/token";

    //http请求方式: GET
// https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET
    @RequestMapping(value = "/wx/token", method = RequestMethod.GET)
    @ResponseBody
    public String getToken() {

        System.out.println("/wx/token " + Thread.currentThread().getName());

        Map param = new HashMap();
        param.put("grant_type", grant_type);
        param.put("appid", appid);
        param.put("secret", secret);
        StringBuilder sb = new StringBuilder();
        int keylenght = 0;
        for (Object key : param.keySet()) {
            if (keylenght < 2) {
                sb.append(key).append("=").append(param.get(key)).append("&");
            } else {
                sb.append(key).append("=").append(param.get(key));
            }
            keylenght++;
        }
        String url=tokenurl+"?"+sb.toString();
        System.out.print(url);
        String response = OkHttpUtil.doGet(url);
        System.out.println(response);

        return response;
    }


    @RequestMapping(value = "/download/",method = RequestMethod.GET)
    @ResponseBody
    public String downLoad(){

        System.out.println("url " + Thread.currentThread().getName());


        DownloadUtil.get().download("http://editerupload.eepw.com.cn/201809/61001537857032.jpg", "C:\\Users\\Administrator\\Desktop\\doc", "ok.jpg", new DownloadUtil.OnDownloadListener() {
            @Override
            public void onDownloadSuccess(File file) {
                System.out.println("ok " + file.getName());
            }

            @Override
            public void onDownloading(int progress) {
                //     System.out.println("progress " + progress);
            }

            @Override
            public void onDownloadFailed(Exception e) {
                System.out.println(" " + e.getMessage());
            }
        });

        return "ok";
    }

}
