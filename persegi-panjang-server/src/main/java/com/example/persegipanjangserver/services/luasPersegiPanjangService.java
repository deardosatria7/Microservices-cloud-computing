package com.example.persegipanjangserver.services;
import org.springframework.stereotype.Service;

@Service
public class luasPersegiPanjangService {
    public Integer hitungLuas (Integer a, Integer b){
        return a*b;
    }
}
