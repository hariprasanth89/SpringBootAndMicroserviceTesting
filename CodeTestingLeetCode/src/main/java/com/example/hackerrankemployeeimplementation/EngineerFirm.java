package com.example.hackerrankemployeeimplementation;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

public class EngineerFirm {

	
	private final int[] income;

	public EngineerFirm(int n) {
		income = new int[n];
		for (int i = 0; i < n; i++) {
			income[i] = 0;
		}
	}

	public static void printMessages(double salaryAmount, String salarySpecification, String profession) {
		switch (salarySpecification) {
		case "max":
			System.out.print("Maximum salary amongst " + profession);
			System.out.printf(" is %d", (int) salaryAmount);
			System.out.println("");
			break;
		case "min":
			System.out.print("Minimum salary amongst " + profession);
			System.out.printf(" is %d", (int) salaryAmount);
			System.out.println("");
			break;
		case "ave":
			System.out.print("Average salary of " + profession);
			System.out.printf(" is %.2f", salaryAmount);
			System.out.println("");
			break;
		default:
			System.out.println("Incomes of " + profession + " credited");
			break;
		}
	}

	public void assignSalaries(int[] salaries) {
		if (salaries != null) {
			assignIncome(salaries);
			printMessages(0, "", "engineers");
		}
	}

	public void maxSalary() {
		printMessages(MaxSalary(), "max", "engineers");
	}

	public void minSalary() {
		printMessages(MinSalary(), "min", "engineers");
	}

	public void averageSalary() {
		printMessages(AveSalary(), "ave", "engineers");
	}
	
	private List<Integer> incomeListItrator() {   // refactor code   
		List<Integer> list = Arrays.stream(this.income).boxed().collect(Collectors.toList());
		return list;
	}      

	public Integer MaxSalary() {
		List<Integer> list = incomeListItrator();
		return list.stream().max(Integer::compare).get();
	}

	public Integer MinSalary() {
		List<Integer> list = incomeListItrator();
		return list.stream().min(Integer::compare).get();
	}

	public double AveSalary() {
		List<Integer> list = incomeListItrator();
		IntSummaryStatistics stats = list.stream().mapToInt((x) -> x).summaryStatistics();
		return stats.getAverage();
	}

	public void assignIncome(int[] salaries) {
		System.arraycopy(salaries, 0, this.income, 0, Math.min(this.income.length, salaries.length));
	}
	
}
