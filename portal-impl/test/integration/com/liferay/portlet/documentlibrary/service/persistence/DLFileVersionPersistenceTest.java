/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
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

package com.liferay.portlet.documentlibrary.service.persistence;

import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.test.AggregateTestRule;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.util.IntegerWrapper;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Time;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.test.LiferayIntegrationTestRule;
import com.liferay.portal.test.PersistenceTestRule;
import com.liferay.portal.test.TransactionalTestRule;
import com.liferay.portal.util.PropsValues;
import com.liferay.portal.util.test.RandomTestUtil;

import com.liferay.portlet.documentlibrary.NoSuchFileVersionException;
import com.liferay.portlet.documentlibrary.model.DLFileVersion;
import com.liferay.portlet.documentlibrary.model.impl.DLFileVersionModelImpl;
import com.liferay.portlet.documentlibrary.service.DLFileVersionLocalServiceUtil;

import org.junit.After;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @generated
 */
public class DLFileVersionPersistenceTest {
	@Rule
	public final AggregateTestRule aggregateTestRule = new AggregateTestRule(new LiferayIntegrationTestRule(),
			PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(Propagation.REQUIRED));

	@After
	public void tearDown() throws Exception {
		Iterator<DLFileVersion> iterator = _dlFileVersions.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		DLFileVersion dlFileVersion = _persistence.create(pk);

		Assert.assertNotNull(dlFileVersion);

		Assert.assertEquals(dlFileVersion.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		DLFileVersion newDLFileVersion = addDLFileVersion();

		_persistence.remove(newDLFileVersion);

		DLFileVersion existingDLFileVersion = _persistence.fetchByPrimaryKey(newDLFileVersion.getPrimaryKey());

		Assert.assertNull(existingDLFileVersion);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addDLFileVersion();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		DLFileVersion newDLFileVersion = _persistence.create(pk);

		newDLFileVersion.setUuid(RandomTestUtil.randomString());

		newDLFileVersion.setGroupId(RandomTestUtil.nextLong());

		newDLFileVersion.setCompanyId(RandomTestUtil.nextLong());

		newDLFileVersion.setUserId(RandomTestUtil.nextLong());

		newDLFileVersion.setUserName(RandomTestUtil.randomString());

		newDLFileVersion.setCreateDate(RandomTestUtil.nextDate());

		newDLFileVersion.setModifiedDate(RandomTestUtil.nextDate());

		newDLFileVersion.setRepositoryId(RandomTestUtil.nextLong());

		newDLFileVersion.setFolderId(RandomTestUtil.nextLong());

		newDLFileVersion.setFileEntryId(RandomTestUtil.nextLong());

		newDLFileVersion.setTreePath(RandomTestUtil.randomString());

		newDLFileVersion.setFileName(RandomTestUtil.randomString());

		newDLFileVersion.setExtension(RandomTestUtil.randomString());

		newDLFileVersion.setMimeType(RandomTestUtil.randomString());

		newDLFileVersion.setTitle(RandomTestUtil.randomString());

		newDLFileVersion.setDescription(RandomTestUtil.randomString());

		newDLFileVersion.setChangeLog(RandomTestUtil.randomString());

		newDLFileVersion.setExtraSettings(RandomTestUtil.randomString());

		newDLFileVersion.setFileEntryTypeId(RandomTestUtil.nextLong());

		newDLFileVersion.setVersion(RandomTestUtil.randomString());

		newDLFileVersion.setSize(RandomTestUtil.nextLong());

		newDLFileVersion.setChecksum(RandomTestUtil.randomString());

		newDLFileVersion.setStatus(RandomTestUtil.nextInt());

		newDLFileVersion.setStatusByUserId(RandomTestUtil.nextLong());

		newDLFileVersion.setStatusByUserName(RandomTestUtil.randomString());

		newDLFileVersion.setStatusDate(RandomTestUtil.nextDate());

		_dlFileVersions.add(_persistence.update(newDLFileVersion));

		DLFileVersion existingDLFileVersion = _persistence.findByPrimaryKey(newDLFileVersion.getPrimaryKey());

		Assert.assertEquals(existingDLFileVersion.getUuid(),
			newDLFileVersion.getUuid());
		Assert.assertEquals(existingDLFileVersion.getFileVersionId(),
			newDLFileVersion.getFileVersionId());
		Assert.assertEquals(existingDLFileVersion.getGroupId(),
			newDLFileVersion.getGroupId());
		Assert.assertEquals(existingDLFileVersion.getCompanyId(),
			newDLFileVersion.getCompanyId());
		Assert.assertEquals(existingDLFileVersion.getUserId(),
			newDLFileVersion.getUserId());
		Assert.assertEquals(existingDLFileVersion.getUserName(),
			newDLFileVersion.getUserName());
		Assert.assertEquals(Time.getShortTimestamp(
				existingDLFileVersion.getCreateDate()),
			Time.getShortTimestamp(newDLFileVersion.getCreateDate()));
		Assert.assertEquals(Time.getShortTimestamp(
				existingDLFileVersion.getModifiedDate()),
			Time.getShortTimestamp(newDLFileVersion.getModifiedDate()));
		Assert.assertEquals(existingDLFileVersion.getRepositoryId(),
			newDLFileVersion.getRepositoryId());
		Assert.assertEquals(existingDLFileVersion.getFolderId(),
			newDLFileVersion.getFolderId());
		Assert.assertEquals(existingDLFileVersion.getFileEntryId(),
			newDLFileVersion.getFileEntryId());
		Assert.assertEquals(existingDLFileVersion.getTreePath(),
			newDLFileVersion.getTreePath());
		Assert.assertEquals(existingDLFileVersion.getFileName(),
			newDLFileVersion.getFileName());
		Assert.assertEquals(existingDLFileVersion.getExtension(),
			newDLFileVersion.getExtension());
		Assert.assertEquals(existingDLFileVersion.getMimeType(),
			newDLFileVersion.getMimeType());
		Assert.assertEquals(existingDLFileVersion.getTitle(),
			newDLFileVersion.getTitle());
		Assert.assertEquals(existingDLFileVersion.getDescription(),
			newDLFileVersion.getDescription());
		Assert.assertEquals(existingDLFileVersion.getChangeLog(),
			newDLFileVersion.getChangeLog());
		Assert.assertEquals(existingDLFileVersion.getExtraSettings(),
			newDLFileVersion.getExtraSettings());
		Assert.assertEquals(existingDLFileVersion.getFileEntryTypeId(),
			newDLFileVersion.getFileEntryTypeId());
		Assert.assertEquals(existingDLFileVersion.getVersion(),
			newDLFileVersion.getVersion());
		Assert.assertEquals(existingDLFileVersion.getSize(),
			newDLFileVersion.getSize());
		Assert.assertEquals(existingDLFileVersion.getChecksum(),
			newDLFileVersion.getChecksum());
		Assert.assertEquals(existingDLFileVersion.getStatus(),
			newDLFileVersion.getStatus());
		Assert.assertEquals(existingDLFileVersion.getStatusByUserId(),
			newDLFileVersion.getStatusByUserId());
		Assert.assertEquals(existingDLFileVersion.getStatusByUserName(),
			newDLFileVersion.getStatusByUserName());
		Assert.assertEquals(Time.getShortTimestamp(
				existingDLFileVersion.getStatusDate()),
			Time.getShortTimestamp(newDLFileVersion.getStatusDate()));
	}

	@Test
	public void testCountByUuid() {
		try {
			_persistence.countByUuid(StringPool.BLANK);

			_persistence.countByUuid(StringPool.NULL);

			_persistence.countByUuid((String)null);
		}
		catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	@Test
	public void testCountByUUID_G() {
		try {
			_persistence.countByUUID_G(StringPool.BLANK,
				RandomTestUtil.nextLong());

			_persistence.countByUUID_G(StringPool.NULL, 0L);

			_persistence.countByUUID_G((String)null, 0L);
		}
		catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	@Test
	public void testCountByUuid_C() {
		try {
			_persistence.countByUuid_C(StringPool.BLANK,
				RandomTestUtil.nextLong());

			_persistence.countByUuid_C(StringPool.NULL, 0L);

			_persistence.countByUuid_C((String)null, 0L);
		}
		catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	@Test
	public void testCountByCompanyId() {
		try {
			_persistence.countByCompanyId(RandomTestUtil.nextLong());

			_persistence.countByCompanyId(0L);
		}
		catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	@Test
	public void testCountByFileEntryId() {
		try {
			_persistence.countByFileEntryId(RandomTestUtil.nextLong());

			_persistence.countByFileEntryId(0L);
		}
		catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	@Test
	public void testCountByMimeType() {
		try {
			_persistence.countByMimeType(StringPool.BLANK);

			_persistence.countByMimeType(StringPool.NULL);

			_persistence.countByMimeType((String)null);
		}
		catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	@Test
	public void testCountByC_NotS() {
		try {
			_persistence.countByC_NotS(RandomTestUtil.nextLong(),
				RandomTestUtil.nextInt());

			_persistence.countByC_NotS(0L, 0);
		}
		catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	@Test
	public void testCountByF_V() {
		try {
			_persistence.countByF_V(RandomTestUtil.nextLong(), StringPool.BLANK);

			_persistence.countByF_V(0L, StringPool.NULL);

			_persistence.countByF_V(0L, (String)null);
		}
		catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	@Test
	public void testCountByF_S() {
		try {
			_persistence.countByF_S(RandomTestUtil.nextLong(),
				RandomTestUtil.nextInt());

			_persistence.countByF_S(0L, 0);
		}
		catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	@Test
	public void testCountByG_F_S() {
		try {
			_persistence.countByG_F_S(RandomTestUtil.nextLong(),
				RandomTestUtil.nextLong(), RandomTestUtil.nextInt());

			_persistence.countByG_F_S(0L, 0L, 0);
		}
		catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	@Test
	public void testCountByG_F_T_V() {
		try {
			_persistence.countByG_F_T_V(RandomTestUtil.nextLong(),
				RandomTestUtil.nextLong(), StringPool.BLANK, StringPool.BLANK);

			_persistence.countByG_F_T_V(0L, 0L, StringPool.NULL, StringPool.NULL);

			_persistence.countByG_F_T_V(0L, 0L, (String)null, (String)null);
		}
		catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		DLFileVersion newDLFileVersion = addDLFileVersion();

		DLFileVersion existingDLFileVersion = _persistence.findByPrimaryKey(newDLFileVersion.getPrimaryKey());

		Assert.assertEquals(existingDLFileVersion, newDLFileVersion);
	}

	@Test
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		try {
			_persistence.findByPrimaryKey(pk);

			Assert.fail(
				"Missing entity did not throw NoSuchFileVersionException");
		}
		catch (NoSuchFileVersionException nsee) {
		}
	}

	@Test
	public void testFindAll() throws Exception {
		try {
			_persistence.findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS,
				getOrderByComparator());
		}
		catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	protected OrderByComparator<DLFileVersion> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create("DLFileVersion", "uuid",
			true, "fileVersionId", true, "groupId", true, "companyId", true,
			"userId", true, "userName", true, "createDate", true,
			"modifiedDate", true, "repositoryId", true, "folderId", true,
			"fileEntryId", true, "treePath", true, "fileName", true,
			"extension", true, "mimeType", true, "title", true, "description",
			true, "changeLog", true, "extraSettings", true, "fileEntryTypeId",
			true, "version", true, "size", true, "checksum", true, "status",
			true, "statusByUserId", true, "statusByUserName", true,
			"statusDate", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		DLFileVersion newDLFileVersion = addDLFileVersion();

		DLFileVersion existingDLFileVersion = _persistence.fetchByPrimaryKey(newDLFileVersion.getPrimaryKey());

		Assert.assertEquals(existingDLFileVersion, newDLFileVersion);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		DLFileVersion missingDLFileVersion = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingDLFileVersion);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {
		DLFileVersion newDLFileVersion1 = addDLFileVersion();
		DLFileVersion newDLFileVersion2 = addDLFileVersion();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newDLFileVersion1.getPrimaryKey());
		primaryKeys.add(newDLFileVersion2.getPrimaryKey());

		Map<Serializable, DLFileVersion> dlFileVersions = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, dlFileVersions.size());
		Assert.assertEquals(newDLFileVersion1,
			dlFileVersions.get(newDLFileVersion1.getPrimaryKey()));
		Assert.assertEquals(newDLFileVersion2,
			dlFileVersions.get(newDLFileVersion2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {
		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, DLFileVersion> dlFileVersions = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(dlFileVersions.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {
		DLFileVersion newDLFileVersion = addDLFileVersion();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newDLFileVersion.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, DLFileVersion> dlFileVersions = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, dlFileVersions.size());
		Assert.assertEquals(newDLFileVersion,
			dlFileVersions.get(newDLFileVersion.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys()
		throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, DLFileVersion> dlFileVersions = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(dlFileVersions.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey()
		throws Exception {
		DLFileVersion newDLFileVersion = addDLFileVersion();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newDLFileVersion.getPrimaryKey());

		Map<Serializable, DLFileVersion> dlFileVersions = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, dlFileVersions.size());
		Assert.assertEquals(newDLFileVersion,
			dlFileVersions.get(newDLFileVersion.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery = DLFileVersionLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(new ActionableDynamicQuery.PerformActionMethod() {
				@Override
				public void performAction(Object object) {
					DLFileVersion dlFileVersion = (DLFileVersion)object;

					Assert.assertNotNull(dlFileVersion);

					count.increment();
				}
			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting()
		throws Exception {
		DLFileVersion newDLFileVersion = addDLFileVersion();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(DLFileVersion.class,
				DLFileVersion.class.getClassLoader());

		dynamicQuery.add(RestrictionsFactoryUtil.eq("fileVersionId",
				newDLFileVersion.getFileVersionId()));

		List<DLFileVersion> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		DLFileVersion existingDLFileVersion = result.get(0);

		Assert.assertEquals(existingDLFileVersion, newDLFileVersion);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(DLFileVersion.class,
				DLFileVersion.class.getClassLoader());

		dynamicQuery.add(RestrictionsFactoryUtil.eq("fileVersionId",
				RandomTestUtil.nextLong()));

		List<DLFileVersion> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting()
		throws Exception {
		DLFileVersion newDLFileVersion = addDLFileVersion();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(DLFileVersion.class,
				DLFileVersion.class.getClassLoader());

		dynamicQuery.setProjection(ProjectionFactoryUtil.property(
				"fileVersionId"));

		Object newFileVersionId = newDLFileVersion.getFileVersionId();

		dynamicQuery.add(RestrictionsFactoryUtil.in("fileVersionId",
				new Object[] { newFileVersionId }));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingFileVersionId = result.get(0);

		Assert.assertEquals(existingFileVersionId, newFileVersionId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(DLFileVersion.class,
				DLFileVersion.class.getClassLoader());

		dynamicQuery.setProjection(ProjectionFactoryUtil.property(
				"fileVersionId"));

		dynamicQuery.add(RestrictionsFactoryUtil.in("fileVersionId",
				new Object[] { RandomTestUtil.nextLong() }));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testResetOriginalValues() throws Exception {
		if (!PropsValues.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			return;
		}

		DLFileVersion newDLFileVersion = addDLFileVersion();

		_persistence.clearCache();

		DLFileVersionModelImpl existingDLFileVersionModelImpl = (DLFileVersionModelImpl)_persistence.findByPrimaryKey(newDLFileVersion.getPrimaryKey());

		Assert.assertTrue(Validator.equals(
				existingDLFileVersionModelImpl.getUuid(),
				existingDLFileVersionModelImpl.getOriginalUuid()));
		Assert.assertEquals(existingDLFileVersionModelImpl.getGroupId(),
			existingDLFileVersionModelImpl.getOriginalGroupId());

		Assert.assertEquals(existingDLFileVersionModelImpl.getFileEntryId(),
			existingDLFileVersionModelImpl.getOriginalFileEntryId());
		Assert.assertTrue(Validator.equals(
				existingDLFileVersionModelImpl.getVersion(),
				existingDLFileVersionModelImpl.getOriginalVersion()));
	}

	protected DLFileVersion addDLFileVersion() throws Exception {
		long pk = RandomTestUtil.nextLong();

		DLFileVersion dlFileVersion = _persistence.create(pk);

		dlFileVersion.setUuid(RandomTestUtil.randomString());

		dlFileVersion.setGroupId(RandomTestUtil.nextLong());

		dlFileVersion.setCompanyId(RandomTestUtil.nextLong());

		dlFileVersion.setUserId(RandomTestUtil.nextLong());

		dlFileVersion.setUserName(RandomTestUtil.randomString());

		dlFileVersion.setCreateDate(RandomTestUtil.nextDate());

		dlFileVersion.setModifiedDate(RandomTestUtil.nextDate());

		dlFileVersion.setRepositoryId(RandomTestUtil.nextLong());

		dlFileVersion.setFolderId(RandomTestUtil.nextLong());

		dlFileVersion.setFileEntryId(RandomTestUtil.nextLong());

		dlFileVersion.setTreePath(RandomTestUtil.randomString());

		dlFileVersion.setFileName(RandomTestUtil.randomString());

		dlFileVersion.setExtension(RandomTestUtil.randomString());

		dlFileVersion.setMimeType(RandomTestUtil.randomString());

		dlFileVersion.setTitle(RandomTestUtil.randomString());

		dlFileVersion.setDescription(RandomTestUtil.randomString());

		dlFileVersion.setChangeLog(RandomTestUtil.randomString());

		dlFileVersion.setExtraSettings(RandomTestUtil.randomString());

		dlFileVersion.setFileEntryTypeId(RandomTestUtil.nextLong());

		dlFileVersion.setVersion(RandomTestUtil.randomString());

		dlFileVersion.setSize(RandomTestUtil.nextLong());

		dlFileVersion.setChecksum(RandomTestUtil.randomString());

		dlFileVersion.setStatus(RandomTestUtil.nextInt());

		dlFileVersion.setStatusByUserId(RandomTestUtil.nextLong());

		dlFileVersion.setStatusByUserName(RandomTestUtil.randomString());

		dlFileVersion.setStatusDate(RandomTestUtil.nextDate());

		_dlFileVersions.add(_persistence.update(dlFileVersion));

		return dlFileVersion;
	}

	private List<DLFileVersion> _dlFileVersions = new ArrayList<DLFileVersion>();
	private DLFileVersionPersistence _persistence = DLFileVersionUtil.getPersistence();
}