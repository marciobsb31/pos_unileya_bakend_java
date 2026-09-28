package br.com.unicar;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Path("/carros")
@Produces(MediaType.APPLICATION_JSON)

public class CarroResource {

    @Inject
    CarroService carroService;

    @GET
    @Path("/disponiveis")
    public List<Carro> getCarrosDisponiveis() {
        return carroService.listarDisponiveis();
    }

    @POST
    @Path("/alugar/{placa}")
    public Response alugarCarro(@PathParam("placa") String placa) {
        boolean sucesso = carroService.alugarCarro(placa);
        if (sucesso) {
            return Response.ok("Carro com placa " + placa + " alugado com sucesso!").build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Carro indisponível para aluguel ou não encontrado.")
                    .build();
        }
    }
}
