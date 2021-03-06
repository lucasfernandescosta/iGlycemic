package br.univille.iglycemic.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.iglycemic.model.Usuario;
import br.univille.iglycemic.repository.UsuarioRepository;
import br.univille.iglycemic.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository repository;
    
    @Override
    public void save(Usuario usuario) {
        Optional <Usuario> antigoUsuario = repository.findById(usuario.getId());
        if(antigoUsuario.isPresent()){
            usuario.setSenha(antigoUsuario.get().getSenha());
        }
        repository.save(usuario);
    }

    @Override
    public void delete(Usuario usuario) {
        repository.delete(usuario);
    }

    @Override
    public List<Usuario> getAll() {
        return repository.findAll();
    }
}