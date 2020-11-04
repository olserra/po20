package woo;

import woo.exceptions.ImportFileException;
import woo.exceptions.MissingFileAssociationException;
import woo.exceptions.UnavailableFileException;
import woo.exceptions.BadEntryException;
import woo.exceptions.DuplicateClientKeyException;
import woo.exceptions.DuplicateProductKeyException;
import woo.exceptions.DuplicateSupplierKeyException;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.io.FileNotFoundException;

/**
 * Storefront: façade for the core classes.
 */
public class Storefront {

  /**
   * Carrega o estado anterior da aplicacao que estava guardado num dado ficheiro.
   *
   * @param file o nome do ficheiro com os dados serializados.
   *
   * @throws IOException caso aconteca algum erro durante a leitura do estado.
   * @return um objecto Telele com dados os recuperados do file.
   * @throws ClassNotFoundException
   **/

  /** The actual store. */
  private Store _store = new Store();

  public Client DoRegisterClient(String key, String name, String address) throws DuplicateClientKeyException {
    return _store.registerClient(key, name, address);
  }

  public Supplier DoRegisterSupplier(String key, String name, String address) throws DuplicateSupplierKeyException {
    return _store.registerSupplier(key, name, address);
  }

  public Box DoRegisterProductBox(String key, String serviceType, String supplierKey, int price, int criticalValue,
      int units) throws DuplicateProductKeyException {
    return _store.registerProductBox(key, serviceType, supplierKey, price, criticalValue, units);
  }

  public Book DoRegisterProductBook(String key, String title, String author, String isbn, String supplierKey, int price,
      int criticalValue, int units) throws DuplicateProductKeyException {
    return _store.registerProductBook(key, title, author, isbn, supplierKey, price, criticalValue, units);
  }

  public Container DoRegisterProductContainer(String serviceType, String serviceLevel, String key, String supplierKey,
      int price, int criticalValue, int units) throws DuplicateProductKeyException {
    return _store.registerProductContainer(key, serviceType, serviceLevel, supplierKey, price, criticalValue, units);
  }

  /**
   * @throws IOException
   * @throws FileNotFoundException
   * @throws MissingFileAssociationException
   */
  public static void save(Store store, String file)
      throws IOException, FileNotFoundException, MissingFileAssociationException {
    ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
    out.writeObject(store);
    out.close();
  }

  /**
   * @param filename
   * @throws MissingFileAssociationException
   * @throws IOException
   * @throws FileNotFoundException
   */
  public void saveAs(String filename) throws MissingFileAssociationException, FileNotFoundException, IOException {
    String _filename = filename;
  }

  /**
   * @param filename
   * @throws UnavailableFileException
   * @throws IOException
   * @throws FileNotFoundException
   * @throws ClassNotFoundException
   */
  public static Store load(String filename)
      throws UnavailableFileException, FileNotFoundException, IOException, ClassNotFoundException {
    ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename));

    Store store = (Store) in.readObject();
    in.close();

    return store;
  }

  /**
   * @param textfile
   * @throws ImportFileException
   * @throws DuplicateProductKeyException
   * @throws DuplicateClientKeyException
   * @throws NumberFormatException
   * @throws DuplicateSupplierKeyException
   */
  public void importFile(String textfile) throws ImportFileException, NumberFormatException,
      DuplicateClientKeyException, DuplicateProductKeyException, DuplicateSupplierKeyException {
    try {
      _store.importFile(textfile);
    } catch (IOException | BadEntryException e) {
      throw new ImportFileException(textfile);
    }
  }

}
