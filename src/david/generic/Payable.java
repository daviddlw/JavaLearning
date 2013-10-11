package david.generic;

public interface Payable<T> {
    public void pay();
}

class Hourly implements Payable<Hourly> {

    @Override
    public void pay() {
	// TODO Auto-generated method stub
	System.out.println("pay for hourly");
    }
}

class Daily implements Payable<Daily>{

    @Override
    public void pay() {
	// TODO Auto-generated method stub
	System.out.println("pay for daily");
    }    
}

//class Monthly extends Daily implements Payable<Monthly>{
//
//    @Override
//    public void pay() {
//	// TODO Auto-generated method stub
//	System.out.println("pay for monthly");
//    }
//    
//}
