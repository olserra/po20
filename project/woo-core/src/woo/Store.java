package woo;

import java.io.IOException;
import java.io.FileNotFoundException;
import woo.exceptions.BadEntryException;
import java.io.Serializable;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Collection;
import java.util.Collections;
import java.time.LocalDate;

/**
 * Class Store implements a store.
 */
public class Store implements Serializable {

  /** Serial number for serialization. */
  private static final long serialVersionUID = 202009192006L;

  /** Suppliers. */
  private Map<Integer, Supplier> _suppliers = new HashMap<Integer, Supplier>();

  /** Clients. */
  private Map<Integer, Client> _clients = new HashMap<Integer, Client>();

  /** Transactions. */
  private Map<Integer, Transaction> _transactions = new HashMap<Integer, Transaction>();

  /** Transaction counter. */
  private int _transactionNumber = 0;

  /** Store constructor. */
  public Store() {}
  
  /**
   * Create and register supplier.
   * 
   * @param key
   * @param name
   * @param address
   * @param status
   * @return the new supplier.
   */
  public Supplier registerSupplier(int key, String name, String address, boolean status) throws DuplicateSupplierException {
    if (_suppliers.containsKey(key))
      throw new DuplicateSupplierException(key, name, address, status);
    Supplier supplier = new Supplier(key, name, address, status);
    _suppliers.put(key, supplier);

  }

  /**
   * Remove a supplier.
   * 
   * @param key
   *          the supplier's key.
   * 
   * @return true, if the supplier was removed; false, otherwise.
   */
  public final boolean removeSupplier(int key) {
    Supplier supplier = getSupplier(key);
    if (supplier != null) {
      _suppliers.remove(key);
      return true;
    }
    return false;
  }

  /**
   * Return all the suppliers as an unmodifiable collection.
   * 
   * @return a collection with all the suppliers.
   */
  public Collection<Supplier> getSuppliers() {
    return Collections.unmodifiableCollection(_suppliers.values());
  }

  /**
   * Get the supplier with the given number.
   * 
   * @param key
   *          the supplier's number.
   * 
   * @return the supplier or null if the number does not correspond to a
   *         valkey supplier.
   */
  public Supplier getSupplier(int key) {
    return _suppliers.get(key);
  }

   /**
   * Create and register client.
   * 
   * @param id
   * @param name
   * @param address
   * @param notifications
   * @param pointsStatus
   * @return the new client.
   */
  public Client registerClient(int id, String name, String notifications, boolean status) throws DuplicateClientException {
    if (_clients.containsKey(id))
      throw new DuplicateClientException(id, name, notifications, pointsStatus);
    Client client = new Client(id, name, notifications, pointsStatus);
    _clients.put(id, client);

  }

  /**
   * Remove a client.
   * 
   * @param id
   *          the client's id.
   * 
   * @return true, if the client was removed; false, otherwise.
   */
  public final boolean removeClient(int id) {
    Client client = getClient(id);
    if (client != null) {
      _clients.remove(id);
      return true;
    }
    return false;
  }

  /**
   * Return all the clients as an unmodifiable collection.
   * 
   * @return a collection with all the clients.
   */
  public Collection<Client> getClients() {
    return Collections.unmodifiableCollection(_clients.values());
  }

  /**
   * Get the client with the given number.
   * 
   * @param id
   *          the client's number.
   * 
   * @return the client or null if the number does not correspond to a
   *         valid client.
   */
  public Client getClient(int id) {
    return _clients.get(id);
  }

   /**
   * Create and register transaction.
   * 
   * @param id
   * @param name
   * @param address
   * @param notifications
   * @param pointsStatus
   * @return the new transaction.
   */
  public Transaction registerTransaction(int id, Datetime date) throws DuplicateTransactionException {
    if (_transactions.containsKey(id))
      throw new DuplicateTransactionException(id, date);
    // LocalDate myObj = LocalDate.now();
    Transaction transaction = new Transaction(id, date);
    _transactions.put(id, transaction);

  }

  /**
   * Remove a transaction.
   * 
   * @param id
   *          the transaction's id.
   * 
   * @return true, if the transaction was removed; false, otherwise.
   */
  public final boolean removeTransaction(int id) {
    Transaction transaction = getTransaction(id);
    if (transaction != null) {
      _transactions.remove(id);
      return true;
    }
    return false;
  }

  /**
   * Return all the transactions as an unmodifiable collection.
   * 
   * @return a collection with all the transactions.
   */
  public Collection<Transaction> getTransactions() {
    return Collections.unmodifiableCollection(_transactions.values());
  }

  /**
   * Get the transaction with the given number.
   * 
   * @param id
   *          the transaction's number.
   * 
   * @return the transaction or null if the number does not correspond to a
   *         valid transaction.
   */
  public Transaction getTransaction(int id) {
    return _transactions.get(id);
  }

  /**
   * @param txtfile filename to be loaded.
   * @throws IOException
   * @throws BadEntryException
   */
  void importFile(String txtfile) throws IOException, BadEntryException, FileNotFoundException {

    int lineno = 0;
    try {
      BufferedReader in = new BufferedReader(new FileReader(txtfile));
      String s;

      while ((s = in.readLine()) != null) {
        String line = new String(s.getBytes(), "UTF-8");
        lineno++;
        if (line.charAt(0) == '#')
          continue;
        String[] split = line.split("\\|");
        for (int i = 0; i < split.length; i++)
          if (split[0].equals("SUPPLIER"))
            try {
              store.registerSupplier(split[0][1], split[0][2], split[0][3]);
            } catch (DuplicateSupplierException ih) {
              System.err.println(ih);
            }
          else if (split[0].equals("CLIENT"))
            try {
              store.registerClient(split[0][1], split[0][2], split[0][3]);
            } catch (DuplicateClientException ih) {
              System.err.println(ih);
            }
      }

      in.close();
    } catch (FileNotFoundException e) {
      System.out.println("File not found: " + txtfile + ": " + e);
    } catch (IOException e) {
      System.out.println("IO error: " + txtfile + ": " + lineno + ": line " + e);
    }
  
}