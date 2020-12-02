package com.proyecto.compras;

import com.proyecto.compras.model.ResetToken;
import com.proyecto.compras.model.Usuario;
import com.proyecto.compras.service.ILoginService;
import com.proyecto.compras.service.IResetTokenService;

import com.proyecto.compras.util.EmailUtil;
import com.proyecto.compras.util.Mail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private  ILoginService loginService;

    @Autowired
    private  IResetTokenService tokenService;

    @Autowired
    private  BCryptPasswordEncoder bcrypt;

    @Autowired
    private  EmailUtil emailUtil;

    @PostMapping(value = "/enviarCorreo", consumes = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<Integer> enviarCorreo(@RequestBody String correo){
        int res = 0;

        try {
            Usuario usuario = loginService.verificarUsername(correo);
            if (usuario != null && usuario.getId() > 0){
                ResetToken token = new ResetToken();
                token.setToken(UUID.randomUUID().toString());
                token.setUser(usuario);
                token.setExpiracion(10);
                tokenService.guardar(token);

                Mail mail =  new Mail();
                mail.setFrom("pruebas.compras@gmail.com");
                mail.setTo(usuario.getUsername());
                mail.setSubject("Restablecer Contrasena - Compras");

                Map<String, Object> model = new HashMap<>();
                String url = "https://localhost:4200/recuperar/"+ token.getToken();
                model.put("user", token.getUser().getUsername());
                model.put("resetUrl", url);
                mail.setModel(model);
                emailUtil.enviarMail(mail);
                res =1;

            }
        }catch (Exception e){
            return  new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(res,HttpStatus.OK);
    }

    @GetMapping("/restablecer/verificar/{token}")
    public ResponseEntity<Integer> restablecerPassword(@PathVariable("token") String token){
        int res = 0;
        try {
            if (token != null && token.isEmpty()){
                ResetToken resetToken = tokenService.findByToken(token);
                if (resetToken != null && resetToken.getId() > 0){
                    if (!resetToken.estaExpirado()){
                        res = 1;
                    }
                }
            }
        }catch (Exception e){
            return new ResponseEntity<>(res,HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(res,HttpStatus.OK);
    }

    @PostMapping(value = "/restablecer/{token}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Integer> restablecerClave(@PathVariable("token") String token, @RequestBody String clave ) {
        int res = 0;
        try {
            ResetToken rt = tokenService.findByToken(token);
            String claveHash = bcrypt.encode(clave);
            res = loginService.cambiarClave(claveHash, rt.getUser().getUsername());
            tokenService.eliminar(rt);
        } catch (Exception e) {
            return new ResponseEntity<Integer>(res, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Integer>(res, HttpStatus.OK);
    }


}
