package com.example.gateserver.controller;
import com.example.gateserver.dto.ResultDto;
import com.example.gateserver.dto.TransferDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class GateController {
    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @GetMapping("/{a}/{b}/{operator}")
    public ResponseEntity<ResultDto> calculatorEndPoint
            (@PathVariable("a") Integer a,
             @PathVariable("b") Integer b,
             @PathVariable("operator") String operation){
        ServiceInstance serviceInstance;
        TransferDto transferDto = new TransferDto();
        transferDto.setA(a);
        transferDto.setB(b);
        switch (operation){
            case "segitiga": serviceInstance = loadBalancerClient.choose("server-segitiga"); break;
            case "persegi-panjang": serviceInstance = loadBalancerClient.choose("persegi-panjang-server"); break;
            case "layang-layang": serviceInstance = loadBalancerClient.choose("layang-layang-server"); break;
            default:  serviceInstance = loadBalancerClient.choose("segitiga-server"); break;
        }
        String selectedUrl = serviceInstance.getUri().toString();

        String baseUrl = selectedUrl+"/hitung";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<ResultDto> response = restTemplate.postForEntity(baseUrl, transferDto, ResultDto.class);
        ResultDto resultDto = response.getBody();
        return ResponseEntity.ok(resultDto);
    }

}
