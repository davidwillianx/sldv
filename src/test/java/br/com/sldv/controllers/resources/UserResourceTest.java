package br.com.sldv.controllers.resources;


import com.google.gson.Gson;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.HashMap;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class UserResourceTest {

//    @InjectMocks
//    private UserResource userResource;
//
//    private MockMvc mockMvc;
//
//   @Before
//    public void setUp(){
//       MockitoAnnotations.initMocks(this);
//
//       mockMvc = MockMvcBuilders.standaloneSetup(userResource).build();
//    }
//
//    @Test
//    public void testAccess() throws Exception {
//        HashMap accessData = new HashMap();
//        accessData.put("username", "david");
//        accessData.put("password", "testx");
//
//        String user = new Gson().toJson(accessData);
//
//        mockMvc.perform(
//                post("/api/user")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(user)
//        )
//        .andExpect(status().isOk())
//        .andExpect(jsonPath("$.message", containsString("Bem vindo ao sistema")))
//        .andExpect(jsonPath("$.token", notNullValue()));
//
//    }


}
