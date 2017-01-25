package org.openlmis.referencedata.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class CurrencySettingDto {

  private String currencyCode;

  private String currencySymbol;

  private String currencySymbolSide;
}
