package uz.pdp.task_2_6_1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.task_2_6_1.entity.Filial;
import uz.pdp.task_2_6_1.entity.User;
import uz.pdp.task_2_6_1.payload.ApiResponse;
import uz.pdp.task_2_6_1.payload.FilialDto;
import uz.pdp.task_2_6_1.repository.FilialRepository;
import uz.pdp.task_2_6_1.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class FilialService {

    @Autowired
    FilialRepository filialRepository;

    @Autowired
    UserRepository userRepository;

//-------this is for adding filials
    public ApiResponse addFilial(FilialDto filialDto){
        Optional<User> optionalManager = userRepository.findById(filialDto.getManagerId());
        if (!optionalManager.isPresent()){
            return new ApiResponse("manager not found",false);
        }

        Optional<User> optionalRahbar = userRepository.findById(filialDto.getRahbarId());
        if (!optionalRahbar.isPresent()){
            return new ApiResponse("rahbar not found",false);
        }
        List<User> xodimlarList = userRepository.findAllById(filialDto.getXodimlarId());

        boolean exists = filialRepository.existsByName(filialDto.getName());
        if (exists){
            return new ApiResponse("filial exists",false);
        }
        Filial filial = new Filial();
        filial.setName(filialDto.getName());

        filial.setManger(optionalManager.get());
        filial.setRahbar(optionalRahbar.get());
        filial.setXodimlar(xodimlarList);
        filialRepository.save(filial);
        return new ApiResponse("filial saved",true);
    }


//    -------this is for adding xodimlar and rahbar by manager
    public ApiResponse editFilial(Integer id,FilialDto filialDto) {
        Optional<Filial> optionalFilial = filialRepository.findById(id);
        if (!optionalFilial.isPresent()){
            return new ApiResponse("filial not found",false);
        }

        Optional<User> optionalRahbar = userRepository.findById(filialDto.getRahbarId());
        if (!optionalRahbar.isPresent()){
            return new ApiResponse("user not found",false);
        }

        List<User> xodimList = userRepository.findAllById(filialDto.getXodimlarId());
        Filial filial = optionalFilial.get();
        filial.setRahbar(optionalRahbar.get());
        filial.setXodimlar(xodimList);
        filialRepository.save(filial);
        return new ApiResponse("Filialga xodimlar va rahbar birktirildi",true);
    }
}
