package dims.postgresproj.repository;

import dims.postgresproj.model.Prof;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfRepository extends JpaRepository <Prof,Long> {

}
