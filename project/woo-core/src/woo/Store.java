package woo;

import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Map;
import java.util.HashMap;
import java.util.Collection;
import java.util.Collections;

import woo.exceptions.*;

/**
 * Class Store implements a store.
 */
public class Store implements Serializable {

  /** Serial number for serialization. */
  private static final long serialVersionUID = 202009192006L;

  /** Suppliers. */
  private Map<String, Supplier> _suppliers = new HashMap<String, Supplier>();

  /** Clients. */
  private Map<String, Client> _clients = new HashMap<String, Client>();

  /** Products. */
  private Map<String, Product> _products = new HashMap<String, Product>();

  /** Store constructor. */
  public Store() {
  }

  /**
   * Create and register supplier.
   * 
   * @param key
   * @param name
   * @param address
   * @return the new supplier.
   * @throws DuplicateSupplierKeyException
   */
  public Supplier registerSupplier(String key, String name, String address) throws DuplicateSupplierKeyException {
    if (_suppliers.containsKey(key))
      throw new DuplicateSupplierKeyException(key);
    Supplier supplier = new Supplier(key, name, address);
    return _suppliers.put(key, supplier);
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
   * @param key the supplier's number.
   * 
   * @return the supplier or null if the number does not correspond to a valid
   *         supplier.
   */
  public Supplier getSupplier(String key) {
    return _suppliers.get(key);
  }

  /**
   * Create and register client.
   * 
   * @param key
   * @param name
   * @param address
   * @return the new client.
   * @throws DuplicateClientKeyException
   */
  public Client registerClient(String key, String name, String address) throws DuplicateClientKeyException {
    if (_clients.containsKey(key))
      throw new DuplicateClientKeyException(key);
    Client client = new Client(key, name, address);
    return _clients.put(key, client);
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
   * @param id the client's number.
   * 
   * @return the client or null if the number does not correspond to a valid
   *         client.
   */
  public Client getClient(String key) {
    return _clients.get(key);
  }

  /**
   * Create and product box.
   * 
   * @param key
   * @param serviceType
   * @param supplierKey
   * @param price
   * @param criticalValue
   * @param units
   * @param
   * @return the new transaction.
   * @throws DuplicateProductKeyException
   */
  public Box registerProductBox(String key, String serviceType, String supplierKey, int price, int criticalValue,
      int units) throws DuplicateProductKeyException {
    if (_products.containsKey(key))
      throw new DuplicateProductKeyException(key);
    Box box = new Box(key, serviceType, supplierKey, price, criticalValue, units);
    _products.put(key, box);
    return box;
  }

  /**
   * Create and product book.
   * 
   * @param key
   * @param title
   * @param author
   * @param isbn
   * @param supplierKey
   * @param price
   * @param criticalValue
   * @param units
   * @param
   * @return the new transaction.
   * @throws DuplicateProductKeyException
   */
  public Book registerProductBook(String key, String title, String author, String isbn, String supplierKey, int price,
      int criticalValue, int units) throws DuplicateProductKeyException {
    if (_products.containsKey(key))
      throw new DuplicateProductKeyException(key);
    Book book = new Book(key, title, author, isbn, supplierKey, price, criticalValue, units);
    _products.put(key, book);
    return book;
  }

  /**
   * Create and product book.
   * 
   * @param key
   * @param title
   * @param author
   * @param isbn
   * @param supplierKey
   * @param price
   * @param criticalValue
   * @param units
   * @param
   * @return the new transaction.
   * @throws DuplicateProductKeyException
   */
  public Container registerProductContainer(String serviceType, String serviceLevel, String key, String supplierKey,
      int price, int criticalValue, int units) throws DuplicateProductKeyException {
    if (_products.containsKey(key))
      throw new DuplicateProductKeyException(key);
    Container container = new Container(key, serviceType, serviceLevel, supplierKey, price, criticalValue, units);
    _products.put(key, container);
    return container;
  }

  /**
   * @param txtfile filename to be loaded.
   * @throws IOException
   * @throws BadEntryException
   * @throws DuplicateClientKeyException
   * @throws DuplicateProductKeyException
   * @throws NumberFormatException
   * @throws DuplicateSupplierKeyException
   */
  void importFile(String txtfile) throws IOException, BadEntryException, FileNotFoundException,
      DuplicateClientKeyException, NumberFormatException, DuplicateProductKeyException, DuplicateSupplierKeyException,
      ImportFileException {

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
            registerSupplier(split[0], split[1], split[2]);
          else if (split[0].equals("CLIENT"))
            registerClient(split[1], split[2], split[3]);
          else if (split[0].equals("BOX"))
            registerProductBox(split[1], split[2], split[3], Integer.parseInt(split[4]), Integer.parseInt(split[5]),
                Integer.parseInt(split[6]));
          else if (split[0].equals("CONTAINER"))
            registerProductContainer(split[1], split[2], split[3], split[4], Integer.parseInt(split[4]),
                Integer.parseInt(split[5]), Integer.parseInt(split[6]));
          else if (split[0].equals("BOOK"))
            registerProductBook(split[1], split[2], split[3], split[4], split[5], Integer.parseInt(split[4]),
                Integer.parseInt(split[5]), Integer.parseInt(split[6]));
      }
      in.close();
    } catch (FileNotFoundException e) {
      System.out.println("File not found: " + txtfile + ": " + e);
    } catch (IOException e) {
      System.out.println("IO error: " + txtfile + ": " + lineno + ": line " + e);
    }
  }
}