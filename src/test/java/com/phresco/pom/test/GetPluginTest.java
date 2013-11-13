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
import java.io.IOException;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.phresco.pom.exception.POMErrorCode;
import com.phresco.pom.exception.PhrescoPomException;
import com.phresco.pom.util.PomProcessor;

public class GetPluginTest {

	@Before
	public void prepare() throws IOException{
		File file = new File("pomTest.xml");
		if(file.exists()) {
			file.delete();
		}
	}
	
	@Test
	public void validGetPlugin() throws PhrescoPomException {
			PomProcessor processor = new PomProcessor(new File("pomTest.xml"));
			processor.addPlugin("phresco", "photon","2.2");
			processor.addPlugin("Suresh", "marimuthu","1.1");
			processor.getPlugin("phresco", "photon");
			processor.save();
			String actual = processor.getModel().getBuild().getPlugins().getPlugin().get(0).getArtifactId();
			String expected = "photon";
			Assert.assertEquals(actual,expected);
	}
	
	@Test
	public void invalidGetPlugin(){
		try {
			PomProcessor processor = new PomProcessor(new File("pomTest.xml"));
			processor.addPlugin("Suresh", "marimuthu","1.1");
			processor.addPlugin("phresco", "photon","2.2");
			processor.getPlugin("phres", "phot");
			Assert.assertTrue(true);
		} catch (PhrescoPomException e) {
			Assert.assertTrue(e.getErrorCode()==POMErrorCode.PLUGIN_NOT_FOUND);
		}
	}
	
	@After
	public void delete(){
		File file = new File("pomTest.xml");
		if(file.exists()) {
			file.delete();
		}
	}
}
