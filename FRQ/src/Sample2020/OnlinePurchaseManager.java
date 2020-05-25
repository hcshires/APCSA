package Sample2020;

import java.util.ArrayList;

public class OnlinePurchaseManager {

    private ArrayList<Gizmo> purchases;

    public int countElectronicsByMaker(String maker) {
        int count = 0;
        for (int i = 0; i < purchases.size(); i++) {
            if (purchases.get(i).isElectronic() && purchases.get(i).getMaker().equals(maker)) {
                count++;
            }
        }

        return count;
    }

    public boolean hasAdjacentEqualPair() {
        for (int i = 0; i < purchases.size() - 1; i++) {
            if (purchases.get(i).equals(purchases.get(i + 1))) {
                return true;
            }
        }

        return false;
    }
}
