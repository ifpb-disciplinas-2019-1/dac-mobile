package br.edu.ifpb.contato;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 22/08/2019, 19:36:56
 */
@Entity
public class Contato implements Serializable {

    @Id
    @GeneratedValue
    private int id;
    private String nome;
    private String foto;
    private String sexo;
    // POST /
    // GET /
    // GET /{id}
    // PUT /{id}
    // DELETE /{id}
    public Contato() {
    }

    public Contato(String nome,String sexo) {
        this.nome = nome;
        this.sexo = sexo;
    }

    public static Contato empty() {
        Contato contato = new Contato(
            "contato",
            "men"
        );
        return contato;
    }

    public boolean isEmpty() {
        return this.equals(
            empty()
        );
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFoto() {
        return String.format("https://randomuser.me/api/portraits/%s/%d.jpg",sexo,id);
//                "large": "https://randomuser.me/api/portraits/men/47.jpg"
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 43 * hash + Objects.hashCode(this.id);
        hash = 43 * hash + Objects.hashCode(this.nome);
        hash = 43 * hash + Objects.hashCode(this.foto);
        hash = 43 * hash + Objects.hashCode(this.sexo);
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
        final Contato other = (Contato) obj;
        if (!Objects.equals(this.id,other.id)) {
            return false;
        }
        if (!Objects.equals(this.nome,other.nome)) {
            return false;
        }
        if (!Objects.equals(this.foto,other.foto)) {
            return false;
        }
        if (!Objects.equals(this.sexo,other.sexo)) {
            return false;
        }
        return true;
    }

}

//        public uuid?:number,
//        public nome?:string,
//        public foto?:string,
//        public sexo?:string

