package softuni.exam.repository;

import org.hibernate.sql.Select;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import softuni.exam.models.entity.Volcano;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface VolcanoRepository extends JpaRepository<Volcano, Long> {

    Optional<Volcano> findByName(String name);

    @Query(value = "FROM Volcano WHERE isActive = true and elevation > 3000")
    List<Volcano> findAllByActiveAndElevationAndLastEruption();
}
