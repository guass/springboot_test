package com.guass.www.springboot_jdbc.rpc;

/**
 * 编写一个配置类接口,用于控制心跳包和应用消息的处理
 */
public interface TypeData {

    byte PING = 1;

    byte PONG = 2;
    //顾客
    byte CUSTOMER = 3;
}
