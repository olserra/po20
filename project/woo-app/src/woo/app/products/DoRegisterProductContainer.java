package woo.app.products;

import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.DialogException;
import pt.tecnico.po.ui.Input;
import woo.Storefront;

import woo.exceptions.DuplicateProductKeyException;
import woo.Supplier;

/**
 * Register container.
 */
public class DoRegisterProductContainer extends Command<Storefront> {

  /** Input field. */
  Input<String> _key;

  /** Input field. */
  Input<String> _serviceType;

  /** Input field. */
  Input<String> _serviceLevel;

  /** Input field. */
  Input<String> _supplierKey;

  /** Input field. */
  Input<Integer> _price;

  /** Input field. */
  Input<Integer> _criticalValue;

  int _units;

  public DoRegisterProductContainer(Storefront receiver) {
    super(Label.REGISTER_CONTAINER, receiver);
    _key = _form.addStringInput(Message.requestProductKey());
    _serviceType = _form.addStringInput(Message.requestServiceType());
    _serviceLevel = _form.addStringInput(Message.requestServiceLevel());
    _supplierKey = _form.addStringInput(Message.requestSupplierKey());
    _price = _form.addIntegerInput(Message.requestPrice());
    _criticalValue = _form.addIntegerInput(Message.requestStockCriticalValue());
  }

  @Override
  public final void execute() throws DialogException {
    _form.parse();
    try {
      _receiver.registerProductContainer(_key.value(), _serviceType.value(), _serviceLevel.value(), _supplierKey.value(),
          _price.value(), _criticalValue.value(), _units);
    } catch (_DuplicateProductKeyException e) {
      throw new DuplicateProductKeyException(e.getKey());
    }
  }
}
