package projeto.lic.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import projeto.lic.model.Usuario;

public class ControleUsuario{
    List<Usuario> usuarios = new ArrayList<>();
    public Boolean salvar(Usuario usuario){
        return usuarios.add(usuario);
    }
    public Usuario procuraCpf(String cpf){
        for(Usuario usuario: usuarios) {
            if (usuario.getCpf().equalsIgnoreCase(cpf)) {
                return usuario;
            }
        }
        return null;
    }

}
