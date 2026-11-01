package com.neeraj.junit.user;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class UserUpdate {

	@Test
	public void update() throws Exception {

		UserBean bean = UserModel.findByPk(1);

		assertNotNull("User should not be null", bean);

		bean.setFirst_name("kapil");

		UserModel.update(bean);

		assertEquals("kapil", bean.getFirst_name());
	}
}