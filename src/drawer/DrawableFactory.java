package drawer;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DrawableFactory {

	public DrawableFactory() {
		implementedDrawables = new HashMap<String, Class<?>>();
	}
	
	private Map<String, Class<?>> implementedDrawables;

	void implementPanel(String type, Class<?> panelClass) {
		implementedDrawables.put(type, panelClass);
	}

	public void buildDrawable(String type, List<Object> params)
			throws Exception {
		if (!implementedDrawables.containsKey(type)) {
			throw new Exception("Drawable not implemented!");
		} else {
			Class<?> c = Class.forName("drawer." + type);
			Constructor<?>[] constr = c.getDeclaredConstructors();
			constr[0].newInstance(params);
		}
	}

}
