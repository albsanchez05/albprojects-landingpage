package com.teacherlandingpage.language_tutor_website.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LevelController {

    @GetMapping("/levels/{levelCode}")
    public String showLevelDetail(
            @PathVariable("levelCode") String levelCode,
            @RequestParam(name = "lang", required = false, defaultValue = "ENGLISH") String lang,
            Model model
    ) {
        String targetLang = (lang != null && lang.equalsIgnoreCase("SPANISH")) ? "SPANISH" : "ENGLISH";
        boolean isEnglishCourse = "ENGLISH".equalsIgnoreCase(targetLang);

        String normalizedCode = (levelCode != null) ? levelCode.toLowerCase().trim() : "basico";

        model.addAttribute("levelCode", normalizedCode);
        model.addAttribute("targetLanguage", targetLang);
        model.addAttribute("isEnglishCourse", isEnglishCourse);
        model.addAttribute("navBack", isEnglishCourse ? "Volver a Clases" : "Back to Lessons");

        return "level-detail";
    }
}