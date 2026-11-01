package com.neeraj.junit.user;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class UserDelete {

	@Test
	public void delete() throws Exception {

		UserModel.delete(40);

		UserBean bean = UserModel.findByPk(40);

//		assertTrue(bean ==null);
		assertNull(bean);

	}
}