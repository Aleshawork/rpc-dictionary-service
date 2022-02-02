package com.example.orm.service.utilities;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SqlQueryHandler {

    /**
     * Метод для проверки соответствия указанной в запросе сущности
     * @param sql запрос
     * @param entity имя сущности
     * @return true/false
     * @throws SQLException
     */
    public static boolean checkEntity(String sql,String entity) throws SQLException {
        Pattern pattern = Pattern.compile("\\s[A-Z]{1}[a-z]*\\s");
        Matcher matcher = pattern.matcher(sql);
        if(!matcher.find()) throw new SQLException("Name of entity is not exist!");
        if(sql.substring(matcher.start()+1, matcher.end()-1).equals(entity))
            return true;
        else throw new SQLException("The entity name is selected incorrectly!");

    }


    /**
     * Метод для парсинга имен атрибутов
     * @param sql запрос
     * @return список имен атрибутов, присутствующих в запросе
     * @throws SQLException
     */
    public static List<String>  getAttrName(String sql) throws SQLException {
        List<String> listAttr = new ArrayList<>();
        if(!sql.contains("select")) throw new SQLException("The request is not correctly!");
        String atributes = sql.substring(sql.indexOf("select")+6,sql.indexOf("from")).trim();
        Pattern pattern = Pattern.compile("\\.[a-z]+(\\s|\\,)");
        Matcher matcher = pattern.matcher(sql);
        while (matcher.find()){
            listAttr.add(sql.substring(matcher.start()+1, matcher.end()-1));
        }

        return listAttr;
    }
}
