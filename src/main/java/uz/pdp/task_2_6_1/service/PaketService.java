package uz.pdp.task_2_6_1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.task_2_6_1.entity.Paketlar;
import uz.pdp.task_2_6_1.payload.ApiResponse;
import uz.pdp.task_2_6_1.repository.PaketRepository;

@Service
public class PaketService {
    @Autowired
    PaketRepository paketRepository;
//    -----just add paket-----
    public ApiResponse addPaket(Paketlar paketlar){
       paketRepository.save(paketlar);
       return new ApiResponse("paket addded",true);
    }
}
