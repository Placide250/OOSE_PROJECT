const productName = 'Sample Product';
const price = 19.99;

interface CartItem {
  price: number;
  name: string;
}

function calculateTotal(items: CartItem[]): number {
  let total = 0;
  
  for (let i = 0; i < items.length; i++) {
    if (items[i].price !== null) {
      total += items[i].price;
    }
  }
  
  return total;
}

class ShoppingCart {
  private items: CartItem[] = [];

  addItem(item: CartItem): void {
    this.items.push(item);
    console.log('Item added: ' + item.name);
  }

  getTotal(): number {
    return calculateTotal(this.items);
  }
}

interface Product {
  name: string;
  price: number;
  category: string;
}

function displayProduct(product: Product): string {
  if (product.price === 0) {
    return 'Free';
  }
  return `$${product.price}`;
}

export { ShoppingCart, Product, displayProduct, calculateTotal };
