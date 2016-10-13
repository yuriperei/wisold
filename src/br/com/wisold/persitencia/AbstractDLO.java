package br.com.wisold.persitencia;

import java.util.List;

import br.com.wisold.usuarios.Usuario;

public interface AbstractDLO<Object> {
	
	Object buscarPorId(Long id, Usuario usuario);
	List<Object> listar(Usuario usuario);
	void manter(Object t);
	boolean excluir(Long id, Usuario usuario);

}
