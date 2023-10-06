
package com.api.security.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
public class DemoController {
    @PreAuthorize("hasRole('ADMIN') or hasRole(['ADM)")
    @GetMapping("/hola")
    public ResponseEntity<String> pruebaDemo(){
        return ResponseEntity.ok("HOLA DESDE DEMOCONTROLLER!");
    }
}
