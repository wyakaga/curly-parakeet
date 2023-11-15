package dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import models.Transaction;
import utils.BaseDao;

public class TransactionDao implements BaseDao<Transaction, Integer> {
  List<Transaction> transactions = new ArrayList<>(Arrays.asList(new Transaction()));

  @Override
  public void save(Transaction data) {
    this.transactions.add(data);
  }

  @Override
  public List<Transaction> findAll() {
    return this.transactions;
  }

  @Override
  public Transaction findById(Integer id) {
    return this.transactions.get(id - 1);
  }

  @Override
  public void update(Integer id, Transaction data) {
    this.transactions.set(id - 1, data);
  }

  @Override
  public void delete(Integer id) {
    this.transactions.remove(id - 1);
  }

  @Override
  public Integer size() {
    return this.transactions.size();
  }
}
