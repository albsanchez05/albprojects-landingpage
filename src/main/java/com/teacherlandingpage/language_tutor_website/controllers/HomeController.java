package com.teacherlandingpage.language_tutor_website.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import com.teacherlandingpage.language_tutor_website.repositories.LessonPackageRepository;

@Controller
public class HomeController
{

    private final LessonPackageRepository lessonPackageRepository;

    // Constructor injection for LessonPackageRepository
    public HomeController(LessonPackageRepository lessonPackageRepository)
    {
        this.lessonPackageRepository = lessonPackageRepository;
    }

    @GetMapping( "/" )
    public String index() {
        return "index";
    }

    @GetMapping( "/learn-english" )
    public String learnEnglish( Model model )
    {
        model.addAttribute("packages", lessonPackageRepository.findByTargetLanguage("ENGLISH"));
        model.addAttribute("pageTitle", "Aprende Inglés - Cursos y Tarifas");
        model.addAttribute("bannerSubtitle", "Clases personalizadas adaptadas a tus objetivos profesionales y personales.");
        model.addAttribute("navBack", "← Volver a la selección de idioma");
        model.addAttribute("packagesHeader", "Planes de Clases Disponibles");
        model.addAttribute("rateSuffix", " / hora");
        model.addAttribute("contactBtnText", "Consultar disponibilidad");
        model.addAttribute("ctaTitle", "¿Listo para empezar a aprender?");
        model.addAttribute("ctaSubtitle", "Ponte en contacto para consultar horarios y personalizar tu plan de clases.");
        model.addAttribute("ctaBtnText", "Consultar disponibilidad de clases");
        model.addAttribute("targetLanguage", "ENGLISH");
        return "lessons";
    }

    @GetMapping( "/learn-spanish" )
    public String learnSpanish( Model model )
    {
        model.addAttribute("packages", lessonPackageRepository.findByTargetLanguage("SPANISH"));
        model.addAttribute("pageTitle", "Learn Spanish - Courses & Rates");
        model.addAttribute("bannerSubtitle", "Tailored 1-on-1 language coaching designed for fast conversational fluency.");
        model.addAttribute("navBack", "← Back to Language Selection");
        model.addAttribute("packagesHeader", "Available Packages");
        model.addAttribute("rateSuffix", " / hr");
        model.addAttribute("contactBtnText", "Contact for Availability");
        model.addAttribute("ctaTitle", "Ready to start learning?");
        model.addAttribute("ctaSubtitle", "Get in touch to discuss schedule availability and lesson customization.");
        model.addAttribute("ctaBtnText", "Contact for Lesson Availability");
        model.addAttribute("targetLanguage", "SPANISH");
        return "lessons";
    }
}
