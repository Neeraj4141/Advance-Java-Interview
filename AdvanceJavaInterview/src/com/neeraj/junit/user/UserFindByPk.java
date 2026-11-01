package com.neeraj.junit.user;

import org.junit.Test;

import junit.framework.TestCase;

public class UserFindByPk extends TestCase {

    @Test
    public void testFindByPk() throws Exception {

        UserBean bean = UserModel.findByPk(1);
 assertNotNull("usernot not null", bean);
    }
}