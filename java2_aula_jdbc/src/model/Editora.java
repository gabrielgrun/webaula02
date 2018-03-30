package model;

public class Editora {
    private int editora_id;
    private String nome_editora;
    private String mun_editora;

    public int getEditora_id() {
        return editora_id;
    }

    public void setEditora_id(int editora_id) {
        this.editora_id = editora_id;
    }

    public String getNome_editora() {
        return nome_editora;
    }

    public void setNome_editora(String nome_editora) {
        this.nome_editora = nome_editora;
    }

    public String getMun_editora() {
        return mun_editora;
    }

    public void setMun_editora(String mun_editora) {
        this.mun_editora = mun_editora;
    }
    
    @Override
    public String toString(){
        return nome_editora + " - " + mun_editora;
    }
}
