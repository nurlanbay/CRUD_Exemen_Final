package peaksoft.dao;

import peaksoft.entity.Company;

import java.util.List;
import java.util.Optional;

public interface CompanyDao {

    void saveCompany(Company company);

    Optional<Company> findByCompanyName(String name);

    Optional<Company> findByIdCompany(Long id);

    void deleteByIdCompany(Long id);

    void updateById(Long id);

    List<Company> getAllCompany();
}
