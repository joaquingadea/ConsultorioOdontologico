/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import logica.Usuario;
import logica.Especialidad;
import logica.Turno;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import logica.Odontologo;
import persistencia.exceptions.NonexistentEntityException;

/**
 *
 * @author Juan
 */
public class OdontologoJpaController implements Serializable {

    public OdontologoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    public OdontologoJpaController() {
       emf = Persistence.createEntityManagerFactory("ConsultorioPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Odontologo odontologo) {
        if (odontologo.getListaTurnos() == null) {
            odontologo.setListaTurnos(new ArrayList<Turno>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Usuario usuario_odontologo = odontologo.getUsuario_odontologo();
            if (usuario_odontologo != null) {
                usuario_odontologo = em.getReference(usuario_odontologo.getClass(), usuario_odontologo.getId_usuario());
                odontologo.setUsuario_odontologo(usuario_odontologo);
            }
            Especialidad especialidad = odontologo.getEspecialidad();
            if (especialidad != null) {
                especialidad = em.getReference(especialidad.getClass(), especialidad.getId_especialidad());
                odontologo.setEspecialidad(especialidad);
            }
            List<Turno> attachedListaTurnos = new ArrayList<Turno>();
            for (Turno listaTurnosTurnoToAttach : odontologo.getListaTurnos()) {
                listaTurnosTurnoToAttach = em.getReference(listaTurnosTurnoToAttach.getClass(), listaTurnosTurnoToAttach.getId_turno());
                attachedListaTurnos.add(listaTurnosTurnoToAttach);
            }
            odontologo.setListaTurnos(attachedListaTurnos);
            em.persist(odontologo);
            if (usuario_odontologo != null) {
                usuario_odontologo.getNombre_usuario().add(odontologo);
                usuario_odontologo = em.merge(usuario_odontologo);
            }
            if (especialidad != null) {
                especialidad.getDoctoresEsp().add(odontologo);
                especialidad = em.merge(especialidad);
            }
            for (Turno listaTurnosTurno : odontologo.getListaTurnos()) {
                Odontologo oldDocEncargadoOfListaTurnosTurno = listaTurnosTurno.getDocEncargado();
                listaTurnosTurno.setDocEncargado(odontologo);
                listaTurnosTurno = em.merge(listaTurnosTurno);
                if (oldDocEncargadoOfListaTurnosTurno != null) {
                    oldDocEncargadoOfListaTurnosTurno.getListaTurnos().remove(listaTurnosTurno);
                    oldDocEncargadoOfListaTurnosTurno = em.merge(oldDocEncargadoOfListaTurnosTurno);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Odontologo odontologo) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Odontologo persistentOdontologo = em.find(Odontologo.class, odontologo.getId_persona());
            Usuario usuario_odontologoOld = persistentOdontologo.getUsuario_odontologo();
            Usuario usuario_odontologoNew = odontologo.getUsuario_odontologo();
            Especialidad especialidadOld = persistentOdontologo.getEspecialidad();
            Especialidad especialidadNew = odontologo.getEspecialidad();
            List<Turno> listaTurnosOld = persistentOdontologo.getListaTurnos();
            List<Turno> listaTurnosNew = odontologo.getListaTurnos();
            if (usuario_odontologoNew != null) {
                usuario_odontologoNew = em.getReference(usuario_odontologoNew.getClass(), usuario_odontologoNew.getId_usuario());
                odontologo.setUsuario_odontologo(usuario_odontologoNew);
            }
            if (especialidadNew != null) {
                especialidadNew = em.getReference(especialidadNew.getClass(), especialidadNew.getId_especialidad());
                odontologo.setEspecialidad(especialidadNew);
            }
            List<Turno> attachedListaTurnosNew = new ArrayList<Turno>();
            for (Turno listaTurnosNewTurnoToAttach : listaTurnosNew) {
                listaTurnosNewTurnoToAttach = em.getReference(listaTurnosNewTurnoToAttach.getClass(), listaTurnosNewTurnoToAttach.getId_turno());
                attachedListaTurnosNew.add(listaTurnosNewTurnoToAttach);
            }
            listaTurnosNew = attachedListaTurnosNew;
            odontologo.setListaTurnos(listaTurnosNew);
            odontologo = em.merge(odontologo);
            if (usuario_odontologoOld != null && !usuario_odontologoOld.equals(usuario_odontologoNew)) {
                usuario_odontologoOld.getNombre_usuario().remove(odontologo);
                usuario_odontologoOld = em.merge(usuario_odontologoOld);
            }
            if (usuario_odontologoNew != null && !usuario_odontologoNew.equals(usuario_odontologoOld)) {
                usuario_odontologoNew.getNombre_usuario().add(odontologo);
                usuario_odontologoNew = em.merge(usuario_odontologoNew);
            }
            if (especialidadOld != null && !especialidadOld.equals(especialidadNew)) {
                especialidadOld.getDoctoresEsp().remove(odontologo);
                especialidadOld = em.merge(especialidadOld);
            }
            if (especialidadNew != null && !especialidadNew.equals(especialidadOld)) {
                especialidadNew.getDoctoresEsp().add(odontologo);
                especialidadNew = em.merge(especialidadNew);
            }
            for (Turno listaTurnosOldTurno : listaTurnosOld) {
                if (!listaTurnosNew.contains(listaTurnosOldTurno)) {
                    listaTurnosOldTurno.setDocEncargado(null);
                    listaTurnosOldTurno = em.merge(listaTurnosOldTurno);
                }
            }
            for (Turno listaTurnosNewTurno : listaTurnosNew) {
                if (!listaTurnosOld.contains(listaTurnosNewTurno)) {
                    Odontologo oldDocEncargadoOfListaTurnosNewTurno = listaTurnosNewTurno.getDocEncargado();
                    listaTurnosNewTurno.setDocEncargado(odontologo);
                    listaTurnosNewTurno = em.merge(listaTurnosNewTurno);
                    if (oldDocEncargadoOfListaTurnosNewTurno != null && !oldDocEncargadoOfListaTurnosNewTurno.equals(odontologo)) {
                        oldDocEncargadoOfListaTurnosNewTurno.getListaTurnos().remove(listaTurnosNewTurno);
                        oldDocEncargadoOfListaTurnosNewTurno = em.merge(oldDocEncargadoOfListaTurnosNewTurno);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = odontologo.getId_persona();
                if (findOdontologo(id) == null) {
                    throw new NonexistentEntityException("The odontologo with id " + id + " no longer exists.");
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
            Odontologo odontologo;
            try {
                odontologo = em.getReference(Odontologo.class, id);
                odontologo.getId_persona();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The odontologo with id " + id + " no longer exists.", enfe);
            }
            Usuario usuario_odontologo = odontologo.getUsuario_odontologo();
            if (usuario_odontologo != null) {
                usuario_odontologo.getNombre_usuario().remove(odontologo);
                usuario_odontologo = em.merge(usuario_odontologo);
            }
            Especialidad especialidad = odontologo.getEspecialidad();
            if (especialidad != null) {
                especialidad.getDoctoresEsp().remove(odontologo);
                especialidad = em.merge(especialidad);
            }
            List<Turno> listaTurnos = odontologo.getListaTurnos();
            for (Turno listaTurnosTurno : listaTurnos) {
                listaTurnosTurno.setDocEncargado(null);
                listaTurnosTurno = em.merge(listaTurnosTurno);
            }
            em.remove(odontologo);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Odontologo> findOdontologoEntities() {
        return findOdontologoEntities(true, -1, -1);
    }

    public List<Odontologo> findOdontologoEntities(int maxResults, int firstResult) {
        return findOdontologoEntities(false, maxResults, firstResult);
    }

    private List<Odontologo> findOdontologoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Odontologo.class));
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

    public Odontologo findOdontologo(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Odontologo.class, id);
        } finally {
            em.close();
        }
    }

    public int getOdontologoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Odontologo> rt = cq.from(Odontologo.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
