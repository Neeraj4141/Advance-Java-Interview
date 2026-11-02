package com.neeraj.junit.user;

import org.junit.Test;

import junit.framework.TestCase;

public class UserUpdate extends TestCase {

	@Test
	public void testUpdate() throws Exception {

		UserBean bean = UserModel.findByPk(1);

		bean.setFirst_name("aaa");

		UserModel.update(bean);

		bean = UserModel.findByPk(1);

		assertEquals("aaa", bean.getFirst_name());
	}
}