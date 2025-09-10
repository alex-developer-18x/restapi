package mx.developer.restapi.service;

import mx.developer.restapi.dto.ExpenseDTO;

import java.util.List;

/**
 * Service interface for Expense module
 *
 * @author Jorge Gonzalez
 */
public interface ExpenseService {

    /**
     * It will fetch the expenses from database
     *
     * @return list
     */
    List<ExpenseDTO> getAllExpenses();
}
