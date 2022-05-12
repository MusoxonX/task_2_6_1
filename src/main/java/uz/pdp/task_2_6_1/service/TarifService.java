package uz.pdp.task_2_6_1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.task_2_6_1.entity.SoldSimkarta;
import uz.pdp.task_2_6_1.entity.SoldTarif;
import uz.pdp.task_2_6_1.entity.Tarif;
import uz.pdp.task_2_6_1.payload.ApiResponse;
import uz.pdp.task_2_6_1.payload.TarifSotishDto;
import uz.pdp.task_2_6_1.repository.SoldSimkartaRepository;
import uz.pdp.task_2_6_1.repository.SoldTarifRepository;
import uz.pdp.task_2_6_1.repository.TarifRepository;

import java.util.Optional;

@Service
public class TarifService {
    @Autowired
    TarifRepository tarifRepository;

    @Autowired
    SoldTarifRepository soldTarifRepository;

    @Autowired
    SoldSimkartaRepository soldSimkartaRepository;

    public ApiResponse addTarif(Tarif tarif){
        tarifRepository.save(tarif);
        return new ApiResponse("tarfi qo'shildi",true);
    }

    public ApiResponse sotish(TarifSotishDto tarifSotishDto) {
        Optional<SoldSimkarta> optionalSoldSimkarta = soldSimkartaRepository.findById(tarifSotishDto.getSimkartaId());
        if (!optionalSoldSimkarta.isPresent()){
            return new ApiResponse("simkart not found",false);
        }
        Optional<Tarif> optionalTarif = tarifRepository.findById(tarifSotishDto.getTarifId());
        if (!optionalTarif.isPresent()){
            return new ApiResponse("tarif not found",false);
        }
        SoldTarif soldTarif = new SoldTarif();
        soldTarif.setSoldSimkarta(optionalSoldSimkarta.get());
        Tarif tarif = optionalTarif.get();
        tarif.setActive(true);
        Tarif tarif1 = tarifRepository.save(tarif);
        soldTarif.setTarif(tarif1);
        soldTarifRepository.save(soldTarif);
        return new ApiResponse("tarif urnatildi",true);
    }
}
