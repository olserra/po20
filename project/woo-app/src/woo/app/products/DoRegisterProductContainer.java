package woo.app.products;

import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.DialogException;
import pt.tecnico.po.ui.Input;
import woo.Storefront;

/**
 * Register container.
 */
public class DoRegisterProductContainer extends Command<Storefront> {

  /** Input field. */
  Input<String> _key;

  /** Input field. */
  Input<String> _serviceType;

  /** Input field. */
  Input<String> _supplierKey;

  /** Input field. */
  Input<Integer> _price;

  /** Input field. */
  Input<Integer> _criticalValue;

  int _units = 0;

  public DoRegisterProductContainer(Storefront receiver) {
    super(Label.REGISTER_CONTAINER, receiver);
    _key = _form.addStringInput(Messages.requestProductKey());
    _serviceType = _form.addStringInput(Messages.requestServiceType());
    _supplierKey = _form.addStringInput(Messages.requestSupplierKey());
    _price = _form.addIntegerInput(Messages.requestPrice());
    _criticalValue = _form.addIntegerInput(Messages.requestStockCriticalValue());
  }

  @Override
  public final void execute() throws DialogException {
    _form.parse();
    try {
      _receiver.registerProductContainer(_key.value(), _serviceType.value(), _supplierKey.value(),
          _price.value(), _criticalValue.value(), _units);
    } catch (DuplicateProductKeyException e) {
      throw new DuplicateProductKeyException(e.getKey());
    }
  }
}
