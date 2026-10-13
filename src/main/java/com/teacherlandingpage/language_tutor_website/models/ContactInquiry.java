package com.teacherlandingpage.language_tutor_website.models;

import jakarta.persistence.*;
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

    private String studentName;
    private String email;
    private String targetLanguage; // "ENGLISH" OR "SPANISH"

    @Column(length = 2000)
    private String message;

    private LocalDateTime createAt;

    // Custom constructor without id and createAt
    public ContactInquiry(String studentName, String email, String targetLanguage, String message)
    {
        this.studentName = studentName;
        this.email = email;
        this.targetLanguage = targetLanguage;
        this.message = message;
    }
}
