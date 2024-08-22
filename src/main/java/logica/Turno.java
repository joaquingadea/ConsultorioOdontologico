package logica;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
public class Turno implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_turno; 
    @Temporal(TemporalType.DATE)
    private Date fecha;
    private int hora;
    @ManyToOne
    @JoinColumn(name="id_odontologo")
    private Odontologo docEncargado;
    @ManyToOne
    @JoinColumn(name="id_paciente")
    private Paciente paciente;


    public Turno() {
    }

    public Turno(int id_turno, Date fecha, int hora, Odontologo docEncargado, Paciente paciente) {
        this.id_turno = id_turno;
        this.fecha = fecha;
        this.hora = hora;
        this.docEncargado = docEncargado;
        this.paciente = paciente;
    }
    
    

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Odontologo getDocEncargado() {
        return docEncargado;
    }

    public void setDocEncargado(Odontologo docEncargado) {
        this.docEncargado = docEncargado;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public int getId_turno() {
        return id_turno;
    }

    public void setId_turno(int id_turno) {
        this.id_turno = id_turno;
    }
    
    
}
