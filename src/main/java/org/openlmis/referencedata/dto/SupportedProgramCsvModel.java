/*
 * This program is part of the OpenLMIS logistics management information system platform software.
 * Copyright © 2017 VillageReach
 *
 * This program is free software: you can redistribute it and/or modify it under the terms
 * of the GNU Affero General Public License as published by the Free Software Foundation, either
 * version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU Affero General Public License for more details. You should have received a copy of
 * the GNU Affero General Public License along with this program. If not, see
 * http://www.gnu.org/licenses.  For additional information contact info@OpenLMIS.org.
 */

package org.openlmis.referencedata.dto;

import static org.openlmis.referencedata.web.csv.processor.CsvCellProcessors.BOOLEAN_TYPE;
import static org.openlmis.referencedata.web.csv.processor.CsvCellProcessors.LOCAL_DATE;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.openlmis.referencedata.domain.SupportedProgram;
import org.openlmis.referencedata.web.csv.model.ImportField;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class SupportedProgramCsvModel implements SupportedProgram.Importer {
  @ImportField(name = "programCode", mandatory = true)
  private String programCode;

  @ImportField(name = "facilityCode", mandatory = true)
  private String facilityCode;

  @ImportField(name = "active", type = BOOLEAN_TYPE)
  private Boolean active;

  @ImportField(name = "locallyFulfilled", type = BOOLEAN_TYPE)
  private Boolean locallyFulfilled;

  @ImportField(name = "startDate", type = LOCAL_DATE)
  private LocalDate startDate;

  /**
   * Create new instance of SupportedProgramCsvModel.
   *
   * @param supportedProgram a supportedProgram to create model from, not null
   * @return new instance of SupportedProgramCsvModel, never null
   */
  public static SupportedProgramCsvModel newInstance(SupportedProgram supportedProgram) {
    final SupportedProgramCsvModel model = new SupportedProgramCsvModel();
    model.programCode = supportedProgram.getFacilityProgram().getProgram().getCode().toString();
    model.facilityCode = supportedProgram.getFacilityProgram().getFacility().getCode();
    model.active = supportedProgram.getActive();
    model.locallyFulfilled = supportedProgram.getLocallyFulfilled();
    model.startDate = supportedProgram.getStartDate();
    return model;
  }
}
