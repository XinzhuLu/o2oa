package com.x.query.service.processing.jaxrs;

import java.util.Set;

import javax.ws.rs.ApplicationPath;

import com.x.base.core.project.jaxrs.AbstractActionApplication;
import com.x.query.service.processing.jaxrs.design.DesignAction;
import com.x.query.service.processing.jaxrs.neural.NeuralAction;
import com.x.query.service.processing.jaxrs.segment.SegmentAction;
import com.x.query.service.processing.jaxrs.table.TableAction;
import com.x.query.service.processing.jaxrs.touch.TouchAction;

@ApplicationPath("jaxrs")
public class ActionApplication extends AbstractActionApplication {

	public Set<Class<?>> getClasses() {
		classes.add(TouchAction.class);
		classes.add(NeuralAction.class);
		classes.add(SegmentAction.class);
		classes.add(DesignAction.class);
		classes.add(TableAction.class);
		return classes;
	}

}
