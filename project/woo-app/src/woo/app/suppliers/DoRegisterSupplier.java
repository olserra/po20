package woo.app.suppliers;

import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.DialogException;
import woo.Storefront;

/**
 * Register supplier.
 */
public class DoRegisterSupplier extends Command<Storefront> {

  /** Input field. */
  Input<String> _name;

  /** Input field. */
  Input<Integer> _key;

  /** Input field. */
  Input<String> _address;

  /** Input field. */
  Input<String> _name;

  public DoRegisterSupplier(Storefront receiver) {
    super(Label.REGISTER_SUPPLIER, receiver);
    _name = _form.addStringInput(Messages.requestSupplierName());
    _key = _form.addIntegerInput(Messages.requestSupplierKey());
    _address = _form.addStringInput(Messages.requestSupplierAddress());
    _status = _form.addStringInput(Messages.transactionsOn());
  }

  @Override
  public void execute() throws DialogException {
    _form.parse();
    try {
      _receiver.addSupplier(_name.value(), _id.value());
      _display.popup(Messages.createdSupplier(_name.value(), _key.value(), _address.value(), _status.value()));
    } catch (DuplicateHolderException e) {
      _display.popup("DUPLICATE WHILE TRYING; " + Messages.createdHolder(_name.value(), _key.value(), _address.value(), _status.value()));
    }
  }

}
