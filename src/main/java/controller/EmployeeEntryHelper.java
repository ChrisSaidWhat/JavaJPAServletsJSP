package controller;

import model.EmployeeEntry;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;
/**
 * @author christophersaid - csaid
 * CIS175 - Spring 2024
 * Jan 29, 2024
 */
public class EmployeeEntryHelper {

    //  constructor
    public EmployeeEntryHelper() {

    }

    static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("employeeTracker");

    public void addEmployee(EmployeeEntry empEntry) {
        EntityManager em = emfactory.createEntityManager();
        em.getTransaction().begin();
        em.persist(empEntry);
        em.getTransaction().commit();
        em.close();
    }

    public List<EmployeeEntry> showAllEntries() {
        EntityManager em = emfactory.createEntityManager();
        List<EmployeeEntry> allEntries = em.createQuery("SELECT e FROM EmployeeEntry e").getResultList();
        return allEntries;
    }

    public void deleteEntry(EmployeeEntry toDelete) {
        EntityManager em = emfactory.createEntityManager();
        em.getTransaction().begin();
        TypedQuery<EmployeeEntry> typedQuery = em.createQuery("SELECT e FROM EmployeeEntry e WHERE e.firstName = :selectedFirst AND e.lastName = :selectedLast", EmployeeEntry.class);

        typedQuery.setParameter("selectedFirst", toDelete.getFirstName());
        typedQuery.setParameter("selectedLast", toDelete.getLastName());

        typedQuery.setMaxResults(1);

        EmployeeEntry result = typedQuery.getSingleResult();

        em.remove(result);
        em.getTransaction().commit();
        em.close();
    }

    public EmployeeEntry searchForEntryByEmpNo(int empNo) {
        EntityManager em = emfactory.createEntityManager();
        em.getTransaction().begin();
        EmployeeEntry found = em.find(EmployeeEntry.class, empNo);
        em.close();

        return found;
    }

    public void updateEntry(EmployeeEntry toEdit) {
        EntityManager em = emfactory.createEntityManager();
        em.getTransaction().begin();
        em.merge(toEdit);
        em.getTransaction().commit();
        em.close();
    }

    public List<EmployeeEntry> searchForEntryByFirstName(String firstName) {
        EntityManager em = emfactory.createEntityManager();
        em.getTransaction().begin();
        TypedQuery<EmployeeEntry> typedQuery = em.createQuery("SELECT e FROM EmployeeEntry e WHERE e.firstName = :selectedFirst", EmployeeEntry.class);
        typedQuery.setParameter("selectedFirst", firstName);

        List<EmployeeEntry> foundEntries = typedQuery.getResultList();
        em.close();

        return foundEntries;
    }

    public List<EmployeeEntry> searchForEntryByLastName(String lastName) {
        EntityManager em = emfactory.createEntityManager();
        em.getTransaction().begin();
        TypedQuery<EmployeeEntry> typedQuery = em.createQuery("SELECT e FROM EmployeeEntry e WHERE e.lastName = :selectedLast", EmployeeEntry.class);
        typedQuery.setParameter("selectedLast", lastName);

        List<EmployeeEntry> foundEntries = typedQuery.getResultList();
        em.close();

        return foundEntries;
    }

    public void cleanUp() {
        emfactory.close();
    }

}