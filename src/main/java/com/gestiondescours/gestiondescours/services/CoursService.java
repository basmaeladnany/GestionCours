package com.gestiondescours.gestiondescours.services;

import com.gestiondescours.gestiondescours.models.Cours;
import com.gestiondescours.gestiondescours.models.Professeur;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CoursService {
    Cours saveCours(Cours cours);

    Cours updateCours(Cours cours);

    Cours getCours(Long id);

    List<Cours> getAllCours();

    void deleteCoursById(Long id);

    void deleteAllCours();
    //List<Cours> findAllCoursByProfesseur(Professeur idProfesseur);

//    List<Cours> findAllCoursByProfesseur ();
}