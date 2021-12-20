package com.example.orm.service;

import com.googlecode.jsonrpc4j.JsonRpcMethod;
import com.googlecode.jsonrpc4j.JsonRpcParam;

import java.util.List;

/***
 * Получение данных сообщений по hql (JPCL) запросу
 */
public interface MessageByHqlService {

    /***
     * Получение данных о сообщении и отправителе по hql запросу
     * @param hql запрос на получение данных hql(JPCL)
     * @return список объектов, объект состоит из атрибутов указанных в hql запросе. Порядок следования как и в запросе
     */
    @JsonRpcMethod("getMessageByHql")
     List getMessageByHql(@JsonRpcParam("hql") String hql);
}
