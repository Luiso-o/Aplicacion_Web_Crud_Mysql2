package cat.itacademy.barcelonactiva.TrujilloPortillo.Luis.s05.t01.n02.model.services;

import cat.itacademy.barcelonactiva.TrujilloPortillo.Luis.s05.t01.n02.model.domain.FlorEntity;
import cat.itacademy.barcelonactiva.TrujilloPortillo.Luis.s05.t01.n02.model.dto.FlorDto;
import cat.itacademy.barcelonactiva.TrujilloPortillo.Luis.s05.t01.n02.model.repository.FlorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FlorServices {

    private final FlorRepository florRepository;

    @Autowired
    public FlorServices(FlorRepository florRepository){
        this.florRepository = florRepository;
    }

    public List<FlorDto> getAllFlores(){
        List<FlorEntity> flores = florRepository.findAll();
        return flores.stream().map(this::convertEntityToDto).collect(Collectors.toList());
    }

    public FlorDto getFlorById(Integer id){
        FlorEntity flor = florRepository.findById(id).orElse(null);
        if(flor != null){
            return convertEntityToDto(flor);
        }else{
            return null;
        }
    }

    public void createFlor(FlorDto florDto){
        FlorEntity flor = convertDtoToEntity(florDto);
        florRepository.save(flor);
    }

    public void updateFlor(Integer id,FlorDto florDto){
        FlorEntity flor = florRepository.findById(id).orElse(null);
        if(flor != null){
            flor.setNombreFlor(florDto.getNombreFlor());
            flor.setPaisFlor(florDto.getPaisFlor());
            florRepository.save(flor);
        }
    }

    public void deleteFlor(Integer id){
        florRepository.deleteById(id);
    }

    private FlorDto convertEntityToDto(FlorEntity florEntity){
        return  new FlorDto(florEntity.getNombreFlor(),florEntity.getPaisFlor());
    }

    private FlorEntity convertDtoToEntity(FlorDto florDto){
        return new FlorEntity(florDto.getNombreFlor(),florDto.getPaisFlor());
    }

}
