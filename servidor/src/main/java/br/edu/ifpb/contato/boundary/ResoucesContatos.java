package br.edu.ifpb.contato.boundary;

import br.edu.ifpb.contato.Contato;
import br.edu.ifpb.contato.application.ServiceDeContatos;
import java.net.URI;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.json.JsonObject;
import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 22/08/2019, 20:41:40
 */
@Stateless
@Path("contatos")
@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
@Consumes(MediaType.APPLICATION_JSON)
public class ResoucesContatos {

    @Inject
    private ServiceDeContatos service;

    @Context
    private UriInfo uriInfo;

    @GET
    public Response todosOsClientes() {
        List<Contato> contato = this.service.todosOsContatos();

        GenericEntity<List<Contato>> entity = new GenericEntity<List<Contato>>(
            contato) {
        };
        return Response.ok()
            .entity(entity)
            .build();
    }

    @GET
    @Path("{id}")
    public Response clienteCPF(@PathParam("id") int id) {
        Contato contato = this.service.localizarContatoComId(id);
        return Response.ok()
            .entity(contato)
            .build();
    }

    @POST
    public Response novo(JsonObject object) {
        Contato contato = this.service.criar(
            object.getString("nome"),
            object.getString("sexo")
        );
        String id = String.valueOf(contato.getId());
        URI uri = uriInfo.getAbsolutePathBuilder()
            .path(id)
            .build();

        return Response.created(uri)
            .entity(contato)
            .build();
    }

    @POST
    @Path("novo")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response novo(
        @BeanParam ContatoPorFormulario cliente) {
        Contato contato = this.service.criar(
            cliente.getNome(),
            cliente.getSexo()
        );
        String id = String.valueOf(contato.getId());
        URI uri = uriInfo.getAbsolutePathBuilder()
            .path(id)
            .build();

        return Response.created(uri)
            .entity(contato)
            .build();
    }

    @POST
    @Path("create")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response novoComFormulario(
        @FormParam("nome") String nome,
        @FormParam("sexo") String sexo
    ) {
        Contato contato = this.service.criar(
            nome,
            sexo
        );
        String id = String.valueOf(contato.getId());
        URI uri = uriInfo.getAbsolutePathBuilder()
            .path(id)
            .build();

        return Response.created(uri)
            .entity(contato)
            .build();
    }

    @DELETE
    @Path("{id}")
    public Response remover(@PathParam("id") int id) {
        this.service.removerContato(id);
        return Response.noContent() // 204 
            .build();
    }

    @PUT
    @Path("{id}")
    public Response atualizar(@PathParam("id") int id,Contato contato) {

        Contato resposta = this.service.atualizarContato(id,contato);

        if (resposta.isEmpty()) {
            return Response.notModified()
                .build();
        } else {
            return Response.ok()
                .entity(resposta)
                .build();
        }
    }
}
