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

package org.openlmis.referencedata.service.notification;

import static org.apache.commons.lang3.StringUtils.isBlank;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.openlmis.referencedata.dto.UserDto;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public final class UserContactDetailsDto {
  private UUID referenceDataUserId;
  private String phoneNumber;
  private Boolean allowNotify;
  private EmailDetailsDto emailDetails;

  /**
   * Creates new instance based on data from {@link UserDto}.
   */
  public UserContactDetailsDto(UserDto user) {
    this.referenceDataUserId = user.getId();
    this.phoneNumber = user.getPhoneNumber();
    this.allowNotify = user.getAllowNotify();
    this.emailDetails = isBlank(user.getEmail())
        ? null
        : new EmailDetailsDto(user.getEmail(), user.isVerified());
  }
}