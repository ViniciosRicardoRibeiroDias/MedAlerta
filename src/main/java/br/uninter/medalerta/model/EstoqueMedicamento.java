package br.uninter.medalerta.model;

import jakarta.persistence.*;

@Entity
@Table(name = "EstoqueMedicamento") // Alinhado com o seu CREATE TABLE
public class EstoqueMedicamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idEstoque")
    private Integer idEstoque;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idPrescricao", nullable = false) // Removido o acento
    private Prescricao prescricao; // Corrigido o nome da variável (tinha um erro de digitação)

    @Column(nullable = false)
    private Integer quantidadeTotal;

    @Column(nullable = false)
    private Integer quantidadeAtual;

    public EstoqueMedicamento() {
    }

    public Integer getIdEstoque() {
        return idEstoque;
    }

    public void setIdEstoque(Integer idEstoque) {
        this.idEstoque = idEstoque;
    }

    // Corrigido: O tipo deve ser Prescricao e o nome do método também
    public Prescricao getPrescricao() {
        return prescricao;
    }

    public void setPrescricao(Prescricao prescricao) {
        this.prescricao = prescricao;
    }

    public Integer getQuantidadeTotal() {
        return quantidadeTotal;
    }

    public void setQuantidadeTotal(Integer quantidadeTotal) {
        this.quantidadeTotal = quantidadeTotal;
    }

    public Integer getQuantidadeAtual() {
        return quantidadeAtual;
    }

    public void setQuantidadeAtual(Integer quantidadeAtual) {
        this.quantidadeAtual = quantidadeAtual;
    }

    @Override
    public String toString() {
        return "EstoqueMedicamento{" +
                "idEstoque=" + idEstoque +
                ", quantidadeTotal=" + quantidadeTotal +
                ", quantidadeAtual=" + quantidadeAtual +
                '}';
    }
}
