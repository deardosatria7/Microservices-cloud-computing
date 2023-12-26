package com.example.persegipanjangserver.controller;
import com.example.persegipanjangserver.dto.inputDto;
import com.example.persegipanjangserver.dto.outputDto;
import com.example.persegipanjangserver.services.luasPersegiPanjangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class appController {
    @Autowired
    private luasPersegiPanjangService LuasPersegiPanjangService;

    @PostMapping("/hitung")
    public ResponseEntity<outputDto> luasPersegiPanjangCalculator(@RequestBody inputDto InputDto){
        Integer result = LuasPersegiPanjangService.hitungLuas(InputDto.getA(), InputDto.getB());
        outputDto OutputDto = new outputDto();
        OutputDto.setA(InputDto.getA());
        OutputDto.setB(InputDto.getB());
        OutputDto.setResult(result);
        return ResponseEntity.ok(OutputDto);
    }
}
