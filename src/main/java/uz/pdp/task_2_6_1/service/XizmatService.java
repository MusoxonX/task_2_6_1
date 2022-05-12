package uz.pdp.task_2_6_1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.task_2_6_1.entity.Simkarta;
import uz.pdp.task_2_6_1.entity.SoldSimkarta;
import uz.pdp.task_2_6_1.entity.SoldXizmat;
import uz.pdp.task_2_6_1.entity.Xizmatlar;
import uz.pdp.task_2_6_1.payload.ApiResponse;
import uz.pdp.task_2_6_1.payload.XizmatDto;
import uz.pdp.task_2_6_1.payload.XizmatSotishDto;
import uz.pdp.task_2_6_1.repository.SimcardRepository;
import uz.pdp.task_2_6_1.repository.SoldSimkartaRepository;
import uz.pdp.task_2_6_1.repository.XizmatRepository;

import java.util.Optional;

@Service
public class XizmatService {

    @Autowired
    XizmatRepository xizmatRepository;

    @Autowired
    SimcardRepository simcardRepository;

    public ApiResponse addXizmat(XizmatDto xizmatDto){
        Xizmatlar xizmatlar = new Xizmatlar();
        xizmatlar.setName(xizmatlar.getName());
        xizmatlar.setHaqida(xizmatDto.getHaqida());
        xizmatlar.setTuri(xizmatDto.getTuri());
        xizmatRepository.save(xizmatlar);
        return new ApiResponse("xizmat qushildi",false);
    }

    public ApiResponse sotish(XizmatSotishDto xizmatSotishDto) {
        Optional<Simkarta> optionalSimkarta = simcardRepository.findById(xizmatSotishDto.getSimkartaId());
        if (!optionalSimkarta.isPresent()){
            return new ApiResponse("simkarta not found",false);
        }
        Optional<Xizmatlar> optionalXizmatlar = xizmatRepository.findById(xizmatSotishDto.getXizmatId());
        if (!optionalXizmatlar.isPresent()){
            return new ApiResponse("xizmat not found",false);
        }
        SoldXizmat soldXizmat = new SoldXizmat();
        soldXizmat.setSimkarta(optionalSimkarta.get());
        Xizmatlar xizmatlar = optionalXizmatlar.get();
        xizmatlar.setActive(true);
        soldXizmat.setXizmatlar(xizmatlar);
        xizmatRepository.save(xizmatlar);
        return new ApiResponse("xizmat ulandi",true);
    }
}
