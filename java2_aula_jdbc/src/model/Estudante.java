package model;

import java.sql.Date;

public class Estudante {
    private int estudanteID;
    private String estudanteNome;
    private String cursoNome;
    private Date dataMatricula;
    private String status;

    public int getEstudanteID() {
        return estudanteID;
    }

    public void setEstudanteID(int estudanteID) {
        this.estudanteID = estudanteID;
    }

    public String getEstudanteNome() {
        return estudanteNome;
    }

    public void setEstudanteNome(String estudanteNome) {
        this.estudanteNome = estudanteNome;
    }

    public String getCursoNome() {
        return cursoNome;
    }

    public void setCursoNome(String cursoNome) {
        this.cursoNome = cursoNome;
    }

    public Date getDataMatricula() {
        return dataMatricula;
    }

    public void setDataMatricula(Date dataMatricula) {
        this.dataMatricula = dataMatricula;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
}
