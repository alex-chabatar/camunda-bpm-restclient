package org.camunda.bpm.rest.client.common;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.UnknownHttpStatusCodeException;

public class RestServiceErrorHandler extends DefaultResponseErrorHandler {

  @Override
  public void handleError(ClientHttpResponse response) throws IOException {

    HttpStatus statusCode = response.getStatusCode();
    String errorMessage = new String(getResponseBody(response), getCharset(response));

    switch (statusCode.series()) {
      case CLIENT_ERROR:
        throw new HttpClientErrorException(statusCode,
            response.getStatusText() + "\nClient-Error: " + errorMessage, response.getHeaders(),
            getResponseBody(response), getCharset(response));
      case SERVER_ERROR:
        throw new HttpServerErrorException(statusCode,
          response.getStatusText() + "\nServer-Error: " + errorMessage, response.getHeaders(),
          getResponseBody(response), getCharset(response));
      default:
        throw new UnknownHttpStatusCodeException(statusCode.value(),
          response.getStatusText() + "\nError: " + errorMessage, response.getHeaders(),
          getResponseBody(response), getCharset(response));
    }

  }

  @Override
  protected Charset getCharset(ClientHttpResponse response) {
    Charset charset = super.getCharset(response);
    if (charset == null) {
      charset = StandardCharsets.UTF_8; // UTF-8 as default encoding
    }
    return charset;
  }
}