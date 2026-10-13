package com.teacherlandingpage.language_tutor_website.repositories;

import com.teacherlandingpage.language_tutor_website.models.LessonPackage;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface LessonPackageRepository extends JpaRepository<LessonPackage, Long>
{
    List<LessonPackage> findByTargetLanguage(String targetLanguage);
}
