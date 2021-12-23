package com.example.threadsKLearnings;

import java.util.ArrayList;
import java.util.Random;

public class ThreadsLearnings {
	
	Random random = new Random();
	
	private Object lock1 = new Object();
	private Object lock2 = new Object();
	
	ArrayList<Integer> listStageOne = new ArrayList<>();
	ArrayList<Integer> listStageTwo = new ArrayList<>();
	
	public synchronized void stageOneTreads() {
		synchronized (lock1) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			listStageOne.add(random.nextInt(1000));
		}
	}
	public synchronized void stageTwoTreads() {
		synchronized (lock2) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			listStageTwo.add(random.nextInt(1000));
		}
	}
	
	public void processToRun() {
		
		for (int i = 0; i < 1000; i++) {
			stageOneTreads();
			stageTwoTreads();
		}
		
	}
	
	public void mainToRun() {
		System.out.println("Starting...!!!  ");
		
		long startingCurrentTimeMillis = System.currentTimeMillis();
		
		Thread thread = new Thread(new Runnable() {
			public void run() {
				processToRun();
			}
		});
		
		Thread thread1 = new Thread(new Runnable() {
			public void run() {
				processToRun();
			}
		});
		
		thread.start();
		thread1.start();

		
		try {
			thread.join();
			thread1.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		long endCurrentTimeMillis = System.currentTimeMillis();
		System.out.println("Time Taken : " + (endCurrentTimeMillis-startingCurrentTimeMillis));
		System.out.println("ListStageOne : " + listStageOne.size()  + "listStageTwo :" + listStageTwo.size());
		
	}

}
