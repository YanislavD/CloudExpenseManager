package project.projectforcv.service.impl;

import project.projectforcv.model.Expense;
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
    public Expense createExpense(Expense expense) {

        if (expense.getAmount() == null || expense.getAmount().compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Amount must be greater than zero");
        }

        if (expense.getDate() == null) {
            expense.setDate(LocalDate.now());
        }

        return expenseRepository.save(expense);
    }

    @Override
    public List<Expense> getExpenseByUser(UUID userId) {
        return expenseRepository.findByUserId(userId);
    }
}
