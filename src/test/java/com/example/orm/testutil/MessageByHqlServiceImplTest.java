package com.example.orm.testutil;

import com.example.orm.model.Message;
import com.example.orm.model.ObjectType;
import com.example.orm.model.User;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

public class MessageByHqlServiceImplTest extends AbstractMessageBaseTest{


    @Test
    public void getMessageByHql() throws Exception {
        String body = "{\"id\":0,\"method\":\"getMessageByHql\",\"params\":{\"hql\":\"select m.text, m.date from Message m\"}}";
        performeRequest("/com.example.orm.service.MessageByHqlService",body)
                .andExpect(jsonPath("$.result", hasSize(2)))
                .andReturn();
    }
}