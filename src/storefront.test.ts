/* eslint-disable no-console */
import { ShoppingCart, Product, displayProduct, calculateTotal } from './storefront-fixed';

const mockConsoleLog = jest.fn();
console.log = mockConsoleLog;

class PriceCalculationStub {
  calculateDiscount(price: number, discountPercent: number): number {
    return price * (1 - discountPercent / 100);
  }
}

describe('ShoppingCart Tests', () => {
  let cart: ShoppingCart;

  beforeEach(() => {
    cart = new ShoppingCart();
    mockConsoleLog.mockClear();
  });

  test('should calculate correct total for multiple items in cart', () => {
    const item1 = { name: 'Laptop', price: 999.99 };
    const item2 = { name: 'Mouse', price: 29.99 };
    const item3 = { name: 'Keyboard', price: 79.99 };

    cart.addItem(item1);
    cart.addItem(item2);
    cart.addItem(item3);

    const total = cart.getTotal();
    expect(total).toBeCloseTo(1109.97, 2);
  });

  test('should log correct message when adding item (using mock)', () => {
    const testItem = { name: 'Gaming Monitor', price: 399.99 };
    cart.addItem(testItem);
    expect(mockConsoleLog).toHaveBeenCalledWith('Item added: Gaming Monitor');
    expect(mockConsoleLog).toHaveBeenCalledTimes(1);
  });

  test('should apply discount correctly using price calculation stub', () => {
    const priceStub = new PriceCalculationStub();
    const originalPrice = 100.00;
    const discount = 20;
    const discountedPrice = priceStub.calculateDiscount(originalPrice, discount);
    expect(discountedPrice).toBe(80.00);
  });

  test('should return zero for empty cart total', () => {
    const total = cart.getTotal();
    expect(total).toBe(0);
  });

  test('should display "Free" for zero-price products', () => {
    const freeProduct: Product = { name: 'Free Sample', price: 0, category: 'Promotional' };
    const display = displayProduct(freeProduct);
    expect(display).toBe('Free');
  });

  test('should format price correctly for paid products', () => {
    const product: Product = { name: 'Premium Item', price: 49.99, category: 'Electronics' };
    const display = displayProduct(product);
    expect(display).toBe('$49.99');
  });

  test('should handle null prices in cart items', () => {
    const items: Array<{ name: string; price: number | null }> = [
      { name: 'Valid Item', price: 50 },
      { name: 'Invalid Item', price: null },
      { name: 'Another Valid', price: 30 }
    ];
    const total = calculateTotal(items as Array<{ name: string; price: number }>);
    expect(total).toBe(80);
  });
});
