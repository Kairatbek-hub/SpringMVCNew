package peaksoft.dao;

import org.springframework.stereotype.Repository;
import peaksoft.entity.Company;
import peaksoft.entity.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
@Repository
@Transactional
public class CompanyDaoImpl implements CompanyDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void saveCompany(Company company) {
        entityManager.persist(company);
    }

    @Override
    public void updateCompany(Long id,Company company) {
        Company company1 = entityManager.find(Company.class,id);
        company1.setCompanyName(company.getCompanyName());
        company1.setLocatedCountry(company.getLocatedCountry());
        entityManager.merge(company1);
    }

    @Override
    public List<Company> getAllCompanies() {
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        List<Company> companies = entityManager.createQuery("select c from Company c").getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return companies; }

    @Override
    public Company getCompanyById(Long id) {
        return entityManager.find(Company.class,id);
    }


    @Override
    public void deleteCompanyById(Long id) {
        entityManager.remove(entityManager.find(Company.class,id));
    }

    @Override
    public List<Student> countOfStudents() {
        return entityManager.createQuery("SELECT COUNT(c.students.size) FROM Company c",Student.class).getResultList();
    }
}
