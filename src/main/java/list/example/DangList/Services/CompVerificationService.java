package list.example.DangList.Services;

import io.micrometer.common.util.StringUtils;
import list.example.DangList.Repository.SancCompaniesRepository;
import list.example.DangList.model.InvalidRequestException;
import list.example.DangList.model.SancCompanies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompVerificationService {

    @Autowired
    private SancCompaniesRepository sancCompaniesRepository;

    public boolean verifyCompany(String name) {
        if (StringUtils.isBlank(name)) {
            throw new InvalidRequestException("Full name cannot be blank");
        }

        SancCompanies sancCompanies = sancCompaniesRepository.findSancCompaniesByName(name);
        if (sancCompanies != null) {
            return true;
        } else {
            return false;
        }
    }
}
