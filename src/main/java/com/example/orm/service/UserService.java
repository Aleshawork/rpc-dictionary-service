package com.example.orm.service;



import com.example.orm.dto.DtoFields;
import com.example.orm.model.User;
import com.googlecode.jsonrpc4j.JsonRpcMethod;
import com.googlecode.jsonrpc4j.JsonRpcParam;
import java.util.List;

public interface UserService {

    /***
     * Получение информации о User по hql (JPCL) запросу
     * @param hql запрос на получение данных hql(JPCL)
     * @return список объектов, объект состоит из атрибутов указанных в hql запросе. Порядок следования как и в запросе
     */
    @JsonRpcMethod("getUserByHql")
    public List<DtoFields> getUserByHql(@JsonRpcParam(value = "hql") String hql );

    /***
     * Получение информации о User по имени
     * @param name имя пользователя
     * @return информацию о пользователе
     */
    @JsonRpcMethod("getUserByName")
    public User getUserByName(@JsonRpcParam(value = "name")String name);

    @JsonRpcMethod("getUserById")
    public User getUserById(@JsonRpcParam(value = "id")Long id);
}
