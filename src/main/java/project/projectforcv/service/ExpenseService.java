package project.projectforcv.service;

import project.projectforcv.model.Expense;
import project.projectforcv.model.User;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public interface ExpenseService {

    Expense createExpense(String description, BigDecimal amount, User user);

    List<Expense> getExpenseByUser(UUID userId);
}
