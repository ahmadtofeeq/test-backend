package com.irrigation;

import java.util.List;
import java.util.concurrent.BlockingQueue;

import com.backend.model.Plot;
import com.backend.repository.PlotRepository;

public class IrrigationSensorSimulation implements Runnable {

	
	private PlotRepository plotRepository;
	protected BlockingQueue<Plot> queue = null;

	public IrrigationSensorSimulation(BlockingQueue<Plot> queue, PlotRepository plotRepository) {
		this.queue = queue;
		this.plotRepository= plotRepository;
	}

	@Override
	public void run() {
		List<Plot> list = plotRepository.findAll();
		int size = list.size() -1;
		int randomCounter = 1;
		while (true) {
			System.out.println("(IrrigationSensorSimulation) Random counter="+ randomCounter);

			int index = size / randomCounter;

			Plot plot = list.get(index);
			System.out.println("(IrrigationSensorSimulation) isIrrigationStatus="+ plot.isIrrigationStatus());
			if (!plot.isIrrigationStatus()) {
				try {
					System.out.println("(IrrigationSensorSimulation) Request for irrigation for plot "+ plot.getId());
					queue.add(plot);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if(randomCounter >= size) {
				randomCounter = 1;
			}
			++randomCounter;
		}

	}

}
