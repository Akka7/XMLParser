package list.example.DangList.Services;

import io.micrometer.common.util.StringUtils;
import list.example.DangList.Repository.SanctionRepository;
import list.example.DangList.model.InvalidRequestException;
import list.example.DangList.model.Sanction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SanctionVerificationService {

    @Autowired
    private SanctionRepository sanctionRepository;

    public boolean verifySanction(String name) {
        if (StringUtils.isBlank(name)) {
            throw new InvalidRequestException("Full name cannot be blank");
        }

        Sanction sanction = sanctionRepository.findSanctionByName(name);
        if (sanction != null) {
            return true;
        } else {
            return false;
        }
    }
}
