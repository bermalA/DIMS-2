package dims.postgresproj.service;

import dims.postgresproj.model.Prof;

import java.util.List;

public interface ProfService {
    List<Prof> getProfs();
    Prof getProf(long id);
    void saveProf(Prof prof);
    void deleteProf(long id);
}
