package com.example.layanglayangserver.controller;

import com.example.layanglayangserver.dto.inputDto;
import com.example.layanglayangserver.dto.outputDto;
import com.example.layanglayangserver.services.luasLayangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class appController {
    @Autowired
    private luasLayangService LuasLayangService;

    @PostMapping("/hitung")
    public ResponseEntity<outputDto> luasLayangCalculator(@RequestBody inputDto InputDto){
        Integer result = LuasLayangService.hitungLuas(InputDto.getA(), InputDto.getB());
        outputDto OutputDto = new outputDto();
        OutputDto.setA(InputDto.getA());
        OutputDto.setB(InputDto.getB());
        OutputDto.setResult(result);
        return ResponseEntity.ok(OutputDto);
    }
}
