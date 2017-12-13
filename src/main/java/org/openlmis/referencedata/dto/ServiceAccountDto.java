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

import org.openlmis.referencedata.domain.ServiceAccount;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.ZonedDateTime;
import java.util.UUID;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@ToString
public final class ServiceAccountDto
    extends BaseDto
    implements ServiceAccount.Importer, ServiceAccount.Exporter {

  private String login;
  private UUID createdBy;
  private ZonedDateTime createdDate;

  /**
   * Creates new instance of {@link ServiceAccountDto} based on passed service account.
   */
  public static ServiceAccountDto newInstance(ServiceAccount serviceAccount) {
    ServiceAccountDto dto = new ServiceAccountDto();
    serviceAccount.export(dto);

    return dto;
  }
}
