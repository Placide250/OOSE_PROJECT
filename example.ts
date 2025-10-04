
const message = 'Hello World';

function calculateTotal(price: number, quantity: number) {
  if (price > 0) {
    return price * quantity;
  } else {
    return 0;
  }
}

const unusedVariable = 'This is not used';

console.log(message);

interface User {
  name: string;
  age: number;
}

function processUser(user: User) {
  if (user.age === 18) {
    return 'Just became adult';
  }
  return 'Processing user';
}