package com.biacode.biacentric.vcs.test

import com.biacode.biacentric.vcs.test.helper.VcsUnitTestHelper
import org.easymock.EasyMockRunner
import org.easymock.EasyMockSupport
import org.junit.runner.RunWith

/**
 * Created by Arthur Asatryan.
 * Date: 11/10/17
 * Time: 7:00 PM
 */
@RunWith(EasyMockRunner::class)
abstract class AbstractVcsUnitTest : EasyMockSupport() {

    private val helper = VcsUnitTestHelper()

}