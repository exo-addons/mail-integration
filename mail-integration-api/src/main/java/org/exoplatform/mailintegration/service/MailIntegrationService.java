/*
 * Copyright (C) 2022 eXo Platform SAS.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
package org.exoplatform.mailintegration.service;

import org.exoplatform.mailintegration.model.MailIntegrationSetting;
import org.exoplatform.mailintegration.rest.model.MessageRestEntity;

import javax.mail.Store;
import java.util.List;

public interface MailIntegrationService {
  /**
   * @param connectionInformation {@link MailIntegrationSetting} object to create
   * @param identityId User identity creating the mail integration setting
   * @return created {@link MailIntegrationSetting} with generated technical identifier
   * @throws IllegalAccessException
   */
  MailIntegrationSetting createMailIntegrationSetting(MailIntegrationSetting mailIntegrationSetting,
                                               long identityId) throws IllegalAccessException;
  
  /**
   * Retrieves mail integration setting by its technical user identity identifier.
   *
   * @param currentIdentityId User identity  the mail integration setting
   * @return A {@link MailIntegrationSetting} object
   * @throws IllegalAccessException when user is not authorized to get mail integration settings
   */
  List<MailIntegrationSetting> getMailIntegrationSettingsByUserId(long currentIdentityId) throws IllegalAccessException;

  /**
   *
   * @param mailIntegrationSetting {@link MailIntegrationSetting} object to connect
   * @return
   */
  Store imapconnect(MailIntegrationSetting mailIntegrationSetting);


  void sendMailIntegrationNotifications();

  MessageRestEntity getMessageById(long mailIntegrationSettingId, String messageId, long identityId) throws IllegalAccessException;
}
