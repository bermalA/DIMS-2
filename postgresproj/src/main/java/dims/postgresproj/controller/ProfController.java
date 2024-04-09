package dims.postgresproj.controller;

import dims.postgresproj.model.Prof;
import dims.postgresproj.service.ProfService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProfController {
    private final ProfService profService;

    public ProfController(ProfService profService) {
        this.profService = profService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Prof>> showProfs() {
        List<Prof> profs = profService.getProfs();
        return ResponseEntity.ok().body(profs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Prof> showProf(@PathVariable long id) {
        Prof prof = profService.getProf(id);
        return ResponseEntity.ok().body(prof);
    }

    @PostMapping("/newProf")
    public ResponseEntity<Void> createNewProf(@RequestBody Prof newProf) {
        Prof prof = new Prof();
        prof.setId(newProf.getId());
        prof.setName(newProf.getName());
        prof.setDepartment(newProf.getDepartment());
        profService.saveProf(prof);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateProf(@PathVariable long id, @RequestBody Prof updatedProf) {
        Prof prof = profService.getProf(id);
        if (prof == null) {
            return ResponseEntity.notFound().build();
        }
        prof.setName(updatedProf.getName());
        prof.setDepartment(updatedProf.getDepartment());

        profService.saveProf(prof);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteProf(@PathVariable long id) {
        Prof prof = profService.getProf(id);
        if (prof == null) {
            return ResponseEntity.notFound().build();
        }
        profService.deleteProf(id);
        return ResponseEntity.ok().build();
    }

}
