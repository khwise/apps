package com.clone.apps.business.sample;

import com.clone.apps.persistence.entity.sample.Sample;

import java.util.List;

/**
 * Created by kh.jin on 2019. 6. 24.
 */
public interface SampleService {

    List<Sample> getAll();

    Sample getOne(String id);

    Sample add(Sample param);

    Sample update(String id, Sample param);

    String delete(String id);
}
