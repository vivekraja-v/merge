/**
 * Phresco Pom
 *
 * Copyright (C) 1999-2013 Photon Infotech Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.phresco.pom.test;

import java.io.File;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.phresco.pom.exception.PhrescoPomException;
import com.phresco.pom.model.Model.Dependencies;
import com.phresco.pom.util.PomProcessor;

public class RemoveAllDependencyTest {

	@Before
	public void prepare() throws PhrescoPomException {

	}

	@Test
	public void validRemoveAllDependency() throws PhrescoPomException {
		AddDependencyTest addTest = new AddDependencyTest();
		addTest.prepare();	
		PomProcessor processor = new PomProcessor(new File("pomTest.xml"));
		processor.removeAllDependencies();
		processor.save();
		Dependencies actual = processor.getModel().getDependencies();
		Dependencies expected = null;
		Assert.assertEquals(expected, actual);

	}
	@Test
	public void validRemoveAllDependencyNull() throws PhrescoPomException {
		PomProcessor processor = new PomProcessor(new File("pomTest.xml"));
		processor.removeAllDependencies();
		processor.save();

	}
	@After
	public void delete(){
		File file = new File("pomTest.xml");
		if(file.exists()) {
			file.delete();
		}
	}
}
