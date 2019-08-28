package com.clone.apps.domain.sample.service;

import com.clone.apps.entity.sample.Sample;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by kh.jin on 2019. 6. 24.
 */

@Service
public class SampleServiceImpl implements SampleService {

    private Map<String, Sample> map = new HashMap<>();

    @Override
    public List<Sample> getAll() {
        return new ArrayList(map.values());
    }

    @Override
    public Sample getOne(String id) {
        return map.get(id);
    }

    @Override
    public Sample add(Sample param) {
        map.put(param.getId(), param);
        return param;
    }

    @Override
    public Sample update(String id, Sample param) {
        map.put(id, param);
        return param;
    }

    @Override
    public String delete(String id) {
        map.remove(id);
        return id;
    }
}
