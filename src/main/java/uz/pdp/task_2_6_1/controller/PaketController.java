package uz.pdp.task_2_6_1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.pdp.task_2_6_1.entity.Paketlar;
import uz.pdp.task_2_6_1.payload.ApiResponse;
import uz.pdp.task_2_6_1.service.PaketService;

@RestController
@RequestMapping("/api/paket")
public class PaketController {
    @Autowired
    PaketService paketService;
    @PostMapping
    public HttpEntity<?> addPaket(@RequestBody Paketlar paketlar){
        ApiResponse apiResponse = paketService.addPaket(paketlar);
        return ResponseEntity.ok(apiResponse);
    }
}
