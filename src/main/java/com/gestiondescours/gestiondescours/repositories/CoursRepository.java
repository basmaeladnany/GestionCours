package com.gestiondescours.gestiondescours.repositories;

import com.gestiondescours.gestiondescours.models.Cours;
import com.gestiondescours.gestiondescours.models.Professeur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CoursRepository extends JpaRepository<Cours,Long> {

   // @Query("select cours from Cours cours where cours.idProfesseur >?1")
     //List<Cours> findAllCoursByProfesseur(Professeur idProfesseur);

 //   @Query("SELECT nom_cours AS nom_cours, professeur.nom_professeur AS nom_cours_professeur FROM cours INNER JOIN professeur ON cours.professeur_id_professeur = professeur.id_professeur;")
  //  List<Cours> findAllCoursByProfesseur ();
}
