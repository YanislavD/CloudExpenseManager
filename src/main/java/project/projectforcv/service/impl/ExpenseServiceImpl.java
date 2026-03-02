package project.projectforcv.service.impl;

import project.projectforcv.model.Expense;
import project.projectforcv.model.User;
import project.projectforcv.repository.ExpenseRepository;
import project.projectforcv.service.ExpenseService;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class ExpenseServiceImpl implements ExpenseService {

    private final ExpenseRepository expenseRepository;

    public ExpenseServiceImpl(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    @Override
    public Expense createExpense(String description, BigDecimal amount, User user) {

        if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Amount must be greater than zero");
        }

        Expense expense = new Expense();
        expense.setDescription(description);
        expense.setAmount(amount);
        expense.setDate(LocalDate.now()); // default
        expense.setUser(user);

        return expenseRepository.save(expense);
    }

    @Override
    public List<Expense> getExpenseByUser(UUID userId) {
        return expenseRepository.findByUserId(userId);
    }
}
