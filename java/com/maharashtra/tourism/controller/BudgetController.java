package com.maharashtra.tourism.controller;
import com.maharashtra.tourism.dto.*;import com.maharashtra.tourism.service.TourismService;
import jakarta.validation.Valid;import org.springframework.web.bind.annotation.*;
@RestController @RequestMapping("/api/budget") public class BudgetController {private final TourismService service;public BudgetController(TourismService service){this.service=service;}@PostMapping("/calculate") public BudgetResponse calculate(@Valid @RequestBody BudgetRequest request){return service.calculate(request);}}
