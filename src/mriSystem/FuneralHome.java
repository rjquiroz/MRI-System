package mriSystem;

public class FuneralHome {
    private String name;
    private Address funeralAddress;

    public FuneralHome(){

    }
    
    public FuneralHome(String name, Address funeralAddress){
        this.name = name;
        this.funeralAddress = funeralAddress;
    }

    public String toString(){
        return "\nFuneral Home Information: \n\nFuneral Home: " + name + funeralAddress.toString();
    }

}
