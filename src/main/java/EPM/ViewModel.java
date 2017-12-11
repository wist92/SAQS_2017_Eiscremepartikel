package EPM;

import javax.swing.event.EventListenerList;

import java.util.*;

//import EPM.Station;

public class ViewModel {

	private EventListenerList views = new EventListenerList();

//	private Station station;
//	private boolean addbutton;
	// private highlighting h;

	public ViewModel() {
		new Timer().schedule(new TimerTask() {
			@Override
			public void run() {
				// Station hinzufügen
				notifyViews(new GUIEvent(this, "Romeo"));
			}
		}, 0, 500);
	}

	public void addView(GUIListener listener) {
		views.add(GUIListener.class, listener);
	}

	public void removeView(GUIListener listener) {
		views.remove(GUIListener.class, listener);
	}

	protected synchronized void notifyViews(GUIEvent event) {
		for (GUIListener g : views.getListeners(GUIListener.class)) {
			g.updateGUI(event);
		}
	}
}
