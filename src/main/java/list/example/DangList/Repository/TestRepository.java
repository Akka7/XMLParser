package list.example.DangList.Repository;

import list.example.DangList.model.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestRepository extends JpaRepository <Test, Long>{
}
