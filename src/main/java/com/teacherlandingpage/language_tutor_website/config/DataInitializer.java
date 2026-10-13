package com.teacherlandingpage.language_tutor_website.config;

import ch.qos.logback.core.encoder.JsonEscapeUtil;
import com.teacherlandingpage.language_tutor_website.models.LessonPackage;
import com.teacherlandingpage.language_tutor_website.repositories.LessonPackageRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.util.List;

@Configuration
public class DataInitializer
{
    @Bean
    CommandLineRunner initDatabase(LessonPackageRepository repository)
    {
        return args ->
        {
            if (repository.count() == 0)
            {
                repository.saveAll( List.of (
                    new LessonPackage( "Beginner Spanish Lessons", "SPANISH", "Learn the basics", new BigDecimal("30.00") ),
                    new LessonPackage( "Intermediate Spanish Lessons", "SPANISH", "Improve your skills", new BigDecimal("30.00") ),
                    new LessonPackage( "Advanced Spanish Lessons", "SPANISH", "Master the language", new BigDecimal("35.00") ),
                    new LessonPackage( "Conversational Spanish", "SPANISH", "Practice speaking", new BigDecimal("35.00") ),
                    new LessonPackage( "Inglés para principiantes", "ENGLISH", "Aprende lo básico", new BigDecimal("25.00") ),
                    new LessonPackage( "Inglés intermedio", "ENGLISH", "Mejora tus habilidades", new BigDecimal("25.00") ),
                    new LessonPackage( "Inglés avanzado", "ENGLISH", "Domina el idioma", new BigDecimal("30.00") ),
                    new LessonPackage( "Inglés conversacional", "ENGLISH", "Practica hablar", new BigDecimal("30.00") )
                ) );
                System.out.println(">>> Sample lesson packages have been initialized in the database.");
            }
        };
    }
}
