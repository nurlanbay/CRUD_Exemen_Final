package peaksoft.dao;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import peaksoft.entity.Company;
import peaksoft.exception.CompanyNotFoundException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Controller
@Transactional
public class CompanyDaoImpl implements CompanyDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void saveCompany(Company company) {
        entityManager.persist(company);
    }

    @Override
    public Optional<Company> findByCompanyName(String name) {
        int companyId = entityManager.createQuery("SELECT c FROM Company c WHERE c.companyName = ?1").executeUpdate();
        return findByIdCompany((long) companyId);
    }

    @Override
    public Optional<Company> findByIdCompany(Long id) {
        return Optional.ofNullable(entityManager.find(Company.class, id));
    }

    @Override
    public void deleteByIdCompany(Long id) {
        Company byIdCompany = findByIdCompany(id)
                .orElseThrow(() -> new CompanyNotFoundException(
                        String.format("Company with id = %d does not exists", id)
                ));
        System.out.println(byIdCompany);
        entityManager.createQuery("DELETE FROM Company c WHERE c.id = ?1")
                .setParameter(1,byIdCompany.getId())
                .executeUpdate();
    }

    @Override
    public void updateById(Long id) {
        entityManager.merge(id);
    }

    @Override
    public List<Company> getAllCompany() {
        List<Company> list = entityManager.createQuery("select c from Company c ", Company.class).getResultList();
        return list;
    }
}
