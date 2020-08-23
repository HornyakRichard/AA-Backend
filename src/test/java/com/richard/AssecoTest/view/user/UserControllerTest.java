package com.richard.AssecoTest.view.user;

import com.jayway.jsonpath.JsonPath;
import com.richard.AssecoTest.common.JsonFileReader;
import org.junit.Before;
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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest()
@AutoConfigureMockMvc
@ComponentScan({"com.richard.AssecoTest"})
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private String token;

    @Before
    public void setUp() throws Exception {

        final MvcResult result = mockMvc.perform(
                MockMvcRequestBuilders.post("/authenticate")
                        .content(readFileAsString("authenticate/login"))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andReturn();

        token = "Bearer " + JsonPath.parse(result.getResponse().getContentAsString()).read("token");
    }

    @Test
    public void getUserByIdReturnOk() throws Exception {
        final MvcResult result = mockMvc.perform(get("/user/10")
                .header("Authorization", token))
                .andExpect(status().isOk()).andReturn();
        JSONAssert.assertEquals(readFileAsString("getUserById/responseOk"), result.getResponse().getContentAsString(), JSONCompareMode.NON_EXTENSIBLE);
    }

    @Test
    public void getUserByIdReturnNotFound() throws Exception {
        final MvcResult result = mockMvc.perform(get("/user/19")
                .header("Authorization", token))
                .andExpect(status().isNotFound()).andReturn();
        JSONAssert.assertEquals(readFileAsString("getUserById/responseNotFound"), result.getResponse().getContentAsString(), JSONCompareMode.NON_EXTENSIBLE);
    }

    @Test
    public void getUsersReturnOk() throws Exception {
        final MvcResult result = mockMvc.perform(get("/user")
                .header("Authorization", token))
                .andExpect(status().isOk()).andReturn();
        JSONAssert.assertEquals(readFileAsString("getUsers/responseOk"), result.getResponse().getContentAsString(), JSONCompareMode.NON_EXTENSIBLE);
    }

    @Test
    public void addUserReturnOk() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders.post("/user")
                        .content(readFileAsString("addUser/requestBodyOk"))
                        .header("Authorization", token)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andReturn();
    }

    @Test
    public void deleteUserByIdReturnOk() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders.delete("/user/23")
                        .header("Authorization", token))
                .andExpect(status().isOk()).andReturn();
    }

    @Test
    public void deleteUserByIdReturnNotFound() throws Exception {
        final MvcResult result = mockMvc.perform(
                MockMvcRequestBuilders.delete("/user/33")
                        .header("Authorization", token))
                .andExpect(status().isNotFound()).andReturn();
        JSONAssert.assertEquals(readFileAsString("deleteUserById/responseNotFound"), result.getResponse().getContentAsString(), JSONCompareMode.NON_EXTENSIBLE);
    }
}
