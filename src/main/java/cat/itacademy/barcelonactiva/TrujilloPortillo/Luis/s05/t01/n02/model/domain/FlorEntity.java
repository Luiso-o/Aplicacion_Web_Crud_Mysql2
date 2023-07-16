package cat.itacademy.barcelonactiva.TrujilloPortillo.Luis.s05.t01.n02.model.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "Flores")
public class FlorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idFlor")
    private Integer pk_FlorId;

    @Column(name = "nombreFlor")
    private  String nombreFlor;

    @Column(name = "colorFlor")
    private String paisFlor;


    public FlorEntity(){}

    public FlorEntity(String nombreFlor, String paisFlor) {
        this.nombreFlor = nombreFlor;
        this.paisFlor = paisFlor;
    }

    public Integer getPk_FlorId() {
        return pk_FlorId;
    }

    public String getNombreFlor() {
        return nombreFlor;
    }

    public String getPaisFlor() {
        return paisFlor;
    }

    public void setNombreFlor(String nombreFlor) {
        this.nombreFlor = nombreFlor;
    }

    public void setPaisFlor(String paisFlor) {
        this.paisFlor = paisFlor;
    }
}
