package services.transaction;

import java.util.List;
import java.util.Objects;
import dao.TransactionDao;
import models.Transaction;

public class TransactionServiceImpl implements TransactionService {
  TransactionDao transactionDao;

  public TransactionServiceImpl(TransactionDao transactionDao) {
    this.transactionDao = transactionDao;
  }

  @Override
  public void registerTransaction(Transaction transaction) {
    if (Objects.isNull(transaction)) {
      throw new RuntimeException("Transaction is required!");
    }

    transactionDao.save(transaction);
    System.out.println("Transaction record saved!");
  }

  @Override
  public void showAllTransaction() {
    List<Transaction> transactions = transactionDao.findAll();

    for (int i = 0; i < transactions.size(); i++) {
      System.out.println((i + 1) + ". " + transactions.get(i));
    }
  }

  @Override
  public void showTransactionById(Integer id) {
    if (id < transactionDao.size()) {
      throw new RuntimeException("id is not found!");
    }

    Transaction transaction = transactionDao.findById(id);
    System.out.println(transaction);
  }

  @Override
  public Transaction getTransactionById(Integer id) {
    if (id < transactionDao.size()) {
      throw new RuntimeException("id is not found!");
    }

    Transaction transaction = transactionDao.findById(id);
    return transaction;
  }
}
