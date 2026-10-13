package com.teacherlandingpage.language_tutor_website.repositories;

import com.teacherlandingpage.language_tutor_website.models.ContactInquiry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactInquiryRepository extends JpaRepository<ContactInquiry, Long>
{
}