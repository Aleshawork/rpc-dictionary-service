package com.example.orm.testutil;



import org.junit.Test;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

public class MessageDulByHqlServiceTest extends AbstractMessageBaseTest{

    @Test
    public void shouldGetMessageByHql() throws Exception {
        String body = "{\"id\":0,\"method\":\"getMessageDulByHql\",\"params\":{\"hql\":\"select u.name from User u\"}}";
        performeRequest("/com.example.orm.service.MessageDulByHqlPrivateService",body)
                .andExpect(jsonPath("$.result",hasSize(2)))
                .andExpect(jsonPath("$.result[0]",is("Alexey")))
                .andReturn();
    }


}
