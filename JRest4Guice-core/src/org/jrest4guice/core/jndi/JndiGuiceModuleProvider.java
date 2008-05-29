package org.jrest4guice.core.jndi;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import org.jrest4guice.core.guice.ModuleProviderTemplate;
import org.jrest4guice.core.jndi.annotations.JndiResource;

import com.google.inject.Binder;
import com.google.inject.Module;

/**
 * 
 * @author <a href="mailto:zhangyouqun@gmail.com">cnoss</a>
 * 
 */
public class JndiGuiceModuleProvider extends ModuleProviderTemplate {
	public JndiGuiceModuleProvider(String... packages) {
		super(packages);
	}

	@Override
	public List<Module> getModules() {
		List<Module> modules = new ArrayList<Module>(0);
		modules.add(new Module() {
			@Override
			public void configure(Binder binder) {
				Field[] fields;
				JndiResource annotation;
				Class type;
				for (Class<?> clazz : classes) {
					fields = clazz.getDeclaredFields();
					System.out.println(clazz.getName()+":"+fields.length);
					for(Field f: fields){
						if(f.isAnnotationPresent(JndiResource.class)){
							annotation = f.getAnnotation(JndiResource.class);
							type = f.getType();
							binder.bind(type).toProvider(JndiProvider.fromJndi(type,annotation.jndi()));
						}
					}
				}			
			}
		});

		return modules;
	}
}