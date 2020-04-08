package com.keepstudy.util.rest.support;

import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: 莫升康
 * @e-mail: 1634414600@qq.com
 * @Date: 2020/4/1 11:18
 * @Description: restful接口实现类
 */
@Component
public class RestTemplateServiceImpl implements RestTemplateService {
    @Autowired
    private RestTemplate restTemplate;

    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public <T> T getForEntity(String url, Class<T> responseType, Map uriVariables) {
        String tempStr = JSONUtil.toJsonStr(uriVariables);
        //log.info(">>>invokeUrl={},params={}", url, tempStr);
        tempStr = tempStr.replaceAll(",", "&").replaceAll("\"", "").replaceAll(":", "=");
        tempStr = tempStr.substring(1, tempStr.length() - 1);
        T resp = restTemplate.getForObject(url + "?" + tempStr, responseType);
        //log.info("<<<invokeUrl={},result={}", url, resp);
        return resp;
    }

    @Override
    public <T> T getForEntity(String url, Map<String, Object> map, Class<T> classz) {
        //log.info(">>>invokeUrl={},params={}", url, objectToString(map));
        String result = restTemplate.getForObject(url, String.class, map);
        //log.info("<<<invokeUrl={},result={}", url, result);
        return this.resultForEntity(classz, result).getResult();
    }

    @Override
    public <T> List<T> getForList(String url, Map<String, Object> map, Class<T> classes) {
        //log.info(">>>invokeUrl={},params={}", url, objectToString(map));
        String result = restTemplate.getForObject(url, String.class, map);
        //log.info("<<<invokeUrl={},result={}", url, result);
        return this.resultForList(classes, result).getResult();

    }

    @Override
    public <T> T postForEntity(String url, Object request, Map<String, Object> map, Class<T> classes) {
        //log.info(">>>invokeUrl={},params={}", url, objectToString(map));
        String result = restTemplate.postForObject(url, request, String.class, map);
        //log.info("<<<invokeUrl={},result={}", url, result);
        return this.resultForEntity(classes, result).getResult();
    }

    @Override
    public <T> T postForEntity(String url, Object request, Map<String, Object> map, Class<T> classes,Class subClass) {
        //log.info(">>>invokeUrl={},params={}", url, objectToString(map));
        String result = restTemplate.postForObject(url, request, String.class, map);
        //log.info("<<<invokeUrl={},result={}", url, result);
        return this.resultForEntity(classes,subClass, result).getResult();
    }

    @Override
    public <T> List<T> postForList(String url, Object request, Map<String, Object> map, Class<T> classes) {
        //log.info(">>>invokeUrl={},params={}", url, objectToString(map));
        String result = restTemplate.postForObject(url, request, String.class, map);
        //log.info("<<<invokeUrl={},result={}", url, result);
        return this.resultForList(classes, result).getResult();
    }

    @Override
    public <T> ResponseEntity<T> postForEntity(String url, Object request, Class<T> responseType,Map<String, ?> uriVariables) {
        //log.info(">>>invokeUrl={},params={}", url, objectToString(uriVariables));
        ResponseEntity<T> resp = restTemplate.postForEntity(url, request, responseType, uriVariables);
        //log.info("<<<invokeUrl={},result={}", url, resp);
        return resp;
    }

    @Override
    public <T> ResponseEntity<T> exchange(String url, HttpMethod method, HttpEntity<String> httpEntity,Class<T> responseType) {
        //log.info(">>>invokeUrl={},params={}", url, objectToString(httpEntity));
        ResponseEntity<T> resp = restTemplate.exchange(url, method,httpEntity, responseType);
        //log.info("<<<invokeUrl={},result={}", url, resp);
        return resp;
    }

    @Override
    public <T> T postForObject(String url, Object request, Class<T> responseType, Map<String, ?> uriVariables) throws RestClientException {
        //log.info(">>>invokeUrl={},params={}", url, objectToString(uriVariables));
        T result = restTemplate.postForObject(url, request, responseType, uriVariables);
        //log.info("<<<invokeUrl={},result={}", url, result);
        return result;
    }

