package com.teacherlandingpage.language_tutor_website.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MethodologyController {

    @GetMapping("/methodology")
    public String showMethodologyPage(
            @RequestParam(name = "lang", required = false, defaultValue = "ENGLISH") String lang,
            Model model) {

        String targetLang = (lang != null && lang.equalsIgnoreCase("SPANISH")) ? "SPANISH" : "ENGLISH";
        boolean isEnglishCourse = "ENGLISH".equalsIgnoreCase(targetLang);

        model.addAttribute("targetLanguage", targetLang);
        model.addAttribute("isEnglishCourse", isEnglishCourse);
        model.addAttribute("navBack", isEnglishCourse ? "Volver a Ver Clases" : "Back to Lessons");

        return "methodology";
    }
}
