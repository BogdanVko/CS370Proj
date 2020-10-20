package com.example.demo.service;


import com.example.demo.entity.Tutor;
import com.example.demo.repository.TutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TutorService {


    @Autowired
    private TutorRepository list;
    public List<Tutor> findAll(){

        return list.findAll();
    }
    public < S extends Tutor> S save(S s){
        return list.save(s);
    }
}
