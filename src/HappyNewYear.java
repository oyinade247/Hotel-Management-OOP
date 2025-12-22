public class HappyNewYear {
    public static void main(String [] args){
        long start = System.currentTimeMillis();

        int count = 1;

        while(count <= 3){
            long now = System.currentTimeMillis();
            if(now - start >= 1000){
                System.out.println("Happy new year");
            }
            count++;
            start = now;
        }
    }
}
