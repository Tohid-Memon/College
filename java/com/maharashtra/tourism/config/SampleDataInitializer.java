package com.maharashtra.tourism.config;

import com.maharashtra.tourism.entity.*;import com.maharashtra.tourism.repository.*;
import org.springframework.boot.CommandLineRunner;import org.springframework.context.annotation.Bean;import org.springframework.context.annotation.Configuration;
import java.math.BigDecimal;import java.util.*;

@Configuration
public class SampleDataInitializer {
 @Bean CommandLineRunner seed(DestinationRepository dr,AttractionRepository ar,HotelRepository hr){return args->{if(dr.count()>0)return;
  String[][] rows={
   {"Mumbai","Mumbai City","A lively coastal metropolis known for landmarks, food, museums and the film industry.","November to February","2","City"},
   {"Pune","Pune","A cultural and education hub with historic forts, museums and nearby hill getaways.","October to February","2","City"},
   {"Matheran","Raigad","A small hill station known for forest trails, viewpoints and a vehicle-restricted central area.","October to May","2","Hill station"},
   {"Lonavala","Pune","A popular Sahyadri hill station with viewpoints, caves and monsoon landscapes.","October to May","2","Hill station"},
   {"Khandala","Pune","A scenic hill destination near Lonavala, known for valleys and mountain views.","October to May","1","Hill station"},
   {"Mahabaleshwar","Satara","A hill station known for viewpoints, forested hills, strawberry farms and lakes.","October to June","2","Hill station"},
   {"Panchgani","Satara","A plateau hill town with expansive valley views and a relaxed climate.","September to May","1","Hill station"},
   {"Nashik","Nashik","A city with important religious sites, riverfront areas and nearby vineyards.","October to March","2","City"},
   {"Shirdi","Ahmednagar","A major pilgrimage destination associated with Sai Baba.","Throughout the year","1","Religious"},
   {"Alibaug","Raigad","A coastal getaway with beaches, historic forts and seafood restaurants.","November to February","2","Beach"},
   {"Murud","Raigad","A coastal town often visited for its beach and nearby sea fort.","November to February","2","Beach"},
   {"Harihareshwar","Raigad","A coastal pilgrimage town with a temple and scenic shoreline.","October to March","1","Beach"},
   {"Ganpatipule","Ratnagiri","A Konkan destination known for its beach and Ganpati temple.","November to February","2","Beach"},
   {"Ratnagiri","Ratnagiri","A Konkan coastal town with beaches, forts and regional food.","November to February","2","Coastal"},
   {"Tarkarli","Sindhudurg","A coastal destination known for clear-water seasons and water-based activities.","October to March","2","Beach"},
   {"Malvan","Sindhudurg","A Konkan town known for coastal scenery, local cuisine and nearby Sindhudurg Fort.","October to March","2","Coastal"},
   {"Kolhapur","Kolhapur","A historic city known for Mahalaxmi Temple, cuisine and traditional crafts.","October to March","2","Heritage"},
   {"Nagpur","Nagpur","A major Vidarbha city and a gateway to several wildlife destinations.","November to February","2","City"},
   {"Amravati","Amravati","A Vidarbha city with religious sites and access to nearby nature destinations.","October to February","1","City"},
   {"Chhatrapati Sambhajinagar","Chhatrapati Sambhajinagar","A heritage city used as a base for nearby cave complexes and historic monuments.","October to March","2","Heritage"},
   {"Ajanta Caves","Jalgaon","A UNESCO-listed group of rock-cut Buddhist caves known for ancient paintings and sculpture.","November to March","1","Heritage"},
   {"Ellora Caves","Chhatrapati Sambhajinagar","A renowned cave complex featuring Buddhist, Hindu and Jain monuments.","October to March","1","Heritage"},
   {"Shani Shingnapur","Ahmednagar","A pilgrimage village known for its Shani temple.","Throughout the year","1","Religious"},
   {"Bhimashankar","Pune","A forested pilgrimage destination associated with one of the twelve Jyotirlingas.","October to February","1","Religious / Nature"},
   {"Trimbakeshwar","Nashik","A pilgrimage town known for its historic Shiva temple near the Brahmagiri hills.","October to March","1","Religious"},
   {"Igatpuri","Nashik","A hill destination with mountain scenery, monsoon landscapes and meditation centres.","September to February","2","Nature"},
   {"Bhandardara","Ahmednagar","A quiet nature destination with a lake, hills and seasonal waterfalls.","September to February","2","Nature"},
   {"Tadoba-Andhari Tiger Reserve","Chandrapur","A protected forest area known for wildlife safaris; permits and sightings are not guaranteed.","October to June","2","Wildlife"},
   {"Pench National Park - Maharashtra","Nagpur","A forest reserve in the Pench landscape; check official park access and safari availability.","October to June","2","Wildlife"},
   {"Torna Fort","Pune","A historic hill fort trek that requires suitable fitness, footwear and weather awareness.","October to February","1","Fort / Trek"},
   {"Raigad Fort","Raigad","A hill fort associated with Chhatrapati Shivaji Maharaj and Maratha history.","October to February","1","Fort / Heritage"},
   {"Pratapgad Fort","Satara","A historic fort in the Mahabaleshwar region associated with Maratha history.","October to February","1","Fort / Heritage"},
   {"Sinhagad Fort","Pune","A popular hill fort near Pune with historic sites and local food stalls.","October to February","1","Fort / Trek"},
   {"Devkund Waterfall","Raigad","A forest waterfall trek; access rules and seasonal safety conditions should be checked locally.","Post-monsoon to winter","1","Nature / Trek"},
   {"Lonar Lake","Buldhana","A crater lake formed by a meteorite impact, with geological and ecological interest.","November to February","1","Nature"},
   {"Amboli","Sindhudurg","A Western Ghats hill station known for monsoon greenery and seasonal waterfalls.","October to February","2","Hill station"},
   {"Sawantwadi","Sindhudurg","A Konkan town known for traditional wooden toys and local craft heritage.","October to March","1","Heritage"},
   {"Jawhar","Palghar","A hill town known for tribal art traditions and scenic landscapes.","October to February","1","Nature / Culture"},
   {"Akkalkot","Solapur","A pilgrimage destination associated with Shri Swami Samarth.","Throughout the year","1","Religious"},
   {"Nanded","Nanded","A city known for Hazur Sahib, an important Sikh pilgrimage site.","October to February","1","Religious"},
   {"Tuljapur","Dharashiv","A pilgrimage town known for the Tulja Bhavani Temple.","October to March","1","Religious"},
   {"Pandharpur","Solapur","A major pilgrimage town associated with Lord Vitthal and the Wari tradition.","October to February","1","Religious"},
   {"Solapur","Solapur","A city known for textile traditions and nearby religious destinations.","October to February","1","City"},
   {"Wardha","Wardha","A town associated with India's independence movement and Gandhi-related heritage.","October to February","1","Heritage"},
   {"Melghat","Amravati","A forested landscape in the Satpura range with wildlife and nature experiences.","October to May","2","Wildlife / Nature"},
   {"Chikhaldara","Amravati","A hill station in Vidarbha known for viewpoints, forests and cooler weather.","October to February","2","Hill station"},
   {"Dapoli","Ratnagiri","A Konkan town with beaches, temples and nearby coastal villages.","October to March","2","Coastal"},
   {"Diveagar","Raigad","A coastal village known for its beach and laid-back Konkan atmosphere.","November to February","2","Beach"},
   {"Kamshet","Pune","A countryside destination known for paragliding in suitable weather and hill scenery.","October to May","1","Adventure"},
   {"Lavasa","Pune region","A planned lakeside hill destination; verify access, services and local conditions before visiting.","October to February","1","Nature"}
  };
  Map<String,Destination> byName=new HashMap<>(); for(String[] r:rows){Destination d=dr.save(new Destination(r[0],r[1],r[2],r[3],Integer.valueOf(r[4]),r[5],null));byName.put(r[0],d);}
  addAttractions(ar,byName,"Matheran",new String[][]{{"Panorama Point","Wide valley views; visibility depends on weather.","Viewpoint","Morning","60","0"},{"Echo Point","A popular viewpoint known for its echo effect in suitable conditions.","Viewpoint","Afternoon","45","0"},{"Charlotte Lake","A lake and nature stop near Matheran.","Nature","Afternoon","60","0"},{"Louisa Point","A scenic viewpoint with views of the surrounding hills.","Viewpoint","Evening","60","0"},{"One Tree Hill Point","A hill viewpoint reached by a walking trail.","Trek / Viewpoint","Morning","90","0"}});
  addAttractions(ar,byName,"Lonavala",new String[][]{{"Karla Caves","Rock-cut Buddhist cave complex.","Heritage","Morning","90","0"},{"Bhushi Dam","A popular seasonal stop; access can be restricted during heavy rain.","Nature","Afternoon","60","0"},{"Lions Point","A well-known valley viewpoint.","Viewpoint","Evening","45","0"},{"Lonavala Lake","A seasonal lake area.","Nature","Afternoon","45","0"}});
  addAttractions(ar,byName,"Mahabaleshwar",new String[][]{{"Arthur's Seat","A famous valley viewpoint.","Viewpoint","Morning","60","0"},{"Venna Lake","A lake-side recreation area.","Lake","Afternoon","60","0"},{"Mapro Garden","A food and garden stop in the region.","Food / Garden","Afternoon","60","0"},{"Elephant's Head Point","A scenic viewpoint.","Viewpoint","Evening","45","0"}});
  addAttractions(ar,byName,"Mumbai",new String[][]{{"Gateway of India","Harbourfront landmark and popular city stop.","Heritage","Morning","60","0"},{"Chhatrapati Shivaji Maharaj Vastu Sangrahalaya","Museum with art and heritage collections.","Museum","Afternoon","120","0"},{"Marine Drive","Seafront promenade for a city walk.","Promenade","Evening","60","0"},{"Sanjay Gandhi National Park","Large urban national park; check entry rules and timings.","Nature","Morning","180","As available"}});
  addAttractions(ar,byName,"Pune",new String[][]{{"Shaniwar Wada","Historic fortification in central Pune.","Heritage","Morning","60","0"},{"Aga Khan Palace","Historic building and Gandhi-related memorial.","Heritage","Afternoon","90","As available"},{"Sinhagad Fort","Historic hill fort outside the city centre.","Fort / Trek","Morning","180","As available"}});
  addAttractions(ar,byName,"Ellora Caves",new String[][]{{"Kailasa Temple","Monolithic rock-cut temple within the Ellora complex.","Heritage","Morning","120","As available"},{"Buddhist Caves","Rock-cut caves forming part of the Ellora complex.","Heritage","Afternoon","90","As available"},{"Jain Caves","Jain monuments within the Ellora complex.","Heritage","Afternoon","60","As available"}});
  addAttractions(ar,byName,"Ganpatipule",new String[][]{{"Ganpatipule Beach","Coastal beach next to the temple area.","Beach","Morning","60","0"},{"Swayambhu Ganpati Temple","A well-known temple in Ganpatipule.","Religious","Morning","60","0"},{"Prachin Konkan Museum","Regional heritage and culture display.","Museum","Afternoon","60","As available"}});
  addAttractions(ar,byName,"Alibaug",new String[][]{{"Alibaug Beach","A popular coastal beach.","Beach","Morning","60","0"},{"Kolaba Fort","Sea fort; access depends on tide and local conditions.","Fort","Afternoon","90","As available"},{"Kashid Beach","A nearby beach area; transport is required.","Beach","Evening","90","0"}});
  addAttractions(ar,byName,"Nashik",new String[][]{{"Trimbakeshwar Temple","Important temple near Nashik; check current visitor guidance.","Religious","Morning","90","0"},{"Pandav Leni Caves","Ancient rock-cut caves overlooking the city.","Heritage","Afternoon","90","As available"},{"Ramkund","A sacred riverfront area in Panchavati.","Religious","Evening","45","0"}});
  addAttractions(ar,byName,"Kolhapur",new String[][]{{"Mahalaxmi Temple","Important historic temple in Kolhapur.","Religious","Morning","90","0"},{"New Palace Museum","Museum exploring regional royal history.","Museum","Afternoon","90","As available"},{"Rankala Lake","Lake-side area for an evening visit.","Lake","Evening","60","0"}});
  addAttractions(ar,byName,"Ajanta Caves",new String[][]{{"Cave 1","Known for its historic murals; follow site rules.","Heritage","Morning","60","As available"},{"Cave 2","Cave with paintings and architectural details.","Heritage","Morning","60","As available"},{"Cave 26","A cave noted for sculptural features.","Heritage","Afternoon","60","As available"}});
  addAttractions(ar,byName,"Tadoba-Andhari Tiger Reserve",new String[][]{{"Core-area safari","Wildlife viewing depends on permits, season and animal movement.","Wildlife","Morning","180","Permit required"},{"Buffer-area safari","A safari option subject to current park rules and booking.","Wildlife","Afternoon","180","Permit required"}});
  // Demonstration-only hotel data; names and rates are not live listings.
  for(String dest:List.of("Matheran","Lonavala","Mahabaleshwar","Mumbai","Pune","Alibaug","Ganpatipule","Nashik","Kolhapur","Nagpur","Chhatrapati Sambhajinagar","Shirdi")){
   Destination d=byName.get(dest);String slug=dest.replace(" ","");hr.save(new Hotel(d,slug+" Budget Stay","budget",new BigDecimal("1200"),"Illustrative budget-category stay for project demonstration.","Basic room, Wi-Fi (sample)"));hr.save(new Hotel(d,slug+" Comfort Inn","standard",new BigDecimal("2500"),"Illustrative standard-category stay; verify real listings before travel.","Private room, Wi-Fi (sample)"));hr.save(new Hotel(d,slug+" Premium Retreat","premium",new BigDecimal("5000"),"Illustrative premium-category stay; not a live hotel listing.","Comfort facilities (sample)"));
  }
 };
 }
 private void addAttractions(AttractionRepository repo,Map<String,Destination> map,String destination,String[][] data){for(String[] a:data){BigDecimal fee=null;try{fee=new BigDecimal(a[5]);}catch(Exception ignored){}repo.save(new Attraction(map.get(destination),a[0],a[1],a[2],a[3],Integer.valueOf(a[4]),fee));}}
}
