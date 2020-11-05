package woo.app.clients;

import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.DialogException;
import pt.tecnico.po.ui.Input;
import woo.Storefront;

import woo.exceptions.DuplicateClientKeyException;

import woo.Client;

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
    _key = _form.addStringInput(Message.requestClientKey());
    _name = _form.addStringInput(Message.requestClientName());
    _address = _form.addStringInput(Message.requestClientAddress());
  }

  @Override
  public void execute() throws DialogException {
    _form.parse();
    try {
      _receiver.registerClient(_key.value(), _name.value(), _address.value());
    } catch (_DuplicateClientKeyException e) {
        throw new DuplicateClientkeyException(e.getKey());
    }
  }

}
