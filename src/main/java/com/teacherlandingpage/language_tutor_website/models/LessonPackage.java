package com.teacherlandingpage.language_tutor_website.models;

import jakarta.persistence.*;
import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Entity
@Table( name = "lesson_packages" )
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LessonPackage
{
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long id;

    private String title;

    // "ENGLISH" OR "SPANISH"
    private String targetLanguage;

    @Column( length = 1000 )
    private String description;

    private BigDecimal hourlyRate;

    // Custom constructor without id
    public LessonPackage(String title, String targetLanguage, String description, BigDecimal hourlyRate)
    {
        this.title = title;
        this.targetLanguage = targetLanguage;
        this.description = description;
        this.hourlyRate = hourlyRate;
    }
}


