package com.backend.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.backend.model.Plot;
import com.backend.repository.PlotRepository;

@RestController("plot")
public class PlotController {

	private final PlotRepository plotRepository;

	public PlotController(PlotRepository plotRepository) {
		this.plotRepository = plotRepository;
	}

	@GetMapping("/list")
	public ResponseEntity<List<Plot>> getAllPlots() {
		return new ResponseEntity<>(plotRepository.findAll(), HttpStatus.OK);
	}


	@PostMapping("/")
	public Plot addNewPlot(@RequestBody() Plot plot) {
		return plotRepository.save(plot);
	}
	
	@PutMapping("/configure/{id}")
	public Plot configurePlot(@RequestBody() Plot plot) {
		return plotRepository.save(plot);
	}
	
	@PutMapping("/edit/{id}")
	public Plot editPlot(@RequestBody() Plot plot) {
		return plotRepository.save(plot);
	}
	
	
}
