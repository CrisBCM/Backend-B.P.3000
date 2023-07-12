package com.api.security.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
@CrossOrigin
public class AuthenticationController {
    
    private final AuthenticationService authService;
    
    @PostMapping("/registrar")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody RegisterRequest request
    ){
        
        if(authService.existsByEmail(request.getEmail()))
            return new ResponseEntity("El Email ya existe", HttpStatus.BAD_REQUEST);
        if(authService.existsByNombreUsuario(request.getNombreUsuario()))
            return new ResponseEntity("El nombre de usuario ya existe", HttpStatus.BAD_REQUEST);
        
        return ResponseEntity.ok(authService.register(request));
    }
    @PostMapping("/iniciar-sesion")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody AuthenticationRequest request
    ){
        
        if(!authService.existsByEmail(request.getEmail())){
            return new ResponseEntity("Email no registrado!", HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(authService.authenticate(request));
    }
}