    /**
     * 将结果集JSON转化为实体
     * @param <T>
     * @param classes
     * @param result
     * @return
     * @throws Exception
     */
    private <T> RestServiceResult<T> resultForEntity(Class<T> classes,Class subClass, String result) {
        JavaType superType = objectMapper.getTypeFactory().constructParametrizedType(classes, classes,subClass);
        JavaType type = objectMapper.getTypeFactory().constructParametrizedType(RestServiceResult.class,RestServiceResult.class, superType);
        RestServiceResult<T> restServiceResult = new RestServiceResult<>();
        try {
            if (result != null && !"".equals(result)  ) {
                objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
                restServiceResult = objectMapper.readValue(result, type);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RemoteInvokeException(RestServiceResult.CODE_UNKNOW, "结果集转换出错");
        }
        if (restServiceResult != null && restServiceResult.getStatus() != RestServiceResult.CODE_SUCCSUCCESS) {
            throw new RemoteInvokeException(restServiceResult.getStatus(), restServiceResult.getErrorInfo());
        }
        return restServiceResult;
    }

    /**
     * 将结果集JSON转化为实体
     * @param <T>
     * @param classes
     * @param result
     * @return
     * @throws Exception
     */
    private <T> RestServiceResult<T> resultForEntity(Class<T> classes, String result) {
        JavaType type = objectMapper.getTypeFactory().constructParametrizedType(RestServiceResult.class,RestServiceResult.class, classes);
        RestServiceResult<T> restServiceResult = new RestServiceResult<>();
        try {
            if (result != null && !"".equals(result)  ) {
                objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
                restServiceResult = objectMapper.readValue(result, type);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RemoteInvokeException(RestServiceResult.CODE_UNKNOW, "结果集转换出错");
        }
        if (restServiceResult != null && restServiceResult.getStatus() != RestServiceResult.CODE_SUCCSUCCESS) {
            throw new RemoteInvokeException(restServiceResult.getStatus(), restServiceResult.getErrorInfo());
        }
        return restServiceResult;
    }

    /**
     * 将结果集JSON转化为LIST
     * @param classes
     * @param result
     * @return
     * @throws Exception
     */
    private <T> RestServiceResult<List<T>> resultForList(Class<T> classes, String result) {
        JavaType listType = objectMapper.getTypeFactory().constructParametrizedType(List.class, List.class,classes);
        JavaType type = objectMapper.getTypeFactory().constructParametrizedType(RestServiceResult.class,RestServiceResult.class, listType);
        RestServiceResult<List<T>> restServiceResult = new RestServiceResult<>();
        try {
            if (result != null && !"".equals(result)) {
                restServiceResult = objectMapper.readValue(result, type);
            }
        } catch (Exception e) {
            throw new RemoteInvokeException(RestServiceResult.CODE_UNKNOW, "结果集转换出错");
        }
        if (restServiceResult != null && restServiceResult.getStatus() != RestServiceResult.CODE_SUCCSUCCESS) {
            throw new RemoteInvokeException(restServiceResult.getStatus(), restServiceResult.getErrorInfo());
        }
        return restServiceResult;
    }

    @Override
    public <T> T postForEntity(String url, Object request, Class<T> classes) {
        Map<String, Object> map = new HashMap<>();
        return this.postForEntity(url, request, map, classes);
    }

    @Override
    public <T> T postForEntity(String url, Object request, Class<T> classes,Class subClass) {
        Map<String, Object> map = new HashMap<>();
        return this.postForEntity(url, request, map, classes,subClass);
    }

    @Override
    public <T> List<T> postForList(String url, Object request, Class<T> classes) {
        Map<String, Object> map = new HashMap<>();
        return this.postForList(url, request, map, classes);
    }

    /**
     * 对象转字符串
     *
     * @param obj
     * @return
     */
    private String objectToString(Object obj){
        try {
            if(obj != null) {
                return objectMapper.writeValueAsString(obj);
            }
        } catch (JsonProcessingException e) {
        }
        return null;
    }

    @Override
    public JSONObject postForJson(String url, Object request) {
        JSONObject jsonObject;
        Map<String, Object> map = new HashMap<>();
        //log.info(">>>invokeUrl={},params={}", url, objectToString(map));
        try {
            String result = restTemplate.postForObject(url, request, String.class, map);
            //log.info("<<<invokeUrl={},result={}", url, result);
            jsonObject= JSON.parseObject(result);
            return jsonObject;
        }catch(Exception e) {
            //log.error("调用服务失败，invokeUrl={},params={}，原因={}",url, objectToString(map),e);
            throw e;
        }
    }

    @Override
    public JSONObject postForJson(String url, Object request, Map<String, Object> params) {
        //log.info(">>>invokeUrl={},params={}", url, objectToString(params));
        try {
            String result = restTemplate.postForObject(url, params, String.class);
            //log.info("<<<invokeUrl={},result={}", url, result);
            JSONObject jsonObject=JSON.parseObject(result);
            return jsonObject;
        }catch(Exception e) {
            //log.error("调用服务失败，invokeUrl={},params={}，原因={}",url, params,e);
            throw e;
        }
    }
}
