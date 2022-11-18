package Kodlama.io.Devs.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import Kodlama.io.Devs.entities.concreates.Technology;

public interface TechnologyRepository extends JpaRepository<Technology, Integer>{

}
