
package persistencia;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import logica.Odontologo;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import logica.Especialidad;
import persistencia.exceptions.NonexistentEntityException;

public class EspecialidadJpaController implements Serializable {

    public EspecialidadJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    public EspecialidadJpaController() {
       emf = Persistence.createEntityManagerFactory("ConsultorioPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Especialidad especialidad) {
        if (especialidad.getDoctoresEsp() == null) {
            especialidad.setDoctoresEsp(new ArrayList<Odontologo>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Odontologo> attachedDoctoresEsp = new ArrayList<Odontologo>();
            for (Odontologo doctoresEspOdontologoToAttach : especialidad.getDoctoresEsp()) {
                doctoresEspOdontologoToAttach = em.getReference(doctoresEspOdontologoToAttach.getClass(), doctoresEspOdontologoToAttach.getId_persona());
                attachedDoctoresEsp.add(doctoresEspOdontologoToAttach);
            }
            especialidad.setDoctoresEsp(attachedDoctoresEsp);
            em.persist(especialidad);
            for (Odontologo doctoresEspOdontologo : especialidad.getDoctoresEsp()) {
                Especialidad oldEspecialidadOfDoctoresEspOdontologo = doctoresEspOdontologo.getEspecialidad();
                doctoresEspOdontologo.setEspecialidad(especialidad);
                doctoresEspOdontologo = em.merge(doctoresEspOdontologo);
                if (oldEspecialidadOfDoctoresEspOdontologo != null) {
                    oldEspecialidadOfDoctoresEspOdontologo.getDoctoresEsp().remove(doctoresEspOdontologo);
                    oldEspecialidadOfDoctoresEspOdontologo = em.merge(oldEspecialidadOfDoctoresEspOdontologo);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Especialidad especialidad) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Especialidad persistentEspecialidad = em.find(Especialidad.class, especialidad.getId_especialidad());
            List<Odontologo> doctoresEspOld = persistentEspecialidad.getDoctoresEsp();
            List<Odontologo> doctoresEspNew = especialidad.getDoctoresEsp();
            List<Odontologo> attachedDoctoresEspNew = new ArrayList<Odontologo>();
            for (Odontologo doctoresEspNewOdontologoToAttach : doctoresEspNew) {
                doctoresEspNewOdontologoToAttach = em.getReference(doctoresEspNewOdontologoToAttach.getClass(), doctoresEspNewOdontologoToAttach.getId_persona());
                attachedDoctoresEspNew.add(doctoresEspNewOdontologoToAttach);
            }
            doctoresEspNew = attachedDoctoresEspNew;
            especialidad.setDoctoresEsp(doctoresEspNew);
            especialidad = em.merge(especialidad);
            for (Odontologo doctoresEspOldOdontologo : doctoresEspOld) {
                if (!doctoresEspNew.contains(doctoresEspOldOdontologo)) {
                    doctoresEspOldOdontologo.setEspecialidad(null);
                    doctoresEspOldOdontologo = em.merge(doctoresEspOldOdontologo);
                }
            }
            for (Odontologo doctoresEspNewOdontologo : doctoresEspNew) {
                if (!doctoresEspOld.contains(doctoresEspNewOdontologo)) {
                    Especialidad oldEspecialidadOfDoctoresEspNewOdontologo = doctoresEspNewOdontologo.getEspecialidad();
                    doctoresEspNewOdontologo.setEspecialidad(especialidad);
                    doctoresEspNewOdontologo = em.merge(doctoresEspNewOdontologo);
                    if (oldEspecialidadOfDoctoresEspNewOdontologo != null && !oldEspecialidadOfDoctoresEspNewOdontologo.equals(especialidad)) {
                        oldEspecialidadOfDoctoresEspNewOdontologo.getDoctoresEsp().remove(doctoresEspNewOdontologo);
                        oldEspecialidadOfDoctoresEspNewOdontologo = em.merge(oldEspecialidadOfDoctoresEspNewOdontologo);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = especialidad.getId_especialidad();
                if (findEspecialidad(id) == null) {
                    throw new NonexistentEntityException("The especialidad with id " + id + " no longer exists.");
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
            Especialidad especialidad;
            try {
                especialidad = em.getReference(Especialidad.class, id);
                especialidad.getId_especialidad();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The especialidad with id " + id + " no longer exists.", enfe);
            }
            List<Odontologo> doctoresEsp = especialidad.getDoctoresEsp();
            for (Odontologo doctoresEspOdontologo : doctoresEsp) {
                doctoresEspOdontologo.setEspecialidad(null);
                doctoresEspOdontologo = em.merge(doctoresEspOdontologo);
            }
            em.remove(especialidad);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Especialidad> findEspecialidadEntities() {
        return findEspecialidadEntities(true, -1, -1);
    }

    public List<Especialidad> findEspecialidadEntities(int maxResults, int firstResult) {
        return findEspecialidadEntities(false, maxResults, firstResult);
    }

    private List<Especialidad> findEspecialidadEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Especialidad.class));
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

    public Especialidad findEspecialidad(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Especialidad.class, id);
        } finally {
            em.close();
        }
    }

    public int getEspecialidadCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Especialidad> rt = cq.from(Especialidad.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
