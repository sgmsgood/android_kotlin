public class Singleton {

    public static void main(String[] args) {

    }
}

class Singleton {
    private Singleton() {}

    private static Singleton instance = null;
    static Singleton newInstance() {
        if(instance == null){
            instance = new Singleton();
        }
        return instance;
    }
}