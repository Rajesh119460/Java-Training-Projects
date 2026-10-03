package personalexpensetracker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ExpenseService {
	
	private ArrayList<Expense> expenses= new ArrayList<>();
	
	public void addExpense(Expense expense) {
		
		expenses.add(expense);
		System.out.println("Expenses Added Succesfully");
	}
	
	public void displayExpenses() {
		
		if(expenses.isEmpty())
		{
			System.out.println("No expenses Found");
			return;
		}
		for(Expense expense:expenses)
		{
			System.out.println("Id:"+expense.getId());
			System.out.println("Description:"+expense.getDescription());
			System.out.println("Amount:"+expense.getAmount());
			System.out.println("Category:"+expense.getCategory());
			System.out.println("Time:"+expense.getDate());
		}
	}
	
	//delete expenses 
	public void deleteExpenses(int id) {
		
		for (int i = 0; i < expenses.size(); i++) {

	        if (expenses.get(i).getId() == id) {
	            expenses.remove(i);
	            System.out.println("Expense deleted successfully.");
	            return;
	        }
	    }
		  System.out.println("Expense ID not found.");
	}
	
	//total expenses
	public double totalExpenses() {

	    return expenses.stream()
	                   .mapToDouble(Expense::getAmount)
	                   .sum();
	}
	//highest amount 
	
	public Expense highestAmount() {

	    return expenses.stream()
	                   .max((e1, e2) ->
	                       Double.compare(e1.getAmount(), e2.getAmount()))
	                   .orElse(null);
	}
	//categorywise expenses 
	
	public Map<Category, Double> categoryWiseExpense(){
		
		Map<Category,Double> categoryTotal=new HashMap<>();
		
		for(Expense expense:expenses)
		{
			
			Category category=expense.getCategory();
			double amount=expense.getAmount();
			
			if (categoryTotal.containsKey(category)) {
				 categoryTotal.put(category,categoryTotal.get(category) + amount);
			}else {
				categoryTotal.put(category,amount);
			}
		}
		return categoryTotal;
	}
	 

}
