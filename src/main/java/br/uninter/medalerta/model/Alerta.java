package br.uninter.medalerta.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Alerta")
public class Alerta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idAlerta")
    private Integer idAlerta;

    @Column(name = "idHorarioMedicamento", nullable = false)
    private Integer idHorarioMedicamento;

    @Column(name = "tempoMinutos", nullable = false)
    private Integer tempoMinutos;

    @Enumerated(EnumType.STRING)
    @Column(name = "statusAlerta", nullable = false)
    private StatusAlerta statusAlerta;

    @Column(name = "ativo")
    private Boolean ativo;

    public Alerta() {
    }

    public Alerta(Integer idHorarioMedicamento, Integer tempoMinutos, StatusAlerta statusAlerta, Boolean ativo) {
        this.idHorarioMedicamento = idHorarioMedicamento;
        this.tempoMinutos = tempoMinutos;
        this.statusAlerta = statusAlerta;
        this.ativo = ativo;
    }

    public Integer getIdAlerta() {
        return idAlerta;
    }

    public Integer getIdHorarioMedicamento() {
        return idHorarioMedicamento;
    }

    public void setIdHorarioMedicamento(Integer idHorarioMedicamento) {
        this.idHorarioMedicamento = idHorarioMedicamento;
    }

    public Integer getTempoMinutos() {
        return tempoMinutos;
    }

    public void setTempoMinutos(Integer tempoMinutos) {
        this.tempoMinutos = tempoMinutos;
    }

    public StatusAlerta getStatusAlerta() {
        return statusAlerta;
    }

    public void setStatusAlerta(StatusAlerta statusAlerta) {
        this.statusAlerta = statusAlerta;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }
}
