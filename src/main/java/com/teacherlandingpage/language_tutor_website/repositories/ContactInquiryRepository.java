package com.teacherlandingpage.language_tutor_website.repositories;

import com.teacherlandingpage.language_tutor_website.models.ContactInquiry;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContactInquiryRepository extends JpaRepository<ContactInquiry, Long>
{
    // Fetch all inquiries ordered by submission date in descending order
    List<ContactInquiry> findAllByOrderByCreateAtDesc();
}