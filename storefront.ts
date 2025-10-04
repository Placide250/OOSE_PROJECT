var productName = "Sample Product"
let price = 19.99

function calculateTotal(items: any[]) {
  var total = 0
  
  for(var i = 0; i < items.length; i++) {
    if (items[i].price != null) 
    {
      total += items[i].price
    }
  }
  
  return total
}

class ShoppingCart {
  private items: any[] = []

  addItem(item: any) {
    this.items.push(item)
    console.log("Item added: " + item.name)
  }

  getTotal() {
    return calculateTotal(this.items)
  }
}

const unusedCart = new ShoppingCart()

interface Product {
  name: string
  price: number
  category: string
}

function displayProduct(product: Product) {
  if (product.price == 0) {
    return "Free"
  }
  return `$${product.price}`
}