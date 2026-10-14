package com.teacherlandingpage.language_tutor_website.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "contact_inquiries")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ContactInquiry
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Please enter your name / Por favor ingresa tu nombre")
    @Size(min = 2, max = 100, message = "Student name must be between 2 and 100 characters / El nombre del estudiante debe tener entre 2 y 100 caracteres")
    private String studentName;

    @NotBlank(message = "Please enter your email address / Por favor ingresa tu correo")
    @Email(message = "Please enter a valid email address / Ingresa un correo válido")
    private String email;

    @NotBlank(message = "Target language is required / El idioma objetivo es obligatorio")
    private String targetLanguage; // "ENGLISH" OR "SPANISH"

    @NotBlank(message = "Please enter your mobile/phone number / Por favor ingresa tu número de teléfono")
    @Pattern(
        regexp = "^[0-9+ \\-()]+$",
        message = "Phone number must contain only digits / El teléfono solo debe contener números"
    )
    private String phoneNumber;

    @NotBlank(message = "Please enter a short message / Por favor ingresa un mensaje corto")
    @Size(min = 10, max = 2000, message = "Message must be between 10 and 2000 characters / El mensaje debe tener entre 10 y 2000 caracteres")
    @Column(length = 2000)
    private String message;

    @Column( nullable = false, updatable = false )
    private LocalDateTime createAt;

    // Automatically set createAt before persisting
    @PrePersist
    private void onCreate()
    {
        createAt = LocalDateTime.now();
    }

    // Custom constructor without id and createAt
    public ContactInquiry(String studentName, String email, String targetLanguage, String phoneNumber, String message)
    {
        this.studentName = studentName;
        this.email = email;
        this.targetLanguage = targetLanguage;
        this.phoneNumber = phoneNumber;
        this.message = message;
    }
}
