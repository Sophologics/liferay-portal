/**
 * Copyright (c) 2000-2011 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.portlet.dynamicdatalists.service.base;

import com.liferay.counter.service.CounterLocalService;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.service.ResourceLocalService;
import com.liferay.portal.service.ResourceService;
import com.liferay.portal.service.UserLocalService;
import com.liferay.portal.service.UserService;
import com.liferay.portal.service.persistence.ResourceFinder;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserFinder;
import com.liferay.portal.service.persistence.UserPersistence;

import com.liferay.portlet.dynamicdatalists.model.DDLEntryItem;
import com.liferay.portlet.dynamicdatalists.service.DDLEntryItemLocalService;
import com.liferay.portlet.dynamicdatalists.service.DDLEntryLocalService;
import com.liferay.portlet.dynamicdatalists.service.DDLEntryService;
import com.liferay.portlet.dynamicdatalists.service.persistence.DDLEntryFinder;
import com.liferay.portlet.dynamicdatalists.service.persistence.DDLEntryItemPersistence;
import com.liferay.portlet.dynamicdatalists.service.persistence.DDLEntryPersistence;
import com.liferay.portlet.dynamicdatamapping.service.DDMStructureLinkLocalService;
import com.liferay.portlet.dynamicdatamapping.service.DDMStructureLinkService;
import com.liferay.portlet.dynamicdatamapping.service.persistence.DDMStructureLinkPersistence;

import java.util.List;

import javax.sql.DataSource;

/**
 * The base implementation of the d d l entry item local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.liferay.portlet.dynamicdatalists.service.impl.DDLEntryItemLocalServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.portlet.dynamicdatalists.service.impl.DDLEntryItemLocalServiceImpl
 * @see com.liferay.portlet.dynamicdatalists.service.DDLEntryItemLocalServiceUtil
 * @generated
 */
