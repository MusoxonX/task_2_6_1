package uz.pdp.task_2_6_1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.task_2_6_1.entity.User;
import uz.pdp.task_2_6_1.payload.ApiResponse;
import uz.pdp.task_2_6_1.payload.RegisterDto;
import uz.pdp.task_2_6_1.service.AuthService;

import java.nio.file.attribute.UserPrincipalNotFoundException;

@RestController
@RequestMapping("/auth")
public class  AuthController {

    @Autowired
    AuthService authService;

//    -------- xodimlarni qo'shish uchun------------------
    @PostMapping
    public HttpEntity<?> addUser(@RequestBody RegisterDto registerDtoo){
        ApiResponse apiService = authService.addUser(registerDtoo);
        return ResponseEntity.status(apiService.isSuccess()?201:409).body(apiService);
    }

//    ----------xodimlar ma'lumotlarini ko'rishlari uchun---------
    @GetMapping("/xodim/{id}")
    public HttpEntity<?> getUser(@PathVariable Integer id){
        ApiResponse apiResponse = authService.getUser(id);
        return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
    }

//    --------- xodimlar ma'lumotlarini o'zgartirishlari uchun-----------
    @PutMapping("/xodim/{id}")
    public HttpEntity<?> editUser(@PathVariable Integer id,@RequestBody RegisterDto registerDto){
        ApiResponse apiResponse=authService.editUser(id,registerDto);
        return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
    }
}