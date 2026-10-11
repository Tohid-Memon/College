package com.maharashtra.tourism.controller;
import com.maharashtra.tourism.entity.*;import com.maharashtra.tourism.service.TourismService;
import org.springframework.web.bind.annotation.*;import java.util.*;
@RestController @RequestMapping("/api/destinations")
public class DestinationController {
 private final TourismService service; public DestinationController(TourismService service){this.service=service;}
 @GetMapping public List<Destination> all(){return service.allDestinations();}
 @GetMapping("/search") public List<Destination> search(@RequestParam(required=false) String query){return service.search(query);}
 @GetMapping("/by-name") public Destination byName(@RequestParam String name){return service.byName(name);}
 @GetMapping("/{id}") public Destination one(@PathVariable Long id){return service.destination(id);}
 @GetMapping("/{id}/attractions") public List<Attraction> attractions(@PathVariable Long id){return service.attractions(id);}
 @GetMapping("/{id}/hotels") public List<Hotel> hotels(@PathVariable Long id){return service.hotels(id);}
 @GetMapping("/{id}/itinerary") public Map<String,Object> itinerary(@PathVariable Long id,@RequestParam(defaultValue="1") int days){return service.itinerary(id,days);}
}
