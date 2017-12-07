package EPM;

/*
 * Test für Observer Ansatz
 */
public class Client {

	public static void main(String[] args) {
		ViewModel vm = new ViewModel();
		
		class TestView implements GUIListener {
			public void updateGUI(GUIEvent event) {
				System.out.println(event.getMessage());
			}
		}

		vm.addView(new TestView());
	}

}
