package uz.pdp.task_2_6_1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.task_2_6_1.entity.Simkarta;
import uz.pdp.task_2_6_1.payload.ApiResponse;
import uz.pdp.task_2_6_1.payload.SotishDto;
import uz.pdp.task_2_6_1.repository.SoldSimkartaRepository;
import uz.pdp.task_2_6_1.service.SimcardService;

@RestController
@RequestMapping("/api/simcard")
public class SimcardController {

    @Autowired
    SimcardService simcardService;
    @Autowired
    SoldSimkartaRepository soldSimkartaRepository;

    //    ------simcardlarni qo'shish--------
    @PostMapping
    public HttpEntity<?> addSim(@RequestBody Simkarta simkarta){
        ApiResponse apiResponse = simcardService.addSim(simkarta);
        return ResponseEntity.status(apiResponse.isSuccess()?201:409).body(apiResponse);
    }


// --------simkarta sotish------
    @PostMapping("/sotish")
    public HttpEntity<?> sotish(@RequestBody SotishDto sotishDto){
        ApiResponse apiResponse = simcardService.sotish(sotishDto);
        return ResponseEntity.status(apiResponse.isSuccess()?201:409).body(apiResponse);
    }

//    -------sotilgan nomerlar ruyhati---------bu yulga faqat manager va director kira oladi-------
    @GetMapping
    public HttpEntity<?> getSotilgan(){
        return ResponseEntity.ok(soldSimkartaRepository.findAll());
    }
}
