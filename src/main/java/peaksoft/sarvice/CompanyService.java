package peaksoft.sarvice;

import peaksoft.entity.Company;

import java.util.List;
import java.util.Optional;

public interface CompanyService {

    void saveCompany(Company company);

    Optional<Company> findByIdCompany(Long id);

    void deleteByIdCompany(Long id);

    void updateById(Long id);

    List<Company> getAllCompany();
}
