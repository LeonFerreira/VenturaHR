package br.edu.infnet.infra.usuarios;

import br.edu.infnet.domain.usuarios.Usuario;
import javax.persistence.Entity;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;

public class UsuarioService {
    
    private final String REST_URI = "http://localhost:8081/usuarios";
    private final Client client = ClientBuilder.newClient();
    
    public Usuario obterPorEmail(String email){
        
        return client
                .target(REST_URI)
                .path("email")
                .path(email)
                .request(MediaType.APPLICATION_JSON)
                .get(Usuario.class);
    }
    
    public Usuario criarConta (Usuario usuario) {
        
        return client
                .target(REST_URI)
                .request(MediaType.APPLICATION_JSON)
                .post(Entity.entity(usuario, MediaType.APPLICATION_JSON), Usuario.class);
    }
}