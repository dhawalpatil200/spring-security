package com.dhawal.security.service;

import com.dhawal.security.models.DemoEntity;
import com.dhawal.security.repository.DemoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class DemoService {
    @Autowired
    DemoRepository demoRepository;

    public List<DemoEntity> getAllDemos() {
        return demoRepository.findAll();
    }

    public DemoEntity getDemoById(Long id) {
        Optional<DemoEntity> d = demoRepository.findById(id);
        return d.orElse(null);
    }

    public DemoEntity createDemo(DemoEntity d) {
        return demoRepository.save(d);
    }

    public void deleteDemo(Long id) {
        DemoEntity d = getDemoById(id);
        if(d != null)
            demoRepository.delete(d);
    }
}
