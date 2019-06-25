package com.clone.apps.web.sample;

import com.clone.apps.business.sample.SampleService;
import com.clone.apps.persistence.entity.Sample;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by kh.jin on 2019. 6. 25.
 *
 * WebMVC 단위 테스트 샘플코드
 */
@RunWith(SpringRunner.class)
@WebMvcTest(SampleMvcController.class)
public class SampleMvcControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    @Qualifier("sampleServiceImpl")
    private SampleService sampleService;

    private final Map<String, Sample> map = new HashMap<>();

    private SampleRequest request;

    @Before
    public void setup() {
        Sample sample = new Sample();
        sample.setId("A");
        sample.setName("AAA");
        map.put(sample.getId(), sample);

        request = new SampleRequest();

        request.setId("b");
        request.setName("bbb");
    }

    @Test
    public void sampleGetList() throws Exception{
        // given
        given(sampleService.getAll()).willReturn(new ArrayList<>(map.values()));

        // when
        ResultActions resultActions = mvc.perform(get("/sample")).andDo(print());

        // then
        resultActions
                .andExpect(status().isOk())
                .andExpect(jsonPath("result").isArray())
                .andExpect(jsonPath("code").value("SF02"))
        ;
    }

    @Test
    public void sampleGet() throws Exception{
        // given
        given(sampleService.getOne("A")).willReturn(map.get("A"));

        // when
        ResultActions resultActions = mvc.perform(get("/sample/A")).andDo(print());

        // then
        resultActions
                .andExpect(status().isOk())
                .andExpect(jsonPath("code").value("SF01"))
                .andExpect(jsonPath("result.id").value("A"))
                .andExpect(jsonPath("result.name").value("AAA"))
        ;
    }

    @Test
    public void samplePost() throws Exception {
        mvc.perform(post("/sample")
                .content(asJsonString(request))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk());
    }

    @Test
    public void sampleUpdate() throws Exception{
        mvc.perform(put("/sample/{id}", "A")
                .content(asJsonString(request))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk());
    }

    @Test
    public void sampleDelete() throws Exception {
        mvc.perform(delete("/sample/{id}", "A")
                .content(asJsonString(request))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk());
    }

    // todo : 공통으로 처리해야 하나?
    public static String asJsonString(final Object o) {
        try {
            return new ObjectMapper().writeValueAsString(o);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}