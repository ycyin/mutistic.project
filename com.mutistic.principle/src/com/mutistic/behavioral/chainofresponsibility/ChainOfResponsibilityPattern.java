package com.mutistic.behavioral.chainofresponsibility;

import com.mutistic.utils.PrintUtil;

/**
 * @program 职责链模式[Chain of Responsibility Pattern]
 * @description 
 * @author mutisitic
 * @date 2018年9月7日
 */
public class ChainOfResponsibilityPattern {
	public static void main(String[] args) {
		PrintUtil.ln("职责链模式[Chain of Responsibility Pattern]");
		PrintUtil.ln("一、定义、本质:\r\n" + 
				"\r\n" + 
				"定义: 使多个对象都有机会处理请求，从而避免请求的发送者和接收者之间的耦合美系。将这些对象连成一条链，\r\n" + 
				"并沿着这条链传递该请求，直到有一个对象处理它为止。\r\n" + 
				"本质: 分离职责，动态组合\r\n" + 
				"\r\n" + 
				"二、结构和说明:\r\n" + 
				"\r\n" + 
				"Handler：定义职责的接口，通常在这里定义处理请求的方法，可以在这实现后继链\r\n" + 
				"\r\n" + 
				"ConcreteHandler：实现职责的类，在这个类里面，实现对它职责范围内请求的处理，如果不处理，\r\n" + 
				"就继续转发请求给后继者。\r\n" + 
				"\r\n" + 
				"Client：职责链的客户端，向链上的具体处理者对象提交请求，让职责链负责处理\r\n" + 
				"\r\n" + 
				"三、理解:\r\n" + 
				"\r\n" + 
				"主要解决：职责链上的处理者负责处理请求，客户只需要将请求发送到职责链上即可，\r\n" + 
				"无须关心请求的处理细节和请求的传递，所以职责链将请求的发送者和请求的处理者解耦了。\r\n" + 
				"如何解决：拦截的类都实现统一接口。\r\n" + 
				"\r\n" + 
				"1、职责链模式的功能：\r\n" + 
				"  职责链模式主要用来处理：“客户端发出一个请求，有多个对象都有机会来处理这一个请求，但是客户端不知道究竟谁会来处理他的请求”，\r\n" + 
				"这样的情况。也就是需要让请求者和接收者解耦，这样就可以动态的切换和组合接收者了。\r\n" + 
				"  注意在标准的职责链模式里面，是只要有对象处理了请求，这个请求就到此为止，不再被传递和处理了。\r\n" + 
				"  如果是要变形使用职责链，就可以让这个请求继续传递，每个职责对象对这个请求进行一定的功能处理，\r\n" + 
				"从而形成一个处理请求的功能链。\r\n" + 
				"\r\n" + 
				"2、隐式接收者：\r\n" + 
				"  当客户端发出请求的时候，客户端并不知逍谁会真正处理他的请求，客户端只知道他提交请求的第一个对象。\r\n" + 
				"从第一个处理对开始，整个职责里面的对象，要么自己处理请求，要么继续转发给下一个接收者。\r\n" + 
				"\r\n" + 
				"3、谁来处理：\r\n" + 
				"  职责链中那么多处理对象，到底准来处理请求呢，这个是在运行时期动态决定的。\r\n" + 
				"当请求被传递到某个处理对象的时候，这个对象会按照己经没定好的条件来判断，是否属于自己处理的范上，\r\n" + 
				"如果是就处理，如果不是就转发请求给下一个对象\r\n" + 
				"\r\n" + 
				"4、请求一定会被处理吗？\r\n" + 
				"  在职责链模式中，请求不一定会被处理，因为可能没有合适的处理者，请求在职责链面从头传递尾，\r\n" + 
				"每个处理对象都判断不属于自己处理，最后请求就没有对象来处理。这一点是需要注意的。\r\n" + 
				"  可以在职责链的末端始终加一个不支持此功能处理的职责对象，如果传递到这个职责，提示本职责链没有真正的职责对象处理这个清求\r\n" + 
				"\r\n" + 
				"四、写法:\r\n" + 
				"\r\n" + 
				"1、如何构建链：\r\n" + 
				"  可以按照实现的地方：\r\n" + 
				"  1.1、外部链：可以实现在客户端，在提交请求前组合链，也就是在使用的时候动态组合链，称为外部链\r\n" + 
				"  1.2、内部链：可以在Handler里面实现链的组合，算是内部链的一种\r\n" + 
				"  1.3、内部连：可以在各个职责对象而，由各个职责对象自行决定后续的处理对象，\r\n" + 
				"这种实现力式要求每个职责对象除了进行业务处理外，还必须了解整个业务流程。\r\n" + 
				"按照构建的数据来源，也就是决定了按照什么顺序来组合链的数据，分以下几种：\r\n" + 
				"  1.3.1：可以在程序里面动态组合\r\n" + 
				"  1.3.2：可以通过外部，如数据库来获取组合的数据，这种属于数据库驱动的方式\r\n" + 
				"  1.3.3：可以通过配置文件传递过来，也可以是流程的配置文件，\r\n" + 
				"  如果是从外部获取数据来构建链，那么在程序运行的时候，会读取这些数据，然后根据数据的要求\r\n" + 
				"来获取相应的对象，并组合起来。\r\n" + 
				"  1.3.4、不需要构建链，因为己有的对象己经自然构成链了，这种情况多以现在组合模式构建的对象树中，\r\n" + 
				"这样子对象可以很自然的向上找到自己的父对象。\r\n" + 
				"\r\n" + 
				"2、处理多种请求的方式：\r\n" + 
				"  2.1、简单的处理方式：一个简单的方法就是为每种业务单独定义一个方法，然后客户端根据不同的需要调用不同的方法\r\n" + 
				"  2.2、涌用请求的处理方式：2.1的方式有一个很明显的问题，那就是只要增加一个业务，就需要修改职责的接口，\r\n" + 
				"不是很灵活的，Java开发中很强调面向接口编程，因此接口应该相对保持稳定，接口一修改，要修改的地方就太多了，\r\n" + 
				"频繁修改接口绝对不是个好主意。\r\n" + 
				"  \r\n" + 
				"  分析现在变化的东西：\r\n" + 
				"    不同的业务需要传递的业务数据不同\r\n" + 
				"    不同的业务请求的方法不同\r\n" + 
				"    不同的职责对象处理这些不同的业务请求的业务逻辑不同\r\n" + 
				"  解决这些问题，可以首先定义一套通用的调用框架、用一个通用的请求对象来封装请求传递的参数；\r\n" + 
				"然后定义一个通用的调用方法，这个方法不区分具体业务，所有的业务都是这一个方法，\r\n" + 
				"那么具体的业务如何区分呢，就是在通用的请求对象里面会有一个业务的标记，\r\n" + 
				"到了职责对象里面，属于本职责处理就跟原来一样的处理方式，如果不属于，就传递到下一个处理对象就好了。\r\n" + 
				"\r\n" + 
				"3、功能链：\r\n" + 
				"  在实际开发中，经会出现一个把职责链稍稍变形的用法。\r\n" + 
				"  在标准的职责链中，一个请求在职责链中传递，只要有一个对象处理了这个请求，就会停止。\r\n" + 
				"  现在稍稍变一下，改成一个请求在职责链中传递，每个职责区对象负责处理请求的某一方面功能，处理完成后，不是停止，\r\n" + 
				"而是继续向下传递请求，当请求通过很多职责对象处理过后，功能也就处理完了，把这样的职责链称为功能链。\r\n" + 
				"\r\n" + 
				"五、优点:\r\n" + 
				"\r\n" + 
				"1、请求者和就接收者松散耦合\r\n" + 
				"2、动态组合职责\r\n" + 
				"3、简化了对象。使得对象不需要知道链的结构\r\n" + 
				"4、增强给对象指派职责的灵活性。通过改变链内的成员或者调动它们的次序，允许动态地新增或者删除责任。 \r\n" + 
				"5、增加新的请求处理类很方便。 \r\n" + 
				"\r\n" + 
				"六、缺点:\r\n" + 
				"\r\n" + 
				"1、产生很多细粒度对象\r\n" + 
				"2、请求不一定能被处理\r\n" + 
				"3、系统性能将受到一定影响，而且在进行代码调试时不太方便，可能会造成循环调用。 \r\n" + 
				"4、可能不容易观察运行时的特征，容易出错\r\n" + 
				"\r\n" + 
				"七、使用场景:\r\n" + 
				"\r\n" + 
				"1、如果有多个对象可以处理同一个请求，但是具体由哪个对象来处理该请求，是运行时刻动态确定的。\r\n" + 
				"这种情况可以使用职责链模式，把处理请求的对象实现成为职责对象，然后把它们构成一个职责链，\r\n" + 
				"当请求在这个链中传递的时候，具体由哪个职责对象来处理，会在运行时动态判断\r\n" + 
				"\r\n" + 
				"2、如果想在不明确指定接收者的情况下，向多个对象中的一个提交一个请求的话，可以使用职责链模式，\r\n" + 
				"职责链模式实现了请求者和接收者之间的解耦，请求者不需要知道究竟是哪一个接收者对象来处理了请求\r\n" + 
				"\r\n" + 
				"3、如果想要动态指定处理一个请求的对象集合，可以使用职责链模式，职责链模式能动态的构建职责链，\r\n" + 
				"也就是动态的来决定到底哪些职责对象来参处理请求中来，相当于是动态指定了处一个请求的职责对象集合\r\n" + 
				"\r\n" + 
				"具体场景：\r\n" + 
				"1、JS 中的事件冒泡。 \r\n" + 
				"2、JAVA WEB 中 Apache Tomcat 对 Encoding 的处理，Struts2 的拦截器，jsp servlet 的 Filter。 \r\n" + 
				"\r\n" + 
				"八、注意事项:\r\n" + 
				"\r\n" + 
				"在 JAVA WEB 中遇到很多应用，比如Filter\r\n" + 
				"");
	}
}