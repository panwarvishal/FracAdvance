package com.frac.FracAdvanced.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.frac.FracAdvanced.model.ProjectDetails;
import com.frac.FracAdvanced.model.ReservoirLithologyModelVerticle;

public interface ReservoirLithologyVerticleRepo extends JpaRepository<ReservoirLithologyModelVerticle, Integer> {

		
	@Query("select t from ReservoirLithologyModelVerticle t where t.rLVerticle=:rLVerticle order by t.id")
	List<ReservoirLithologyModelVerticle> findByrLVerticle(ProjectDetails rLVerticle);



}
