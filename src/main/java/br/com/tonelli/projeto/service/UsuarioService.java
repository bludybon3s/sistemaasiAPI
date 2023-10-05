package br.com.tonelli.projeto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tonelli.projeto.dto.UsuarioDTO;
import br.com.tonelli.projeto.entity.UsuarioEntity;
import br.com.tonelli.projeto.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public List<UsuarioDTO> ListarTodos(){
		List<UsuarioEntity> usuarios = usuarioRepository.findAll();
		return usuarios.stream().map(UsuarioDTO::new).toList();
	}
	
	public void inserir(UsuarioDTO usuario) {
		UsuarioEntity usuarioEntity = new UsuarioEntity(usuario);
		usuarioRepository.save(usuarioEntity);
	}
	
	public UsuarioDTO alterar(UsuarioDTO usuario) {
		UsuarioEntity usuarioEntity = new UsuarioEntity(usuario);
		return new UsuarioDTO(usuarioRepository.save(usuarioEntity));
	}
	public void excluir(Long id) {	
		UsuarioEntity usuario = usuarioRepository.findById(id).get();
		usuarioRepository.delete(usuario);
		
	}
}
