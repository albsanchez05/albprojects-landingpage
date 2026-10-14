package com.teacherlandingpage.language_tutor_website.controllers;

import com.teacherlandingpage.language_tutor_website.repositories.ContactInquiryRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController
{
    private ContactInquiryRepository contactInquiryRepository;

    public AdminController(ContactInquiryRepository contactInquiryRepository)
    {
        this.contactInquiryRepository = contactInquiryRepository;
    }

    @GetMapping("/inquiries")
    public String viewInquiries( Model model )
    {
        model.addAttribute("inquiries", contactInquiryRepository.findAllByOrderByCreateAtDesc());
        model.addAttribute( "totalInquiries", contactInquiryRepository.count() );
        return "admin-inquiries";
    }
}
