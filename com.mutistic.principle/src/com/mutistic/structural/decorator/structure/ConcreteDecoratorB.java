package com.mutistic.structural.decorator.structure;

import com.mutistic.utils.PrintUtil;

/**
 * @program ConcreteDecorator：
 * @description 实际的装饰器对象，实现具体要向被装饰对象添加的功能。
 * @author mutisitic
 * @date 2018年9月6日
 */
public class ConcreteDecoratorB  extends Decorator {
	/**
	 * 构造函数：传入具体的组件对象
	 * @param component 具体的组件对象
	 */
	public ConcreteDecoratorB(Component component) {
		super(component);
	}

	/**
	 * @description 重写Decorator的operation，实现具体的装饰功能
	 * @author mutisitic
	 * @date 2018年9月6日
	 * @see com.mutistic.structural.decorator.structure.Decorator#operation()
	 */
	@Override
	public void operation() {
		// 调用父类的方法，可以在调用前后添加附加动作
		super.operation(); 
		addedBehavior();
	}

	/**
	 * @description 添加的职责
	 * @author mutisitic
	 * @date 2018年9月6日
	 */
	private void addedBehavior() {
		PrintUtil.three("ConcreteDecoratorB.addedBehavior()", "添加的职责");
	}
}
