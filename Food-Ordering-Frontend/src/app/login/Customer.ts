import Address from "./Address";
export default class  Customer{
    id:number=0;
    email:string="";
    password:string="";
    firstName:string="";
    lastName:string="";
    address:Address=new Address();
}