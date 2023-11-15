package services.transaction;

import models.Transaction;

public interface TransactionService {
  void registerTransaction(Transaction transaction);

  void showAllTransaction();

  void showTransactionById(Integer id);

  Transaction getTransactionById(Integer id);
}
