package com.company;

class bank {
    void getDetails(double rate){
        System.out.println("Rate : " + rate);
    }
}

class SBI extends bank{
    void getDetails(double rate){
        System.out.println("rate : " + rate);
    }
}
class BOI extends bank{
    void getDetails(double rate) {
        System.out.println("rate : " + rate);
    }
}

class ICICI extends bank {
    void getDetails(double rate){
        System.out.println("rate : " + rate);
    }
}

class Overriding {
    public static void main(String[] args) {
        SBI sb = new SBI();
        BOI b = new BOI();
        ICICI ic = new ICICI();
        sb.getDetails(5.6);
        b.getDetails(8.7);
        ic.getDetails(56.4);

    }
}