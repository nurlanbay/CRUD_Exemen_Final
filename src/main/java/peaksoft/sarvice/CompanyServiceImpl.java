package peaksoft.sarvice;

import org.springframework.stereotype.Service;
import peaksoft.dao.CompanyDao;
import peaksoft.entity.Company;
import peaksoft.exception.CompanyAlreadyExistsException;
import peaksoft.exception.CompanyNotFoundException;

import java.util.List;
import java.util.Optional;


@Service
public class CompanyServiceImpl implements CompanyService {

    // Dependency
    private final CompanyDao companyDao;

    // Injection
    public CompanyServiceImpl(CompanyDao companyDao) {
        this.companyDao = companyDao;
    }

    @Override
    public void saveCompany(Company company) {
        Optional<Company> companyOptional = companyDao.findByCompanyName(company.getCompanyName());
        if (companyOptional.isPresent()) {
            throw new CompanyAlreadyExistsException(
                    "Company with name = " + company.getCompanyName() + " has already exists in database"
            );
        }
        companyDao.saveCompany(company);
    }

    @Override
    public Optional<Company> findByIdCompany(Long id) {
        return companyDao.findByIdCompany(id);
    }

    @Override
    public void deleteByIdCompany(Long id) {
        Company byIdCompany = findByIdCompany(id)
                .orElseThrow(() -> new CompanyNotFoundException(
                        String.format("Company with id = %d does not exists", id)
                ));
        System.out.println(byIdCompany);
        companyDao.deleteByIdCompany(id);
    }

    @Override
    public void updateById(Long id) {
        // TODO: 02.03.2022 update
    }

    @Override
    public List<Company> getAllCompany() {
        return companyDao.getAllCompany();
    }
}
