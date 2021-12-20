package com.example.orm.service;

import com.example.orm.model.Message;
import com.googlecode.jsonrpc4j.JsonRpcMethod;
import com.googlecode.jsonrpc4j.JsonRpcParam;

import java.util.List;

/***
 *
 * Сервис для получения и сохранения информации о сообщениях
 */

public interface MessageService {


    /***
     * Сохранения нового сообщения с текущей датой (дата отправки)
     * @param text текст сообщения
     */
    @JsonRpcMethod("saveMassage")
    void saveMassage(@JsonRpcParam(value = "text") String text);

    /***
     * Поиск всех сообщений
     * @return Список объектов
     */
    @JsonRpcMethod("findAll")
    List<Message> findAll();

    /***
     * Поиск сообщений по дате
     * @param date дата отправки сообщения
     * @return Список сообщений, отправленных в date
     */
    @JsonRpcMethod("findAllByDate")
    List<Message> findAllByDate(@JsonRpcParam(value = "date") String date);


    /***
     * Поиск сообщений содержащих указанный текст
     * @param text текст сообщения
     * @return Список сообщений содержащих указанный текст
     */
    @JsonRpcMethod("findByText")
    List<Message> findByText(@JsonRpcParam(value = "text") String text);


    @JsonRpcMethod("findAllByUserName")
    List<Message> findAllByUserName(@JsonRpcParam(value = "name") String name);




}
