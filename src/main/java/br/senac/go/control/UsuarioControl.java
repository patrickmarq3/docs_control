package br.senac.go.control;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.senac.go.entidade.Usuario;
import br.senac.go.persistencia.UsuarioDao;

@ManagedBean
@SessionScoped
public class UsuarioControl implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Usuario usuario = new Usuario(); 
	
	public String incluir(){
		
		if(usuario.getId() != 0){
			
			UsuarioDao.alterar(usuario);
			usuario = new Usuario();
			return "cadastro_usuario.xhtml";			
		}else{
			
			UsuarioDao.inserir(usuario);
			usuario = new Usuario();
			return "cadastro_usuario.xhtml";
		}
		
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
