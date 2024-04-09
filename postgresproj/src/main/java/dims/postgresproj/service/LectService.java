package dims.postgresproj.service;

import dims.postgresproj.model.Lect;

import java.util.List;

public interface LectService {
    List<Lect> getLects();
    Lect getLect(long id);
    void deleteLect(long id);
    void saveLect(Lect lect);
}
