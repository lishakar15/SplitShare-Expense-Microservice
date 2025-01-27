package com.splitwise.microservices.expense_service.repository;

import com.splitwise.microservices.expense_service.entity.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense,Long> {

    Optional<Expense> findByExpenseId(Long expenseId);
    void deleteByExpenseId(Long expenseId);
    @Query("select e.expenseDescription from Expense e where e.expenseId =:expenseId")
    String getExpenseDescById(@Param("expenseId") Long expenseId);
    @Query("select e.expenseId from Expense e where e.groupId =:groupId")
    List<Long> getExpensesByGroupId(@Param("groupId") Long groupId);
    @Query(value = "select category, sum(settle_amount) from expense_details e JOIN  expense_participants p on e.expense_id = p.expense_id where  p.participant_id =:participantId group by category",
    nativeQuery = true)
    List<Object[]> getCategoryDistributionByParticipantId(@Param("participantId") Long participantId);
}
