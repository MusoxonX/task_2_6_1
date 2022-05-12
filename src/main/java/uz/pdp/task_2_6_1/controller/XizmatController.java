package uz.pdp.task_2_6_1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.task_2_6_1.payload.ApiResponse;
import uz.pdp.task_2_6_1.payload.XizmatDto;
import uz.pdp.task_2_6_1.payload.XizmatSotishDto;
import uz.pdp.task_2_6_1.repository.XizmatRepository;
import uz.pdp.task_2_6_1.service.XizmatService;

@RestController
@RequestMapping("/api/xizmat")
public class XizmatController {
    @Autowired
    XizmatService xizmatService;
    @Autowired
    XizmatRepository xizmatRepository;
//    -----bu xizmat qushish uchun ------
    @PostMapping
    public HttpEntity<?> addXizmat(@RequestBody XizmatDto xizmatDto){
        ApiResponse apiResponse = xizmatService.addXizmat(xizmatDto);
        return ResponseEntity.status(apiResponse.isSuccess()?201:409).body(apiResponse);
    }

    @GetMapping
    public HttpEntity<?> getXizmat(){
        return ResponseEntity.ok(xizmatRepository.findAll());
    }

//    -----xizmat sotish uchun------
    @PostMapping("/sotish")
    public HttpEntity<?> sotish(@RequestBody XizmatSotishDto xizmatSotishDto){
        ApiResponse apiResponse = xizmatService.sotish(xizmatSotishDto);
        return ResponseEntity.status(apiResponse.isSuccess()?201:409).body(apiResponse);
    }

}
