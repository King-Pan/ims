package club.javalearn.ims.web;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runner.Runner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
/**
 * @author king-pan
 * @date 2018/11/17
 * @Description ${DESCRIPTION}
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserControllerTest {


    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webContext;   //注入WebApplicationContext

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders
                .webAppContextSetup(webContext)        //设置MockMvc
                .build();
    }

    @Test
    public void page() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/user/")
                .accept(MediaType.TEXT_HTML_VALUE)).andExpect(status().isOk());
    }
}