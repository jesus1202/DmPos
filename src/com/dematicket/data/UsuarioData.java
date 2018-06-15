/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dematicket.data;

import com.dematicket.bean.Usuario;
import com.dematicket.bean.UsuarioVO;
import javax.swing.JOptionPane;

/**
 *
 * @author lmonge
 */
public class UsuarioData {

    static Usuario usuario;
    static UsuarioVO usuarioVO;
    
    public static Usuario getUsuario(){
        if(usuario==null){
            usuario = new Usuario();
        }
        return usuario;
    }
    public static UsuarioVO getUsuarioBD(String usuario, String password){
        UsuarioDAO miusuarioDAO = new UsuarioDAO();
        usuarioVO = miusuarioDAO.consultarUsuario(usuario, password);
      return usuarioVO;
    }
    
    public static UsuarioVO updateInsertUsuarioBD(String usuario, String password, String empresa, String perfil, String email, String nombres, String tienda, String estado){
        UsuarioDAO miusuarioDAO = new UsuarioDAO();
        miusuarioDAO.ingresarUsuario(usuario, password, empresa, perfil,email, nombres,tienda,estado);
      return usuarioVO;
    }
    public static void changePassBD(String usuario, String password, String newPassword){
        UsuarioDAO miusuarioDAO = new UsuarioDAO();
        miusuarioDAO.cambiarClaveUsuario(usuario, password, newPassword);
      //return usuarioVO;
    }
    
}
