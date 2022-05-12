package uz.pdp.task_2_6_1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.task_2_6_1.payload.ApiResponse;
import uz.pdp.task_2_6_1.payload.FilialDto;
import uz.pdp.task_2_6_1.service.FilialService;

@RestController
@RequestMapping("/api/filial")
public class FilialController {
    @Autowired
    FilialService filialService;

//    -----filiallarni qo'shish uchun--------
    @PostMapping
    public HttpEntity<?> addFilial(@RequestBody FilialDto filialDto){
        ApiResponse apiResponse = filialService.addFilial(filialDto);
        return ResponseEntity.status(apiResponse.isSuccess()?201:409).body(apiResponse);
    }

//    ---------filiallarni tahrirlash uchun, bu yo'lga faqat manager murojat qila oladi-----------
    @PutMapping("/{id}")
    public HttpEntity<?> editFilial(@PathVariable Integer id,@RequestBody FilialDto filialDto){
        ApiResponse apiResponse=filialService.editFilial(id,filialDto);
        return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
    }
}