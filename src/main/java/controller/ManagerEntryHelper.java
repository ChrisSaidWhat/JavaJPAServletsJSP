package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.ManagerEntry;

/**
 * @author christophersaid - csaid
 * CIS175 - Spring 2024
 * Feb 22, 2024
 */
public class ManagerEntryHelper {
	
	//	constructor
	public ManagerEntryHelper() {
		
	}
	
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("employeeTracker");
	
	public void addManager(ManagerEntry manEntry) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(manEntry);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<ManagerEntry> showAllEntries() {
		EntityManager em = emfactory.createEntityManager();
		List<ManagerEntry> allEntries = em.createQuery("SELECT m FROM ManagerEntry m").getResultList();
		return allEntries;
	}
	
	public void deleteEntry(ManagerEntry toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ManagerEntry> typedQuery = em.createQuery("SELECT m FROM ManagerEntry m WHERE m.firstName = :selectedFirst AND m.lastName = :selectedLast", ManagerEntry.class);
		
		typedQuery.setParameter("selectedFirst", toDelete.getFirstName());
		typedQuery.setParameter("selectedLast", toDelete.getLastName());
		
		typedQuery.setMaxResults(1);
		
		ManagerEntry result = typedQuery.getSingleResult();
		
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}
	
	public ManagerEntry searchForEntryByManNo(int manNo) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		ManagerEntry found = em.find(ManagerEntry.class, manNo);
		em.close();
		
		return found;
	}
	
	public void updateEntry(ManagerEntry toEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<ManagerEntry> searchForEntryByFirstName(String firstName) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ManagerEntry> typedQuery = em.createQuery("SELECT m FROM ManagerEntry m WHERE m.firstName = :selectedFirst", ManagerEntry.class);
		typedQuery.setParameter("selectedFirst", firstName);
		
		List<ManagerEntry> foundEntries = typedQuery.getResultList();
		em.close();
		
		return foundEntries;
	}
	
	public List<ManagerEntry> searchForEntryByLastName(String lastName) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ManagerEntry> typedQuery = em.createQuery("SELECT m FROM ManagerEntry m WHERE m.lastName = :selectedLast", ManagerEntry.class);
		typedQuery.setParameter("selectedLast", lastName);
		
		List<ManagerEntry> foundEntries = typedQuery.getResultList();
		em.close();
		
		return foundEntries;
	}
	
	public void cleanUp() {
		emfactory.close();
	}
}
