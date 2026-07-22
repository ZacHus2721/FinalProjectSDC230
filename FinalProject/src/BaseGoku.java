public class BaseGoku extends Player {

    public BaseGoku() {
        super("Goku", "Base Form", 9000);
    }

    @Override
    public void specialMove() {
        System.out.println("Goku uses the Kaio-Ken Attack!");
    }

}