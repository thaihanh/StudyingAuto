package exercise3;

public class C extends B {
    @Override
    public void exception() throws Exception {
        //super.exception();
        throw new Exception("level 3");
    }
}
