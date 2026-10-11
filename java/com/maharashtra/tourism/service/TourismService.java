package com.maharashtra.tourism.service;

import com.maharashtra.tourism.dto.*;
import com.maharashtra.tourism.entity.*;
import com.maharashtra.tourism.exception.NotFoundException;
import com.maharashtra.tourism.repository.*;
import org.springframework.stereotype.Service;
import java.math.*;
import java.util.*;

@Service
public class TourismService {
 private final DestinationRepository destinations; private final AttractionRepository attractions; private final HotelRepository hotels;
 public TourismService(DestinationRepository destinations,AttractionRepository attractions,HotelRepository hotels){this.destinations=destinations;this.attractions=attractions;this.hotels=hotels;}
 public List<Destination> allDestinations(){return destinations.findAll(org.springframework.data.domain.Sort.by("name").ascending());}
 public List<Destination> search(String query){if(query==null||query.isBlank())return allDestinations();String q=query.trim();return destinations.findByNameContainingIgnoreCaseOrderByNameAsc(q);}
 public Destination destination(Long id){return destinations.findById(id).orElseThrow(()->new NotFoundException("Destination not found. Try a popular Maharashtra destination."));}
 public Destination byName(String name){return destinations.findByNameIgnoreCase(name.trim()).orElseThrow(()->new NotFoundException("We don't have information about this destination yet. Please check the spelling or try another Maharashtra destination."));}
 public List<Attraction> attractions(Long id){destination(id);return attractions.findByDestination_IdOrderByIdAsc(id);}
 public List<Hotel> hotels(Long id){destination(id);return hotels.findByDestination_IdOrderByPricePerNightAsc(id);}
 public Map<String,Object> itinerary(Long id,int days){if(days<1||days>3)throw new IllegalArgumentException("Days must be between 1 and 3.");Destination d=destination(id);List<Attraction> list=attractions.findByDestination_IdOrderByIdAsc(id);Map<String,Object> result=new LinkedHashMap<>();result.put("destination",d.getName());result.put("days",days);if(list.isEmpty()){result.put("message","We do not have enough attraction data to create a detailed itinerary for this destination yet.");result.put("plan",List.of());return result;}List<Map<String,Object>> plan=new ArrayList<>();String[] periods={"Morning","Afternoon","Evening"};int perDay=3;for(int day=0;day<days;day++){List<Map<String,Object>> slots=new ArrayList<>();for(int slot=0;slot<perDay;slot++){int index=day*perDay+slot;if(index>=list.size())break;Attraction a=list.get(index);slots.add(Map.of("period",periods[slot],"attraction",a.getName(),"description",a.getDescription()==null?"Explore this attraction at your own pace.":a.getDescription()));}if(!slots.isEmpty())plan.add(Map.of("day",day+1,"activities",slots));}result.put("note","Suggested order only; this itinerary is not geographically optimized. Confirm local access and timings before travel.");result.put("plan",plan);return result;}
 public BudgetResponse calculate(BudgetRequest r){if(!Set.of("budget","standard","premium").contains(r.hotelCategory().toLowerCase(Locale.ROOT)))throw new IllegalArgumentException("Hotel category must be budget, standard, or premium.");int nights=Math.max(0,r.days()-1);BigDecimal rate=switch(r.hotelCategory().toLowerCase(Locale.ROOT)){case "budget"->new BigDecimal("1200");case "standard"->new BigDecimal("2500");default->new BigDecimal("5000");};BigDecimal accommodation=rate.multiply(BigDecimal.valueOf(r.rooms())).multiply(BigDecimal.valueOf(nights));BigDecimal food=r.dailyFoodPerPerson().multiply(BigDecimal.valueOf(r.travellers())).multiply(BigDecimal.valueOf(r.days()));BigDecimal total=accommodation.add(food).add(r.transportation()).add(r.miscellaneous());return new BudgetResponse(money(accommodation),money(food),money(r.transportation()),money(r.miscellaneous()),money(total),money(total.divide(BigDecimal.valueOf(r.travellers()),2,RoundingMode.HALF_UP)),nights,"Demo estimate. Hotel rates are illustrative category averages, rooms default to one per two travellers, and one-day trips have zero hotel nights.");}
 private BigDecimal money(BigDecimal n){return n.setScale(2,RoundingMode.HALF_UP);}
}
