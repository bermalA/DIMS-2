package dims.postgresproj.repository;

import dims.postgresproj.model.Lect;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LectRepository extends JpaRepository<Lect, Long> {
}
