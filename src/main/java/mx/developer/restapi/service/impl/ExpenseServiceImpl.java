package mx.developer.restapi.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mx.developer.restapi.dto.ExpenseDTO;
import mx.developer.restapi.entity.ExpenseEntity;
import mx.developer.restapi.repository.ExpenseRepository;
import mx.developer.restapi.service.ExpenseService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Service implementation for Expense module
 *
 * @author Jorge Gonzalez
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class ExpenseServiceImpl implements ExpenseService {
    private final ExpenseRepository expenseRepository;
    private final ModelMapper modelMapper;

    /**
     * It will fetch the expenses from database
     *
     * @return list
     */
    @Override
    public List<ExpenseDTO> getAllExpenses() {
        // call the repository method
        List<ExpenseEntity> list = expenseRepository.findAll();
        log.info("Printing the data from repository: {}", list);

        // convert the Expense Entity to Expense DTO
        List<ExpenseDTO> listOfExpenses = list.stream()
                .map(expenseEntity -> mapToExpenseDTO(expenseEntity))
                .collect(Collectors.toList());

        // return the list
        return listOfExpenses;
    }

    /**
     * Mapper method to convert Expense Entity to Expense DTO
     *
     * @param expenseEntity
     * @return
     */
    private ExpenseDTO mapToExpenseDTO(ExpenseEntity expenseEntity) {
        return modelMapper.map(expenseEntity, ExpenseDTO.class);
    }
}
