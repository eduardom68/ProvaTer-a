package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import entidade.Incidente;
import Util.JPAUtil;
import static Util.MessageUtil.*;

public class IncidenteDao {
	
	public static void salvar(Incidente incidente) {
	    EntityManager em = JPAUtil.criarEntityManager();
		em.getTransaction().begin();
		em.persist(incidente);
		em.getTransaction().commit();
		em.close();
	}

	public static Incidente especifico(Incidente incidente) {
		EntityManager em = JPAUtil.criarEntityManager();
		em.getTransaction().begin();
		em.merge(incidente);
		em.getTransaction().commit();
		em.close();
		return incidente;
	}

	public static List<Incidente> todos() {
	    EntityManager em = JPAUtil.criarEntityManager();
	    Query query = em.createQuery("SELECT i FROM Incidente i", Incidente.class);
	    List<Incidente> lista = query.getResultList();
	    em.close();
	    return lista;
	}
	
	public static Long total() {
	    EntityManager em = JPAUtil.criarEntityManager();
	    Query query = em.createQuery("SELECT COUNT(i) FROM Incidente i", Long.class);
	    Long count = (Long) query.getSingleResult();
	    em.close();
	    return count;
	}
	
	
	public static void confirma(Incidente incidente) {
	    EntityManager em = JPAUtil.criarEntityManager();
		em.getTransaction().begin();
		em.merge(incidente);
		em.getTransaction().commit();
		em.close();
	}

	public static void editar(Incidente incidente) {
	    EntityManager em = JPAUtil.criarEntityManager();
		em.getTransaction().begin();
		em.merge(incidente);
		em.getTransaction().commit();
		em.close();
	}

    public static void excluir(Incidente incidente) {
		EntityManager em = JPAUtil.criarEntityManager();
		em.getTransaction().begin();
		incidente = em.find(Incidente.class, incidente.getId());
		em.remove(incidente);
		em.getTransaction().commit();
		em.close();
    }
	

}