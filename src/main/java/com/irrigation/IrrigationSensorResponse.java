package com.irrigation;

import java.util.concurrent.BlockingQueue;

import com.backend.model.Plot;
import com.backend.repository.PlotRepository;

public class IrrigationSensorResponse implements Runnable {

	private PlotRepository plotRepository;
	protected BlockingQueue<Plot> queue = null;

	public IrrigationSensorResponse(BlockingQueue<Plot> queue, PlotRepository plotRepository) {
		this.queue = queue;
		this.plotRepository= plotRepository;
	}

	@Override
	public void run() {
		while (true) {

			try {
				System.out.println("Queue Status."+queue.isEmpty());
				if (!queue.isEmpty()) {
					Plot plot = queue.remove();
					plot.setIrrigationStatus(false);
					plotRepository.save(plot);
					System.out.println("Plot "+ plot.getId()+" is irrigated.");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
