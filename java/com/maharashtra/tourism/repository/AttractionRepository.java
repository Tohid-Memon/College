package com.maharashtra.tourism.repository;
import com.maharashtra.tourism.entity.Attraction;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface AttractionRepository extends JpaRepository<Attraction,Long> {
    List<Attraction> findByDestination_IdOrderByIdAsc(Long destinationId);
}
