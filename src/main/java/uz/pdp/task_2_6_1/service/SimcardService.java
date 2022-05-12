package uz.pdp.task_2_6_1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.task_2_6_1.entity.Simkarta;
import uz.pdp.task_2_6_1.entity.SoldSimkarta;
import uz.pdp.task_2_6_1.payload.ApiResponse;
import uz.pdp.task_2_6_1.payload.SotishDto;
import uz.pdp.task_2_6_1.repository.SimcardRepository;
import uz.pdp.task_2_6_1.repository.SoldSimkartaRepository;

import java.util.Optional;

@Service
public class SimcardService {
    @Autowired
    SimcardRepository simcardRepository;
    @Autowired
    SoldSimkartaRepository soldSimkartaRepository;
    //    ------simcard adding
    public ApiResponse addSim(Simkarta simcard){
        simcardRepository.save(simcard);
        return new ApiResponse("simcard added",true);
    }



    public ApiResponse sotish(SotishDto sotishDto) {
        Optional<Simkarta> optionalSimkarta = simcardRepository.findById(sotishDto.getSimkartaId());
        if (!optionalSimkarta.isPresent()){
            return new ApiResponse("simkarta band qilingan yoki topilmadi",false);
        }
        boolean exists = soldSimkartaRepository.existsByPassportNumber(sotishDto.getPassportNumber());
        if (exists){
            return new ApiResponse("passport band qilingan",false);
        }

        SoldSimkarta soldSimkarta = new SoldSimkarta();
        soldSimkarta.setFirstName(sotishDto.getFirstName());
        soldSimkarta.setLastName(sotishDto.getLastName());
        soldSimkarta.setPassportNumber(sotishDto.getPassportNumber());
        Simkarta simkarta = optionalSimkarta.get();
        simkarta.setActive(true);
        simkarta.setSotildi(true);
        Simkarta simkarta1 = simcardRepository.save(simkarta);
        soldSimkarta.setSimkarta(simkarta1);
        soldSimkartaRepository.save(soldSimkarta);
        return new ApiResponse("simkarta sotildi",true);
    }
}
