package peaksoft.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import peaksoft.entity.Company;
import peaksoft.entity.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
@Repository
@Transactional
public class CompanyDaoImpl implements CompanyDao{

    private final EntityManagerFactory entityManagerFactory;

    @Autowired
    public CompanyDaoImpl(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }
    @Override
    public void saveCompany(Company company) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        entityManager.persist(company);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void updateCompany(Long id,Company company) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        Company company1 = entityManager.find(Company.class,id);
        company1.setCompanyName(company.getCompanyName());
        company1.setLocatedCountry(company.getLocatedCountry());
        entityManager.merge(company1);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public List<Company> getAllCompanies() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        List<Company> companies = entityManager.createQuery("select c from Company c").getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return companies; }

    @Override
    public Company getCompanyById(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        Company company = entityManager.find(Company.class, id);
        entityManager.getTransaction().commit();
        entityManager.close();
        return company;
    }


    @Override
    public void deleteCompanyById(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        Company company = entityManager.find(Company.class, id);
        entityManager.remove(company);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public List<Student> countOfStudents() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        List<Student> students =  entityManager.createQuery("SELECT COUNT(c.students.size) FROM Company c",Student.class).getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return students;
    }
}
