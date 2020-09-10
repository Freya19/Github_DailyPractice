package gepeng18.test;

import java.io.IOException;

class SSuper{
    private void fun() throws IOException {
        throw new IOException();

    }
}

public class 重载  extends SSuper{

    protected void fun(){
    }

}
