package com.example.serversegitiga.controller;
import com.example.serversegitiga.dto.inputDto;
import com.example.serversegitiga.dto.outputDto;
import com.example.serversegitiga.services.luasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class appController {
    @Autowired
    private luasService LuasService;

    @PostMapping ("/hitung")
    public ResponseEntity<outputDto> luasSegitigaCalculator(@RequestBody inputDto InputDto){
        Integer result = LuasService.hitungLuas(InputDto.getA(), InputDto.getB());
        outputDto OutputDto = new outputDto();
        OutputDto.setA(InputDto.getA());
        OutputDto.setB(InputDto.getB());
        OutputDto.setResult(result);
        return ResponseEntity.ok(OutputDto);
    }
}
