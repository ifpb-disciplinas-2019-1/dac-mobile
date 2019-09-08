package br.edu.ifpb.contato.infra;

import br.edu.ifpb.contato.Contato;
import br.edu.ifpb.contato.Contatos;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 22/08/2019, 20:31:47
 */
@Stateless
public class ContatosEmJPA implements Contatos {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Contato novo(Contato contato) {
        em.persist(contato);
        return contato;
    }

    @Override
    public List<Contato> todos() {
        return em.createQuery("FROM Contato c",Contato.class)
            .getResultList();
    }

    @Override
    public Contato buscarPorId(int id) {
        return em.find(Contato.class,id);
    }

    @Override
    public Contato atualizar(Contato contato) {
        return em.merge(contato);
    }

    @Override
    public void remover(Contato contato) {
        em.remove(
            em.merge(contato)
        );
    }

}

//ionic start agenda tabs

