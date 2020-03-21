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
        String urlProvider = "dubbo%3A%2F%2F192.168.193.1%3A20880%2Fcom.keepstudy.api.EmployeeRemoteService%3Fanyhost%3Dtrue%26application%3Ddubbo-provider%26dubbo%3D2.5.5%26generic%3Dfalse%26interface%3Dcom.keepstudy.api.EmployeeRemoteService%26methods%3DgetEmployeeByConditionRemote%26pid%3D3224%26revision%3D1.0-SNAPSHOT%26side%3Dprovider%26timestamp%3D1584711177960";
        String urlConsumer = "consumer%3A%2F%2F192.168.193.1%2Fcom.keepstudy.api.EmployeeRemoteService%3Fapplication%3Ddubbo-consumer%26category%3Dconsumers%26check%3Dfalse%26dubbo%3D2.5.5%26interface%3Dcom.keepstudy.api.EmployeeRemoteService%26methods%3DgetEmployeeByConditionRemote%26pid%3D11280%26revision%3D1.0-SNAPSHOT%26side%3Dconsumer%26timestamp%3D1584757391336";
        String decodeProvider = URLDecoder.decode(urlProvider, "UTF-8");
        String decodeConsumer = URLDecoder.decode(urlConsumer, "UTF-8");
        System.out.println("provider解码后："+decodeProvider);
        System.out.println("consumer解码后："+decodeConsumer);
    }
}
