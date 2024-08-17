
package persistencia;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import logica.Turno;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import logica.Paciente;
import persistencia.exceptions.NonexistentEntityException;

public class PacienteJpaController implements Serializable {

    public PacienteJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    public PacienteJpaController() {
       emf = Persistence.createEntityManagerFactory("ConsultorioPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Paciente paciente) {
        if (paciente.getLista_turnos() == null) {
            paciente.setLista_turnos(new ArrayList<Turno>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Turno> attachedLista_turnos = new ArrayList<Turno>();
            for (Turno lista_turnosTurnoToAttach : paciente.getLista_turnos()) {
                lista_turnosTurnoToAttach = em.getReference(lista_turnosTurnoToAttach.getClass(), lista_turnosTurnoToAttach.getId_turno());
                attachedLista_turnos.add(lista_turnosTurnoToAttach);
            }
            paciente.setLista_turnos(attachedLista_turnos);
            em.persist(paciente);
            for (Turno lista_turnosTurno : paciente.getLista_turnos()) {
                Paciente oldPacienteOfLista_turnosTurno = lista_turnosTurno.getPaciente();
                lista_turnosTurno.setPaciente(paciente);
                lista_turnosTurno = em.merge(lista_turnosTurno);
                if (oldPacienteOfLista_turnosTurno != null) {
                    oldPacienteOfLista_turnosTurno.getLista_turnos().remove(lista_turnosTurno);
                    oldPacienteOfLista_turnosTurno = em.merge(oldPacienteOfLista_turnosTurno);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Paciente paciente) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Paciente persistentPaciente = em.find(Paciente.class, paciente.getId_persona());
            List<Turno> lista_turnosOld = persistentPaciente.getLista_turnos();
            List<Turno> lista_turnosNew = paciente.getLista_turnos();
            List<Turno> attachedLista_turnosNew = new ArrayList<Turno>();
            for (Turno lista_turnosNewTurnoToAttach : lista_turnosNew) {
                lista_turnosNewTurnoToAttach = em.getReference(lista_turnosNewTurnoToAttach.getClass(), lista_turnosNewTurnoToAttach.getId_turno());
                attachedLista_turnosNew.add(lista_turnosNewTurnoToAttach);
            }
            lista_turnosNew = attachedLista_turnosNew;
            paciente.setLista_turnos(lista_turnosNew);
            paciente = em.merge(paciente);
            for (Turno lista_turnosOldTurno : lista_turnosOld) {
                if (!lista_turnosNew.contains(lista_turnosOldTurno)) {
                    lista_turnosOldTurno.setPaciente(null);
                    lista_turnosOldTurno = em.merge(lista_turnosOldTurno);
                }
            }
            for (Turno lista_turnosNewTurno : lista_turnosNew) {
                if (!lista_turnosOld.contains(lista_turnosNewTurno)) {
                    Paciente oldPacienteOfLista_turnosNewTurno = lista_turnosNewTurno.getPaciente();
                    lista_turnosNewTurno.setPaciente(paciente);
                    lista_turnosNewTurno = em.merge(lista_turnosNewTurno);
                    if (oldPacienteOfLista_turnosNewTurno != null && !oldPacienteOfLista_turnosNewTurno.equals(paciente)) {
                        oldPacienteOfLista_turnosNewTurno.getLista_turnos().remove(lista_turnosNewTurno);
                        oldPacienteOfLista_turnosNewTurno = em.merge(oldPacienteOfLista_turnosNewTurno);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = paciente.getId_persona();
                if (findPaciente(id) == null) {
                    throw new NonexistentEntityException("The paciente with id " + id + " no longer exists.");
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
            Paciente paciente;
            try {
                paciente = em.getReference(Paciente.class, id);
                paciente.getId_persona();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The paciente with id " + id + " no longer exists.", enfe);
            }
            List<Turno> lista_turnos = paciente.getLista_turnos();
            for (Turno lista_turnosTurno : lista_turnos) {
                lista_turnosTurno.setPaciente(null);
                lista_turnosTurno = em.merge(lista_turnosTurno);
            }
            em.remove(paciente);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Paciente> findPacienteEntities() {
        return findPacienteEntities(true, -1, -1);
    }

    public List<Paciente> findPacienteEntities(int maxResults, int firstResult) {
        return findPacienteEntities(false, maxResults, firstResult);
    }

    private List<Paciente> findPacienteEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Paciente.class));
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

    public Paciente findPaciente(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Paciente.class, id);
        } finally {
            em.close();
        }
    }

    public int getPacienteCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Paciente> rt = cq.from(Paciente.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
