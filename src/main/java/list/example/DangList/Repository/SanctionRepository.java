package list.example.DangList.Repository;

import jakarta.transaction.Transactional;
import list.example.DangList.model.Sanction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface SanctionRepository extends JpaRepository<Sanction, Long> {
    Sanction findSanctionByName (String name);
}
