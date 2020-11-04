package woo.app.clients;

import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.DialogException;
import pt.tecnico.po.ui.Input;
import woo.Storefront;

import woo.exceptions.*;

/**
 * Register new client.
 */
public class DoRegisterClient extends Command<Storefront> {

  /** Input field. */
  Input<String> _name;

  /** Input field. */
  Input<String> _key;

  /** Input field. */
  Input<String> _address;

  public DoRegisterClient(Storefront storefront) {
    super(Label.REGISTER_CLIENT, storefront);
    _key = _form.addStringInput(Messages.requestSupplierKey());
    _name = _form.addStringInput(Messages.requestSupplierName());
    _address = _form.addStringInput(Messages.requestSupplierAddress());
  }

  @Override
  public void execute() throws DialogException {
    _form.parse();
    try {
      _receiver.registerClient(_key.value(), _name.value(), _address.value());
    } catch (DuplicateClientKeyException e) {
        throw new DuplicateClientkeyException(e.getKey());
    }
  }

}
