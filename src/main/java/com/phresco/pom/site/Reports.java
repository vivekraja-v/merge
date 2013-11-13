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
package com.phresco.pom.site;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement 
public class Reports implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1793840535412841558L;

	private String id;
	
	private String displayName = "";
	
	private String artifactId ="";
	
	private String groupId = "";
	
	private String version = "";
	
	private boolean enabled=false;
	
	private List<ReportCategories> reportCategories;
	
	private String techId;
	
	public Reports(String displayName, String artifactId, String groupId,
			String version) {
		super();
		this.displayName = displayName;
		this.artifactId = artifactId;
		this.groupId = groupId;
		this.version = version;
	}
	

	/**
	 * @param reportCategories the reportCategories to set
	 */
	public void setReportCategories(List<ReportCategories> reportCategories) {
		this.reportCategories = reportCategories;
	}

	/**
	 * @return the enabled
	 */
	public boolean isEnabled() {
		return enabled;
	}

	/**
	 * @param enabled the enabled to set
	 */
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	/**
	 * @return the reportCategories
	 */
	public List<ReportCategories> getReportCategories() {
		return reportCategories;
	}

	public Reports() {
		super();
		this.id = UUID.randomUUID().toString();
	}

	public String getDisplayName() {
		return displayName;
	}

	public String getArtifactId() {
		return artifactId;
	}

	public String getGroupId() {
		return groupId;
	}

	public String getVersion() {
		return version;
	}
	
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public void setArtifactId(String artifactId) {
		this.artifactId = artifactId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getTechId() {
		return techId;
	}


	public void setTechId(String techId) {
		this.techId = techId;
	}

	public void setId(String id) {
		this.id = id;
	}


	public String getId() {
		return id;
	}

	public static final Reports SUREFIRE_REPORT = new Reports(
			SiteMessages.getString("Reports.surefireReport.display.name") ,
			SiteMessages.getString("Reports.surefireReport.artifact.id"), 
			SiteMessages.getString("Reports.surefireReport.group.id"), 
			SiteMessages.getString("Reports.surefireReport.version")); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$


	public static final Reports JAVADOC = new Reports(SiteMessages.getString("Reports.javadoc.display.name"), 
			SiteMessages.getString("Reports.javadoc.artifact.id"),
			SiteMessages.getString("Reports.javadoc.group.id"),
			SiteMessages.getString("Reports.javadoc.version"));	
	
	public static final Reports JDEPEND = new Reports(SiteMessages.getString("Reports.jdepend.display.name"), 
			SiteMessages.getString("Reports.jdepend.artifact.id"),
			SiteMessages.getString("Reports.jdepend.group.id"),
			SiteMessages.getString("Reports.jdepend.version"));	
	
	public static final Reports PMD = new Reports(SiteMessages.getString("Reports.pmd.display.name"), 
			SiteMessages.getString("Reports.pmd.artifact.id"),
			SiteMessages.getString("Reports.pmd.group.id"),
			SiteMessages.getString("Reports.pmd.version"));	
	
	public static final Reports COBERTURA = new Reports(SiteMessages.getString("Reports.cobertura.display.name"), 
			SiteMessages.getString("Reports.cobertura.artifact.id"),
			SiteMessages.getString("Reports.cobertura.group.id"),
			SiteMessages.getString("Reports.cobertura.version"));	
	
	public static final Reports LINK_CHECK = new Reports(SiteMessages.getString("Reports.linkcheck.display.name"), 
			SiteMessages.getString("Reports.linkcheck.artifact.id"),
			SiteMessages.getString("Reports.linkcheck.group.id"),
			SiteMessages.getString("Reports.linkcheck.version"));	
	
	public static final Reports JXR = new Reports(SiteMessages.getString("Reports.jxr.display.name"), 
			SiteMessages.getString("Reports.jxr.artifact.id"),
			SiteMessages.getString("Reports.jxr.group.id"),
			SiteMessages.getString("Reports.jxr.version"));
	
	public static final Reports PROJECT_INFO = new Reports(SiteMessages.getString("Reports.project-info.display.name"), 
			SiteMessages.getString("Reports.project-info.artifact.id"),
			SiteMessages.getString("Reports.project-info.group.id"),
			SiteMessages.getString("Reports.project-info.version"));
	static {
		List<ReportCategories> catagories = new ArrayList<ReportCategories>();
		catagories.add(ReportCategories.INFO_INDEX);
		catagories.add(ReportCategories.INFO_MODULE);
		catagories.add(ReportCategories.INFO_DEPENDENCIES);
		catagories.add(ReportCategories.CIM);
		catagories.add(ReportCategories.SCM);
		catagories.add(ReportCategories.SUMMARY);
		catagories.add(ReportCategories.LICENSE);
		PROJECT_INFO.setReportCategories(catagories);
	}
}