package com.stella.alephart.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.stella.alephart.models.LocationState;

@Repository
public interface LocationStateRepository extends JpaRepository<LocationState, Long>{

}
