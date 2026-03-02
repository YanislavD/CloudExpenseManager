package project.projectforcv.service;

import project.projectforcv.model.Expense;

import java.util.List;
import java.util.UUID;

public interface ExpenseService {

    Expense createExpense(Expense expense);

    List<Expense> getExpenseByUser(UUID userId);
}
