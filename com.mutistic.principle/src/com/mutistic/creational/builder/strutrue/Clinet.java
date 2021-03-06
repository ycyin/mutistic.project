package com.mutistic.creational.builder.strutrue;

import com.mutistic.utils.PrintUtil;

/**
 * @program Client 
 * @description 
 * @author mutisitic
 * @date 2018年8月14日
 */
public class Clinet {

	public static void main(String[] args) {
		PrintUtil.one("创建具体建造者实例");
		ConcreteBuilder builder = new ConcreteBuilder();
		
		PrintUtil.one("创建指导者传入建造者实例");
		Director dire = new Director(builder);
		
		PrintUtil.one("指导者开始构建");
		dire.construct();
		
		PrintUtil.one("从建造者获取构建后的产品对象");
		Product product = builder.getResultProduct();
		
		PrintUtil.one("处理产品的其他业务逻辑");
		product.getClass();
	}
}
