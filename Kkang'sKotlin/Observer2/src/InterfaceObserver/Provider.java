package InterfaceObserver;

import java.util.ArrayList;
import java.util.List;

public class Provider implements Subscribable {

    @Override
    public List<Integer> observerList(int x) {
        List<Integer> list = new ArrayList<>();
        list.add(x);

        return list;
    }
}
