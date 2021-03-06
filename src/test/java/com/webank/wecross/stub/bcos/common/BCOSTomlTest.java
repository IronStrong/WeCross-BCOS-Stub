package com.webank.wecross.stub.bcos.common;

import static junit.framework.TestCase.assertEquals;

import java.io.IOException;
import org.junit.Test;

public class BCOSTomlTest {
    @Test
    public void loadTomlTest() throws IOException {
        String file = "stub-sample-ut.toml";
        BCOSToml bcosToml = new BCOSToml(file);
        assertEquals(bcosToml.getPath(), file);
    }
}
