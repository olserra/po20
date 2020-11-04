package woo.app.clients;

import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.DialogException;
import pt.tecnico.po.ui.Input;
import woo.Storefront;

/**
 * Show client.
 */
public class DoShowClient extends Command<Storefront> {

  /** Input field. */
  Input<String> _key;

  public DoShowClient(Storefront storefront) {
    super(Label.SHOW_CLIENT, storefront);
    _key = _form.addStringInput(Messages.requestClientKey());
  }

  @Override
  public void execute() throws DialogException {
    _display.popup(_receiver.getClient(_key));
  }

}
