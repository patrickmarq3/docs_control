package br.senac.go.control;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.event.RowEditEvent;

import br.senac.go.entidade.Usuario;
import br.senac.go.persistencia.UsuarioDao;

@ManagedBean
@SessionScoped
public class UsuarioControl implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Usuario usuario = new Usuario(); 
	
	private List<Usuario> selectedUsuarios = new ArrayList<Usuario>();
	
	List<Usuario> usuarios;
	
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
	public void getListagem(){
		usuarios = new ArrayList<Usuario>();
		usuarios = UsuarioDao.listagem();
	}
	public void onRowEdit(RowEditEvent event) {
		UsuarioDao.alterar((Usuario) event.getObject());
		usuario = new Usuario();
    }
	public void excluir() {
		try{
			
			if(!selectedUsuarios.isEmpty()){
				for(Usuario u : selectedUsuarios){
					UsuarioDao.excluir(u);
				}
			}
		}catch(Exception e){
		}
	}

	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	public List<Usuario> getUsuarios() {
		return usuarios;
	}
	public List<Usuario> getSelectedUsuarios() {
		return selectedUsuarios;
	}
	public void setSelectedUsuarios(List<Usuario> selectedUsuarios) {
		this.selectedUsuarios = selectedUsuarios;
	}
}
