/*
 * Copyright 2002-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.beans.factory.config;

import org.springframework.beans.BeansException;

/**
 * Allows for custom modification of an application context's bean definitions,
 * adapting the bean property values of the context's underlying bean factory.
 *
 * <p>Application contexts can auto-detect BeanFactoryPostProcessor beans in
 * their bean definitions and apply them before any other beans get created.
 *
 * <p>Useful for custom config files targeted at system administrators that
 * override bean properties configured in the application context.
 *
 * <p>See PropertyResourceConfigurer and its concrete implementations
 * for out-of-the-box solutions that address such configuration needs.
 *
 * <p>A BeanFactoryPostProcessor may interact with and modify bean
 * definitions, but never bean instances. Doing so may cause premature bean
 * instantiation, violating the container and causing unintended side-effects.
 * If bean instance interaction is required, consider implementing
 * {@link BeanPostProcessor} instead.
 *
 * 允许自定义修改应用程序上下文的Bean定义，以适应上下文基础Bean工厂的Bean属性值。
 *
 * 应用程序上下文可以在其Bean定义中自动检测BeanFactoryPostProcessor Bean，并在创建任何其他Bean之前应用它们。
 * 对于针对系统管理员的自定义配置文件很有用，这些文件覆盖了在应用程序上下文中配置的Bean属性。
 *
 * 请参阅PropertyResourceConfigurer及其具体实现，以获取可解决此类配置需求的即用型解决方案。
 *
 * BeanFactoryPostProcessor可以与Bean定义进行交互并对其进行修改，但不能与Bean实例进行交互。
 * 这样做可能会导致bean实例化过早，从而违反了容器并造成了意外的副作用。如果需要与bean实例交互，请考虑实现BeanPostProcessor。
 *
 * @author Juergen Hoeller
 * @since 06.07.2003
 * @see BeanPostProcessor
 * @see PropertyResourceConfigurer
 */
@FunctionalInterface
public interface BeanFactoryPostProcessor {

	/**
	 * Modify the application context's internal bean factory after its standard
	 * initialization. All bean definitions will have been loaded, but no beans
	 * will have been instantiated yet. This allows for overriding or adding
	 * properties even to eager-initializing beans.
	 * 在bean factory标准初始化之后对其进行修改。
	 * 此时所有bean定义已经被加载，但是还没有bean被实例化。
	 * 对bean的属性进行重写或者增加修改，甚至对eager-initializing bean也生效。
	 * @param beanFactory the bean factory used by the application context
	 * @throws org.springframework.beans.BeansException in case of errors
	 */
	void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException;

}
