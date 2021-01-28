package com.example.demo.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.Recommended;

public interface RecommendedRepository extends JpaRepository<Recommended,String>{

	@Query(nativeQuery = true, value = "select * from recommended r where r.character_type = :characterType ORDER BY r.rank ASC LIMIT 10")
	public List<Recommended> findByCharacterTypeOrderByRankAsc(int characterType);

}
