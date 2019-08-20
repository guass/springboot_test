package com.guass.www.springboot_jdbc.controller;

import com.alibaba.fastjson.JSON;
import com.guass.www.springboot_jdbc.utils.DownloadUtil;
import com.guass.www.springboot_jdbc.utils.OkHttpUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Api(value = "用户的增删改查")
@Controller
public class TestController {

    @GetMapping(value = "/test")
    @ResponseBody
    public String test(){
        return "Test";
    }

    @Autowired
    StringRedisTemplate mRedisTemplate;


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

    @ApiOperation(value = "通过key从redis查询value", notes="返回value")
    @GetMapping(value = "/get-obj/{key}")
    @ResponseBody
    public String test2(HttpServletRequest request, HttpServletResponse response,@PathVariable("key") String key){

        Object obj = mRedisTemplate.opsForValue().get(key);
        System.out.println("obj " + obj);
        return JSON.toJSONString(obj);
    }


    @PostMapping(value = "/set-name")
    @ResponseBody
    @ApiImplicitParam(name = "key", value = "gggg")
    public String test3(HttpServletRequest request, HttpServletResponse response,@RequestParam Map<String,String> map){

        String key = map.get("key");
        String value = map.get("value");


        mRedisTemplate.opsForValue().set(key,value);


        return JSON.toJSONString( mRedisTemplate.opsForValue().get(key));
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
