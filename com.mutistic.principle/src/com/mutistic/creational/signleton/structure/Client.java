package com.mutistic.creational.signleton.structure;

import com.mutistic.utils.PrintUtil;

/**
 * @program Client客户端 
 * @description 
 * @author mutisitic
 * @date 2018年8月13日
 */
public class Client {
	public static void main(String[] args) {
		PrintUtil.one("演示单例模式[Signleton Pattern]：");
		PrintUtil.two("单例模式-饿汉式", SignletonByHungry.getIntance());
		PrintUtil.two("单例模式-懒汉式（线程不安全）", Signleton.getIntance());
		PrintUtil.two("单例模式-懒汉式（使用synchronized保证线程安全）", SignletonBySynchronized.getIntance());
		PrintUtil.two("单例模式-懒汉式（通过双重检查枷锁的方式实现线程安全）", SignletonByVolatile.getIntance());
		PrintUtil.two("单例模式-懒汉式（通过 Lazy initialization holder class模式）", SignletonByLazzClass.getIntance());
		PrintUtil.two("单例模式-懒汉式（通过单元素枚举）", SignletonByEnum.uniqueIntance);
	}
}
