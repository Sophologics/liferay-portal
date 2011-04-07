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

package com.liferay.portlet.dynamicdatalists.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;

/**
 * The interface for the d d l entry local service.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DDLEntryLocalServiceUtil
 * @see com.liferay.portlet.dynamicdatalists.service.base.DDLEntryLocalServiceBaseImpl
 * @see com.liferay.portlet.dynamicdatalists.service.impl.DDLEntryLocalServiceImpl
 * @generated
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface DDLEntryLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DDLEntryLocalServiceUtil} to access the d d l entry local service. Add custom service methods to {@link com.liferay.portlet.dynamicdatalists.service.impl.DDLEntryLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	* Adds the d d l entry to the database. Also notifies the appropriate model listeners.
	*
	* @param ddlEntry the d d l entry to add
	* @return the d d l entry that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.dynamicdatalists.model.DDLEntry addDDLEntry(
		com.liferay.portlet.dynamicdatalists.model.DDLEntry ddlEntry)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Creates a new d d l entry with the primary key. Does not add the d d l entry to the database.
	*
	* @param entryId the primary key for the new d d l entry
	* @return the new d d l entry
	*/
	public com.liferay.portlet.dynamicdatalists.model.DDLEntry createDDLEntry(
		long entryId);

	/**
	* Deletes the d d l entry with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param entryId the primary key of the d d l entry to delete
	* @throws PortalException if a d d l entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deleteDDLEntry(long entryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Deletes the d d l entry from the database. Also notifies the appropriate model listeners.
	*
	* @param ddlEntry the d d l entry to delete
	* @throws SystemException if a system exception occurred
	*/
	public void deleteDDLEntry(
		com.liferay.portlet.dynamicdatalists.model.DDLEntry ddlEntry)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query to search with
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query to search with
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Gets the d d l entry with the primary key.
	*
	* @param entryId the primary key of the d d l entry to get
	* @return the d d l entry
	* @throws PortalException if a d d l entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.liferay.portlet.dynamicdatalists.model.DDLEntry getDDLEntry(
		long entryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Gets the d d l entry with the UUID and group id.
	*
	* @param uuid the UUID of d d l entry to get
	* @param groupId the group id of the d d l entry to get
	* @return the d d l entry
	* @throws PortalException if a d d l entry with the UUID and group id could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.liferay.portlet.dynamicdatalists.model.DDLEntry getDDLEntryByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Gets a range of all the d d l entries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of d d l entries to return
	* @param end the upper bound of the range of d d l entries to return (not inclusive)
	* @return the range of d d l entries
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<com.liferay.portlet.dynamicdatalists.model.DDLEntry> getDDLEntries(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Gets the number of d d l entries.
	*
	* @return the number of d d l entries
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getDDLEntriesCount()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Updates the d d l entry in the database. Also notifies the appropriate model listeners.
	*
	* @param ddlEntry the d d l entry to update
	* @return the d d l entry that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.dynamicdatalists.model.DDLEntry updateDDLEntry(
		com.liferay.portlet.dynamicdatalists.model.DDLEntry ddlEntry)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Updates the d d l entry in the database. Also notifies the appropriate model listeners.
	*
	* @param ddlEntry the d d l entry to update
	* @param merge whether to merge the d d l entry with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the d d l entry that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.dynamicdatalists.model.DDLEntry updateDDLEntry(
		com.liferay.portlet.dynamicdatalists.model.DDLEntry ddlEntry,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Gets the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier();

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier);

	public com.liferay.portlet.dynamicdatalists.model.DDLEntry addEntry(
		long userId, long groupId, long ddmStructureId,
		java.lang.String entryKey, boolean autoEntryKey,
		java.util.Map<java.util.Locale, java.lang.String> nameMap,
		java.lang.String description,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public void addEntryResources(
		com.liferay.portlet.dynamicdatalists.model.DDLEntry entry,
		boolean addCommunityPermissions, boolean addGuestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public void addEntryResources(
		com.liferay.portlet.dynamicdatalists.model.DDLEntry entry,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public void deleteEntry(
		com.liferay.portlet.dynamicdatalists.model.DDLEntry entry)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public void deleteEntry(long entryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public void deleteEntry(long groupId, java.lang.String entryKey)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public void deleteEntries(long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.liferay.portlet.dynamicdatalists.model.DDLEntry getEntry(
		long entryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.liferay.portlet.dynamicdatalists.model.DDLEntry getEntry(
		long groupId, java.lang.String entryKey)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<com.liferay.portlet.dynamicdatalists.model.DDLEntry> getEntries(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getEntriesCount(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<com.liferay.portlet.dynamicdatalists.model.DDLEntry> search(
		long companyId, long groupId, java.lang.String keywords, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int searchCount(long companyId, long groupId,
		java.lang.String keywords)
		throws com.liferay.portal.kernel.exception.SystemException;

	public com.liferay.portlet.dynamicdatalists.model.DDLEntry updateEntry(
		long groupId, long ddmStructureId, java.lang.String entryKey,
		java.util.Map<java.util.Locale, java.lang.String> nameMap,
		java.lang.String description,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;
}