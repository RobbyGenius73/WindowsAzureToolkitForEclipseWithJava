/*
 Copyright 2013 Microsoft Open Technologies, Inc.
 
 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at
 
 http://www.apache.org/licenses/LICENSE-2.0
 
 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.
 */

package com.microsoftopentechnologies.windowsazure.tools.build;

/**
 * 
 * A Class representing an environment variable setting
 * 
 */
public class StartupEnv {
	private String name;
	private String value;
	private String cloudValue;

	/**
	 * Sets name attribute
	 * @param name
	 *            Name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets name attribute
	 * @return
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Sets value attribute
	 * @param value
	 *            Value
	 */
	public void setValue(String value) {
		this.value = value;
	}

	/**
	 * Gets value attribute
	 * @return
	 */
	public String getValue() {
		return this.value;
	}

	/**
	 * Sets cloudvalue attribute
	 * @param value
	 *            Value
	 */
	public void setCloudValue(String value) {
		this.cloudValue = value;
	}

	/**
	 * Gets cloudvalue attribute
	 * @return
	 */
	public String getCloudValue() {
		if(this.cloudValue != null) {
			return this.cloudValue;
		} else {
			return this.value;
		}
	}

	/** Allows the use of an arbitrary type attribute setting on a component by external tools, but the Ant extension currently 
	 * has no functionality associated with it
	 * 
	 * @param type
	 */
	public void setType(String type) {
		return;
	}
	
	/**
	 * Returns the environment variable setting command line
	 * @return
	 */
	public String createCommandLine(boolean forCloud) {
		if(!forCloud) {
			return String.format("set %s=%s", this.name, this.getValue());
		} else {
			return String.format("set %s=%s", this.name, this.getCloudValue());			
		}
	}
	
	public String createCommandLine() {
		return createCommandLine(false);
	}
}