package list.example.DangList.Repository;

import jakarta.transaction.Transactional;
import list.example.DangList.model.SancCompanies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface SancCompaniesRepository extends JpaRepository<SancCompanies, Long>  {
    SancCompanies findSancCompaniesByName (String name);
}
