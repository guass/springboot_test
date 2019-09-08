package com.guass.www.springboot_jdbc.rpc;

import io.netty.channel.ChannelHandlerContext;

public class Server3Handler extends Middleware {

    public Server3Handler() {
        super("server");
        // TODO Auto-generated constructor stub
    }
    @Override
    protected void handlerData(ChannelHandlerContext ctx, Object msg) {
        // TODO Auto-generated method stub
        Model model  = (Model) msg;
        System.out.println("server 接收数据 ： " +  model.toString());
        model.setType(TypeData.CUSTOMER);
        model.setBody("---------------");
        ctx.channel().writeAndFlush(model);
        System.out.println("server 发送数据： " + model.toString());
    }
    @Override
    protected void handlerReaderIdle(ChannelHandlerContext ctx) {
        // TODO Auto-generated method stub
        super.handlerReaderIdle(ctx);
        System.err.println(" ---- client "+ ctx.channel().remoteAddress().toString() + " reader timeOut, --- close it");
        ctx.close();
    }
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)
            throws Exception {
        ctx.close();
        System.err.println( name +"  exception" + cause.toString());
    }

}
