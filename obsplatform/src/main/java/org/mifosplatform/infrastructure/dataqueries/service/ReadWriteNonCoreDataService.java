package org.mifosplatform.infrastructure.dataqueries.service;

import java.util.List;

import org.mifosplatform.infrastructure.core.api.JsonCommand;
import org.mifosplatform.infrastructure.core.data.CommandProcessingResult;
import org.mifosplatform.infrastructure.dataqueries.data.DatatableData;
import org.mifosplatform.infrastructure.dataqueries.data.GenericResultsetData;
import org.springframework.security.access.prepost.PreAuthorize;

/**
 * @author hugo
 * 
 */
public interface ReadWriteNonCoreDataService {

	List<DatatableData> retrieveDatatableNames(String appTable);

	DatatableData retrieveSingleDatatable(String datatable);

	@PreAuthorize(value = "hasAnyRole('ALL_FUNCTIONS', 'REGISTER_DATATABLE')")
	void registerDatatable(JsonCommand command);

	@PreAuthorize(value = "hasAnyRole('ALL_FUNCTIONS', 'REGISTER_DATATABLE')")
	void registerDatatable(String dataTableName, String applicationTableName);

	@PreAuthorize(value = "hasAnyRole('ALL_FUNCTIONS', 'REGISTER_DATATABLE')")
	void registerDatatable(JsonCommand command, String permissionTable);

	@PreAuthorize(value = "hasAnyRole('ALL_FUNCTIONS', 'DEREGISTER_DATATABLE')")
	void deregisterDatatable(String datatable);

	GenericResultsetData retrieveDataTableGenericResultSet(String datatable,
			Long appTableId, String order, Long id);

	CommandProcessingResult createDatatable(JsonCommand command);

	void updateDatatable(String datatableName, JsonCommand command);

	void deleteDatatable(String datatableName);

	CommandProcessingResult createNewDatatableEntry(String datatable,
			Long appTableId, JsonCommand command);

	CommandProcessingResult createPPIEntry(String datatable, Long appTableId,
			JsonCommand command);

	CommandProcessingResult updateDatatableEntryOneToOne(String datatable,
			Long appTableId, JsonCommand command);

	CommandProcessingResult updateDatatableEntryOneToMany(String datatable,
			Long appTableId, Long datatableId, JsonCommand command);

	CommandProcessingResult deleteDatatableEntries(String datatable,
			Long appTableId);

	CommandProcessingResult deleteDatatableEntry(String datatable,
			Long appTableId, Long datatableId);

	String getTableName(String Url);

	String getDataTableName(String Url);

}
