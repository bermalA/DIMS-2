package dims.postgresproj.service;

import dims.postgresproj.model.Prof;
import dims.postgresproj.repository.ProfRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfServiceImpl implements ProfService {
    @Autowired
    private ProfRepository profRepository;

    @Override
    public List<Prof> getProfs() {
        return profRepository.findAll();
    }

    @Override
    public void saveProf(Prof prof) {
        this.profRepository.save(prof);
    }

    @Override
     public Prof getProf(long id){
        Optional<Prof> optional = profRepository.findById(id);
        Prof prof=  null;
        if(optional.isPresent()){
            prof = optional.get();
        }else{
            throw new RuntimeException("Prof not found");
        }
        return prof;
    }

    @Override
    public void deleteProf(long id) {
        this.profRepository.deleteById(id);
    }
}