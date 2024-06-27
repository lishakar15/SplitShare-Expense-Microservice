package com.splitwise.microservices.expense_service.model;

import com.splitwise.microservices.expense_service.enums.SplitType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ExpenseRequest {
    private Long groupId;
    private Long paidBy;
    private Double totalAmount;
    private String expenseDescription;
    private Date spentOnDate;
    private Date createDate;
    private Date lastUpdateDate;
    private String category;
    private List<UserExpenseSplit> userExpenseSplitList;
    private String splitType;
}