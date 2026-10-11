package com.maharashtra.tourism.repository;
import com.maharashtra.tourism.entity.Destination;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;
public interface DestinationRepository extends JpaRepository<Destination,Long> {
    List<Destination> findByNameContainingIgnoreCaseOrderByNameAsc(String query);
    Optional<Destination> findByNameIgnoreCase(String name);
}
