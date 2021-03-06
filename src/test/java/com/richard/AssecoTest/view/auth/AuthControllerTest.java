package com.richard.AssecoTest.view.auth;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static com.richard.AssecoTest.common.JsonFileReader.readFileAsString;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest()
@AutoConfigureMockMvc
@ComponentScan({"com.richard.AssecoTest"})
public class AuthControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void authenticateReturnOk() throws Exception {

        mockMvc.perform(
                MockMvcRequestBuilders.post("/authenticate")
                        .content(readFileAsString("authenticate/loginOk"))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andReturn();
    }

    @Test
    public void authenticateReturnUnauthorized() throws Exception {

        final MvcResult result = mockMvc.perform(
                MockMvcRequestBuilders.post("/authenticate")
                        .content(readFileAsString("authenticate/loginUnauthorized"))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isUnauthorized()).andReturn();
        JSONAssert.assertEquals(readFileAsString("authenticate/responseUnauthorized"), result.getResponse().getContentAsString(), JSONCompareMode.NON_EXTENSIBLE);
    }
}
