package model;

import java.sql.Date;

public class Emprestimo {
    private int emprestimo_id;
    private Livro livro_id;
    private Estudante estudante_id;
    private Date data_retirada;
    private Date data_devolucao;
    private Date data_entrega;
    private String status;

    public int getEmprestimo_id() {
        return emprestimo_id;
    }

    public void setEmprestimo_id(int emprestimo_id) {
        this.emprestimo_id = emprestimo_id;
    }

    public Livro getLivro_id() {
        return livro_id;
    }

    public void setLivro_id(Livro livro_id) {
        this.livro_id = livro_id;
    }

    public Estudante getEstudante_id() {
        return estudante_id;
    }

    public void setEstudante_id(Estudante estudante_id) {
        this.estudante_id = estudante_id;
    }

    public Date getData_retirada() {
        return data_retirada;
    }

    public void setData_retirada(Date data_retirada) {
        this.data_retirada = data_retirada;
    }

    public Date getData_devolucao() {
        return data_devolucao;
    }

    public void setData_devolucao(Date data_devolucao) {
        this.data_devolucao = data_devolucao;
    }

    public Date getData_entrega() {
        return data_entrega;
    }

    public void setData_entrega(Date data_entrega) {
        this.data_entrega = data_entrega;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
}
