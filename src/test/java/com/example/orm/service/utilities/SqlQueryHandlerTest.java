package com.example.orm.service.utilities;

import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.*;

class SqlQueryHandlerTest {

    String sql1 = "select u  from User u";
    String sql2 = "select u.name, u.age from User u";

    @Test
    void checkEntity() throws SQLException {
        assertThat(SqlQueryHandler.checkEntity(sql1,"User"),equalTo(true));
        assertThat(SqlQueryHandler.checkEntity(sql2,"User"),equalTo(true));
    }

    @Test
    void getAttrName() throws SQLException {
        List<String> list = SqlQueryHandler.getAttrName(sql2);
        assertThat(list,hasSize(2));
        assertThat(list.get(0),equalTo("name"));
        assertThat(list.get(1),equalTo("age"));
    }
}