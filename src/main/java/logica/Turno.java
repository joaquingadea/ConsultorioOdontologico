package logica;
import java.util.Date;

public class Turno {
    private int id;
    private Odontologo docEncargado;
    private Date fecha;

    public Turno() {
    }

    public Turno(int id, Odontologo docEncargado, Date fecha) {
        this.id = id;
        this.docEncargado = docEncargado;
        this.fecha = fecha;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Odontologo getDocEncargado() {
        return docEncargado;
    }

    public void setDocEncargado(Odontologo docEncargado) {
        this.docEncargado = docEncargado;
    }
    
    
}
