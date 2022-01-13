package com.example.orm.service;

import com.googlecode.jsonrpc4j.JsonRpcMethod;
import com.googlecode.jsonrpc4j.JsonRpcParam;

import java.util.List;
import java.util.Set;

/***
 * Получение данных сообщений компании Dul
 */
public interface MessageDulByHqlPrivateService {

    /***
     * Получение данных о сообщении компании Dul и отправителе по hql запросу
     * @param hql запрос на получение данных hql(JPCL)
     * @return список объектов, объект состоит из атрибутов указанных в hql запросе. Порядок следования как и в запросе
     */
    @JsonRpcMethod("getMessageDulByHql")
    List getMessageDulByHql(@JsonRpcParam("hql") String hql);

}
