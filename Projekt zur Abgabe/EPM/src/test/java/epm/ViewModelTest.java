package epm;

import org.junit.Assert;
import org.junit.Test;

public class ViewModelTest {
	@Test
	public void disableLoginButton() throws Exception {
		ViewModel viewModel = new ViewModel();
		// No username and password were set
		Assert.assertFalse(viewModel.isLoginPossibleProperty().get());

		viewModel.userNameProperty().set("Stefanie Albrecht");
		// username was set, but no password
		Assert.assertFalse(viewModel.isLoginPossibleProperty().get());

		viewModel.passwordProperty().set("love");
		// username and password were set
		Assert.assertTrue(viewModel.isLoginPossibleProperty().get());
	}
}