package br.edu.ifpb.contato.application;

import br.edu.ifpb.contato.Contato;
import br.edu.ifpb.contato.Contatos;
import java.util.List;
import java.util.Objects;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 22/08/2019, 20:38:40
 */
@Stateless
public class ServiceDeContatos {

    @Inject
    private Contatos contatos;

    public Contato criar(String nome,String sexo) {
        Objects.requireNonNull(nome,"Nome precisa ser preenchido");
        Objects.requireNonNull(sexo,"Sexo precisa ser preenchido");
        Contato contato = new Contato(nome,sexo);
        return this.contatos.novo(contato);
    }

    public List<Contato> todosOsContatos() {
        return this.contatos.todos();
    }

    public Contato localizarContatoComId(int id) {
        Objects.requireNonNull(id,"Identificador precisa ser preenchido");
        Contato contato = this.contatos.buscarPorId(id);

        if (contato == null) {
            return Contato.empty();
        }
        return contato;
    }

    public Contato atualizarContato(int id,Contato contato) {
        Objects.requireNonNull(id,"Identificador precisa ser preenchido");
        Contato contatoRetorno = localizarContatoComId(id);
        if (contatoRetorno.isEmpty()) {
            return Contato.empty();
        }
        contato.setId(id);
        this.contatos.atualizar(contato);
        // recurso atualizado
        return localizarContatoComId(id);
    }

    public void removerContato(int identificador) {
        Objects.requireNonNull(identificador,"Identificador precisa ser preenchido");
        Contato contato = localizarContatoComId(identificador);
        if (contato.isEmpty()) {
            return;
        }
        this.contatos.remover(contato);
    }

}
