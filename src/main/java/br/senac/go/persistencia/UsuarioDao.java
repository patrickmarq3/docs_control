package br.senac.go.persistencia;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.senac.go.entidade.Usuario;
import br.senac.go.util.HibernateUtil;

public class UsuarioDao implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public static void inserir (Usuario usuario){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction t = sessao.beginTransaction();
		sessao.save(usuario);
		t.commit();
		sessao.close();
	}
	public static void alterar (Usuario usuario){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction t = sessao.beginTransaction();
		sessao.update(usuario);
		t.commit();
		sessao.close();
	}
	public static void excluir (Usuario usuario){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction t = sessao.beginTransaction();
		sessao.delete(usuario);
		t.commit();
	}
	@SuppressWarnings("unchecked")
	public static List<Usuario> listagem(){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Query consulta = sessao.createQuery("from Usuario");
		return consulta.list();
	}
	public static Usuario pesqId(int id){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Query consulta = sessao.createQuery("from Usuario where codigo = :parametro");
		consulta.setInteger("parametro", id);
		return (Usuario)consulta.uniqueResult();
	}
}
