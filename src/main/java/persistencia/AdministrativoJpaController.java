/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import logica.Administrativo;
import logica.Usuario;
import persistencia.exceptions.NonexistentEntityException;

/**
 *
 * @author Juan
 */
public class AdministrativoJpaController implements Serializable {

    public AdministrativoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Administrativo administrativo) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Usuario usuario_administrativo = administrativo.getUsuario_administrativo();
            if (usuario_administrativo != null) {
                usuario_administrativo = em.getReference(usuario_administrativo.getClass(), usuario_administrativo.getId_usuario());
                administrativo.setUsuario_administrativo(usuario_administrativo);
            }
            em.persist(administrativo);
            if (usuario_administrativo != null) {
                usuario_administrativo.getNombre_usuario().add(administrativo);
                usuario_administrativo = em.merge(usuario_administrativo);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Administrativo administrativo) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Administrativo persistentAdministrativo = em.find(Administrativo.class, administrativo.getId_persona());
            Usuario usuario_administrativoOld = persistentAdministrativo.getUsuario_administrativo();
            Usuario usuario_administrativoNew = administrativo.getUsuario_administrativo();
            if (usuario_administrativoNew != null) {
                usuario_administrativoNew = em.getReference(usuario_administrativoNew.getClass(), usuario_administrativoNew.getId_usuario());
                administrativo.setUsuario_administrativo(usuario_administrativoNew);
            }
            administrativo = em.merge(administrativo);
            if (usuario_administrativoOld != null && !usuario_administrativoOld.equals(usuario_administrativoNew)) {
                usuario_administrativoOld.getNombre_usuario().remove(administrativo);
                usuario_administrativoOld = em.merge(usuario_administrativoOld);
            }
            if (usuario_administrativoNew != null && !usuario_administrativoNew.equals(usuario_administrativoOld)) {
                usuario_administrativoNew.getNombre_usuario().add(administrativo);
                usuario_administrativoNew = em.merge(usuario_administrativoNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = administrativo.getId_persona();
                if (findAdministrativo(id) == null) {
                    throw new NonexistentEntityException("The administrativo with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(int id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Administrativo administrativo;
            try {
                administrativo = em.getReference(Administrativo.class, id);
                administrativo.getId_persona();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The administrativo with id " + id + " no longer exists.", enfe);
            }
            Usuario usuario_administrativo = administrativo.getUsuario_administrativo();
            if (usuario_administrativo != null) {
                usuario_administrativo.getNombre_usuario().remove(administrativo);
                usuario_administrativo = em.merge(usuario_administrativo);
            }
            em.remove(administrativo);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Administrativo> findAdministrativoEntities() {
        return findAdministrativoEntities(true, -1, -1);
    }

    public List<Administrativo> findAdministrativoEntities(int maxResults, int firstResult) {
        return findAdministrativoEntities(false, maxResults, firstResult);
    }

    private List<Administrativo> findAdministrativoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Administrativo.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Administrativo findAdministrativo(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Administrativo.class, id);
        } finally {
            em.close();
        }
    }

    public int getAdministrativoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Administrativo> rt = cq.from(Administrativo.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
