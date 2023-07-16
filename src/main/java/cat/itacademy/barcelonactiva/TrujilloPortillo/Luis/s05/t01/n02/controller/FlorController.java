package cat.itacademy.barcelonactiva.TrujilloPortillo.Luis.s05.t01.n02.controller;

import cat.itacademy.barcelonactiva.TrujilloPortillo.Luis.s05.t01.n02.model.dto.FlorDto;
import cat.itacademy.barcelonactiva.TrujilloPortillo.Luis.s05.t01.n02.model.services.FlorServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/flores")
public class FlorController {
    private final FlorServices florServices;

    @Autowired
    public FlorController(FlorServices florServices){
        this.florServices = florServices;
    }

    @GetMapping
    public ResponseEntity<List<FlorDto>> getAllFlores(){
        List<FlorDto> flores = florServices.getAllFlores();
        return ResponseEntity.ok(flores);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FlorDto> getFlorById(@PathVariable Integer id){
        FlorDto flor = florServices.getFlorById(id);
        if(flor != null){
            return ResponseEntity.ok(flor);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Void>createFlor(@RequestBody FlorDto florDto){
        florServices.createFlor(florDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateFlor(@PathVariable Integer id, @RequestBody FlorDto florDto){
        florServices.updateFlor(id,florDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFlor(@PathVariable Integer id){
        florServices.deleteFlor(id);
        return ResponseEntity.ok().build();
    }
}

