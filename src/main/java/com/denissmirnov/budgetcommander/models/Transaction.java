package com.denissmirnov.budgetcommander.models;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="transactions")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "t_id")
    private Integer t_id;

    @ManyToOne
    private ApplicationUser bc_user;

    @Column(name="transaction_date")
    private Date transactionDate;

    @Column(name = "account_bank")
    private String accountBank;

    private String contragent;

    @Column(name = "transaction_type")
    private String transactionType;

    @Column(name = "transaction_group")
    private String transactionGroup;

    private String project;

    private String commentary;

    private Long amount;

    private String status;

    public Integer getT_id() {
        return t_id;
    }

    public void setT_id(Integer t_id) {
        this.t_id = t_id;
    }

    public ApplicationUser getBc_user() {
        return bc_user;
    }

    public void setBc_user(ApplicationUser bc_user) {
        this.bc_user = bc_user;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getAccountBank() {
        return accountBank;
    }

    public void setAccountBank(String accountBank) {
        this.accountBank = accountBank;
    }

    public String getContragent() {
        return contragent;
    }

    public void setContragent(String contragent) {
        this.contragent = contragent;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public String getTransactionGroup() {
        return transactionGroup;
    }

    public void setTransactionGroup(String transactionGroup) {
        this.transactionGroup = transactionGroup;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getCommentary() {
        return commentary;
    }

    public void setCommentary(String commentary) {
        this.commentary = commentary;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
