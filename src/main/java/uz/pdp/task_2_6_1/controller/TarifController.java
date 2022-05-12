package uz.pdp.task_2_6_1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.task_2_6_1.entity.Tarif;
import uz.pdp.task_2_6_1.payload.ApiResponse;
import uz.pdp.task_2_6_1.payload.TarifSotishDto;
import uz.pdp.task_2_6_1.repository.TarifRepository;
import uz.pdp.task_2_6_1.service.TarifService;

import java.util.List;

@RestController
@RequestMapping("/api/tarif")
public class TarifController {
    @Autowired
    TarifService tarifService;

    @Autowired
    TarifRepository tarifRepository;

    @PostMapping
    public HttpEntity<?> addTarif(@RequestBody Tarif tarif){
        ApiResponse apiResponse = tarifService.addTarif(tarif);
        return ResponseEntity.status(apiResponse.isSuccess()?201:409).body(apiResponse);
    }

    @GetMapping
    public HttpEntity<?> getTarif(){
        List<Tarif> all = tarifRepository.findAll();
        return ResponseEntity.ok(all);
    }

    @PostMapping("/sotish")
    public HttpEntity<?> sotish(@RequestBody TarifSotishDto tarifSotishDto){
        ApiResponse apiResponse = tarifService.sotish(tarifSotishDto);
        return ResponseEntity.status(apiResponse.isSuccess()?201:409).body(apiResponse);
    }

}
