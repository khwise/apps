package com.clone.apps.web.sample;

import com.clone.apps.business.sample.SampleService;
import com.clone.apps.global.models.response.DefaultResponse;
import com.clone.apps.global.models.response.SuccessCode;
import com.clone.apps.persistence.entity.sample.Sample;
import com.clone.apps.web.BaseWebController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SampleMvcController implements BaseWebController {
    private final Logger log = LoggerFactory.getLogger(SampleMvcController.class);

    private final SampleService sampleService;

    @Autowired
    public SampleMvcController(@Qualifier("sampleServiceImpl") final SampleService sampleService) {
        this.sampleService = sampleService;
    }

    @GetMapping("/sample")
    public DefaultResponse<List<Sample>> sampleGetList() {
        // todo : log format 정의
        log.debug("sample list.");
        // todo : Response 를 Abstract 또는 상속으로 구조화
        return DefaultResponse.success(SuccessCode.FIND_LIST, sampleService.getAll());
    }

    @GetMapping("/sample/{id}")
    public DefaultResponse<Sample> sampleGet(@PathVariable final String id) {
        return DefaultResponse.success(SuccessCode.FIND, sampleService.getOne(id));
    }

    @PostMapping("/sample")
    public DefaultResponse<Sample> samplePost(final SampleRequest request) {
        return DefaultResponse.success(SuccessCode.CREATED, sampleService.add(request));
    }

    @PutMapping("/sample/{id}")
    public DefaultResponse<Sample> sampleUpdate(@PathVariable final String id, final SampleRequest request) {
        return DefaultResponse.success(SuccessCode.UPDATED, sampleService.update(id, request));
    }

    @DeleteMapping("/sample/{id}")
    public DefaultResponse<String> sampleDelete(@PathVariable String id) {
        return DefaultResponse.success(SuccessCode.DELETED, sampleService.delete(id));
    }
}
