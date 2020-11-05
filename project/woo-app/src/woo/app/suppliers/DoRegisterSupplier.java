package woo.app.suppliers;

import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.DialogException;
import woo.Storefront;
import pt.tecnico.po.ui.Input;
import woo.exceptions.DuplicateSupplierKeyException;

/**
 * Register supplier.
 */
public class DoRegisterSupplier extends Command<Storefront> {

  /** Input field. */
  Input<String> _key;

  /** Input field. */
  Input<String> _name;

  /** Input field. */
  Input<String> _address;

  public DoRegisterSupplier(Storefront receiver) {
    super(Label.REGISTER_SUPPLIER, receiver);
    _name = _form.addStringInput(Message.requestSupplierName());
    _key = _form.addStringInput(Message.requestSupplierKey());
    _address = _form.addStringInput(Message.requestSupplierAddress());
  }

  @Override
  public void execute() throws DialogException {
    _form.parse();
    try {
      _receiver.registerSupplier(_key.value(), _name.value(), _address.value());
    } catch (_DuplicateSupplierKeyException e) {
        throw new DuplicateSupplierKeyException(e.getKey());
    }
  }
}
