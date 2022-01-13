package com.example.orm.testutil;

import com.example.orm.OrmApplication;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Commit;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import java.nio.charset.StandardCharsets;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;


@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@TestPropertySource("classpath:application-test.properties")
@Transactional
@Rollback(value = false)
@Commit
@SpringBootTest
public abstract class AbstractBaseTest {



//    @Autowired
//    protected EntityManagerFactory entityManagerFactory;
    @PersistenceContext
    protected EntityManager em;


    @Autowired
    private MockMvc mockMvc;

//    public EntityManager getEntityManager(){
//        return entityManagerFactory.createEntityManager();
//    }



    protected ResultActions performeRequest(String url,String content) throws Exception {
      return   mockMvc.perform(post(url)
                .contentType(MediaType.APPLICATION_JSON)
                .content(content.getBytes(StandardCharsets.UTF_8)))
                .andDo(print());
    }


}
