package woo.app.clients;

import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.DialogException;
import pt.tecnico.po.ui.Input;
import woo.Storefront;

/**
 * Register new client.
 */
public class DoRegisterClient extends Command<Storefront> {

  public DoRegisterClient(Storefront storefront) {
    super(Label.REGISTER_CLIENT, storefront);
    _name = _form.addStringInput(Messages.requestSupplierName());
    _key = _form.addIntegerInput(Messages.requestSupplierKey());
    _key = _form.addStringInput(Messages.requestSupplierAddress());
    _status = _form.addBooleanInput(Messages.transactionsOn());
  }

  @Override
  public void execute() throws DialogException {
    // FIXME implement command
  }

}
