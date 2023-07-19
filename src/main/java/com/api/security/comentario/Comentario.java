package com.api.security.comentario;

import com.api.security.persona.Persona;
import com.api.security.publicacion.Publicacion;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Comentario {
    @Id
    @GeneratedValue
    private int id;
    
    private String autor;
    private String contenido;
    private LocalDateTime fecha;
    private int likes;
    private int dislikes;
    
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "id_persona")
    private Persona persona;
    
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "id_publicacion")
    private Publicacion publicacion;
}