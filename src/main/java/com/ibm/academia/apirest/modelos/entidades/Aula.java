package com.ibm.academia.apirest.modelos.entidades;

import com.ibm.academia.apirest.enumeradores.TipoPizarron;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@Entity
//@Table(name = "aulas", schema = "universidad")
@Table(name = "aulas")
public class Aula implements Serializable {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "numero_aula")
    private Integer numeroAula;

    @Column(name = "metros_cuadrados")
    private Double metros_cuadrados;

    @Column(name = "cantidad_pupitres")
    private Integer cantidadPupitres;

    @Column(name = "tipo_pizarron")
    @Enumerated(EnumType.STRING)
    private TipoPizarron tipoPizarron;

    @ManyToOne(optional = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "pabellon_id", foreignKey = @ForeignKey(name = "FK_PABELLON_ID"))
    private Pabellon pabellon;

    @Column(name = "usuario_creacion", nullable = false)
    private String usuarioCreacion;

    @Column(name = "fecha_creacion", nullable = true)
    private Date fechaCreacion;

    @Column(name = "fecha_modificacion", nullable = true)
    private Date fechaModificacion;

    public Aula(Long id, Integer numeroAula, Double metros_cuadrados, Integer cantidadPupitres, TipoPizarron tipoPizarron, Pabellon pabellon, String usuarioCreacion) {
        this.id = id;
        this.numeroAula = numeroAula;
        this.metros_cuadrados = metros_cuadrados;
        this.cantidadPupitres = cantidadPupitres;
        this.tipoPizarron = tipoPizarron;
        this.pabellon = pabellon;
        this.usuarioCreacion = usuarioCreacion;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Aula{");
        sb.append("id=").append(id);
        sb.append(", numeroAula='").append(numeroAula).append('\'');
        sb.append(", metros_cuadrados='").append(metros_cuadrados).append('\'');
        sb.append(", cantidadPupitres='").append(cantidadPupitres).append('\'');
        sb.append(", tipoPizarron=").append(tipoPizarron);
        sb.append(", pabellon=").append(pabellon);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Aula aula = (Aula) o;
        return id.equals(aula.id) && numeroAula.equals(aula.numeroAula);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, numeroAula);
    }

    @PrePersist
    private void antesPersistir(){
        this.fechaCreacion = new Date();
    }

    @PreUpdate
    private void antesActualizar(){
        this.fechaModificacion = new Date();
    }
}
