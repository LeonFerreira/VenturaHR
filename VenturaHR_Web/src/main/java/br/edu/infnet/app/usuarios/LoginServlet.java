
package br.edu.infnet.app.usuarios;

import br.edu.infnet.domain.usuarios.Usuario;
import br.edu.infnet.infra.usuarios.UsuarioService;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/usuarios/login"})
public class LoginServlet extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String email = request.getRemoteUser();
        UsuarioService us = new UsuarioService();
        Usuario usuario = us.obterPorEmail(email);
        request.setAttribute("usuario", usuario);
        
        String caixaEntrada = "";
        if (request.isUserInRole("empresa")){
            caixaEntrada = "/empresas/index.jsp";
        } else if(request.isUserInRole("candidato")){
            caixaEntrada = "/candidatos/index.jsp";
        } else {
            caixaEntrada = "/administradores/index.jsp";
        }
        
        RequestDispatcher rd = request.getRequestDispatcher(caixaEntrada);
        rd.forward(request, response);
        
    }
    
}