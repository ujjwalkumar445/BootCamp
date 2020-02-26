package exercise2;

class Q5_cloneable implements Cloneable{
    int rollno;
    String name;
    Q5_cloneable(int rollno,String name){
    }

    public static void main(String[] args) {
        try{
            Q5_cloneable a = new Q5_cloneable(4161,"ujjwal");
            Q5_cloneable a2 = (Q5_cloneable)a.clone();
            System.out.println(a.rollno+" "+a.name);
            System.out.println(a2.rollno+" "+a2.name);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }

}
