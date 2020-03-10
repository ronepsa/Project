package ifba.exemplo.model;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import ifba.exemplo.util.HibernateUtil;

public class UsuarioDAO {
	public List<Usuario>getListarTodos(){
		Session s = HibernateUtil.getSessionFactory().openSession();
		SQLQuery query = s.createSQLQuery("select * from projeto");
		query.addEntity(Usuario.class);
		List<Usuario>lista = query.list();
		s.close();
		return lista;
	}
	
	public static void main (String [] args) {
		UsuarioDAO u = new UsuarioDAO();
		List<Usuario> ul = u.getListarTodos();
		for(Usuario usuario : ul) {
		  System.out.println(usuario.getNm_usuario());
		}
	}
}
