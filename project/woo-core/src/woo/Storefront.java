package woo;

import java.io.IOException;
import woo.exceptions.ImportFileException;
import java.io.FileNotFoundException;
import woo.exceptions.MissingFileAssociationException;
import woo.exceptions.UnavailableFileException;
import woo.exceptions.BadEntryException;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

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

  /** Current filename. */
  private String _filename = "";

  /** The actual store. */
  private Store _store = new Store();

  // FIXME define other attributes
  // FIXME define constructor(s)
  // FIXME define other methods

  /**
   * @throws IOException
   * @throws FileNotFoundException
   * @throws MissingFileAssociationException
   */
  public void save(Store store, String file)
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
    _filename = filename;
    save();
  }

  /**
   * @param filename
   * @throws UnavailableFileException
   */
  public void load(String filename) throws UnavailableFileException {
    ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename));

    Store store = (Store) in.readObject();
    in.close();

    return store;
  }

  /**
   * @param textfile
   * @throws ImportFileException
   */
  public void importFile(String textfile) throws ImportFileException {
    try {
      _store.importFile(textfile);
    } catch (IOException | BadEntryException /* FIXME maybe other exceptions */ e) {
      throw new ImportFileException(textfile);
    }
  }

}
