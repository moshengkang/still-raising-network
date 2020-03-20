package com.keepstudy;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 * @Author: moshengkang
 * @e-mial: 1634414600@qq.com
 * @Version: 1.0
 * @Description: 解码
 */
public class DecodeTest {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String url = "dubbo%3A%2F%2F192.168.193.1%3A20880%2Fcom.keepstudy.api.EmployeeRemoteService%3Fanyhost%3Dtrue%26application%3Ddubbo-provider%26dubbo%3D2.5.5%26generic%3Dfalse%26interface%3Dcom.keepstudy.api.EmployeeRemoteService%26methods%3DgetEmployeeByConditionRemote%26pid%3D3224%26revision%3D1.0-SNAPSHOT%26side%3Dprovider%26timestamp%3D1584711177960";
        String decode = URLDecoder.decode(url, "UTF-8");
        System.out.println("解码后："+decode);
    }
}
