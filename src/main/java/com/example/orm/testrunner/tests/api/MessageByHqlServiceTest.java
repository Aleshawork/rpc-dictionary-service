package com.example.orm.testrunner.tests.api;

import com.example.orm.service.MessageByHqlService;
import com.example.orm.testrunner.config.TestMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.hamcrest.Matchers.*;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@Service
public class MessageByHqlServiceTest {
    @Autowired
    private MessageByHqlService messageByHqlService;

    @TestMethod
    public void shouldGetMessageByHql(){
        List messageByHql = messageByHqlService.getMessageByHql("select m.text, m.date from Message m");
        assertThat(messageByHql.size(),is(not(nullValue())));

    }
}
