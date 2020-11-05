package woo.app.products;

import pt.tecnico.po.ui.Command;   
import pt.tecnico.po.ui.DialogException;
import pt.tecnico.po.ui.Input;
import woo.Storefront;
import woo.exceptions.DuplicateProductKeyException;


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

  int _units;

  public DoRegisterProductBook(Storefront receiver) {
    super(Label.REGISTER_BOOK, receiver);
    _key = _form.addStringInput(Message.requestProductKey());
    _title = _form.addStringInput(Message.requestBookTitle());
    _author = _form.addStringInput(Message.requestBookTAuthor());
    _isbn = _form.addStringInput(Message.requestISBN());
    _supplierKey = _form.addStringInput(Message.requestSupplierKey());
    _price = _form.addIntegerInput(Message.requestPrice());
    _criticalValue = _form.addIntegerInput(Message.requestStockCriticalValue());
  }

  @Override
  public final void execute() throws DialogException {
    _form.parse();
    try {
      _receiver.registerProductBook(_key.value(), _title.value(), _author.value(),_isbn.value(),_supplierKey.value(),_price.value(),_criticalValue.value(), _units);
    } catch (_DuplicateProductKeyException e) {
        throw new DuplicateProductKeyException(e.getKey());
    }
  }
}
