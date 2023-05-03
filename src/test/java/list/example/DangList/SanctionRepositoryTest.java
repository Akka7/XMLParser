package list.example.DangList;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import list.example.DangList.Repository.SanctionRepository;
import list.example.DangList.model.Sanction;

@SpringBootTest
@Transactional
public class SanctionRepositoryTest {

	@Autowired
	private SanctionRepository repository;

	@Test
	public void testSave() {
		Sanction sanction = new Sanction("Test Name", "Test Info");
		repository.save(sanction);
	}
}

