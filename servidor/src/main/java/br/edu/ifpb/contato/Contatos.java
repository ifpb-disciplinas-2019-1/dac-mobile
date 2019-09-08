package br.edu.ifpb.contato;

import java.util.List;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 22/08/2019, 19:56:37
 */
public interface Contatos {

    public Contato novo(Contato contato);

    public List<Contato> todos();

    public Contato buscarPorId(int id);

    public Contato atualizar(Contato contato);

    public void remover(Contato contato);
}
