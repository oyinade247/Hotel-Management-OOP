package hotels;

public enum RoomType {
        SINGLE(10000),
        DOUBLE(15000),
        SUITE(25000);
        private int price;


        RoomType(int price){
            this.price = price;

        }
    public int getPrice(){
            return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }

}
