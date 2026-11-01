package com.neeraj.junit.user;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import org.junit.Test;

public class UserAdd {

	@Test
	public void testAdd() throws Exception {

		UserBean bean = new UserBean();

		bean.setId(100);
		bean.setFirst_name("Sandeep");
		bean.setLogin("sandeep123");

		UserModel model = new UserModel();
		model.add(bean);

		bean = model.findByPk(100);

		assertNotNull("User should not be null", bean);
		assertEquals("Sandeep", bean.getFirst_name());
		assertEquals("sandeep123", bean.getLogin());
	}
}