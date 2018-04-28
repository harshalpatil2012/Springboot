package com.springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.model.AppUser;
import com.springboot.model.Rank;
import com.springboot.model.Trainingstatus;


@Repository
public interface TrainingStatusRepository extends JpaRepository<Trainingstatus, Integer> {

	Trainingstatus findByTrainingStatus(String tstatus);

}
