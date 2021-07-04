import FoodItem from "../fooditems/fooditems";
import Customer from "../login/Customer";
import Cart from "./Cart";

export default class Orders{

    id:number=0;
    quantity:number=0;
    price:number=0;
    foodItem:FoodItem=new FoodItem();
    customer:Customer=new Customer();
}