package com.x.processplatform.assemble.designer.jaxrs;

import javax.servlet.annotation.WebFilter;

import com.x.base.core.project.jaxrs.CipherManagerUserJaxrsFilter;

@WebFilter(urlPatterns = "/jaxrs/output/*", asyncSupported = true)
public class OutputJaxrsFilter extends CipherManagerUserJaxrsFilter {

}
