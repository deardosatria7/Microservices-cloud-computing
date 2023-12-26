package com.example.layanglayangserver.services;
import org.springframework.stereotype.Service;

@Service
public class luasLayangService {
    public Integer hitungLuas (Integer a, Integer b){
        return a*b/2;
    }
}
