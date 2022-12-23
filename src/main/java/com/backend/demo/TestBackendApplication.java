package com.backend.demo;

import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.backend.model.Plot;
import com.backend.repository.PlotRepository;
import com.irrigation.IrrigationSensorResponse;
import com.irrigation.IrrigationSensorSimulation;

@SpringBootApplication
@ComponentScan({ "com.backend.repository" })
@EnableJpaRepositories("com.backend.repository")
@EntityScan({ "com.backend.model" })
public class TestBackendApplication implements CommandLineRunner{

	@Autowired
	private PlotRepository plotRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(TestBackendApplication.class, args);
		System.out.println("--AppStarted---");
	}

	@Override
	public void run(String... args) throws Exception {
		// Entering some seeding data
		Plot plotc1 = new Plot("c1", "Ahmad", 10, 20, "morning", false);
		Plot plotc2 = new Plot("c2", "Ahmad", 11, 25, "evening", false);
		Plot plotc3 = new Plot("c3", "Ahmad", 12, 20, "morning", false);
		
		ArrayList<Plot> plots = new ArrayList<>();
		plots.add(plotc1);
		plots.add(plotc2);
		plots.add(plotc3);
		
		plotRepository.saveAll(plots);
		System.out.println("Entered Seeding data...");
		
		BlockingQueue<Plot> queue = new ArrayBlockingQueue<>(1024);
		IrrigationSensorResponse irrigationSensorResponse = new IrrigationSensorResponse(queue, plotRepository);
		IrrigationSensorSimulation irrigationSensorSimulation = new IrrigationSensorSimulation(queue, plotRepository);
		
		new Thread(irrigationSensorSimulation).start();
		new Thread(irrigationSensorResponse).start();
	}

}
