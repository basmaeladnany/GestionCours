package com.gestiondescours.gestiondescours.services;

import com.gestiondescours.gestiondescours.models.Cours;
import com.gestiondescours.gestiondescours.models.Professeur;
import com.gestiondescours.gestiondescours.repositories.CoursRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoursServiceImpl implements CoursService {

    @Autowired
    CoursRepository coursRepsitoriy;
    @Override
    public Cours saveCours(Cours cours) {
        return coursRepsitoriy.save(cours);
    }

    @Override
    public Cours updateCours(Cours cours) {
        return coursRepsitoriy.save(cours);
    }



    @Override
    public Cours getCours(Long id) {
        return coursRepsitoriy.findById(id).get();
    }

    @Override
    public List<Cours> getAllCours() {
        return coursRepsitoriy.findAll();
    }
    @Override
    public void deleteCoursById(Long id) {
        coursRepsitoriy.deleteById(id);
    }
    @Override
    public void deleteAllCours() {
        coursRepsitoriy.deleteAll();
    }

  //  @Override
   //// public List<Cours> findAllCoursByProfesseur() {
      //  return coursRepsitoriy.findAllCoursByProfesseur();
        // }

    //  @Override
 //   public List<Cours> findAllCoursByProfesseur(Professeur idProfesseur) {
   //    return coursRepsitoriy.findAllCoursByProfesseur(idProfesseur);
    //  }


}
