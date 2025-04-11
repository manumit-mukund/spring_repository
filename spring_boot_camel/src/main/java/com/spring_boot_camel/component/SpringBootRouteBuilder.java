package com.spring_boot_camel.component;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class SpringBootRouteBuilder extends RouteBuilder {

	@Override
	public void configure() throws Exception {

		// The route will copy all
		// content from the input folder to the output folder. After the route execution
		// is complete, the file is deleted from the source folder.		
		// from("file:C://folder-1").to("file:C://folder-2");
		

		// If you do not want this, then noop=true should
		// be specified. This will copy the files from
		// one location to another without deleting it
		// from the source folder.
		from("file:C://folder-1?noop=true").to("file:C://folder-2");
	}
}
