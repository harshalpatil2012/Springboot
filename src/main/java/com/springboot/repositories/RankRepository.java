package com.springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.model.AppUser;
import com.springboot.model.Rank;


@Repository
public interface RankRepository extends JpaRepository<Rank, Integer> {

	Rank findByRank(String rank);

}
