package dims.postgresproj.service;

import dims.postgresproj.model.Lect;
import dims.postgresproj.repository.LectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LectServiceImpl implements LectService {
    @Autowired
    private LectRepository lectRepository;

    @Override
    public List<Lect> getLects() {
        return lectRepository.findAll();
    }

    @Override
    public Lect getLect(long id) {
        Optional<Lect> optional = lectRepository.findById(id);
        Lect lect = null;
        if (optional.isPresent()) {
            lect = optional.get();
        }else {
            throw new RuntimeException("Lecture not found");
        }
        return lect;
    }

    @Override
    public void deleteLect(long id) {
        this.lectRepository.deleteById(id);
    }

    @Override
    public void saveLect(Lect lect) {
        this.lectRepository.save(lect);
    }

}
