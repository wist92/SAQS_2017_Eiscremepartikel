package epm;

import org.junit.Assert;
import org.junit.Test;

public class ViewModelTest {
	@Test
	public void disableLoginButton() throws Exception {
		ViewModel viewModel = new ViewModel();
		// No stationId and target were set
		Assert.assertFalse(viewModel.isApplyPossibleProperty().get());

		viewModel.getStationIdProperty().set("GD6G5");
		// stationId was set, but no target
		Assert.assertFalse(viewModel.isApplyPossibleProperty().get());

		viewModel.getTargetProperty().set("45");
		// stationId and target were set
		Assert.assertTrue(viewModel.isApplyPossibleProperty().get());
	}
}