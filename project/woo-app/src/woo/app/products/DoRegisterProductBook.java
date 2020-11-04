package woo.app.products;

import pt.tecnico.po.ui.Command;                                                                                                              import pt.tecnico.po.ui.DialogException;                                                                                                      import pt.tecnico.po.ui.Input;                                                                                                                import woo.Storefront;                                                                                                                        //FIXME import other classes

/**
 * Register book.
 */
public class DoRegisterProductBook extends Command<Storefront> {

  /** Input field. */
  Input<String> _key;

  /** Input field. */
  Input<String> _title;

  /** Input field. */
  Input<String> _author;

  /** Input field. */
  Input<String> _isbn;

  /** Input field. */
  Input<String> _supplierKey;
  
  /** Input field. */
  Input<Integer> _price;

  /** Input field. */
  Input<Integer> _criticalValue;

  int _units = 0;

  public DoRegisterProductBook(Storefront receiver) {
    super(Label.REGISTER_BOOK, receiver);
    _key = _form.addStringInput(Messages.requestProductKey());
    _title = _form.addStringInput(Messages.requestBookTitle());
    _author = _form.addStringInput(Messages.requestBookTAuthor());
    _isbn = _form.addStringInput(Messages.requestISBN());
    _supplierKey = _form.addStringInput(Messages.requestSupplierKey());
    _price = _form.addIntegerInput(Messages.requestPrice());
    _criticalValue = _form.addIntegerInput(Messages.requestStockCriticalValue());
  }

  @Override
  public final void execute() throws DialogException {
    _form.parse();
    try {
      _receiver.registerProductBook(_key.value(), _title.value(), _author.value(),_isbn.value(),_supplierKey.value(),_price.value(),_criticalValue.value(), _units);
    } catch (DuplicateProductKeyException e) {
        throw new DuplicateProductKeyException(e.getKey());
    }
  }
}
