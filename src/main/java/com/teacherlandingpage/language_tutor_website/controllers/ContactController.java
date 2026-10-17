package com.teacherlandingpage.language_tutor_website.controllers;

import com.teacherlandingpage.language_tutor_website.models.ContactInquiry;
import com.teacherlandingpage.language_tutor_website.repositories.ContactInquiryRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ContactController {

    private final ContactInquiryRepository contactInquiryRepository;

    public ContactController(ContactInquiryRepository contactInquiryRepository) {
        this.contactInquiryRepository = contactInquiryRepository;
    }

    @GetMapping("/contact")
    public String showContactForm(@RequestParam(name = "lang", required = false, defaultValue = "ENGLISH") String lang, Model model) {
        // Normalize language parameter safely
        String targetLang = (lang != null && lang.equalsIgnoreCase("SPANISH")) ? "SPANISH" : "ENGLISH";
        boolean isEnglishCourse = "ENGLISH".equalsIgnoreCase(targetLang);

        if (!model.containsAttribute("inquiry")) {
            ContactInquiry inquiry = new ContactInquiry();
            inquiry.setTargetLanguage(targetLang);
            model.addAttribute("inquiry", inquiry);
        }

        // Add both targetLanguage and isEnglishCourse so all HTML template checks work
        model.addAttribute("targetLanguage", targetLang);
        model.addAttribute("isEnglishCourse", isEnglishCourse);

        // Localized UI Labels based on target course language
        model.addAttribute("navBack", isEnglishCourse ? "← Volver a Ver Clases" : "← Back to Lessons");
        model.addAttribute("formTitle", isEnglishCourse ? "Contacto y Disponibilidad de Clases" : "Contact & Lesson Availability");
        model.addAttribute("formSubtitle", isEnglishCourse ?
                "Rellena el siguiente formulario para consultar la disponibilidad de horarios o personalizar tu plan de clases." :
                "Fill out the form below to inquire about schedule availability or customized lesson plans.");
        model.addAttribute("labelName", isEnglishCourse ? "Tu Nombre" : "Your Name");
        model.addAttribute("labelEmail", isEnglishCourse ? "Correo Electrónico" : "Email Address");
        model.addAttribute("labelPhone", isEnglishCourse ? "Número de Teléfono / Móvil" : "Mobile / Phone Number");
        model.addAttribute("labelLanguage", isEnglishCourse ? "Idioma que quieres aprender" : "Language You Want to Learn");
        model.addAttribute("labelMessage", isEnglishCourse ? "Tu Mensaje / Objetivos" : "Your Message / Goals");
        model.addAttribute("placeholderName", isEnglishCourse ? "ej. Juan Pérez" : "e.g. Jane Doe");
        model.addAttribute("placeholderPhone", isEnglishCourse ? "ej. +34 600 000 000" : "e.g. +1 555 123 4567");
        model.addAttribute("placeholderMessage", isEnglishCourse ?
                "Cuéntame un poco sobre tu nivel actual, objetivos y disponibilidad de horarios..." :
                "Tell me a bit about your current level, goals, and preferred learning schedule...");
        model.addAttribute("submitBtnText", isEnglishCourse ? "Enviar Consulta" : "Send Inquiry");

        return "contact";
    }

    @PostMapping("/contact")
    public String processContactForm(
            @Valid @ModelAttribute("inquiry") ContactInquiry inquiry,
            BindingResult bindingResult,
            RedirectAttributes redirectAttributes,
            Model model
    ) {
        // Fallback to ENGLISH if targetLanguage is null
        String targetLang = (inquiry.getTargetLanguage() != null && inquiry.getTargetLanguage().equalsIgnoreCase("SPANISH")) ? "SPANISH" : "ENGLISH";
        inquiry.setTargetLanguage(targetLang);

        if (bindingResult.hasErrors()) {
            return showContactForm(targetLang, model);
        }

        contactInquiryRepository.save(inquiry);

        boolean isEnglishCourse = "ENGLISH".equalsIgnoreCase(targetLang);
        String successMessage = isEnglishCourse ?
                "¡Gracias! Tu mensaje ha sido enviado exitosamente. Me pondré en contacto contigo pronto." :
                "Thank you! Your message has been sent successfully. I will get back to you shortly.";
        redirectAttributes.addFlashAttribute("successMessage", successMessage);

        return "redirect:/contact?lang=" + targetLang;
    }
}