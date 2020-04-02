package com.keepstudy.util.rest.support;

import com.alibaba.fastjson.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;

import java.util.List;
import java.util.Map;

/**
 * @author: 莫升康
 * @e-mail: 1634414600@qq.com
 * @Date: 2020/4/1 10:56
 * @Description: restful接口封装
 */
public interface RestTemplateService {

    /**
     * @Description:
     * @Param:
     * @Param:返回类型
     * @Param:入参为键值对map
     * @return:
     */
    <T> T getForEntity(String url, Class<T> responseType, Map uriVariables);

    /**
     * 调用get请求返回entity
     * @param url
     * @param map
     * @return
     * @throws Exception
     */
    public <T> T getForEntity(String url, Map<String, Object> map, Class<T> classz);

    /**
     * 调用post请求，请求参数，对象方式，返回一个JSONObject对象（最常用）
     * @param url 请求地址
     * @param request 请求参数
     * @return
     */
    public JSONObject postForJson(String url, Object request);

    /**
     * 调用post请求，请求参数，map集合，返回一个JSONObject对象
     * @param url
     * @return
     */
    public JSONObject postForJson(String url, Object request, Map<String, Object> params);

    /**
     * 调用get请求返回list
     * @param url
     * @param map
     * @param classes
     * @return
     * @throws Exception
     */
    public <T> List<T> getForList(String url, Map<String, Object> map, Class<T> classes);

    /**
     * 调用POST请求返回entity
     * @param url
     * @param request
     * @param map
     * @param classes
     * @return
     * @throws Exception
     */
    public <T> T postForEntity(String url, Object request, Map<String, Object> map, Class<T> classes);

    /**
     * 调用POST请求返回实体
     * @param url
     * @param request
     * @param classes
     * @return
     */
    public <T> T postForEntity(String url, Object request, Class<T> classes);

    /**
     * 调用POST请求返回list
     * @param <T>
     * @param url
     * @param request
     * @param map
     * @param classes
     * @return
     */
    public <T> List<T> postForList(String url, Object request, Map<String, Object> map, Class<T> classes);

    /* 调用POST请求返回list
     * @param <T>
     * @param url
     * @param request
     * @param classes
     * @return
     */
    public <T> List<T> postForList(String url, Object request, Class<T> classes);

    public <T> T postForEntity(String url, Object request,  Class<T> classes,Class subClass);

    public <T> T postForEntity(String url, Object request,Map<String, Object> map,  Class<T> classes,Class subClass);

    public <T> ResponseEntity<T> postForEntity(String url, Object request, Class<T> responseType , Map<String, ?> uriVariables);

    public <T> ResponseEntity<T> exchange(String url, HttpMethod method, HttpEntity<String> httpEntity, Class<T> responseType);

    public <T> T postForObject(String url, Object request, Class<T> responseType, Map<String, ?> uriVariables) throws RestClientException;
}
