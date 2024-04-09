package dims.postgresproj.controller;

import dims.postgresproj.model.Lect;
import dims.postgresproj.service.LectService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LectController {
    private LectService lectService;

    public LectController(LectService lectService) {this.lectService = lectService;}

    @GetMapping("/lects")
    public ResponseEntity<List<Lect>> showLects(){
        List<Lect> lects = lectService.getLects();
        return ResponseEntity.ok().body(lects);
    }

    @GetMapping("/lects/{id}")
    public ResponseEntity<Lect> showLect(@PathVariable Long id){
        Lect lect = lectService.getLect(id);
        return ResponseEntity.ok().body(lect);
    }

    @PostMapping("/newLect")
    public ResponseEntity<Void> createLect(@RequestBody Lect newLect){
        Lect lect = new Lect();
        lect.setId(newLect.getId());
        lect.setName(newLect.getName());
        lect.setCredit(newLect.getCredit());
        lectService.saveLect(lect);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/lects/update/{id}")
    public ResponseEntity<Void> updateLect(@PathVariable long id, @RequestBody Lect newLect){
        Lect lect = lectService.getLect(id);
        if(lect==null){
            return ResponseEntity.notFound().build();
        }
        lect.setName(newLect.getName());
        lect.setCredit(newLect.getCredit());

        lectService.saveLect(lect);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/lects/delete/{id}")
    public ResponseEntity<Void> deleteLect(@PathVariable long id){
        Lect lect = lectService.getLect(id);
        if(lect==null){
            return ResponseEntity.notFound().build();
        }
        lectService.deleteLect(id);
        return ResponseEntity.ok().build();
    }
}
