package com.crunchify.jsp.servlet;
 
import edu.co.sergio.mundo.dao.DepartamentoDAO;
import edu.co.sergio.mundo.vo.Obra;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import javax.servlet.RequestDispatcher;
 
/**
 * @author Crunchify.com
 */
 
public class HelloCrunchify extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // reading the user input
        String user = request.getParameter("user");
        String nombre = request.getParameter("nombre");
        String descripcion = request.getParameter("descripcion");
        String estilo = request.getParameter("estilo");
        int valor= Integer.parseInt(request.getParameter("valor"));
        
        //Se debe incluir validaciones - Lo recuerda: Gestion de Excepciones.
        DepartamentoDAO dao = new DepartamentoDAO();
        
        Obra obra = new Obra();
        obra.setUsuario(user);
        obra.setNombreObra(nombre);
        obra.setDescp(descripcion);
        obra.setEstilo(estilo);
        obra.setValor(valor);
        dao.insert(obra);
        
        //Listando la informacion  
//        List<Departamento> departamentos =  dao.findAll();
//        request.setAttribute("departamentos", departamentos);
       
       
        //Redireccionando la informacion
        RequestDispatcher redireccion = request.getRequestDispatcher("index.jsp");
        redireccion.forward(request, response);
        
        
        }
}
