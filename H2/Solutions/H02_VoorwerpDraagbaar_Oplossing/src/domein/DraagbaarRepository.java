package domein;

import java.util.ArrayList;
import java.util.List;

public class DraagbaarRepository {

    private final List<Draagbaar> collectie;

    public DraagbaarRepository() {
        collectie = new ArrayList<>();
    }

    public void voegDraagbaarItemToe(Draagbaar item) {
        collectie.add(item);
    }

	public List<Draagbaar> getCollectie() {
		return collectie;
	}
}
