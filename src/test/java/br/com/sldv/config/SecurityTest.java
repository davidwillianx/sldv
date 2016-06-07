package br.com.sldv.config;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.FilterChainProxy;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ContextConfiguration(classes = App.class)
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class SecurityTest {

    @Autowired
    private WebApplicationContext webapp;

    @Autowired
    private FilterChainProxy springSecurityFilter;

    private MockMvc mockMvc;

    @Before
    public void setUp(){
        mockMvc = MockMvcBuilders.webAppContextSetup(webapp)
        .addFilters(springSecurityFilter)
        .apply(springSecurity())
        .alwaysDo(print())
        .build();
    }


    @Test
    public void testShouldReturnToken() throws Exception {
        mockMvc
          .perform(post("/oauth/token"))
          .andExpect(status().isOk());
    }

}
