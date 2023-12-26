package com.example.serversegitiga.services;
import org.springframework.stereotype.Service;

@Service
public class luasService {
    public Integer hitungLuas (Integer a, Integer b){
        return a * b / 2;
    }
}