public abstract class DDLEntryItemLocalServiceBaseImpl
	implements DDLEntryItemLocalService, IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.liferay.portlet.dynamicdatalists.service.DDLEntryItemLocalServiceUtil} to access the d d l entry item local service.
	 */

	/**
	 * Adds the d d l entry item to the database. Also notifies the appropriate model listeners.
	 *
	 * @param ddlEntryItem the d d l entry item to add
	 * @return the d d l entry item that was added
	 * @throws SystemException if a system exception occurred
	 */
	public DDLEntryItem addDDLEntryItem(DDLEntryItem ddlEntryItem)
		throws SystemException {
		ddlEntryItem.setNew(true);

		return ddlEntryItemPersistence.update(ddlEntryItem, false);
	}

	/**
	 * Creates a new d d l entry item with the primary key. Does not add the d d l entry item to the database.
	 *
	 * @param entryItemId the primary key for the new d d l entry item
	 * @return the new d d l entry item
	 */
	public DDLEntryItem createDDLEntryItem(long entryItemId) {
		return ddlEntryItemPersistence.create(entryItemId);
	}

	/**
	 * Deletes the d d l entry item with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param entryItemId the primary key of the d d l entry item to delete
	 * @throws PortalException if a d d l entry item with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public void deleteDDLEntryItem(long entryItemId)
		throws PortalException, SystemException {
		ddlEntryItemPersistence.remove(entryItemId);
	}

	/**
	 * Deletes the d d l entry item from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ddlEntryItem the d d l entry item to delete
	 * @throws SystemException if a system exception occurred
	 */
	public void deleteDDLEntryItem(DDLEntryItem ddlEntryItem)
		throws SystemException {
		ddlEntryItemPersistence.remove(ddlEntryItem);
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query to search with
	 * @return the matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return ddlEntryItemPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query to search with
	 * @param start the lower bound of the range of model instances to return
	 * @param end the upper bound of the range of model instances to return (not inclusive)
	 * @return the range of matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return ddlEntryItemPersistence.findWithDynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query to search with
	 * @param start the lower bound of the range of model instances to return
	 * @param end the upper bound of the range of model instances to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return ddlEntryItemPersistence.findWithDynamicQuery(dynamicQuery,
			start, end, orderByComparator);
	}

	/**
	 * Counts the number of rows that match the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query to search with
	 * @return the number of rows that match the dynamic query
	 * @throws SystemException if a system exception occurred
	 */
	public long dynamicQueryCount(DynamicQuery dynamicQuery)
		throws SystemException {
		return ddlEntryItemPersistence.countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Gets the d d l entry item with the primary key.
	 *
	 * @param entryItemId the primary key of the d d l entry item to get
	 * @return the d d l entry item
	 * @throws PortalException if a d d l entry item with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public DDLEntryItem getDDLEntryItem(long entryItemId)
		throws PortalException, SystemException {
		return ddlEntryItemPersistence.findByPrimaryKey(entryItemId);
	}

	/**
	 * Gets a range of all the d d l entry items.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of d d l entry items to return
	 * @param end the upper bound of the range of d d l entry items to return (not inclusive)
	 * @return the range of d d l entry items
	 * @throws SystemException if a system exception occurred
	 */
	public List<DDLEntryItem> getDDLEntryItems(int start, int end)
		throws SystemException {
		return ddlEntryItemPersistence.findAll(start, end);
	}

	/**
	 * Gets the number of d d l entry items.
	 *
	 * @return the number of d d l entry items
	 * @throws SystemException if a system exception occurred
	 */
	public int getDDLEntryItemsCount() throws SystemException {
		return ddlEntryItemPersistence.countAll();
	}

	/**
	 * Updates the d d l entry item in the database. Also notifies the appropriate model listeners.
	 *
	 * @param ddlEntryItem the d d l entry item to update
	 * @return the d d l entry item that was updated
	 * @throws SystemException if a system exception occurred
	 */
	public DDLEntryItem updateDDLEntryItem(DDLEntryItem ddlEntryItem)
		throws SystemException {
		ddlEntryItem.setNew(false);

		return ddlEntryItemPersistence.update(ddlEntryItem, true);
	}

	/**
	 * Updates the d d l entry item in the database. Also notifies the appropriate model listeners.
	 *
	 * @param ddlEntryItem the d d l entry item to update
	 * @param merge whether to merge the d d l entry item with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	 * @return the d d l entry item that was updated
	 * @throws SystemException if a system exception occurred
	 */
	public DDLEntryItem updateDDLEntryItem(DDLEntryItem ddlEntryItem,
		boolean merge) throws SystemException {
		ddlEntryItem.setNew(false);

		return ddlEntryItemPersistence.update(ddlEntryItem, merge);
	}

	/**
	 * Gets the d d l entry local service.
	 *
	 * @return the d d l entry local service
	 */
	public DDLEntryLocalService getDDLEntryLocalService() {
		return ddlEntryLocalService;
	}

	/**
	 * Sets the d d l entry local service.
	 *
	 * @param ddlEntryLocalService the d d l entry local service
	 */
	public void setDDLEntryLocalService(
		DDLEntryLocalService ddlEntryLocalService) {
		this.ddlEntryLocalService = ddlEntryLocalService;
	}

	/**
	 * Gets the d d l entry remote service.
	 *
	 * @return the d d l entry remote service
	 */
	public DDLEntryService getDDLEntryService() {
		return ddlEntryService;
	}

	/**
	 * Sets the d d l entry remote service.
	 *
	 * @param ddlEntryService the d d l entry remote service
	 */
	public void setDDLEntryService(DDLEntryService ddlEntryService) {
		this.ddlEntryService = ddlEntryService;
	}

	/**
	 * Gets the d d l entry persistence.
	 *
	 * @return the d d l entry persistence
	 */
	public DDLEntryPersistence getDDLEntryPersistence() {
		return ddlEntryPersistence;
	}

	/**
	 * Sets the d d l entry persistence.
	 *
	 * @param ddlEntryPersistence the d d l entry persistence
	 */
	public void setDDLEntryPersistence(DDLEntryPersistence ddlEntryPersistence) {
		this.ddlEntryPersistence = ddlEntryPersistence;
	}

	/**
	 * Gets the d d l entry finder.
	 *
	 * @return the d d l entry finder
	 */
	public DDLEntryFinder getDDLEntryFinder() {
		return ddlEntryFinder;
	}

	/**
	 * Sets the d d l entry finder.
	 *
	 * @param ddlEntryFinder the d d l entry finder
	 */
	public void setDDLEntryFinder(DDLEntryFinder ddlEntryFinder) {
		this.ddlEntryFinder = ddlEntryFinder;
	}

	/**
	 * Gets the d d l entry item local service.
	 *
	 * @return the d d l entry item local service
	 */
	public DDLEntryItemLocalService getDDLEntryItemLocalService() {
		return ddlEntryItemLocalService;
	}

	/**
	 * Sets the d d l entry item local service.
	 *
	 * @param ddlEntryItemLocalService the d d l entry item local service
	 */
	public void setDDLEntryItemLocalService(
		DDLEntryItemLocalService ddlEntryItemLocalService) {
		this.ddlEntryItemLocalService = ddlEntryItemLocalService;
	}

	/**
	 * Gets the d d l entry item persistence.
	 *
	 * @return the d d l entry item persistence
	 */
	public DDLEntryItemPersistence getDDLEntryItemPersistence() {
		return ddlEntryItemPersistence;
	}

	/**
	 * Sets the d d l entry item persistence.
	 *
	 * @param ddlEntryItemPersistence the d d l entry item persistence
	 */
	public void setDDLEntryItemPersistence(
		DDLEntryItemPersistence ddlEntryItemPersistence) {
		this.ddlEntryItemPersistence = ddlEntryItemPersistence;
	}

	/**
	 * Gets the counter local service.
	 *
	 * @return the counter local service
	 */
	public CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Gets the resource local service.
	 *
	 * @return the resource local service
	 */
	public ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Gets the resource remote service.
	 *
	 * @return the resource remote service
	 */
	public ResourceService getResourceService() {
		return resourceService;
	}

	/**
	 * Sets the resource remote service.
	 *
	 * @param resourceService the resource remote service
	 */
	public void setResourceService(ResourceService resourceService) {
		this.resourceService = resourceService;
	}

	/**
	 * Gets the resource persistence.
	 *
	 * @return the resource persistence
	 */
	public ResourcePersistence getResourcePersistence() {
		return resourcePersistence;
	}

	/**
	 * Sets the resource persistence.
	 *
	 * @param resourcePersistence the resource persistence
	 */
	public void setResourcePersistence(ResourcePersistence resourcePersistence) {
		this.resourcePersistence = resourcePersistence;
	}

	/**
	 * Gets the resource finder.
	 *
	 * @return the resource finder
	 */
	public ResourceFinder getResourceFinder() {
		return resourceFinder;
	}

	/**
	 * Sets the resource finder.
	 *
	 * @param resourceFinder the resource finder
	 */
	public void setResourceFinder(ResourceFinder resourceFinder) {
		this.resourceFinder = resourceFinder;
	}

	/**
	 * Gets the user local service.
	 *
	 * @return the user local service
	 */
	public UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Gets the user remote service.
	 *
	 * @return the user remote service
	 */
	public UserService getUserService() {
		return userService;
	}

	/**
	 * Sets the user remote service.
	 *
	 * @param userService the user remote service
	 */
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	/**
	 * Gets the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	/**
	 * Gets the user finder.
	 *
	 * @return the user finder
	 */
	public UserFinder getUserFinder() {
		return userFinder;
	}

	/**
	 * Sets the user finder.
	 *
	 * @param userFinder the user finder
	 */
	public void setUserFinder(UserFinder userFinder) {
		this.userFinder = userFinder;
	}

	/**
	 * Gets the d d m structure link local service.
	 *
	 * @return the d d m structure link local service
	 */
	public DDMStructureLinkLocalService getDDMStructureLinkLocalService() {
		return ddmStructureLinkLocalService;
	}

	/**
	 * Sets the d d m structure link local service.
	 *
	 * @param ddmStructureLinkLocalService the d d m structure link local service
	 */
	public void setDDMStructureLinkLocalService(
		DDMStructureLinkLocalService ddmStructureLinkLocalService) {
		this.ddmStructureLinkLocalService = ddmStructureLinkLocalService;
	}

	/**
	 * Gets the d d m structure link remote service.
	 *
	 * @return the d d m structure link remote service
	 */
	public DDMStructureLinkService getDDMStructureLinkService() {
		return ddmStructureLinkService;
	}

	/**
	 * Sets the d d m structure link remote service.
	 *
	 * @param ddmStructureLinkService the d d m structure link remote service
	 */
	public void setDDMStructureLinkService(
		DDMStructureLinkService ddmStructureLinkService) {
		this.ddmStructureLinkService = ddmStructureLinkService;
	}

	/**
	 * Gets the d d m structure link persistence.
	 *
	 * @return the d d m structure link persistence
	 */
	public DDMStructureLinkPersistence getDDMStructureLinkPersistence() {
		return ddmStructureLinkPersistence;
	}

	/**
	 * Sets the d d m structure link persistence.
	 *
	 * @param ddmStructureLinkPersistence the d d m structure link persistence
	 */
	public void setDDMStructureLinkPersistence(
		DDMStructureLinkPersistence ddmStructureLinkPersistence) {
		this.ddmStructureLinkPersistence = ddmStructureLinkPersistence;
	}

	/**
	 * Gets the Spring bean ID for this bean.
	 *
	 * @return the Spring bean ID for this bean
	 */
	public String getBeanIdentifier() {
		return _beanIdentifier;
	}

	/**
	 * Sets the Spring bean ID for this bean.
	 *
	 * @param beanIdentifier the Spring bean ID for this bean
	 */
	public void setBeanIdentifier(String beanIdentifier) {
		_beanIdentifier = beanIdentifier;
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query to perform
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = ddlEntryItemPersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = DDLEntryLocalService.class)
	protected DDLEntryLocalService ddlEntryLocalService;
	@BeanReference(type = DDLEntryService.class)
	protected DDLEntryService ddlEntryService;
	@BeanReference(type = DDLEntryPersistence.class)
	protected DDLEntryPersistence ddlEntryPersistence;
	@BeanReference(type = DDLEntryFinder.class)
	protected DDLEntryFinder ddlEntryFinder;
	@BeanReference(type = DDLEntryItemLocalService.class)
	protected DDLEntryItemLocalService ddlEntryItemLocalService;
	@BeanReference(type = DDLEntryItemPersistence.class)
	protected DDLEntryItemPersistence ddlEntryItemPersistence;
	@BeanReference(type = CounterLocalService.class)
	protected CounterLocalService counterLocalService;
	@BeanReference(type = ResourceLocalService.class)
	protected ResourceLocalService resourceLocalService;
	@BeanReference(type = ResourceService.class)
	protected ResourceService resourceService;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = ResourceFinder.class)
	protected ResourceFinder resourceFinder;
	@BeanReference(type = UserLocalService.class)
	protected UserLocalService userLocalService;
	@BeanReference(type = UserService.class)
	protected UserService userService;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	@BeanReference(type = UserFinder.class)
	protected UserFinder userFinder;
	@BeanReference(type = DDMStructureLinkLocalService.class)
	protected DDMStructureLinkLocalService ddmStructureLinkLocalService;
	@BeanReference(type = DDMStructureLinkService.class)
	protected DDMStructureLinkService ddmStructureLinkService;
	@BeanReference(type = DDMStructureLinkPersistence.class)
	protected DDMStructureLinkPersistence ddmStructureLinkPersistence;
	private String _beanIdentifier;
}