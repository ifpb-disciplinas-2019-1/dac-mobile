package br.edu.ifpb.contato.boundary;

import java.io.Serializable;
import javax.ws.rs.FormParam;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 30/08/2019, 09:52:56
 */
public class ContatoPorFormulario implements Serializable {

    @FormParam("nome")
    private String nome;
    @FormParam("sexo")
    private String sexo;

    public ContatoPorFormulario() {
    }

    public ContatoPorFormulario(String nome,String sexo) {
        this.nome = nome;
        this.sexo = sexo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + (this.nome != null ? this.nome.hashCode() : 0);
        hash = 97 * hash + (this.sexo != null ? this.sexo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ContatoPorFormulario other = (ContatoPorFormulario) obj;
        if ((this.nome == null) ? (other.nome != null) : !this.nome.equals(other.nome)) {
            return false;
        }
        if ((this.sexo == null) ? (other.sexo != null) : !this.sexo.equals(other.sexo)) {
            return false;
        }
        return true;
    }

}
