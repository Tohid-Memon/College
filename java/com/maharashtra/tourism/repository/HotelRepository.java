package com.maharashtra.tourism.repository;
import com.maharashtra.tourism.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface HotelRepository extends JpaRepository<Hotel,Long> {
    List<Hotel> findByDestination_IdOrderByPricePerNightAsc(Long destinationId);
}
