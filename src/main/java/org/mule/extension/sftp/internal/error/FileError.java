/*
 * Copyright 2023 Salesforce, Inc. All rights reserved.
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package org.mule.extension.sftp.internal.error;

import static java.util.Optional.ofNullable;

import org.mule.runtime.extension.api.error.ErrorTypeDefinition;
import org.mule.runtime.extension.api.error.MuleErrors;

import java.util.Optional;

/**
 * Errors for the file family extensions
 * 
 * @since 1.0
 */
public enum FileError implements ErrorTypeDefinition<FileError> {

  ILLEGAL_PATH,

  ILLEGAL_CONTENT,

  FILE_LOCK,

  FILE_ALREADY_EXISTS,

  ACCESS_DENIED,

  FILE_DOESNT_EXIST,

  CONNECTIVITY(MuleErrors.CONNECTIVITY),

  INVALID_CREDENTIALS(CONNECTIVITY),

  CONNECTION_TIMEOUT(CONNECTIVITY),

  CANNOT_REACH(CONNECTIVITY),

  UNKNOWN_HOST(CONNECTIVITY),

  KEY_EXCHANGE_FAILED(CONNECTIVITY),

  SERVICE_NOT_AVAILABLE(CONNECTIVITY),

  DISCONNECTED(CONNECTIVITY);

  private ErrorTypeDefinition<? extends Enum<?>> parentError;

  FileError(ErrorTypeDefinition<? extends Enum<?>> parentError) {
    this.parentError = parentError;
  }

  FileError() {

  }

  @Override
  public Optional<ErrorTypeDefinition<? extends Enum<?>>> getParent() {
    return ofNullable(parentError);
  }
}
