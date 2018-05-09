package com.itlgl.ui.panel;

public interface BaseFunctionInterface {
    byte[] encode(byte[] src) throws Exception;
    byte[] decode(byte[] src) throws Exception;
}
