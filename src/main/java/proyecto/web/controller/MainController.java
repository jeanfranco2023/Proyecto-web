package proyecto.web.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import proyecto.web.dto.Login;
import proyecto.web.entity.Usuarios;
import proyecto.web.repository.UsuarioRepository;


@Controller
public class MainController {


    @Autowired
    private UsuarioRepository usuarioRepository;

    private Usuarios usuarioIniciado;


@GetMapping("/index")
    public String verVista(Model model) {
        model.addAttribute("login", new Login());
        return "index";
    }

    @PostMapping("/login")
    public String postMethodName(@ModelAttribute("login") Login  login) {
        System.out.println(login);
        
        Optional<Usuarios> usuarioOptional = usuarioRepository.findByEmail(login.getEmail());

        if(usuarioOptional.isPresent()) {
            Usuarios usuario = usuarioOptional.get();
            String password = usuario.getPassword();

            if(password.equals(login.getPassword())) {
                usuarioIniciado = usuario;
                return "redirect:/principal";
            }
        }

        return "redirect:/index";
    }



    @GetMapping("/registro")
    public String mostrarVistaRegistrarUsuario(Model model) {
        model.addAttribute("usuario", new Usuarios());
        return "registro";
    }

    @PostMapping("/guardar")
    public String registrarUsuario(@ModelAttribute("usuario") Usuarios usuario) {
        try {
            usuarioRepository.save(usuario);
        } catch(Exception e) {
            return "redirect:/registrar";
        }
        
        return "redirect:/index";
    }


    @GetMapping("/principal")
    public String principal(Model model) {
        model.addAttribute("nombreUsuario", usuarioIniciado.getNombre());
        return "principal";
    }

    
}
