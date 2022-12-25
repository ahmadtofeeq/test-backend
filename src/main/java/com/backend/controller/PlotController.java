package com.backend.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.model.Plot;
import com.backend.repository.PlotRepository;

import jakarta.validation.Valid;

@RestController()
@RequestMapping(value = "/plot")
public class PlotController {

	private final PlotRepository plotRepository;

	public PlotController(PlotRepository plotRepository) {
		this.plotRepository = plotRepository;
	}

	@GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<List<Plot>> getAllPlots() {
		return new ResponseEntity<>(plotRepository.findAll(), HttpStatus.OK);
	}

	@PostMapping("/add")
	public Plot addNewPlot(@Valid @RequestBody() Plot plot) {
		return plotRepository.save(plot);
	}
	
	@PutMapping("/configure/{id}")
	public Plot configurePlot(@Valid @RequestBody() Plot plot) {
		return plotRepository.save(plot);
	}
	
	@PutMapping("/edit/{id}")
	public Plot editPlot(@Valid @RequestBody() Plot plot) {
		return plotRepository.save(plot);
	}
	
}
